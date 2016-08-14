public class NumValid implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        boolean num = (result != null) && (result.longValue()%2==0);
        return num;
    }
}
