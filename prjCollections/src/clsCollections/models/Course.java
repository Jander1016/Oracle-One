package clsCollections.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
  private String  name;
  private int time;

  private List<ClassCourse> listClass = new ArrayList<>();

  public Course(String name, int time) {
    this.name = name;
    this.time = time;
  }
  public Course(String name, int time, List<ClassCourse> listClass) {
    this.name = name;
    this.time = time;
    this.listClass = listClass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public List<ClassCourse> getListClass() {
    return Collections.unmodifiableList(listClass);
  }

  public void setListClass(List<ClassCourse> listClass) {
    this.listClass = listClass;
  }

  public void AddClass(ClassCourse c) {
    this.listClass.add(c);
  }

  @Override
  public String toString() {
    return this.name + " (" + time + ")";
  }
}
