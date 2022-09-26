import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngBasic {

    @Test
    public void test1() {
        String testExpected = "cao";
        //dohvatanje podataka....
        //izvrsavanje neke akcije
        String testActual = "Cao";

        Assert.assertEquals(testActual, testExpected, "Poruke treba da budu jednake");
    }

    @Test
    public void test2() {
        String testExpected = "cao";
        //dohvatanje podataka....
        //izvrsavanje neke akcije
        String testActual = "cao";

        Assert.assertEquals(testActual, testExpected, "Poruke treba da budu jednake");
    }

    @Test
    public void test3() {
        int x = 10;
        int y = 5;

        Assert.assertTrue(x - y== 6, "Rezultat bi trebalo da bude 5");
    }

    @Test
    public void test4() {
        Assert.assertFalse(false, "Ne treba bit");
    }
}