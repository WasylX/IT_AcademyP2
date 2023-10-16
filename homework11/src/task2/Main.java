package task2;

public class Main {
    public static void main(String[] args) {
        String login = "user123";
        String password = "password123";
        String confirmPassword = "password123";

        boolean registrationResult = RegistrationValidator.registerUser(login, password, confirmPassword);

        if (registrationResult) {
            System.out.println("Регистрация успешна.");
        } else {
            System.out.println("Регистрация не удалась.");
        }
    }
}

