import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {

    @Test
    public void givenQuantity_inFeet_ShouldConvert_toInches() throws QuantityMeasurementException {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        double actual = quantityMeasurement.convert(1);
        Assert.assertEquals(12,actual,0.0);
    }

    @Test
    public void givenQuantity_inNegativeFeet_ShouldThrowException() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        try {
            double actual = quantityMeasurement.convert(-2);
            Assert.assertEquals(24,actual,0.0);
        } catch (QuantityMeasurementException e) {
            e.getMessage();
        }
    }
}
