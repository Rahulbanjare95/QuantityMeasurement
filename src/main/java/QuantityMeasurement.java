import javax.lang.model.element.QualifiedNameable;

public class QuantityMeasurement {

    public double convert(int inch) throws QuantityMeasurementException {
        if(inch < 0)
            throw new QuantityMeasurementException("Negative Units Not allowed",
                    QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        return inch*12;
    }
}
