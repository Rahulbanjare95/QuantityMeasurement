import exception.QuantityMeasurementException;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.UNKNOWN;
import service.QuantityMeasurement;
import utility.Unit;


public class QuantityMeasurementTest {

    @Test
    public void givenFeetToCheckEquality_ShouldReturnEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 0.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenNullValue_shouldCheck() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(quantityMeasurement.equals(nullValue));
    }

    @Test
    public void givenReference_SameObject_ShouldReturnTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = quantityMeasurement;
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
    }

    @Test
    public void givenClassType_IfDifferent_ShouldReturnFalse() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        String message = "Hello World!";
        Assert.assertFalse(quantityMeasurement.getClass().equals(message.getClass()));
    }

    @Test
    public void givenUnitValue_shouldCheck_EqualityInEntity_ReturnsTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 1.0);
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
    }

    @Test
    public void givenZeroInch_shouldReturnEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 0.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenNullValue_ShouldReturnFalse() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(quantityMeasurement.equals(nullValue));
    }

    @Test
    public void givenReference_ForSameObject_ForInch_ShouldReturnTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement reference = quantityMeasurement;
        Assert.assertTrue(quantityMeasurement.equals(reference));
    }

    @Test
    public void givenClassType_IfDifferentWhenINCHisUnit_ShouldReturnFalse() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        String check = "Hello Java";
        Assert.assertFalse(quantityMeasurement.getClass().equals(check.getClass()));
    }

    @Test
    public void givenUnitValue_ShouldCheckEqualityInEntity_ForInchReturnsTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 1.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenOneFeetAndOneInch_ShouldReturnNotEquals() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 1.0);
        Assert.assertNotEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenOneYardAndOneInch_shouldReturnNotEquals() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.YARD, 1.0);
        Assert.assertNotEquals(quantityMeasurement1, quantityMeasurement);
    }

    @Test
    public void givenThreeFeet_shouldReturnEqualToOneYard() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 3.0);
        double convert = quantityMeasurement.convertFeetToYard((double) 3);
        Assert.assertEquals(1, convert, 0.0);

    }

    @Test
    public void givenOneYard_shouldReturn36inch() {
        try {
            QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.YARD, 1.0);
            double convert = quantityMeasurement.convertYardToInch((double) 1);
            Assert.assertEquals(36, convert, 0.0);
        } catch (QuantityMeasurementException e) {
            e.getMessage();
        }
    }

    @Test
    public void givenOneYardValueNegative_shouldThrowCustomException() {
        try {
            QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.YARD, 1.0);
            double convert = quantityMeasurement.convertYardToInch(-1.0);
            Assert.assertEquals("Negative value not allowed",
                    QuantityMeasurementException.ExceptionType.NEGATIVE_UNIT_ERROR);
        } catch (QuantityMeasurementException e) {
            e.getMessage();
        }
    }

    @Test
    public void givenZeroCm_andZeroCm_ShouldReturnEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 0.0);
        Assert.assertEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenZeroCm_andOtherCM_shouldReturnNotEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 1.0);
        Assert.assertNotEquals(quantityMeasurement, quantityMeasurement1);
    }

    @Test
    public void givenCM_whenCheckedForNullShouldReturnFalse() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM,1.0);
        QuantityMeasurement nullValue = null;
        Assert.assertFalse(quantityMeasurement.equals(nullValue));
    }

    @Test
    public void givenCM_referenceToSameObject_ShouldReturnTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
        QuantityMeasurement dummyReference = quantityMeasurement;
        Assert.assertTrue(quantityMeasurement.equals(dummyReference));
    }
    @Test
    public void givenClassType_IfDifferent_ShouldReturnNotEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
        String hello = "This Is String";
        Assert.assertFalse(quantityMeasurement.getClass().equals(hello.getClass()));
    }
    @Test
    public void givenUnitValuesOfCm_ShouldCheckEqualityInUnits() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.CM, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.CM, 1.0);
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
    }



}
