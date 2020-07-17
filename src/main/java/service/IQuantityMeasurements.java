package service;

public interface IQuantityMeasurements {
    boolean compareTo(QuantityMeasurement q1, QuantityMeasurement q2);
    boolean temperatureComparision(QuantityMeasurement q1, QuantityMeasurement q2);
    double addTwoUnits(QuantityMeasurement q1, QuantityMeasurement q2);

}
