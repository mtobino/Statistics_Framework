package Statistics_Framework;

// import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * Coin Simulation implementation of the Simulation template
 */
public class CoinSimulation extends SimulationTemplate {
    private GeneratorBehavior<Boolean> coinGenerator;

    @Override
    public void setup() {
        coinGenerator = new CoinGeneratorBehavior();
    }

    @Override
    public void run(BiFunction function, Object[] args) {
        answer = (Answer) function.apply(coinGenerator, args);
    }

    @Override
    public void displayResults() {
        System.out.println("The Answer to your function was: " + answer.getAnswer());
    }
}
