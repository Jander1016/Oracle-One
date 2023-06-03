public class TestFuncionario {
  public static void main(String[] args) {
    Funcionario manager = new Funcionario();
    manager.setName("Jander");
    manager.setDocument("01908765W");
    manager.setSalary(6000);

    System.out.println("Bonus funcionario: " + manager.getBonus());

  }
}
