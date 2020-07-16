package service;

import exception.QuantityMeasurementException;
import utility.Unit;

public class QuantityMeasurement {
    private  Unit unit;
    Double value;

    public QuantityMeasurement(Unit unit, Double value) {
        this.unit=unit;
        this.value=value;
    }

    public double convertFeetToYard(double value) throws QuantityMeasurementException {
        if (value < 0 )
            throw new QuantityMeasurementException("Negative values cannot be converted", QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        return (Unit.FEET.conversionFactor)*(Unit.INCH.conversionFactor)*value/ Unit.YARD.conversionFactor;
    }
    public double convertInchToCM(double value) throws QuantityMeasurementException {
        if (value < 0 )
            throw new QuantityMeasurementException("Negative values cannot be converted", QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        return (Unit.INCH.conversionFactor)*(Unit.CM.conversionFactor)*value;
    }
    public double convertYardToInch(double v) throws QuantityMeasurementException {
        if (value < 0 )
            throw new QuantityMeasurementException("Negative values cannot be converted", QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        return (Unit.YARD.conversionFactor)*(Unit.INCH.conversionFactor)*value;
    }

    public double addTwoUnits(QuantityMeasurement quantityMeasurement, QuantityMeasurement quantityMeasurement1) {
        return quantityMeasurement.value +quantityMeasurement1.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.value, value) == 0 &&
                unit == that.unit;
    }

}
