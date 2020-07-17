import exception.QuantityMeasurementException;
import org.junit.Assert;
import org.junit.Test;
import service.QuantityMeasurement;
import utility.Unit;

public class QuantityMeasurementTest {

    @Test
    public void givenFeetToCheckEquality_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 0.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenNullValue_shouldCheck() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(quantityMeasurement.equals(nullValue));
    }

    @Test
    public void givenReference_SameObject_ShouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = quantityMeasurement;
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
    }

    @Test
    public void givenClassType_IfDifferent_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        String message = "Hello World!";
        Assert.assertFalse(quantityMeasurement.getClass().equals(message.getClass()));
    }

    @Test
    public void givenUnitValue_shouldCheck_EqualityInEntity_ReturnsTrue() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 1.0);
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
    }

    @Test
    public void givenZeroInch_shouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 0.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenNullValue_ShouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(quantityMeasurement.equals(nullValue));
    }

    @Test
    public void givenReference_ForSameObject_ForInch_ShouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement reference = quantityMeasurement;
        Assert.assertTrue(quantityMeasurement.equals(reference));
    }

    @Test
    public void givenClassType_IfDifferentWhenINCHisUnit_ShouldReturnFalse() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        String check = "Hello Java";
        Assert.assertFalse(quantityMeasurement.getClass().equals(check.getClass()));
    }

    @Test
    public void givenUnitValue_ShouldCheckEqualityInEntity_ForInchReturnsTrue() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 1.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenOneFeetAndOneInch_ShouldReturnNotEquals() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 1.0);
        Assert.assertNotEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenOneYardAndOneInch_shouldReturnNotEquals() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.YARD, 1.0);
        Assert.assertNotEquals(quantityMeasurement1, quantityMeasurement);
    }

    @Test
    public void givenThreeFeet_shouldReturnEqualToOneYard() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 3.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.YARD, 1.0);
        boolean b = quantityMeasurement.compareTo(quantityMeasurement1, quantityMeasurement1);
        Assert.assertTrue(b);
    }

    @Test
    public void givenOneYard_shouldReturn36inch(){
        try {
            QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.YARD, 1.0);
            QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 36.0);
            boolean b = quantityMeasurement.compareTo(quantityMeasurement1, quantityMeasurement1);
            Assert.assertTrue(b);
        } catch (QuantityMeasurementException e) {
            e.getMessage();
        }
    }

    @Test
    public void givenOneYardValueNegative_shouldThrowCustomException(){
        try {
            QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.YARD, -1.0);
            Assert.assertEquals("Negative values cannot be converted",QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        } catch (QuantityMeasurementException e) {
        e.printStackTrace();
        }
    }


    @Test
    public void givenZeroCm_andZeroCm_ShouldReturnEqual() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 0.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenZeroCm_andOtherCM_shouldReturnNotEqual() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 1.0);
        Assert.assertNotEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenCM_whenCheckedForNullShouldReturnFalse() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(quantityMeasurement.equals(nullValue));
    }

    @Test
    public void givenCM_referenceToSameObject_ShouldReturnTrue() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
        QuantityMeasurement dummyReference = quantityMeasurement;
        Assert.assertTrue(quantityMeasurement.equals(dummyReference));
    }

    @Test
    public void givenClassType_IfDifferent_ShouldReturnNotEqual() throws QuantityMeasurementException{
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
        String hello = "This Is String";
        Assert.assertFalse(quantityMeasurement.getClass().equals(hello.getClass()));
    }

    @Test
    public void givenUnitValuesOfCm_ShouldCheckEqualityInUnits() {
        try {
            QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
            QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 1.0);
            Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given0Inch0Feet_ShouldReturn_Zero() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 0.0);
        boolean b = quantityMeasurement.compareTo(quantityMeasurement1, quantityMeasurement1);
        Assert.assertTrue(b);
    }

    @Test
    public void givenTwoInches_ShouldReturn_FiveCM() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 2.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 2.5);
        boolean b = quantityMeasurement.compareTo(quantityMeasurement1, quantityMeasurement1);
        Assert.assertTrue(b);
    }

    @Test
    public void givenTwoUnitsOfSameType_ShouldAddToInches()throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH,2.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 2.0);
        double addedValues = quantityMeasurement.addTwoUnits(quantityMeasurement, quantityMeasurement1);
        Assert.assertEquals(4.0,addedValues,0.0);
    }
    @Test
    public void givenOneFeetAndTwoInch_shouldReturnFourteenInch() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET,12.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 2.0);
        double addedValues = quantityMeasurement.addTwoUnits(quantityMeasurement,quantityMeasurement1);
        Assert.assertEquals(14, addedValues, 0.0);
    }

    @Test
    public void givenOneFeetAndOneFeet_ShouldReturnTwentyFourInch() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 12.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 12.0);
        double addedValues = quantityMeasurement.addTwoUnits(quantityMeasurement,quantityMeasurement1);
        Assert.assertEquals(24,addedValues,0.0);
    }

    @Test
    public void given1GallonAnd3Liters780ml_shouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement gallon = new QuantityMeasurement(Unit.GALLON, 1.0);
        QuantityMeasurement liter = new QuantityMeasurement(Unit.LITER, 3.78);
        boolean b = gallon.compareTo(gallon, liter);
        Assert.assertTrue(b);
    }

    @Test
    public void givenOneLitreAnd1000ml_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement liter = new QuantityMeasurement(Unit.LITER,1.0);
        QuantityMeasurement ml = new QuantityMeasurement(Unit.ML, 1000.0);
        boolean v = liter.compareTo(liter, ml);
        Assert.assertTrue(v);
    }

    @Test
    public void givenOneGallonAnd3780Liter_shouldReturnSeverThousandLiter() throws QuantityMeasurementException {
    QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.GALLON,3780.0);
    QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.LITER, 3780.0);
        double v = quantityMeasurement.addTwoUnits(quantityMeasurement, quantityMeasurement1);
    Assert.assertEquals(7560,v,0.0);
    }

    @Test
    public void givenOneKGAndThousandGrams_ShouldReturnEquals() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.KG, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.GRAM, 1000.0);
        boolean b = quantityMeasurement.compareTo(quantityMeasurement1, quantityMeasurement1);
        Assert.assertTrue(b);
    }
    @Test
    public void givenOneTONEAndThousandKG_ShouldReturnEquals() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.TONNE, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.KG, 1000.0);
        boolean b = quantityMeasurement.compareTo(quantityMeasurement1, quantityMeasurement1);
        Assert.assertTrue(b);
    }

    @Test
    public void givenOneToneAndOneGrams_ShouldAddToExpectedResult() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.TONNE,1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.GRAM, 1000.0);
        double added = quantityMeasurement.addTwoUnits(quantityMeasurement, quantityMeasurement1);
        Assert.assertEquals(1001, added, 0.0);
    }

    @Test
    public void givenTemparatureInFahrenheitAndCelsius_ShouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement  = new QuantityMeasurement(Unit.FAHRENHEIT,212.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CELSIUS, 100.0);
        boolean b = quantityMeasurement.temperatureComparision(quantityMeasurement, quantityMeasurement1);
        Assert.assertEquals(true,b);


    }
}