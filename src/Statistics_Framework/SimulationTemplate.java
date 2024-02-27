package Statistics_Framework;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Template class for all Simulations
 */
public abstract class SimulationTemplate {
        /**
         * The Simulate template method that each simulation will follow
         */
        public final void simulate()
        {
                setup();
                run();
                displayResults();
        }

        /**
         * Will setup the generators for each class
         */
        public abstract void setup();

        /**
         * Will run the simulation
         */
        public abstract void run();

        /**
         * Display the results
         */
        public abstract void displayResults();



}
