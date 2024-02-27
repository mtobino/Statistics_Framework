package Statistics_Framework;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Template class for all Simulations
 */
public abstract class SimulationTemplate {
        /**
         * The Simulate template method that each simulation will follow
         *
         * @param function     the function the simulation will be running
         */
        public final void simulate(Function function)
        {
                setup();
                run(function);
                displayResults();
        }

        /**
         * Will Setup the generators for each class
         */
        public abstract void setup();

        /**
         * Will run the predicate passed through
         *
         * @param function     the function that is being tested
         */
        public abstract void run(Function function);

        /**
         * Display the results
         */
        public abstract void displayResults();



}
