package clsCollections;

import java.util.*;
import java.util.stream.Collectors;

public class Class11 {
  public static void main(String[] args) {
    String student1="Jander";
    String student2="Ricky Yegros";
    String student3="Mauri";
    String student4="Nacho";
    String student5="Miqueas";

    Set<String> students = new HashSet<>();

    students.add(student1);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);

    for ( String student:students ) {
      System.out.println(student);
    }



  }
}
