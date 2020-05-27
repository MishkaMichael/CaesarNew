import org.junit.Test;
import ru.maleev.Caesar;

import static org.junit.Assert.assertEquals;

public class CaesarTest {
    @Test
    public void testEncrypt () {
        String sourse = "Привет! Hello?";
        String expected = "Рсйгёу! Ifmmp?";
        String actual = Caesar.encrypt(sourse, 1);
        assertEquals ("Unexpected string value", expected, actual);
    }
    @Test
    public void testDecrypt () {
        String sourse = "Рсйгёу! Ifmmp?";
        String expected = "Привет! Hello?";
        String actual = Caesar.decrypt(sourse, 1);
        assertEquals ("Unexpected string value", expected, actual);
    }
}
