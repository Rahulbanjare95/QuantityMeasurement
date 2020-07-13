import org.junit.Assert;
import org.junit.Test;
import service.QuantityMeasurement;
import service.Unit;

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



}
