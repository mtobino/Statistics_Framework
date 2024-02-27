package Statistics_Framework;

import java.util.function.Predicate;

public abstract class SimulationTemplate {
        public void simulate(Predicate predicate)
        {
                setup();
                run(predicate);
                displayResults();
        }

        public abstract void setup();

        public abstract void run(Predicate predicate);

        public abstract void displayResults();



}
