package Student;
import java.util.*;
public class UI_Of_StudentProject {
    static void menu() {
        System.out.println("1.Add Student\n2.Remove Student\n3.Search Student\n4.Show All Student\n5.Show by Birth Month\n6.Exit");
    }
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        boolean isRun = true;
        int rollNo = 101;
        Scanner sc = new Scanner(System.in);
        menu();
        while (isRun) {
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student BirthMonthNumber: ");
                    int Bm = sc.nextInt();
                    Student student = new Student(name,rollNo,Bm);
                    if (sm.addStudent(student)) {
                        System.out.println("Student Added Successfully!");
                        System.out.println("Roll No: "+rollNo++);
                    }
                    else {
                        System.out.println("No Student Added!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student RollNo: ");
                    int num = sc.nextInt();
                    if (sm.removeStudent(num)) {
                        System.out.println("Student Removed Successfully!");
                    }
                    else {
                        System.out.println("No Student Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student Roll No: ");
                    int r = sc.nextInt();
                    if (sm.searchStudent(r) != null ) {
                        System.out.println("Student Name: "+sm.searchStudent(r).getName());
                        System.out.println("Student BirthMonth: "+sm.searchStudent(r).getBirthmonth());

                    }
                    else {
                        System.out.println("No Student Found!");
                    }
                    break;

                case 4:
                    System.out.println("All Student!");
                    sm.showAllStudent();
                    break;

                case 5:
                    System.out.println("Student By Month!");
                    System.out.print("Enter Month: ");
                    int m = sc.nextInt();
                    sm.showSameBMStudent(m);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    isRun = false;
                    break;
            }
        }

    }
}
