package clsCollections;

import clsCollections.models.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Class5 {
  public static void main(String[] args) {
    Course course1 = new Course("JavaScript", 30);
    Course course2 = new Course("Ruby", 10);
    Course course3 = new Course("PHP", 20);
    Course course4 = new Course("Java", 50);

    ArrayList<Course> listCourses = new ArrayList<>();
    listCourses.add(course1);
    listCourses.add(course2);
    listCourses.add(course3);
    listCourses.add(course4);

    System.out.println(listCourses);

    Collections.sort(listCourses, Comparator.comparing(Course::getName));

    System.out.println(listCourses);

    List<Course> courses = listCourses.stream()
                          .sorted(Comparator.comparingInt(Course::getTime))
                          .collect(Collectors.toList());

    System.out.println(courses);

    List<Course> courses2 = listCourses.stream()
            .filter(course -> !course.getName().equalsIgnoreCase("PHP"))
            .sorted(Comparator.comparingInt(Course::getTime))
            .collect(Collectors.toList());

    System.out.println(courses2);
  }
}
