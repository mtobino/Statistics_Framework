package Statistics_Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Coin Simulation implementation of the Simulation template
 */
public class CoinSimulation extends SimulationTemplate {
    private GeneratorBehavior<Boolean> coinGenerator;
    private Answer answer;

    @Override
    public void setup() {
        coinGenerator = new CoinGeneratorBehavior();
    }

    @Override
    public void run(Function function) {
        answer = (Answer) function.apply(coinGenerator);

    }

    @Override
    public void displayResults() {
        System.out.println("The Answer to your function was: " + answer.getAnswer());
    }
}
