package appbanco;
import java.util.Scanner;

public class AppBanco {

    public static void main(String[] args) {
        int opc;
        Banco bank = new Banco();
        bank.AsignarDatosdelBanco("Banco Upiita", "Avenida IPN");

        do{
            System.out.println("1. Agregar cliente");
            System.out.println("2. Seleccionar cliente");
            System.out.println("3. Listar clientes");
            System.out.println("9. Salir");
            System.out.print("Ingrese su seleccion: ");
            opc = Seleccion();

            switch(opc){
                case 1:
                    AgregarCliente(bank);
                    break;
                case 2:
                    SeleccionarCliente(bank);
                    break;
                case 3:
                    ListarClientes(bank);
                    break;
            }

        }while(opc != 9);
    }

    public static int Seleccion(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String Informacion(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void AgregarCliente(Banco b){
        String nombre;
        int edad;
        System.out.print("Ingresa nombre del cliente: ");
        nombre = Informacion();
        System.out.print("Ingresa edad del cliente: ");
        edad = Seleccion();
        // Traigo a la clase cliente, los guarda en su array
        Cliente cl = new Cliente();
        cl.AsignarNombre(nombre);
        cl.AsignarEdad(edad);
        b.AgregarCliente(cl);  //lo agrega al banco
    }

    public static void SeleccionarCliente(Banco b){
        int opc;
        Cliente aux;
        if(b.ObtenerNumClientes()==0){
            System.out.println("No hay clientes registrados!");
        }else{
            ListarClientes(b);
            System.out.print("Ingrese numero de cliente: ");
            opc = Seleccion();
            aux = b.ObtenerCliente(opc);
            if(aux != null){
                operacionCliente(aux);
            }else{
                System.out.println("Numerod e clientes no valido");
            }
//terminado
        }
    }

    public static void ListarClientes(Banco b){
        int tam = b.ObtenerNumClientes();
        if(tam==0){
            System.out.println("No hay clientes registrados");
        }else{
            System.out.println("Estos son los clientes registrados");
            for(int i=0; i<tam; i++){
                Cliente aux;
                aux = b.ObtenerCliente(i);
                System.out.println(i+" "+aux.ObtenerNombre()+" "+aux.ObtenerEdad());
            }
        }
    }

    /**
     * Metodo que se llama en el metodo
     * seleeccionar numero de clientes
     */
    public static void operacionCliente(Cliente cl){
        int opc;
        do{
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Seleccionar Cuenta");
            System.out.println("3. Listar cuentas");
            System.out.println("9. Regresar al menu");
            System.out.print("Ingrese seleccion: ");
            opc = Seleccion();

            switch(opc){
            }

        }while(opc != 9);
    }

    /**
     * Metodos que se llaman en el menu de operacionCliente
     */

    /**
        Este le agrega una cuenta al usuario
     voy a hacer nuevas clases con herencia
     e implementarlas aqui
     */
    public static void AgregarCuenta(Cliente client){
        int opc1, accountNumber;

        System.out.println("SELECCIONE SU TIPO DE CUENTA");
        System.out.println("1. Cuenta de ahorro");
        System.out.println("2. Cuenta de inversion");
        System.out.println("3. Cuenta de crédito");
        opc1 = Seleccion();
        System.out.print("Ingrese el numero de cuenta: ");
        accountNumber = Seleccion();
        String clave;
        switch(opc1){
            case 1: // Extiendo clase cuenta y llamo a esa clase
                CuentaAhorro ca = new CuentaAhorro();
                ca.asignarNumeroCuenta(accountNumber);
                System.out.println("Ingrese su nueva clave");
                clave = Informacion();
                ca.setClave("1234", clave);
                client.AgregarCuenta(ca);
                break;
            case 2:

                break;
            case 3:
                break;
                
            default:
                System.out.println("Cuenta no ingresada");
        }
    }

} //llave de la clase