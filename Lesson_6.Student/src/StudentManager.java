import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentManager {
    public static void removeLowGradeStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.promoteToNextCourse();
            }
        }
    }


    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты, учащиеся на " + course + " курсе:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> grades1 = Arrays.asList(4, 3, 5, 4);
        List<Integer> grades2 = Arrays.asList(2, 3, 2, 3);
        List<Integer> grades3 = Arrays.asList(3, 4, 5, 4);
        List<Integer> grades4 = Arrays.asList(5, 5, 5, 5);
        List<Integer> grades5 = Arrays.asList(2, 3, 2, 2);

        Student student1 = new Student("Иван Иванов", "A", 1, grades1);
        Student student2 = new Student("Мария Петрова", "A", 1, grades2);
        Student student3 = new Student("Татьяна Смирнова", "Б", 2, grades3);
        Student student4 = new Student("Андрей Аверьянов", "A", 2, grades4);
        Student student5 = new Student("Борис Годунов", "Б", 1, grades5);


        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        // печать всех студентов
        System.out.println("Список студентов:");
        for (Student student : students) {
            student.printInfo();
        }

        // удаление студентов с низким средним баллом
        removeLowGradeStudents(students);

        // актуальный список студентов после удаления
        System.out.println("\nСтуденты с высоким средним баллом:");
        for (Student student : students) {
            student.printInfo();
        }

        // перевод студента на следующий курс
        promoteStudents(students);

        // список студентов после перевода
        System.out.println("\nСписок студентов, переведённых на следующий курс:");
        for (Student student : students) {
            student.printInfo();
        }

        // печать студентов на определённом курсе
        System.out.println();
        printStudents(students, 2);
    }
}