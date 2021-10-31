import java.util.Scanner;
import java.util.regex.*;

public class app {

    public static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("~Mr. Attendance~");
        while (true) {
            System.out.println("Select a login \tS - Student \tF - Faculty");
            char key;
            key = s.next().charAt(0);
            switch (key) {
            case 'S':
                System.out.println("Student!");
                System.out.println("Welcome to student login \nEnter your email: ");
                String email = s.next();
                if (validate(email)) {
                    System.out.println("Nice");
                } else {
                    System.out.println("Please enter a valid email id!");
                }
                break;
            case 'F':
                System.out.println("Faculty!");
                break;
            default:
                System.out.println("Please enter a valid login!");
                break;
            }

            break;
        }
        s.close();
    }
}