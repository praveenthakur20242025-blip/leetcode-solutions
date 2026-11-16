class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class custom {
    public static void main(String[] args) {

        int age = 16;

        try {
            if (age < 18) {
                throw new InvalidAgeException("Age is below 18");
            }

            System.out.println("Eligible");

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}