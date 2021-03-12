package appbanco;

import java.io.LineNumberReader;
import java.util.ArrayList;

public class Cliente {

    protected String nombre;
    protected int edad;
    /*
    <Cuenta> -> tipo de datos que tendra el arreglo
    cuentas -> nombre del arreglo
    La clase Cliente necesita las propiedades
    de la clase Cuenta
     */

    private ArrayList<Cuenta> cuentas;

    public Cliente(){
        cuentas = new ArrayList();
    }

    public void AsignarNombre(String N){
        nombre=N;
    }

    public boolean AsignarEdad(int E){
        if(E>=18){
            edad = E;
            return true;
        }
        return false;
    }

    public void AgregarCuenta(Cuenta c){
        cuentas.add(c);
    }

    public int ObtenerNumeroCuentas(){
        return cuentas.size();  //obtiene tamano del array
    }

    public Cuenta ObtenerCuenta(int index){
        // este if dice que el parametro se sale de los elementos del array
        if(index<0 || (ObtenerNumeroCuentas() == 0) || (index >= ObtenerNumeroCuentas())){
            return null;
        }
        return cuentas.get(index);
    }

    public String ObtenerNombre(){
        return nombre;
    }

    public int ObtenerEdad(){
        return edad;
    }
}
