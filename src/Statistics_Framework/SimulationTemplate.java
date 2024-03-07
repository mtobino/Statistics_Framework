package Statistics_Framework;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Template class for all Simulations. Here the actions of simulating
 * and displaying the results of the simulation are set. The act of
 * setting up the simulation and running it are determined by the subclasses.
 */
public abstract class SimulationTemplate {
        protected Answer answer;
        protected GeneratorBehavior generatorBehavior;
        protected ArrayList<Answer> trialResults;
        protected Trial trial;
        /**
         * The Simulate template method that each simulation will follow
         *
         * @param function      the function the simulation will be running
         * @param prompt        the prompt the user wants printed
         */
        public final void simulate(Function function, String prompt)
        {
                simulate(function, prompt, 50, false);

        }
        public final void simulate(Function function, String prompt, int numOfTrials, boolean isPercentage){
                setupGenerator();
                setupTrial(function);
                runTrials(numOfTrials);
                computeFinalAnswer(numOfTrials);
                displayResults(prompt, isPercentage);
        }

        private void runTrials(int numOfTrials) {
                for(int i = 0; i < numOfTrials; i++)
                {
                        trialResults.add(trial.runTrial(generatorBehavior));
                }
        }

        private void computeFinalAnswer(int numOfTrials)
        {
                double totalSum = 0;
                for(Answer answer1 : trialResults){
                        totalSum += (double) answer1.getAnswer();
                }
                answer = new Answer<>(totalSum / numOfTrials);

        }

        private void setupTrial(Function function) {
                trial = new Trial(function);
        }

        /**
         * Will Setup the generators for each class
         */
        protected abstract void setupGenerator();

        /**
         * Will run the function passed through
         *
         * @param function     the function that is being tested
         */
        private void run(Function function) {
                answer = (Answer) function.apply(generatorBehavior);

        }

        /**
         * Display the results
         */
        private void displayResults(String prompt, boolean isPercentage)
        {
                if(isPercentage){
                        System.out.println(prompt + "\nAnswer: " + answer.getAnswer());
                }
                else{
                        System.out.println(prompt + "\nAnswer: " + ((int) answer.getAnswer()));
                }

        }



}
