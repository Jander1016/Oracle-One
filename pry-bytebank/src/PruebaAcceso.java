public class PruebaAcceso {
  public static void main(String[] args) {
    Cuenta cuenta = new Cuenta(-22);
    cuenta.setAgencia(-22);
    cuenta.deposita(400);
    cuenta.retirar(300);
    System.out.println(cuenta.getSaldo());
    System.out.println(cuenta.getAgencia());
  }
}
