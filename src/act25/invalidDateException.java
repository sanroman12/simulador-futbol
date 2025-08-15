 package act25;

public class invalidDateException extends IllegalArgumentException{
    private String date;
    private int dateValue;


    public invalidDateException(String date, int dateValue) {
        super("invalidYear");
        this.date = date;
        this.dateValue = dateValue;
    }

    @Override
    public String toString() {
        return getMessage() + "\nInvalid date: " + date + " = " + dateValue;
        }
}
