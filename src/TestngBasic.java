import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "myDataProvider")
    public Object[][] createData1(){
        Object[][] mojaMatrica = new Object[2][3];
        mojaMatrica[0][0] = "Cedric";
        mojaMatrica[0][1] = "Zarkovic";
        mojaMatrica[0][2] = 36;

        mojaMatrica[1][0] = "Anne";
        mojaMatrica[1][1] = "Zarkovic";
        mojaMatrica[1][2] = 37;

        return mojaMatrica;

        /* Moze i ovako
        return new Object[][] {
        { "Cedric", "Zarkovic", 36},
        { "Anne", "Zarkovic", 37},
        };
         */
    }

    @Test(dataProvider = "myDataProvider")
    public void verifyData1(String ime, String prezime, Integer godine) {
        System.out.println(ime + " " + prezime + " " + godine);
    }
}