import java.util.ArrayList;
import java.util.List;

public class Sever {
    private static Sever instance = new Sever();
    private static List<Student> studentList = new ArrayList<>();
    private Sever(){}
    public static Sever getInstance(){
        return instance;
    }

    public void loadAllStudentsData(){
        Subject[] subjectsStudent1 = {
        		 new Subject("Lap Trinh Mang", 9),
                 new Subject("Lap Trinh C", 8),
                 new Subject("Cau Truc Du Lieu", 7)
        };
        Subject[] subjectsStudent2 = {
        		new Subject("Toan Roi Rac", 10),
                new Subject("Ki Nang Mem", 7),
                new Subject("Lap Trinh Web", 9)
        };
        Subject[] subjectsStudent3 = {
        		new Subject("Dai So", 8),
                new Subject("Phuong Phap Tinh", 9),
                new Subject("NLCB1", 9)
        };
        Subject[] subjectsStudent4 = {
        		new Subject("TTMo", 8),
                new Subject("KPM", 9),
                new Subject("CNTT", 9)
        };
        Subject[] subjectsStudent5 = {
        		new Subject("A", 8),
                new Subject("B", 9),
                new Subject("C", 9)
        };
        studentList.add(new Student("Hoang Ngoc Long", 23, 64121, subjectsStudent1));
        studentList.add(new Student("Vu Tat Thanh", 23, 64154, subjectsStudent2));
        studentList.add(new Student("Nguyen Van A", 23, 64555, subjectsStudent3));
        studentList.add(new Student("Tran Van B", 19, 64777, subjectsStudent4));
        studentList.add(new Student("Tran Van C", 22, 64888, subjectsStudent4));
    }

    public List<Student> getTop5StudentWithHighestMark(){
        List<Student> listTop5 = new ArrayList<>();

        studentList.sort((student, otherStudent) -> student.getAverageMark() > otherStudent.getAverageMark() ? -1 : 1);

        for(int i = 0; i < 5; i++){
            listTop5.add(studentList.get(i));
        }

        return listTop5;
    }
}
