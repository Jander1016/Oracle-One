public class TestGerente {
  public static void main(String[] args) {

    Gerente g1 = new Gerente();
    g1.setName("Marco");
    g1.setDocument("235568413");
    g1.setSalary(5000.0);

    System.out.println(g1.getName());
    System.out.println(g1.getDocument());
    System.out.println(g1.getSalary());

    g1.setPassword(2222);
    boolean autentico = g1.authenticate(2222);

    System.out.println(autentico);
    System.out.println(g1.getBonus());
  }
}
