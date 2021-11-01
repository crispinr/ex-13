import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface utilities {

    void date();

    boolean validate(String emailStr);
}

class util implements utilities {

    public void date() {
        String date;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDateTime now = LocalDateTime.now();
        date = dateFormat.format(now);
        System.out.println("Attendance List for " + date + ": ");
    }

    public boolean validate(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}

public class app {

    public static void main(String args[]) {

        // variables
        String email, name;
        char key;

        util u = new util();

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
                if (u.validate(email)) {
                    System.out.println("Nice");
                    u.date();
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
                if (u.validate(email)) {
                    System.out.println("Nice");
                    u.date();
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