import gitlab.foxminded.task4.IntegerDivision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




public class IntegerDivisionTest {
public static final IntegerDivision division = new IntegerDivision();
private static String actual;
private static final String expectedStandart = "_78945|4\n" +
        " 4    |------\n" +
        " --   |19736\n" +
        " _38\n" +
        "  36\n" +
        "  --\n" +
        "  _29\n" +
        "   28\n" +
        "   --\n" +
        "   _14\n" +
        "    12\n" +
        "    --\n" +
        "    _25\n" +
        "     24\n" +
        "     --\n" +
        "       1";

    @Test
    public void standartTest() {
        actual = division.division(78945,4);
        assertEquals(expectedStandart,actual);
    }
    @Test
    public void nullTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            division.division(null,null);
        });

        final String expectedMessage = "null division";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void divisionByZeroTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            division.division(2,0);
        });

        final String expectedMessage = "division by 0";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void negativeDivisionTest() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            division.division(6,-2);
        });

        final String expectedMessage = "negative values are not supported";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void dividerMoreThanDividentTest() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            division.division(6,7);
        });

        final String expectedMessage = "divider more than divident";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

















}
