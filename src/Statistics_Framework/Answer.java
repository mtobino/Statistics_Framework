package Statistics_Framework;

public class Answer<T>
{
    private final T answer;

    public Answer(T answer){
        this.answer = answer;
    }

    public T getAnswer() {
        return answer;
    }
}
