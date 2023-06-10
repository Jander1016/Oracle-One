package clsCollections;

import clsCollections.models.Course;
import clsCollections.models.Student;

import java.util.Comparator;
import java.util.Iterator;

public class Class16 {
  public static void main(String[] args) {
    Course course1 = new Course("JavaScript", 30);

    Student student1 = new Student("Jander", "001");
    Student student2 = new Student("Ricky Yegros", "002");
    Student student3 = new Student("Mauri", "003");
    Student student4 = new Student("Nacho", "004");
    Student student5 = new Student("Miqueas", "005");
    Student student6 = new Student("Miqueas", "006");
    Student student7 = new Student("Billy", "007");
    Student student8 = new Student("Julian", "008");

    course1.addStudent(student1);
    course1.addStudent(student2);
    course1.addStudent(student3);
    course1.addStudent(student4);
    course1.addStudent(student5);
    course1.addStudent(student6);
    course1.addStudent(student7);
    course1.addStudent(student8);

    course1.getStudents()
            .stream()
            .sorted(Comparator.comparing(Student::getCode).reversed())
            .forEach(student -> System.out.println(student.getCode() +" - " + student.getName()));

    Iterator<Student> studentsIterator = course1.getStudents().iterator();

    while(studentsIterator.hasNext())
    {
      System.out.println(studentsIterator.next().getName());
    }

    course1.getStudents().forEach(student-> System.out.println(student.getCode() +" - " + student.getName()));

  }
}
