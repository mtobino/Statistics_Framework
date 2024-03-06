package Statistics_Framework;

import java.util.function.Function;
/**
 * Coin Simulation implementation of the Simulation template
 */
public class CoinSimulation extends SimulationTemplate {
    @Override
    public void setup() {
        generatorBehavior = new CoinGeneratorBehavior();
    }
}
