import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface Mediator {
    void sendMessage(String message, Student student);
    void addStudent(Student student);
}

// Concrete Mediator (Teacher)
class TeacherMediator implements Mediator {
    private List<Student> students = new ArrayList<>();

    @Override
    public void sendMessage(String message, Student sender) {
        for (Student student : students) {
            if (student != sender) {  // Sender shouldn't receive their own message
                student.receiveMessage(message);
            }
        }
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
}

// Colleague Class (Student)
abstract class Student {
    protected Mediator mediator;
    protected String name;

    public Student(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}

// Concrete Colleague (Specific Students)
class ConcreteStudent extends Student {

    public ConcreteStudent(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends message: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Mediator teacherMediator = new TeacherMediator();

        Student student1 = new ConcreteStudent(teacherMediator, "Sultan");
        Student student2 = new ConcreteStudent(teacherMediator, "Miras");
        Student student3 = new ConcreteStudent(teacherMediator, "Asanali");

        teacherMediator.addStudent(student1);
        teacherMediator.addStudent(student2);
        teacherMediator.addStudent(student3);

        // Students send messages via the mediator (teacher)
        student1.sendMessage("Can anyone help with the assignment?");
        student2.sendMessage("Sure, I can help!");
    }
}
