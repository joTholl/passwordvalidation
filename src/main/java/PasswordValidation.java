import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class PasswordValidation {

    static final Set<String> commonPasswords = new HashSet<>(Arrays.asList("password","passwort", "12345678", "admin", "A2345678"));

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
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    static boolean containsUpperChar(String password) {
        if (password == null) {
            return false;
        }
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    static boolean containsLowerChar(String password) {
        if (password == null) {
            return false;
        }
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    static boolean isCommonPassword(String password) {
        password = password == null ? "" : password.trim().toLowerCase(Locale.ROOT);

        for (String commonPassword : commonPasswords) {
            if (password.contains(commonPassword)) {
                return true;
            }

        }
        return false;
    }

    static boolean isValid(String password) {
        if (!hasMinLenght(password)) {
            return false;
        }
        if (!containsDigit(password)) {
            return false;
        }
        if (!containsUpperChar(password)) {
            return false;
        }
        if (!containsLowerChar(password)) {
            return false;
        }
        if (isCommonPassword(password)) {
            return false;
        }
        return true;
    }

    static boolean containsSpecialChar(String password, String allowed) {
        //TODO
        return false;
    }
}
