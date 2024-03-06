package Statistics_Framework;

/**
 * Coin Simulation implementation of the Simulation template
 */
public class CoinSimulation extends SimulationTemplate {
    @Override
    public void setup() {
        generatorBehavior = new CoinGeneratorBehavior();
    }
}
