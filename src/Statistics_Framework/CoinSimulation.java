package Statistics_Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Coin Simulation implementation of the Simulation template
 */
public class CoinSimulation extends SimulationTemplate {
    private GeneratorBehavior<Boolean> coinGenerator;

    //not sure if we need this list
    // List<Double> chances = new ArrayList<>(2);

    @Override
    public void setup() {
        coinGenerator = new CoinGeneratorBehavior();
    }

    @Override
    public void run(Predicate predicate) {
        if(predicate.test("yerr")){
            displayResults();
        }

    }

    @Override
    public void displayResults() {
        System.out.println("hahaha");
    }
}
