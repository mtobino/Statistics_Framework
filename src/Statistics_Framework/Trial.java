package Statistics_Framework;

import java.util.function.Function;

public class Trial {
    private Function trial;

    public Trial(Function trial){
        this.trial = trial;
    }

    public Function getTrial() {
        return trial;
    }
    public Answer runTrial(GeneratorBehavior generatorBehavior){
        return (Answer) trial.apply(generatorBehavior);
    }
}
