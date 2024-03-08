package Statistics_Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Template class for all Simulations. Here the actions of simulating
 * and displaying the results of the simulation are set. The act of
 * setting up the simulation and running it are determined by the subclasses.
 */
public abstract class SimulationTemplate {
        protected Answer answer;
        protected double finalAnswer;
        protected GeneratorBehavior generatorBehavior;
        protected List<Double> trialResults;
        protected Trial trial;
        private static final int DEFAULT_NUM_OF_TRIALS = 50;
        private static final boolean DEFAULT_IS_PERCENTAGE = false;
        /**
         * The Simulate template method that each simulation will follow
         *
         * @param function      the function the simulation will be running
         * @param prompt        the prompt the user wants printed
         */
        public final void simulate(Function function, String prompt)
        {
                simulate(function, prompt, DEFAULT_NUM_OF_TRIALS, DEFAULT_IS_PERCENTAGE);

        }
        public final void simulate(Function function, String prompt, int numOfTrials){
                simulate(function, prompt, numOfTrials, DEFAULT_IS_PERCENTAGE);
        }
        public final void simulate(Function function, String prompt, boolean isPercentage){
                simulate(function, prompt, DEFAULT_NUM_OF_TRIALS, isPercentage);
        }
        public final void simulate(Function function, String prompt, int numOfTrials, boolean isPercentage){
                setupGenerator();
                setupTrial(function);
                runTrials(numOfTrials);
                computeFinalAnswer(numOfTrials);
                displayResults(prompt, isPercentage);
        }

        /**
         *
         * @param numOfTrials
         */
        private void runTrials(int numOfTrials) {
                for(int i = 0; i < numOfTrials; i++)
                {
                        trialResults.add(trial.runTrial(generatorBehavior));
                }
        }

        /**
         * Sum up all the trials and divide them by the number of tests performed
         *
         * @param numOfTrials
         */
        private void computeFinalAnswer(int numOfTrials)
        {
                //double totalSum = 0;
                for(Double answer1 : trialResults){
                        finalAnswer += answer1;
                }
                finalAnswer /= numOfTrials;

        }

        /**
         * Set up the trial that is going to be tested
         *
         * @param function      the function that serves as a trial to be tested
         */
        private void setupTrial(Function function) {
                trial = new Trial(function);
                trialResults = new ArrayList<>();
        }
        /**
         * Will Setup the generators for each class
         */
        protected abstract void setupGenerator();
        /**
         * Display the results
         */
        private void displayResults(String prompt, boolean isPercentage)
        {
                if(isPercentage){
                        System.out.println(prompt + "\nAnswer: " + (finalAnswer * 100));
                }
                else{
                        System.out.printf(prompt + "\nAnswer: %.0f", finalAnswer);
                }

        }



}
