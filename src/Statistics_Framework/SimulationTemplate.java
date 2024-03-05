package Statistics_Framework;

import java.util.function.Function;

/**
 * Template class for all Simulations. Here the actions of simulating
 * and displaying the results of the simulation are set. The act of
 * setting up the simulation and running it are determined by the subclasses.
 */
public abstract class SimulationTemplate {
        protected Answer answer;
        /**
         * The Simulate template method that each simulation will follow
         *
         * @param function     the function the simulation will be running
         */
        public final void simulate(Function function, String prompt)
        {
                setup();
                run(function);
                displayResults(prompt);
        }

        /**
         * Will Setup the generators for each class
         */
        protected abstract void setup();

        /**
         * Will run the function passed through
         *
         * @param function     the function that is being tested
         */
        protected abstract void run(Function function);

        /**
         * Display the results
         */
        public void displayResults(String prompt)
        {
                System.out.println(prompt + "\nAnswer: " + answer.getAnswer());
        }



}
