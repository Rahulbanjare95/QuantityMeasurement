package utility;

public enum Unit {

    FEET(UnitType.LENGTH, 12.0),
    INCH(UnitType.LENGTH, 1.0),
    YARD(UnitType.LENGTH, 36.0),
    CM(UnitType.LENGTH, 0.4),
    LITER(UnitType.VOLUME, 1.0),
    GALLON(UnitType.VOLUME, 3.78),
    ML(UnitType.VOLUME, 0.001),
    KG(UnitType.WEIGHTS, 1.0),
    GRAM(UnitType.WEIGHTS, 0.001),
    TONNE(UnitType.WEIGHTS, 1000.0),
    FAHRENHEIT(UnitType.TEMPERATURE, 0.029),
    CELSIUS(UnitType.TEMPERATURE, 1.0);

    public Double conversionFactor;
    public UnitType type;

    Unit(UnitType type, Double conversionFactor) {
        this.conversionFactor = conversionFactor;
        this.type = type;
    }
}

