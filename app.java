import java.util.Scanner;

public class app {

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
                break;
            case 'F':
                System.out.println("Faculty!");
                break;
            default:
                break;
            }
            break;
        }
        s.close();
    }
}