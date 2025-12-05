import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationTest {

    @ParameterizedTest
    @CsvSource({"1234567,false", "12345678,true", "123456789,true", "'',false", ",false"})
    void hasMinLenghtTest(String given, boolean expected) {
        assertEquals(expected, PasswordValidation.hasMinLenght(given));
    }

    @ParameterizedTest
    @CsvSource({"1,true", "123,true", "1ab,true", "ab,false", ",false"})
    void containsDigitTest(String given, boolean expected) {
        assertEquals(expected, PasswordValidation.containsDigit(given));
    }

    @ParameterizedTest
    @CsvSource({"A,true", "Abc,true", "13,false", "ab,false", ",false"})
    void containsUpperCharTest(String given, boolean expected) {
        assertEquals(expected, PasswordValidation.containsUpperChar(given));
    }

    @ParameterizedTest
    @CsvSource({"a,true", "Abc,true", "13,false", "A,false", ",false"})
    void containsLowerCharTest(String given, boolean expected) {
        assertEquals(expected, PasswordValidation.containsLowerChar(given));
    }

    @ParameterizedTest
    @CsvSource({"password1,true", "12345678,true", "Admin,true", "Ek5jgn!?,false", ",false"})
    void isCommonPasswordTest(String given, boolean expected) {
        assertEquals(expected, PasswordValidation.isCommonPassword(given));
    }

    @ParameterizedTest
    @CsvSource({"Password1!,Unsicheres Passwort!", "A1b!,Weniger als 8 Zeichen!", "Whgpasgn!jgh,Keine Ziffer!", "saghom!3ss,Kein Großbuchstabe!",
            "WAG1260!.,Kein Kleinbuchstabe!", " aghh457!B,Passwort erfolgreich validiert!", "jakghi39AS!kldjfhnolsknjosangon,Passwort erfolgreich validiert!",
            "AGjb52fhc,Kein Sonderzeichen oder ein falsches Sonderzeichen!", "AGjb52fhc ,Kein Sonderzeichen oder ein falsches Sonderzeichen!","Ek5jgn!?3,Passwort erfolgreich validiert!",
            ",Weniger als 8 Zeichen!.Keine Ziffer!.Kein Großbuchstabe!.Kein Kleinbuchstabe!.Kein Sonderzeichen oder ein falsches Sonderzeichen!"})
    void isValidTest(String given, String expected) {
        List<String> expectedlist = Arrays.asList(expected.split("\\."));
        assertEquals(expectedlist, PasswordValidation.isValid(given));
    }

    @ParameterizedTest
    @CsvSource({"password1,false", "12345678 ,false", "Admin!,true", "Ek5jgn!?,true", ",false"})
    void containsSpecialCharTest(String given, boolean expected) {
        assertEquals(expected, PasswordValidation.containsSpecialChar(given));
    }

    @ParameterizedTest
    @CsvSource({"7,Weniger als 8 Zeichen!.Keine Ziffer!.Kein Großbuchstabe!.Kein Kleinbuchstabe!.Kein Sonderzeichen oder ein falsches Sonderzeichen!",
            "8,Passwort erfolgreich validiert!"})
    void generateSecurePasswordTest(String given, String expected) {
        List<String> expectedList = Arrays.asList(expected.split("\\."));
        assertEquals(expectedList, PasswordValidation.isValid(PasswordValidation.generateSecurePassword(Integer.parseInt(given))));
    }
}
