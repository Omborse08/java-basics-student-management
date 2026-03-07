package Student;

class Student{
    private String name;
    private int rollno;
    private int birthmonth;

    Student(String name,int rollno,int BM) {
        this.name = name;
        this.rollno = rollno;
        this.birthmonth = BM;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public int getBirthmonth() {
        return birthmonth;
    }
}
