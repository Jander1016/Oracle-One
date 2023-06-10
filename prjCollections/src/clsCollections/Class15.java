package clsCollections;

import clsCollections.models.Course;
import clsCollections.models.Student;

import java.util.*;

public class Class15 {
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

    System.out.println(course1.getStudent().contains(student1));
    System.out.println(course1.verficatedStudent(student7));

  }

}
