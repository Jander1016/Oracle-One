package clsCollections;

import clsCollections.models.Student;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Class14 {
  public static void main(String[] args) {
    Student student1= new Student("Jander","001");
    Student student2= new Student("Ricky Yegros","002");
    Student student3= new Student("Mauri","003");
    Student student4= new Student("Nacho","004");
    Student student5= new Student("Miqueas","005");
    Student student6= new Student("Miqueas","006");
    Student student7= new Student("Billy","007");
    Student student8= new Student("Julian","008");

    Collection<Student> students = new HashSet<>();

    students.add(student1);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);
    students.add(student6);
    students.add(student7);

    System.out.println(students.contains(student1));

    Student student9= new Student("Jander","001");
    students.add(student9);
    System.out.println(student1.equals(student9));
  }
}
