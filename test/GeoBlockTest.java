import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.geoclusters.Geocluster;
import org.junit.Test;
import com.geoclusters.Geoblock;

/**
 * Created by noelwilson on 12/12/2015.
 */

public class GeoBlockTest {
    @Test
    public void test4by7Geoblock() {
        String csv_file = "test_01.csv";
        Geoblock geoblock = new Geoblock(4,7);
        assertEquals(28, geoblock.get_geos().size());

        // Load csv data into geo block
        geoblock.load_csv(csv_file);

        // Get largest
        Geocluster cluster = geoblock.get_largest_cluster();

        // Output cluster data =
        String cluster_expected_output = "13, Matt, Thu Oct 14 00:00:00 BST 2010\n" +
        "17, Patrick, Thu Mar 10 00:00:00 GMT 2011\n" +
        "21, Catherine, Fri Feb 25 00:00:00 GMT 2011\n" +
        "22, Michael, Fri Feb 25 00:00:00 GMT 2011\n";
        String cluster_output = cluster.output();

        assertEquals(cluster_expected_output, cluster_output);
    }

    @Test
    public void test7by4Geoblock() {
        String csv_file = "test_01.csv";
        Geoblock geoblock = new Geoblock(7,4);
        assertEquals(28, geoblock.get_geos().size());

        // Load csv data into geo block
        geoblock.load_csv(csv_file);

        // Get largest
        Geocluster cluster = geoblock.get_largest_cluster();

        // Output cluster data =
        String cluster_expected_output = "4, Tom, Sun Oct 10 00:00:00 BST 2010\n" +
                "11, Mel, Sat Jan 01 00:00:00 GMT 2011\n" +
                "5, Katie, Tue Aug 24 00:00:00 BST 2010\n" +
                "6, Nicole, Sun Jan 09 00:00:00 GMT 2011\n" +
                "13, Matt, Thu Oct 14 00:00:00 BST 2010\n";
        String cluster_output = cluster.output();

        assertEquals(cluster_expected_output, cluster_output);
    }

    @Test
    public void load_test() {
        String csv_file = "test_02.csv";
        long startTime = System.currentTimeMillis();

        Geoblock geoblock = new Geoblock(1000,1000);

        // Load csv data into geo block
        geoblock.load_csv(csv_file);

        // Get largest
        Geocluster cluster = geoblock.get_largest_cluster();

        long finishTime = System.currentTimeMillis();
        long time_passed = (finishTime - startTime);

        System.out.print("Test time passed: " + Long.toString(time_passed));

        assertTrue(time_passed < 1000);
    }
}