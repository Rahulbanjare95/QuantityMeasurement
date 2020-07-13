package service;

public enum Unit {
    FEET(0.0),
    INCH(1);

    public double quantity;

    Unit(double quantity) {
        this.quantity=quantity;
    }
}
