package Statistics_Framework;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
public class Main {

    public static void main(String[] args){
        SimulationTemplate sim;

        System.out.println("Repeatedly toss a fair coin until you observe 10 consecutive heads. Compute the average" +
                "\nnumber of tosses needed until the run of 10 heads is obtained.\n");
        sim = new TenHeadsSimulation();
        sim.simulate();

        System.out.println("\nRoll a pair of pair 6-sided dice until their sum is either 4 or 8. Compute the " +
                "\nprobability that you get a 4 before you get an 8.\n");
        sim = new Sum4or8Simulation();
        sim.simulate();
    }
}
