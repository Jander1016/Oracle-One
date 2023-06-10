package clsCollections.models;

public class Student {
  private String name;
  private String code;

  public Student(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public boolean equals(Object obj) {
    Student student= (Student) obj;
    return this.name.equals(student.getName());
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }
}
