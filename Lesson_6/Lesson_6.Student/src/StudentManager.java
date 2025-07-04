import java.util.*;

class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

public class StudentManager {

    // Удаление студентов со средним баллом < 3
    public static void removeStudentsBelowAverage(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    // Перевод студентов на следующий курс, если средний балл >= 3
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.course += 1;
            }
        }
    }

    // Печать студентов, обучающихся на указанном курсе
    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Борис Годунов", "A", 1, Arrays.asList(5, 4, 4)));
        students.add(new Student("Андрей Аверьянов", "Б", 2, Arrays.asList(2, 2, 1)));
        students.add(new Student("Мария Белова", "A", 2, Arrays.asList(5, 5, 5)));
        students.add(new Student("Иван Иванов", "Б", 2, Arrays.asList(5, 3, 4)));
        students.add(new Student("Татьяна Петунина", "Б", 2, Arrays.asList(1, 2, 4)));


        removeStudentsBelowAverage(students);
        promoteStudents(students);
        System.out.println("Информация о переведённых студентах:");
        for (Student student : students) {
            System.out.print("Студент " + student.name + "; Группа: " + student.group +"; Курс: " + student.course + " \n");
        }


        // Студенты, обучающиеся на определённом курсе
        System.out.println("\nСтуденты на 2 курсе:");
        printStudents(students, 2);
    }
}

