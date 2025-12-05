import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationTest {

    @ParameterizedTest
    @CsvSource({"1234567,false","12345678,true","123456789,true","'',false",",false"})
    void hasMinLenghtTest(String given, boolean expected){
        assertEquals(expected,PasswordValidation.hasMinLenght(given));
    }

    @ParameterizedTest
    @CsvSource({"1,true","123,true","1ab,true","ab,false",",false"})
    void containsDigitTest(String given, boolean expected){
        assertEquals(expected,PasswordValidation.containsDigit(given));
    }

    @ParameterizedTest
    @CsvSource({"A,true","Abc,true","13,false","ab,false",",false"})
    void containsUpperCharTest(String given, boolean expected){
        assertEquals(expected,PasswordValidation.containsUpperChar(given));
    }
}
