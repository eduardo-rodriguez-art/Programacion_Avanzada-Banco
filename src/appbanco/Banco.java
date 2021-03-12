package appbanco;

import java.util.ArrayList;

public class Banco {

    protected String nombre;
    protected String direction;
    private ArrayList<Cliente> client;

    public Banco(){
        client = new ArrayList();
    }
    /*
    Un error común a la hora de programar es comenzar con
    las clases que tienen como atributos otras clases
    que aún no han sido definidas, como es el caso de
    la Clase Banco que tiene como atributo un conjunto
    de objetos de la clase cliente.
     */
    public void AgregarCliente(Cliente Ce){
        if (client==null){

            client=new ArrayList();
        }
        client.add(Ce);
    }

    public int ObtenerNumClientes(){
        return client.size();
    }

    public Cliente ObtenerCliente(int index){
        return client.get(index);
    }

    public void AsignarDatosdelBanco(String n, String d){
        nombre=n;
        direction=d;
    }

    public String ObtenerNombre(){
        return nombre;
    }

    public String ObtenerDireccion(){
        return direction;
    }

}
