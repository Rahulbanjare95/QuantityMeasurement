package service;

import exception.QuantityMeasurementException;

public class QuantityMeasurement {
    private  Unit unit;
    Double value;

    public QuantityMeasurement(Unit unit, Double value) {
        this.unit=unit;
        this.value=value;
    }

    public double convertFeetToYard(Double value) throws QuantityMeasurementException {
        return (Unit.FEET.quantity)*(Unit.INCH.quantity)*value/Unit.YARD.quantity;
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
