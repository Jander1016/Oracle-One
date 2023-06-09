package clsCollections;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Class13 {
  public static void main(String[] args) {
    String student1="Jander";
    String student2="Ricky Yegros";
    String student3="Mauri";
    String student4="Nacho";
    String student5="Miqueas";
    String student6="Miqueas";

    Collection<String> students = new HashSet<>();

    students.add(student1);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);
    students.add(student6);

    boolean validated= students.contains(student2);

    String max = students.stream().max(Comparator.comparing(String::length)).get();

    System.out.println(max);

    students.removeIf(student -> student2.equalsIgnoreCase(student));


    students.forEach(student-> System.out.println(student));


  }
}
