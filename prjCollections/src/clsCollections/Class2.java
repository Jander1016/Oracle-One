package clsCollections;

import java.util.ArrayList;

public class Class2 {
  public static void main(String[] args) {
    String variable1="example1";
    String variable2="example2";
    String variable3="example3";
    String variable4="example4";

    ArrayList<String> listStrings = new ArrayList<>();
    listStrings.add(variable1);
    listStrings.add(variable2);
    listStrings.add(variable3);
    listStrings.add(variable4);

    System.out.println(listStrings);

    for (int i = 0; i < listStrings.size(); i++) {
      System.out.println(listStrings.get(i));
    }

    for (String variable : listStrings) {
      System.out.println(variable);
    }

    listStrings.forEach(variable-> System.out.println(variable));

  }
}
