package clsCollections;

import clsCollections.models.ClassCourse;
import clsCollections.models.Course;

import java.util.ArrayList;
import java.util.List;

public class Class7 {
  public static void main(String[] args) {
    Course course1 = new Course("JavaScript", 30);
    course1.AddClass(new ClassCourse("ArrayList"));
    course1.AddClass(new ClassCourse("LinkedList"));
    course1.AddClass(new ClassCourse("List"));

    Course course2 = new Course("Java", 60);
    course2.AddClass(new ClassCourse("Collections"));
    course2.AddClass(new ClassCourse("Variables"));
    course2.AddClass(new ClassCourse("Setters & Getters"));

    System.out.println("Class of the Course "+ course1.getName() + ": " + course1.getListClass());
    System.out.println("Class of the Course "+ course2.getName() + ": " + course2.getListClass());

    List<ClassCourse> list = course1.getListClass();
    System.out.println(list);

    ArrayList<Course> listCourses = new ArrayList<>();
    listCourses.add(course1);
    listCourses.add(course2);

    System.out.println(listCourses);

  }
}
