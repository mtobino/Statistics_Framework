package Statistics_Framework;

import java.util.Random;

/**
 * The coin implementation of the generator interface
 */
public class CoinGeneratorBehavior implements GeneratorBehavior<Boolean> {
    // needs a random object to run
    private final Random rand = new Random();

    /**
     * Generates a random boolean value to represent a coin flip.
     *
     * @return  True represents heads, false represents tails
     */
    public Boolean generate()
    {
        return rand.nextBoolean();
    }
}
