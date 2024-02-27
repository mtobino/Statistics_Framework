package Statistics_Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CoinSimulation extends SimulationTemplate {
    Generator<Boolean> yer;
    List<Double> chances = new ArrayList<>(2);

    @Override
    public void setup() {
        yer = new CoinGenerator();
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
