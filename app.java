import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface utilities {

    String date();

    boolean validate(String emailStr);

    void exportToCSV();

    void createList();

    void student();

    void faculty();
}

class util implements utilities {

    // variables
    String email, name;
    int tot;

    // objects
    static Scanner s = new Scanner(System.in);
    ArrayList<String> studList = new ArrayList<String>();

    // methods
    public String date() {
        String date;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDateTime now = LocalDateTime.now();
        date = dateFormat.format(now);
        return date;
    }

    public boolean validate(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public void exportToCSV() {
        try (PrintWriter writer = new PrintWriter("data.csv")) {
            System.out.print("Enter the total roll number: ");
            int roll = s.nextInt();
            StringBuilder sb = new StringBuilder();
            sb.append("Name");
            sb.append(", ");
            sb.append("- Status");
            sb.append("\n\n");

            while (roll != 0) {
                System.out.print("Enter the student name: ");
                String name = s.next();
                sb.append(name);
                sb.append(", ");
                System.out.print("Enter the student status: ");
                String status = s.next();
                sb.append("- " + status);
                sb.append("\n");
                roll -= 1;
            }
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createList() {
        System.out.print("Enter the total class strength: ");
        tot = s.nextInt();
        for (int i = 1; i <= tot; i++) {
            System.out.print("Enter the name of the student: ");
            name = s.next();
            studList.add(name);
        }
    }

    public void displayList() {
        System.out.println("Attendance List for " + date() + ": ");
        try {
            Scanner sc = new Scanner(new File("./data.csv"));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                System.out.print(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void student() {
        System.out.println("Student!");
        System.out.print("Welcome to student login \nEnter your email: ");
        email = s.next();
        if (validate(email)) {
            displayList();
        } else {
            System.out.println("Please enter a valid email id!");
        }
    }

    public void faculty() {
        System.out.println("Faculty!");
        System.out.print("Welcome to faculty login \nEnter your email: ");
        email = s.next();
        if (validate(email)) {
            createList();
            exportToCSV();
        } else {
            System.out.println("Please enter a valid email id!");
        }
    }
}

public class app {

    public static void main(String args[]) {

        // variables
        char key;

        // objects
        util u = new util();

        // main loop
        while (true) {
            System.out.println("~Mr. Attendance~ \nSelect a login \tS - Student \tF - Faculty");
            key = util.s.next().charAt(0);
            switch (key) {
            case 'S':
                u.student();
                break;
            case 'F':
                u.faculty();
                break;
            default:
                System.out.println("Please enter a valid login!");
                break;
            }
            break;
        }
    }
}