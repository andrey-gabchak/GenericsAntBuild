import java.util.List;

public interface Executor<T> {

    void addTask(Task<? extends T> task) throws Exceptions;

    void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exceptions;

    void execute();

    List<T> getValidResults() throws Exceptions;

    List<T> getInvalidResults()throws Exceptions;

}

