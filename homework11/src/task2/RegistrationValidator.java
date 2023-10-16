package task2;

public class RegistrationValidator {
    public static boolean registerUser(String login, String password, String confirmPassword) {
        try {
            if (!isValidLogin(login)) {
                throw new WrongLoginException("Некорректный логин: " + login);
            }

            if (!isValidPassword(password, confirmPassword)) {
                throw new WrongPasswordException("Некорректный пароль: " + password);
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка регистрации: " + e.getMessage());
            return false;
        }
    }

    private static boolean isValidLogin(String login) {
        return login.matches("^[A-Za-z0-9_]{1,20}$");
    }

    private static boolean isValidPassword(String password, String confirmPassword) {
        return password.matches("^[A-Za-z0-9_]{1,20}$") && password.equals(confirmPassword);
    }
}

