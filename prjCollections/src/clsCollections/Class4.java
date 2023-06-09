package clsCollections;

import clsCollections.models.Course;

import java.util.ArrayList;

public class Class4 {
  public static void main(String[] args) {
    Course course1 = new Course("History", 30);
    Course course2 = new Course("Language", 10);
    Course course3 = new Course("English", 20);
    Course course4 = new Course("Social Science", 50);

    ArrayList<Course> listCourses = new ArrayList<>();
    listCourses.add(course1);
    listCourses.add(course2);
    listCourses.add(course3);
    listCourses.add(course4);

    System.out.println(listCourses);
  }
}
