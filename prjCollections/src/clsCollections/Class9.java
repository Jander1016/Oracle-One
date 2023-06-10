package clsCollections;

import clsCollections.models.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Class9 {
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

    listCourses.sort(Comparator.comparing(Course::getName).reversed());

    // Sum the total time courses
    int sum = 0;
    for (Course course : listCourses) {
      sum += course.getTime();
    }
    System.out.println("The total time of courses: " + sum);

    // Sum the total time courses con stream
    System.out.println("The total time of courses: " + listCourses.stream().mapToInt(Course::getTime).sum());

    // Sum the Max time courses con stream
    System.out.println("The Max time of List courses: " + listCourses
                                                            .stream()
                                                              .mapToInt(Course::getTime)
                                                              .max().getAsInt());

    // Sum the total time courses con stream
    System.out.println("The Sum time of List courses ignored PHP: " + listCourses
            .stream()
            .filter(course->!course.getName().equalsIgnoreCase("PHP"))
            .mapToInt(Course::getTime)
            .sum());


  }
}
