package Student;

import java.util.*;

interface Interface_StudentManager {
    boolean addStudent(Student student);
    boolean removeStudent(int rollno);
    Student searchStudent(int rollno);
    void showAllStudent();
    void showSameBMStudent(int monthNumber);
}

class StudentManager implements Interface_StudentManager {
    HashMap<Integer,Student> students = new HashMap<>();


    @Override
    public boolean addStudent(Student student) {
        if (student != null) {
            students.put(student.getRollno(),student);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeStudent(int rollno) {
        if (students.containsKey(rollno)) {
            students.remove(rollno);
            return true;
        }
        return false;
    }

    @Override
    public Student searchStudent(int rollno) {
        if (students.containsKey(rollno)) {
            return students.get(rollno);
        }
        return null;
    }

    @Override
    public void showAllStudent() {
        if (students.isEmpty()) {
            System.out.println("No Data Found!");
        }
        else {
            for (int student: students.keySet()) {
                Student easy = students.get(student);
                System.out.println("Name: "+easy.getName()+", Roll No: "+easy.getRollno()+", Birth Month: "+easy.getBirthmonth());
            }
        }
    }

    @Override
    public void showSameBMStudent(int monthNumber) {
        if (students.isEmpty()) {
            System.out.println("No Data Found!");
        }
        else {
            for (int s : students.keySet()) {
                Student easy = students.get(s);
                if (easy.getBirthmonth() == monthNumber) {
                    System.out.println("Name: "+easy.getName()+", Roll No: "+easy.getRollno()+", Birth Month: "+easy.getBirthmonth());
                }
            }
        }
    }



}
