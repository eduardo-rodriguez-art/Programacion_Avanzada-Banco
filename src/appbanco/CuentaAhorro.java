package appbanco;

public class CuentaAhorro extends Cuenta{
    String clave = "1234";

    public boolean RetirarDinero(double retiro, String password){

        if(clave.equals(password)==false){
            return false;
        }else{
            return super.RetirarDinero(retiro);
            // llamo ese metodo desde la clase Cuenta con super
        }
    }

    public boolean setClave(String ClaveAnterior, String ClaveActual){
        if(clave.equals(ClaveAnterior)==true){
            clave = ClaveActual;
            return true;
        }else{
            return false;
        }
    }
}
