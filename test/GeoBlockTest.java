package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.geoclusters.Geoblock;

/**
 * Created by noelwilson on 12/12/2015.
 */

public class GeoBlockTest {
    @Test
    public void test4by7Geoblock() {
        Geoblock geoblocks = new Geoblock(4,7);
        assertEquals(28, geoblocks.get_geos().size());
    }
}