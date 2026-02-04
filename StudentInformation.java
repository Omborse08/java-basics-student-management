import java.util.Scanner;

public class StudentInformation {
    public static int [][]studentNumber = new int [5][2];
    public static String [][]studentString = new String[5][2];
    public static int searchbyId;

    static void addStudent(int srNo, String name, int id, int age, String course) {
        studentString[srNo][0] = name;
        studentString[srNo][1] = course;
        studentNumber[srNo][0] = id;
        studentNumber[srNo][1] = age;
        System.out.println("Student Added Successfully");
    }

    static void viewAllStudent(int srNO) {
        for (int i=0;i<srNO;i++) {
            System.out.println("SrNo: "+(i+1)+" Name: "+studentString[i][0]+" ID: "+studentNumber[i][0]+" Age: "+studentNumber[i][1]+" Course: "+studentString[i][1]);
        }
    }

    static int searchByID(int srNo,int id) {
        searchbyId = -1;
        for(int i=0;i<srNo;i++) {
            if(studentNumber[i][0] == id) {
                searchbyId = i;
                break;
            }
        }
        return searchbyId;
    }

    static void showbysearchByID() {
        int  i = searchbyId;
        if (searchbyId == -1)
        {
            System.out.println("No Id Found!");
        }
        else {
            System.out.println("SrNo: " + (i + 1) + " Name: " + studentString[i][0] + " ID: " + studentNumber[i][0] + " Age: " + studentNumber[i][1] + " Course: " + studentString[i][1]);
        }
    }


    static void updateStudent(int srNo,int id,String updateName,int updateAge) {
        boolean isFound = true;
        for(int i=0;i<srNo;i++) {
            if(studentNumber[i][0] == id) {
                isFound = false;
                studentString[i][0] = updateName;
                studentNumber[i][1] = updateAge;
                System.out.println("Student Updates Successdully!");
            }
        }
        if(isFound) {
            System.out.print("\n> Student ID Not Found!");
        }
    }

    static boolean isIdExist(int srNo,int id) {
        boolean isExist = false;
        for(int i=0;i<srNo;i++) {
            if(studentNumber[i][0] == id) {
                isExist = true;
            }
        }
        return isExist;
    }

    static boolean removeStudentByID(int srNo,int id) {
        boolean isRemoved = false;
        for (int i=0;i<srNo;i++) {
            if (studentNumber[i][0] == id) {
                for (int j=i;j<srNo-1;j++) {
                    studentString[j][0] = studentString[j+1][0];
                    studentString[j][1] = studentString[j+1][1];
                    studentNumber[j][0] = studentNumber[j+1][0];
                    studentNumber[j][1] = studentNumber[j+1][1];
                }
                isRemoved = true;
                studentString[srNo-1][0] = null;
                studentString[srNo-1][1] = null;
                studentNumber[srNo-1][0] = 0;
                studentNumber[srNo-1][1] = 0;
            }
        }
        return isRemoved;
    }


    static void showMenu() {
        System.out.println("1.Add Student\n2.View All Student\n3.Search By Id\n4.Update Student\n5.Remove Student\n6.Exit");
    }
    public static void main(String[] args) {
        boolean isRunning = true;
        int srNO = 0;
        Scanner sc = new Scanner(System.in);
        showMenu();
        while (isRunning) {
            System.out.print("\n> Choose Option: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    if (srNO<5) {
                        sc.nextLine();
                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();
                        if (isIdExist(srNO,id)) {
                            System.out.println("> Student ID Exist!");
                            continue;
                        }
                        sc.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
                        if (name.isEmpty()) {
                            System.out.print("Empty Name Not Allowed!");
                            continue;
                        }

                        System.out.print("Enter Student Age: ");
                        int age = sc.nextInt();
                        if (age < 0 || age > 23) {
                            System.out.print("Check Age Again!");
                            continue;
                        }
                        sc.nextLine();
                        System.out.print("Enter Course Name: ");
                        String course = sc.nextLine();
                        if (course.isEmpty()) {
                            System.out.print("Empty Course Not Allowed!");
                            continue;
                        }
                        addStudent(srNO, name, id, age, course);
                        srNO++;
                    }
                    else {
                        System.out.print("\nData Full Plz Remove Students To Continue");
                    }
                    break;

                case 2:
                    if (srNO==0) {
                        System.out.println("NO DATA YET!");
                    }
                    else {
                        viewAllStudent(srNO);
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();
                    searchByID(srNO,searchId);
                    showbysearchByID();
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Update Name: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter Update Age: ");
                    int updateAge = sc.nextInt();
                    updateStudent(srNO,updateId,updateName,updateAge);
                    break;

                case 5:
                    System.out.println("Enter Student ID: ");
                    int removeByID = sc.nextInt();
                    if (removeStudentByID(srNO,removeByID)) {
                        srNO--;
                        System.out.println("Student Removed Successfully!");
                    }
                    else {
                        System.out.println("Student ID Not Found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank You Bye!");
                    isRunning = false;
                    break;
            }
        }
    }
}