package Statistics_Framework;

/**
 * Dice Simulation implementation of the Simulation template
 */
public class DiceSimulation extends SimulationTemplate{
    @Override
    protected void setup() {
        generatorBehavior = new DiceGeneratorBehavior();
    }
}
