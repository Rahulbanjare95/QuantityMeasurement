import org.junit.Assert;
import org.junit.Test;
import service.QuantityMeasurement;
import service.Unit;

import javax.lang.model.element.QualifiedNameable;

public class QuantityMeasurementTest {

    @Test
    public void givenFeetToCheckEquality_ShouldReturnEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET,0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET,0.0);
        Assert.assertEquals(quantityMeasurement,quantityMeasurement1);
    }

    @Test
    public void givenNullValue_shouldCheck() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET,1.0);
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
    public void givenUnitValue_shouldCheck_EqualtiyInEntity_ReturnsTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.FEET, 1.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.FEET, 1.0);
        Assert.assertTrue(quantityMeasurement.equals(quantityMeasurement1));
    }

    @Test
    public void givenZeroInch_shouldReturnEqual() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(Unit.INCH, 0.0);
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(Unit.INCH, 0.0);
        Assert.assertEquals(quantityMeasurement,quantityMeasurement1);
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


}
