package task2;

public class RegistrationValidator {
    public static boolean registerUser(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка регистрации: " + e.getMessage());
            return false;
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (!login.matches("^[A-Za-z0-9_]{1,20}$")) {
            throw new WrongLoginException("Некорректный логин");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches("^[A-Za-z0-9_]{1,20}$") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Некорректный пароль");
        }
    }
}

