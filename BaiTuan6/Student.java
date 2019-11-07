import java.io.Serializable;

public class Student extends Person implements Serializable {
    private int studentID;
    private Subject[] subjects;

    public Student(int studentID, Subject[] subjects) {
        this.studentID = studentID;
        this.subjects = subjects;
    }

    public Student(String name, int age, int studentID, Subject[] subjects) {
        super(name, age);
        this.studentID = studentID;
        this.subjects = subjects;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public double getAverageMark(){
        double totalMark = 0;
        for(int i = 0; i < this.subjects.length; i++){
            totalMark += this.subjects[i].getMark();
        }
        return totalMark / subjects.length;

    }

    private String getMarkDetails(){
        String out = "";
        for(int i = 0; i < subjects.length; i++){
            out += (subjects[i].getSubjectName() + ": " + subjects[i].getMark() + ", ");
        }
        return out + "Average mark: " + getAverageMark();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", studentID=" + studentID +
                ", subjects=" + getMarkDetails() +
                '}';
    }
}
