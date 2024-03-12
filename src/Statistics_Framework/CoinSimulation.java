package Statistics_Framework;

/**
 * Coin Simulation implementation of the Simulation template
 */
public class CoinSimulation extends SimulationTemplate {
    @Override
    protected void setupGenerator() {
        generatorBehavior = new CoinGeneratorBehavior();
    }
}
