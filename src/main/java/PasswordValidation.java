import java.security.SecureRandom;
import java.util.*;


public final class PasswordValidation {
    static final Set<String> commonPasswords = new HashSet<>(Arrays.asList("password", "passwort", "12345678", "admin", "A2345678"));
    static final String allowedSpecialChars = "!?@§$%&/()=+*#'-_.:;";

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

    static List<String> isValid(String password) {
        List<String> result = new ArrayList<>();
        if (!hasMinLenght(password)) {
            result.add("Weniger als 8 Zeichen!");
        }
        if (!containsDigit(password)) {
            result.add("Keine Ziffer!");
        }
        if (!containsUpperChar(password)) {
            result.add("Kein Großbuchstabe!");
        }
        if (!containsLowerChar(password)) {
            result.add("Kein Kleinbuchstabe!");
        }
        if (isCommonPassword(password)) {
            result.add("Unsicheres Passwort!");
        }
        if (!containsSpecialChar(password)) {
            result.add("Kein Sonderzeichen oder ein falsches Sonderzeichen!");
        }
        if (result.isEmpty()) {
            result.add("Passwort erfolgreich validiert!");
        }
        return result;
    }

    static boolean containsSpecialChar(String password) {
        if (password == null) {
            return false;
        }
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (allowedSpecialChars.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }

    static String generateSecurePassword(int lenght) {
        if (lenght < 8) {
            System.out.println("Mindestens 8 Zeichen!");
            return null;
        }
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        //Each Type has to be in the String
        password.append((char) random.nextInt(65, 91));
        password.append((char) random.nextInt(97, 123));
        password.append(random.nextInt(0, 10));
        password.append(allowedSpecialChars.charAt(random.nextInt(0, allowedSpecialChars.length())));

        for (int i = 0; i < lenght - 4; i++) {
            int ran = random.nextInt(0, 4);
            switch (ran) {
                case 0:
                    //Digit
                    password.append(random.nextInt(0, 10));
                    break;
                case 1:
                    //Upper Char
                    password.append((char) random.nextInt(65, 91));
                    break;
                case 2:
                    //Lower Char
                    password.append((char) random.nextInt(97, 123));
                    break;
                case 3:
                    //Special Char
                    password.append(allowedSpecialChars.charAt(random.nextInt(0, allowedSpecialChars.length())));
                    break;
            }
        }
        Collections.shuffle(Arrays.asList(password.toString().toCharArray()));
        if (isCommonPassword(password.toString())) {
            //If password randomly is in the commonPasswords List, do it again
            return generateSecurePassword(lenght);
        }

        return password.toString();
    }

    static void main() {
        Scanner sc = new  Scanner(System.in);
        System.out.println("Bitte Ihr Passwort zur Validierung eingeben:");
        String password = sc.nextLine();
        System.out.println(isValid(password));
    }

}
