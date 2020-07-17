package service;

import exception.QuantityMeasurementException;
import utility.Unit;

public class QuantityMeasurement implements IQuantityMeasurements {
    public Unit unit;
    public Double value;


    /**
     * @param unit contains unit information from enum
     * @param value contains unit given at declaration
     * @throws QuantityMeasurementException when values are given negative
     */
    public QuantityMeasurement(Unit unit, Double value) throws QuantityMeasurementException {
        this.unit = unit;
        this.value = value;
        if (value < 0)
            throw new QuantityMeasurementException("Negative Values cant be compared",
                    QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
    }

    /**
     * @param quantityMeasurement represents reference containing unit and value
     * @param quantityMeasurement1 represents reference containing unit and value
     * @return double result which contains sum of both the parameters
     */
    @Override
    public double addTwoUnits(QuantityMeasurement quantityMeasurement, QuantityMeasurement quantityMeasurement1) {
        return quantityMeasurement.value + quantityMeasurement1.value;
    }

    /**
     * @param q1 represents reference containing unit and value
     * @param q2 represents reference containing unit and value
     * @return true for comparison when same unit type and false otherwise
     */
    @Override
    public boolean compareTo(QuantityMeasurement q1, QuantityMeasurement q2) {
        if (q1.unit.type.equals(q2.unit.type))
            return (Double.compare(Math.round(q1.value * q1.unit.conversionFactor),
                    Math.round(q2.value * q2.unit.conversionFactor)) == 0);
        return false;
    }

    /**
     * @param q1 represents reference containing one unit as Celsius
     * @param q2 represents reference containing one unit as Fahrenheit
     * @return true for comparison when same unit type and false otherwise
     */
    public boolean temperatureComparision(QuantityMeasurement q1, QuantityMeasurement q2) {
        if (q1.unit.type.equals(q2.unit.type))
            return (Double.compare(((q1.value - 32) * 5 / 9), q2.value * q2.unit.conversionFactor) == 0);
        return false;
    }

    /**
     * Compare two objects created in test cases to compare for equality
     *
     * @param o Object of new QuantityMeasurement
     * @return true for same type false for different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.value, value) == 0 &&
                unit == that.unit;
    }
}
