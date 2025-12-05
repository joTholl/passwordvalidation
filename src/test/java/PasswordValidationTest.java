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

    @ParameterizedTest
    @CsvSource({"a,true","Abc,true","13,false","A,false",",false"})
    void containsLowerCharTest(String given, boolean expected){
        assertEquals(expected,PasswordValidation.containsLowerChar(given));
    }

    @ParameterizedTest
    @CsvSource({"password1,true","12345678,true","Admin,true","Ek5jgn!?,false",",false"})
    void isCommonPasswordTest(String given, boolean expected){
        assertEquals(expected,PasswordValidation.isCommonPassword(given));
    }

    @ParameterizedTest
    @CsvSource({"Password1!,false","A1b!,false","Whgpasgn!jgh,false","saghom!3ss,false",
            "WAG1260!.,false"," aghh457!B,true","jakghi39AS!kldjfhnolsknjosangon,true",
            "AGjb52fhc,true","Ek5jgn!?3,true",",false"})
    void isValidTest(String given, boolean expected){
        assertEquals(expected,PasswordValidation.isValid(given));
    }
}
