public class PruebaEncapsulamiento {
  public static void main(String[] args) {
    Cuenta cuenta= new Cuenta(2);
    Cliente cliente= new Cliente();
      cliente.setNombre("Jander");
      cliente.setDocumento("0938383F");

      cuenta.setTitular(cliente);

      System.out.println(cliente);
      System.out.println(cuenta.getTitular());

  }
}
