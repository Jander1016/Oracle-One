package clsCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Class3 {
  public static void main(String[] args) {
    String course1 = "History";
    String course2 = "Language";
    String course3 = "English";
    String course4 = "Social Science";

    ArrayList<String> listStrings = new ArrayList<>();
    listStrings.add(course1);
    listStrings.add(course2);
    listStrings.add(course3);
    listStrings.add(course4);

    System.out.println(listStrings);

    Collections.sort(listStrings);
    System.out.println(listStrings);

    Collections.sort(listStrings, Collections.reverseOrder());
    System.out.println(listStrings);

    listStrings.sort(Comparator.reverseOrder());
    System.out.println(listStrings);

    listStrings.sort(Comparator.naturalOrder());
    System.out.println(listStrings);

    List<String> courses= listStrings.stream().sorted().collect(Collectors.toList());
    System.out.println(courses);
  }
}
