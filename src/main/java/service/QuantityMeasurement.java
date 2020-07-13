package service;

import exception.QuantityMeasurementException;

public class QuantityMeasurement {
    Unit unit;
    double value;

    public QuantityMeasurement(Unit unit, double v) {
        this.unit=unit;
        this.value=value;
    }

    public double convert(int feet) throws QuantityMeasurementException {
        if(feet < 0)
            throw new QuantityMeasurementException("Negative Units Not allowed",
                    QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        return feet*12;
    }

}
