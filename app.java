import java.util.Scanner;
import java.util.regex.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String dateAndTime = dateTimeFormat.format(now);
                    System.out.println(dateAndTime);
                    System.out.println("Attendance List for " + dateAndTime + ": ");
                    System.out.println("Enter the total class strength: ");
                    int tot = s.nextInt();
                    String stud[] = new String[tot];
                    for (int i = 0; i < tot; i++) {
                        System.out.println("Name of student " + (i + 1) + ": ");
                        stud[i] = s.next();
                    }

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