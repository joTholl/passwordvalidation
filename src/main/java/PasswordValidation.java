import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class PasswordValidation {

    static final Set<String> commonPasswords = new HashSet<>(Arrays.asList("password", "12345678", "admin", "A2345678"));

    static boolean hasMinLenght(String password) {
        if (password == null) {
            return false;
        }
        return password.length() >= 8;
    }

    static boolean containsDigit(String password) {
        if (password == null) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (password.contains(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    static boolean containsUpperChar(String password) {
        if (password == null) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    static boolean containsLowerChar(String password) {
        if (password == null) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

    static boolean isCommonPassword(String password) {
        if (password == null) {
            return false;
        }
        password = password.toLowerCase();
        password = password.trim();
        for (String commonPassword : commonPasswords) {
            if (password.contains(commonPassword)) {
                return false;
            }

        }
        return true;
    }

    static boolean containsSpecialChar(String password, String allowed) {
        //TODO
        return false;
    }

    static boolean isValid(String password) {
        //TODO
        return false;
    }
}
