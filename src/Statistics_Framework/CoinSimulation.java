package Statistics_Framework;

import java.util.function.Function;
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
    public void run(Function function) {
        answer = (Answer) function.apply(coinGenerator);

    }
}
