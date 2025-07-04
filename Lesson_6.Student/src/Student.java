import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;


    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    // средний балл
    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }


    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    // перевод на следующий курс
    public void promoteToNextCourse() {
        this.course++;
    }

    // инфо о студенте
    public void printInfo() {
        System.out.println("Имя: " + name + ", Группа: " + group + ", Курс: " + course + ", Средний балл: " + getAverageGrade());
    }
}