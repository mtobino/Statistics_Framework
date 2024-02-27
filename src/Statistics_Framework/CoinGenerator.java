package Statistics_Framework;


import java.util.Random;

public class CoinGenerator implements Generator<Boolean>{
    private final Random rand = new Random();
    public Boolean generate()
    {
        return rand.nextBoolean();
    }
}
