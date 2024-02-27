package Statistics_Framework;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
public class Main {

    public static void main(String[] args){
        SimulationTemplate sim = new CoinSimulation();
        Predicate<String> pred = (p) -> p.equals("yerr");
        Consumer<Integer> sum = (t) -> t = t + 1;
        Function<Integer, Integer> func = (f) -> f > 0 ? 1 : -1; // I am thinking we switch from predicates to functions to capture the return values that Dr. Baliga wants.

        sim.simulate(func);
    }
}
