public class TestCuentaSinCliente {

    public static void main(String[] args) {
        Cuenta cuentaDeJimena = new Cuenta(21);
        System.out.println(cuentaDeJimena.getSaldo());

        // Descomentar esta linea para evitar el NullPointerException
         cuentaDeJimena.setTitular(new Cliente());

        System.out.println(cuentaDeJimena.getTitular());

        cuentaDeJimena.getTitular().setNombre("Jimena");
        System.out.println(cuentaDeJimena.getTitular().getNombre());
    }
}
