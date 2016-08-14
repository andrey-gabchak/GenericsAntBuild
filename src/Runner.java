import java.util.List;

public class Runner {

    public static void main(String[] args) {


        ExecutorImplementation executor = new ExecutorImplementation();
        NumValid valid = new NumValid();


        try {

            executor.addTask(new NumberTasks(15L), valid);
            executor.addTask(new NumberTasks(1L), valid);
            executor.addTask(new NumberTasks(19L), valid);
            executor.addTask(new NumberTasks(-5L), valid);
            executor.addTask(new NumberTasks(4L), valid);
            executor.addTask(new NumberTasks(0L), valid);
            executor.execute();
        } catch (Exceptions exceptions) {
            exceptions.printStackTrace();
        }

        List<Long> listInvalid = null;
        try {
            listInvalid = executor.getInvalidResults();
        } catch (Exceptions exceptions) {
            exceptions.printStackTrace();
        }

        List<Long> listValid = null;
        try {
            listValid = executor.getValidResults();
        } catch (Exceptions exceptions) {
            exceptions.printStackTrace();
        }

        System.out.println("Valid:");
        for (Long aLong : listValid) {
            System.out.println(aLong);
        }

        System.out.println("Invalid:");
        for (Long aLong : listInvalid) {
            System.out.println(aLong);
        }

    }
}