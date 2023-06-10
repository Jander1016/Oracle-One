package clsCollections.models;

import java.util.*;

public class Course {
  private String  name;
  private int time;
  private List<ClassCourse> listClass = new ArrayList<>();
  private Collection<Student> student = new HashSet<>();
//private Collection<Student> student = new LinkedHashSet<>();
  private Map<String, Student> studentMap = new HashMap<>();
  //private Map<String, Student> studentMap = new linkedHashMap<>();
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

  public void addClass(ClassCourse c) {
    this.listClass.add(c);
  }

  @Override
  public String toString() {
    return this.name + " (" + time + ")";
  }

  public void addStudent(Student student) {
    this.student.add(student);
    this.studentMap.put(student.getCode(), student);
  }
  public boolean verificatedStudent(Student student) {
    return this.student.contains(student);
  }
  public Collection<Student> getStudents() {
    return student;
  }

  public Map<String, Student> getStudentMap() {
    return studentMap;
  }
}
