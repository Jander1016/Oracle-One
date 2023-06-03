public class Gerente extends Funcionario{

  private int password;

  public void setPassword(int password) {
    this.password = password;
  }

  public boolean authenticate(int password){
    return this.password == password;
  }

  @Override
  public double getBonus() {
    return super.getBonus() + super.getSalary();
  }
}
