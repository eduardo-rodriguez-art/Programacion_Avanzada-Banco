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

    public static Double SeleccionDouble(){
        Scanner dou = new Scanner(System.in);
        return dou.nextDouble();
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
            ListarClientes(b);  //lista los clientes para que pueda verlos
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
                case 1:
                    AgregarCuenta(cl);
                    break;
                case 2:
                    SeleccionarCuenta(cl);
                    break;
                case 3:
                    ListarCuentas(cl);
                    break;
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
                CuentaInversion myCI = new CuentaInversion(0.15, 0.07);
                myCI.asignarNumeroCuenta(accountNumber);
                client.AgregarCuenta(myCI); //otro polimorfismo nivel método
                break;
            case 3:
                CuentaCredito cc = new CuentaCredito();
                cc.setLimiteCredito(1000.0);
                client.AgregarCuenta(cc); // creo que polimorfismo nivel metodo
                break;

            default:
                System.out.println("Cuenta no ingresada");
        }
    }

    public static void SeleccionarCuenta(Cliente cl){
        int opc;
        Cuenta aux;
        if(cl.ObtenerNumeroCuentas()==0){
            System.out.println("El cliente no tiene cuentas asignadas");
        }else{
            ListarCuentas(cl);  //el metodo esta debajo de este
            System.out.print("Seleccione el indice de la cuenta: ");
            opc = Seleccion();
            aux = cl.ObtenerCuenta(opc);
            if(aux != null){
                OperacionCuenta(aux);  //esta debajo
            }else{
                System.out.println("Numero de cuenta no valido");
            }
        }
    }

    public static void ListarCuentas(Cliente cl){
        int tam, i;
        tam = cl.ObtenerNumeroCuentas();
        if(tam == 0){
            System.out.println("No hay cuentas registradas");
        }else{
            System.out.println("Estas son las cuentas disponibles");
            for (i=0;i<tam;i++){
                Cuenta aux;
                aux = cl.ObtenerCuenta(i);
                System.out.println(" "+i+": "+aux.obtenerNumeroCuenta()+" - Saldo: $"+aux.obtenerSaldo());
            }
        }
    }
//* problemas aqui
    public static void OperacionCuenta(Cuenta myAcc){
        int opc;
        System.out.println("1. Abonar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Obtener saldo");
        System.out.println("4. Calcular Utilidad");
        System.out.println("9. Regresar al menu");
        System.out.print("Ingrese seleccion: ");
        opc = Seleccion();
            switch(opc) {
                case 1:
                    AbonarEnCuenta(myAcc); //tambien debajo
                    break;
                case 2:
                    RetirarDinero(myAcc);
                    break;
                case 3:
                    ObtenerSaldo(myAcc);
                    break;
                case 4:
                    if (myAcc instanceof CuentaInversion) {
                        CalcularUtilidadMensual((CuentaInversion) myAcc);
                        //* el valor se castea
                    } else
                        System.out.println("No es cuenta de inversion");
                    break;
            }
    }

    public static void AbonarEnCuenta(Cuenta c){
        double dinero;
        System.out.print("Ingrese cantidad a abonar: $");
        dinero = SeleccionDouble();

        if(c.abonarDinero(dinero)){
            System.out.println("Cantidad abonada correctamente");
        }else{
            System.out.println("No se realizo la transaccion");
        }
    }

    public static void RetirarDinero(Cuenta c){
        String clave;
        double dinero;
        System.out.print("Ingrese cantidad a retirar: $");
        dinero = SeleccionDouble();
        if(c instanceof CuentaAhorro){
            System.out.print("Ingrese la clave: ");
            clave = Informacion();
            //se castea para que sea su instancia
            ((CuentaAhorro)c).RetirarDinero(dinero, clave);
        }
        else{
            if(c.RetirarDinero(dinero)){
                System.out.println("Transaccion realizada");
            }else{
                System.out.println("Error en la transaccion");
            }
        }
    }

    public static void ObtenerSaldo(Cuenta c){
        System.out.println("El saldo es: $"+c.obtenerSaldo());
    }

    public static void CalcularUtilidadMensual(CuentaInversion aux){
        aux.calcularUtilidadMensual();
    }

} //llave de la clase