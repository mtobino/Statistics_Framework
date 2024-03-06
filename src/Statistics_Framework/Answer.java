package Statistics_Framework;

/**
 * A class to hold a variable typed answer for the simulation to display
 *
 * @param <T>   the type specified by the user
 */
public class Answer<T>
{
    private final T answer;

    /**
     * Constructor for the answer
     *
     * @param answer    the answer that was compyted
     */
    public Answer(T answer){
        this.answer = answer;
    }

    /**
     * Getter for the answer
     *
     * @return answer   the answer stored in the answer object
     */
    public T getAnswer() {
        return answer;
    }
}
