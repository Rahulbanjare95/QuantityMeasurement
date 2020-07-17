package service;

import exception.QuantityMeasurementException;
import utility.Unit;

public class QuantityMeasurement implements IQuantityMeasurements {
    public Unit unit;
    public double value;


    /**
     * @param unit contains unit information from enum
     * @param value contains unit given at declaration
     * @throws QuantityMeasurementException when values are given negative
     */
    public QuantityMeasurement(Unit unit, double value) throws QuantityMeasurementException {
        this.unit = unit;
        this.value = value;
        if (value < 0)
            throw new QuantityMeasurementException("Negative Values cant be compared",
                    QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
    }

    /**
     * @param quantity1 represents reference containing unit and value
     * @param quantity2 represents reference containing unit and value
     * @return double result which contains sum of both the parameters
     */
    @Override
    public double addTwoUnits(QuantityMeasurement quantity1, QuantityMeasurement quantity2) {
        return quantity1.value + quantity2.value;
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
     * @param fahrenheit
     * @param  celsius
     * @return true for comparison when same unit type and false otherwise
     */
    public boolean temperatureComparision(QuantityMeasurement fahrenheit, QuantityMeasurement celsius) {
        if (fahrenheit.unit.type.equals(celsius.unit.type))
            return (Double.compare(((fahrenheit.value - 32) * 5 / 9),
                    celsius.value * celsius.unit.conversionFactor) == 0);
        return false;
    }

    /**
     * Compare two objects created in test cases to compare for equality
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
