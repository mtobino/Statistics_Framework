package Statistics_Framework;

/**
 * Dice Simulation implementation of the Simulation template
 */
public class DiceSimulation extends SimulationTemplate{
    @Override
    public void setup() {
        generatorBehavior = new DiceGeneratorBehavior();
    }
}
