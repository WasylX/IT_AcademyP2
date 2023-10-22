package task2;

public class Main {
    public static void main(String[] args){
        String login = "user123";
        String password = "password123";
        String confirmPassword = "password124";

        RegistrationValidator.registerUser(login, password, confirmPassword);
    }
}

