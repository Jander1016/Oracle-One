public class PruebaConstructor {
  public static void main(String[] args) {
    Cuenta cuenta1 = new Cuenta(22);
    Cuenta cuenta2 = new Cuenta(32);
    Cuenta cuenta3 = new Cuenta(221);
    Cuenta cuenta4 = new Cuenta(221);
    System.out.println(Cuenta.getTotal());
    System.out.println(cuenta2.getAgencia());
  }
}
