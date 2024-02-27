package Statistics_Framework;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
public class Main {

    public static void main(String[] args){
        SimulationTemplate sim = new TenHeadsSimulation();
        sim.simulate();
    }
}
