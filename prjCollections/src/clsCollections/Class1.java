package clsCollections;

import java.util.ArrayList;

public class Class1 {
  public static void main(String[] args) {
    String variable1="example1";
    String variable2="example2";
    String variable3="example3";
    String variable4="example4";

    ArrayList<String> list1 = new ArrayList<>();
    list1.add(variable1);
    list1.add(variable2);
    list1.add(variable3);
    list1.add(variable4);

    System.out.println(list1);

    list1.remove(1);

    System.out.println(list1);

    list1.set(2,"Hello, world!");

    System.out.println(list1);


    System.out.println(list1.get(2));

    System.out.println(list1.size());

  }
}
