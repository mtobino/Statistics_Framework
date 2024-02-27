package Statistics_Framework;

import java.util.function.Predicate;

/**
 * Template class for all Simulations
 */
public abstract class SimulationTemplate {
        /**
         * The Simulate template method that each simulation will follow
         *
         * @param predicate     the predicate the simulation will be running
         */
        public final void simulate(Predicate predicate)
        {
                setup();
                run(predicate);
                displayResults();
        }

        /**
         * Will Setup the generators for each class
         */
        public abstract void setup();

        /**
         * Will run the predicate passed through
         *
         * @param predicate     the predicate that is being tested
         */
        public abstract void run(Predicate predicate);

        /**
         * Display the results
         */
        public abstract void displayResults();



}
