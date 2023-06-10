package clsCollections;

import clsCollections.models.ClassCourse;
import clsCollections.models.Course;

import java.util.ArrayList;

public class Class6 {
  public static void main(String[] args) {
    Course course1 = new Course("JavaScript", 30);
    course1.addClass(new ClassCourse("ArrayList"));
    course1.addClass(new ClassCourse("LinkedList"));
    course1.addClass(new ClassCourse("List"));

    Course course2 = new Course("Java", 60);
    course2.addClass(new ClassCourse("Collections"));
    course2.addClass(new ClassCourse("Variables"));
    course2.addClass(new ClassCourse("Setters & Getters"));

    System.out.println("Class of the Course "+ course1.getName()+ ": " + course1.getListClass());
    System.out.println("Class of the Course "+ course2.getName()+ ": " + course2.getListClass());

    ArrayList<Course> listCourses = new ArrayList<>();
    listCourses.add(course1);
    listCourses.add(course2);

    System.out.println(listCourses);


  }
}
