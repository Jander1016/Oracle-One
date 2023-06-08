package clsCollections;

import clsCollections.models.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Class10 {
  public static void main(String[] args) {
    Course course1 = new Course("JavaScript", 30);
    Course course2 = new Course("Ruby", 40);
    Course course3 = new Course("PHP", 20);
    Course course4 = new Course("Java", 50);
    Course course5 = new Course("Java", 35);
    Course course6 = new Course("Visual Studio .Net", 40);
    Course course7 = new Course("Python", 80);
    Course course8 = new Course("Python", 25);

    ArrayList<Course> listCourses = new ArrayList<>();

    listCourses.add(course1);
    listCourses.add(course2);
    listCourses.add(course3);
    listCourses.add(course4);
    listCourses.add(course5);
    listCourses.add(course6);
    listCourses.add(course7);
    listCourses.add(course8);

    listCourses.sort(Comparator.comparing(Course::getTime));
    System.out.println(listCourses);

    // Sum the total time courses con stream
    System.out.println("The total time of courses: " + listCourses.stream().mapToInt(Course::getTime).sum());

    // Sum the total time courses con stream
    System.out.println("The Sum time of List courses ignored PHP: " + listCourses
                    .stream()
                    .filter(course->!course.getName().equalsIgnoreCase("PHP"))
                    .mapToInt(Course::getTime)
                    .sum());

    // The Max time courses con stream
    System.out.println("The Max time of List courses:" + listCourses
                    .stream()
                    .mapToInt(Course::getTime)
                    .max().getAsInt());

    //The Average time courses con stream
    System.out.println("The Average time of List courses: " + listCourses
                    .stream()
                    .mapToInt(Course::getTime)
                    .average().getAsDouble());

    // The Min time courses con stream
    System.out.println("The Min time of List courses: " + listCourses
                    .stream()
                    .mapToInt(Course::getTime)
                    .min().getAsInt());


    Map<String, List<Course>> groupCourses;
    groupCourses = listCourses.stream().collect(Collectors.groupingBy(Course::getName));

    groupCourses.forEach((key, value) -> {
      System.out.println(key + " - " + value.size());
    });

    // Sum the total time courses con parallelStream
    System.out.println("The Sum time of List courses: " + listCourses
                    .parallelStream()
                    .mapToInt(Course::getTime)
                    .sum());

  }
}
