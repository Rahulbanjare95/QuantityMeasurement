import exception.QuantityMeasurementException;
import org.junit.Assert;
import org.junit.Test;
import service.QuantityMeasurement;
import utility.Unit;

public class QuantityMeasurementTest {

    @Test
    public void givenFeetToCheckEquality_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement feet1 = new QuantityMeasurement(Unit.FEET, 0.0);
        QuantityMeasurement feet2 = new QuantityMeasurement(Unit.FEET, 0.0);
        Assert.assertEquals(feet1, feet2);
    }

    @Test
    public void givenNullValue_shouldCheckForFalse() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement value = null;
        Assert.assertFalse(feet.equals(value));
    }

    @Test
    public void givenReference_SameObject_ShouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement = feet;
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement));
    }

    @Test
    public void givenClassType_IfDifferent_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        String message = "Hello World!";
        Assert.assertFalse(quantityMeasurement.equals(message));
    }

    @Test
    public void givenUnitValue_shouldCheck_EqualityInEntity_ReturnsTrue() throws QuantityMeasurementException {
        QuantityMeasurement feet1 = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement feet2 = new QuantityMeasurement(Unit.FEET, 1.0);
        Assert.assertTrue(feet1.equals(feet2));
    }

    @Test
    public void givenZeroInch_shouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement inch1 = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement inch2 = new QuantityMeasurement(Unit.INCH, 0.0);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void givenNullValue_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(inch.equals(nullValue));
    }

    @Test
    public void givenReference_ForSameObject_ForInch_ShouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement reference = inch;
        Assert.assertTrue(inch.equals(reference));
    }

    @Test
    public void givenClassType_IfDifferentWhenINCHisUnit_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 0.0);
        String check = "Hello Java";
        Assert.assertFalse(inch.equals(check));
    }

    @Test
    public void givenUnitValue_ShouldCheckEqualityInEntity_ForInchReturnsTrue() throws QuantityMeasurementException {
        QuantityMeasurement inch1 = new QuantityMeasurement(Unit.INCH, 1.0);
        QuantityMeasurement inch2 = new QuantityMeasurement(Unit.INCH, 1.0);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void givenOneFeetAndOneInch_ShouldReturnNotEquals() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 1.0);
        Assert.assertNotEquals(feet, inch);
    }

    @Test
    public void givenOneYardAndOneInch_shouldReturnNotEquals() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 1.0);
        QuantityMeasurement yard = new QuantityMeasurement(Unit.YARD, 1.0);
        Assert.assertNotEquals(inch, yard);
    }

    @Test
    public void givenThreeFeet_shouldReturnEqualToOneYard() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 3.0);
        QuantityMeasurement yard = new QuantityMeasurement(Unit.YARD, 1.0);
        boolean comparison = feet.compareTo(feet, yard);
        Assert.assertTrue(comparison);
    }

    @Test
    public void givenOneYard_shouldReturn36inch() {
        try {
            QuantityMeasurement yard = new QuantityMeasurement(Unit.YARD, 1.0);
            QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 36.0);
            boolean comparison = yard.compareTo(yard, inch);
            Assert.assertTrue(comparison);
        } catch (QuantityMeasurementException e) {
            e.getMessage();
        }
    }

    @Test
    public void givenOneYardValueNegative_shouldThrowCustomException() {
        try {
            QuantityMeasurement yard = new QuantityMeasurement(Unit.YARD, -1.0);
            QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 36.0);
            Assert.assertEquals(yard,inch);
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenZeroCm_andZeroCm_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement cm1 = new QuantityMeasurement(Unit.CM, 0.0);
        QuantityMeasurement cm2 = new QuantityMeasurement(Unit.CM, 0.0);
        Assert.assertEquals(cm1, cm2);
    }

    @Test
    public void givenZeroCm_andOtherCM_shouldReturnNotEqual() throws QuantityMeasurementException {
        QuantityMeasurement cm1 = new QuantityMeasurement(Unit.CM, 0.0);
        QuantityMeasurement cm2 = new QuantityMeasurement(Unit.CM, 1.0);
        Assert.assertNotEquals(cm1, cm2);
    }

    @Test
    public void givenCM_whenCheckedForNullShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement cm = new QuantityMeasurement(Unit.CM, 1.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(cm.equals(nullValue));
    }

    @Test
    public void givenCM_referenceToSameObject_ShouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement cm = new QuantityMeasurement(Unit.CM, 1.0);
        QuantityMeasurement dummyReference = cm;
        Assert.assertTrue(cm.equals(dummyReference));
    }

    @Test
    public void givenClassType_IfDifferent_ShouldReturnNotEqual() throws QuantityMeasurementException {
        QuantityMeasurement cm = new QuantityMeasurement(Unit.CM, 1.0);
        String hello = "This Is String";
        Assert.assertFalse(cm.equals(hello));
    }

    @Test
    public void givenUnitValuesOfCm_ShouldCheckEqualityInUnits() {
        try {
            QuantityMeasurement cm1 = new QuantityMeasurement(Unit.CM, 1.0);
            QuantityMeasurement cm2 = new QuantityMeasurement(Unit.CM, 1.0);
            Assert.assertTrue(cm1.equals(cm2));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given0Inch0Feet_ShouldReturn_Zero() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 0.0);
        boolean b = inch.compareTo(inch, feet);
        Assert.assertTrue(b);
    }

    @Test
    public void givenTwoInches_ShouldReturn_FiveCM() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 2.0);
        QuantityMeasurement cm = new QuantityMeasurement(Unit.CM, 5.0);
        boolean b = inch.compareTo(inch, cm);
        Assert.assertTrue(b);
    }

    @Test
    public void givenTwoUnitsOfSameType_ShouldAddToInches() throws QuantityMeasurementException {
        QuantityMeasurement inch1 = new QuantityMeasurement(Unit.INCH, 2.0);
        QuantityMeasurement inch2 = new QuantityMeasurement(Unit.INCH, 2.0);
        double addedValues = inch1.addTwoUnits(inch1, inch2);
        Assert.assertEquals(4.0, addedValues, 0.0);
    }

    @Test
    public void givenOneFeetAndTwoInch_shouldReturnFourteenInch() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 12.0);
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH, 2.0);
        double addedValues = feet.addTwoUnits(feet, inch);
        Assert.assertEquals(14, addedValues, 0.0);
    }

    @Test
    public void givenOneFeetAndOneFeet_ShouldReturnTwentyFourInch() throws QuantityMeasurementException {
        QuantityMeasurement feet1 = new QuantityMeasurement(Unit.FEET, 12.0);
        QuantityMeasurement feet2 = new QuantityMeasurement(Unit.FEET, 12.0);
        double addedValues = feet1.addTwoUnits(feet1, feet2);
        Assert.assertEquals(24, addedValues, 0.0);
    }

    @Test
    public void givenOneFeetAndOneKG_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 12.0);
        QuantityMeasurement kg =  new QuantityMeasurement(Unit.KG,1.0);
        boolean comparison = feet.compareTo(feet, kg);
        Assert.assertEquals(false, comparison);


    }

    @Test
    public void given1GallonAnd3Liters780ml_shouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement gallon = new QuantityMeasurement(Unit.GALLON, 1.0);
        QuantityMeasurement liter = new QuantityMeasurement(Unit.LITER, 3.78);
        boolean comparison = gallon.compareTo(gallon, liter);
        Assert.assertEquals(true,comparison);
    }

    @Test
    public void givenOneLitreAnd1000ml_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement liter = new QuantityMeasurement(Unit.LITER, 1.0);
        QuantityMeasurement ml = new QuantityMeasurement(Unit.ML, 1000.0);
        boolean comparison = liter.compareTo(liter, ml);
        Assert.assertEquals(true, comparison);
    }

    @Test
    public void givenOneGallonAnd3780Liter_shouldReturnSevenThousandFiveSixtyLiter() throws QuantityMeasurementException {
        QuantityMeasurement gallon = new QuantityMeasurement(Unit.GALLON, 3780.0);
        QuantityMeasurement liter = new QuantityMeasurement(Unit.LITER, 3780.0);
        double sum = gallon.addTwoUnits(gallon, liter);
        Assert.assertEquals(7560, sum, 0.0);
    }

    @Test
    public void givenOneKGAndThousandGrams_ShouldReturnEquals() throws QuantityMeasurementException {
        QuantityMeasurement kg = new QuantityMeasurement(Unit.KG, 1.0);
        QuantityMeasurement gram = new QuantityMeasurement(Unit.GRAM, 1000.0);
        boolean comparison = kg.compareTo(kg, gram);
        Assert.assertEquals(true, comparison);
    }

    @Test
    public void givenOneTONEAndThousandKG_ShouldReturnEquals() throws QuantityMeasurementException {
        QuantityMeasurement ton = new QuantityMeasurement(Unit.TONNE, 1.0);
        QuantityMeasurement kg = new QuantityMeasurement(Unit.KG, 1000.0);
        boolean comparison = ton.compareTo(ton, kg);
        Assert.assertEquals(true, comparison);
    }

    @Test
    public void givenOneToneAndOneGrams_ShouldAddToExpectedResult() throws QuantityMeasurementException {
        QuantityMeasurement ton = new QuantityMeasurement(Unit.TONNE, 1.0);
        QuantityMeasurement gram = new QuantityMeasurement(Unit.GRAM, 1000.0);
        double sum = ton.addTwoUnits(ton, gram);
        Assert.assertEquals(1001, sum, 0.0);
    }

    @Test
    public void givenTemperatureInFahrenheitAndCelsius_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement fahrenheit = new QuantityMeasurement(Unit.FAHRENHEIT, 212.0);
        QuantityMeasurement celsius = new QuantityMeasurement(Unit.CELSIUS, 100.0);
        boolean comparison = fahrenheit.temperatureComparision(fahrenheit, celsius);
        Assert.assertEquals(true, comparison);
    }

    @Test
    public void givenTemperatureAndFeet_whenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement fahrenheit = new QuantityMeasurement(Unit.FAHRENHEIT, 212.0);
        QuantityMeasurement feet = new QuantityMeasurement(Unit.FEET, 12.0);
        boolean comparision = fahrenheit.temperatureComparision(fahrenheit, feet);
        Assert.assertEquals(false, comparision);
    }
}