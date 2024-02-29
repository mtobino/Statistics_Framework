package Statistics_Framework;

// import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * Template class for all Simulations
 */
public abstract class SimulationTemplate {
        protected Answer answer;
        /**
         * The Simulate template method that each simulation will follow
         *
         * @param function     the function the simulation will be running
         */
        public final void simulate(BiFunction function, Object[] args)
        {
                setup();
                run(function, args);
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
        public abstract void run(BiFunction function, Object[] args);

        /**
         * Display the results
         */
        public abstract void displayResults();



}
