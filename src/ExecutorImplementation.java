import java.util.ArrayList;
import java.util.List;

public class ExecutorImplementation<T> implements Executor<T> {
    List<Task<? extends T>> tasks=new ArrayList<>();
    List<T> validTasks = new ArrayList<>();
    List<T> inValidTasks = new ArrayList<>();

    boolean isExecute;

    @Override
    public void addTask(Task<? extends T> task) throws Exceptions{
        if (isExecute)throw new Exceptions("method execute() has already been running");
        tasks.add(task);
        validTasks.add(task.getResult());
    }


    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exceptions {
        if (isExecute)throw new Exceptions("method execute() has already been running");
        tasks.add(task);
        if (validator.isValid(task.getResult())) validTasks.add(task.getResult());
        else inValidTasks.add(task.getResult());

    }

    @Override
    public void execute() {
    isExecute = true;
    }

    @Override
    public List<T> getValidResults() throws Exceptions {
        if (!isExecute) throw new Exceptions("method Execute() was not run");

        return validTasks;
    }

    @Override
    public List<T> getInvalidResults() throws Exceptions {
        if (!isExecute) throw new Exceptions("method Execute() was not run");

        return inValidTasks;
    }
}
