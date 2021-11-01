import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        // variables
        String email, name;
        char key;

        Scanner s = new Scanner(System.in);
        System.out.println("~Mr. Attendance~");
        while (true) {
            System.out.println("Select a login \tS - Student \tF - Faculty");
            key = s.next().charAt(0);
            switch (key) {
            case 'S':
                System.out.println("Student!");
                System.out.print("Welcome to student login \nEnter your email: ");
                email = s.next();
                if (validate(email)) {
                    System.out.println("Nice");
                    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String dateAndTime = dateTimeFormat.format(now);
                    System.out.println(dateAndTime);
                    System.out.println("Attendance List for " + dateAndTime + ": ");
                    System.out.print("Enter the total class strength: ");
                    int tot = s.nextInt();
                    ArrayList<String> studList = new ArrayList<String>(tot);
                    for (int i = 1; i <= tot; i++) {
                        System.out.print("Enter the name of the student: ");
                        name = s.next();
                        studList.add(name);
                    }
                    BufferedWriter br;
                    try {
                        br = new BufferedWriter(new FileWriter("sample.csv"));
                        StringBuilder sb = new StringBuilder();

                        // Append strings from array
                        for (String element : studList) {
                            sb.append(element);
                            sb.append(",");
                        }
                        br.write(sb.toString());

                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("Please enter a valid email id!");
                }
                break;
            case 'F':
                System.out.println("Faculty!");
                System.out.print("Welcome to faculty login \nEnter your email: ");
                email = s.next();
                if (validate(email)) {
                    System.out.println("Nice");
                    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String dateAndTime = dateTimeFormat.format(now);
                    System.out.println(dateAndTime);
                    System.out.println("Attendance List for " + dateAndTime + ": ");
                    System.out.print("Enter the total class strength: ");
                    int tot = s.nextInt();
                    ArrayList<String> studList = new ArrayList<String>(tot);
                    for (int i = 1; i <= tot; i++) {
                        System.out.print("Enter the name of the student: ");
                        name = s.next();
                        studList.add(name);
                    }
                    BufferedWriter br;
                    try {
                        br = new BufferedWriter(new FileWriter("sample.csv"));
                        StringBuilder sb = new StringBuilder();

                        // Append strings from array
                        for (String element : studList) {
                            sb.append(element);
                            sb.append(",");
                        }
                        br.write(sb.toString());

                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("Please enter a valid email id!");
                }
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