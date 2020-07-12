import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {

    @Test
    public void givenQuantity_inFeet_ShouldConvert_toInches() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        double actual = quantityMeasurement.convert(1);
        Assert.assertEquals(12,actual,0.0);
    }
}
