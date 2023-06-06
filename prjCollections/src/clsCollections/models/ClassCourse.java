package clsCollections.models;

public class ClassCourse {
  private String  name;

  public ClassCourse(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return this.name ;
  }
}
