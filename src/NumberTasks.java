public class NumberTasks implements Task<Long> {
    Long number;
    Long res;

    public NumberTasks(Long number) {
        res = number;

    }

    @Override
    public void execute() {

    }

    @Override
    public Long getResult() {
        return res;
    }
}
