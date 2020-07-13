
public class QuantityMeasurementException extends Exception {
    public enum ExceptionType {
            NEGATIVE_UNIT_ERROR;
    }
    public  ExceptionType type;
    public  QuantityMeasurementException(String message, ExceptionType type){
        super(message);
        this.type=type;
    }
}
