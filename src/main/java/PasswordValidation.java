public final class PasswordValidation {

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
            if (password.contains(String.valueOf(i))){
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
            if (password.charAt(i)>='A'&&password.charAt(i)<='Z') {
                return true;
            }
        }
        return false;
    }

    static boolean containsLowerChar(String password) {
        //TODO
        return false;
    }

    static boolean isCommonPassword(String password) {
        //TODO
        return false;
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
