package appbanco;

public class Cuenta{

    protected int numeroCuenta;
    protected double saldo;

    public boolean asignarNumeroCuenta(int d){
        if (d>0){
            numeroCuenta = d;
            return true;
        }
        return false;
    }

    public boolean abonarDinero(double d){
        if(d>0){
            saldo = saldo+d;
            return true;
        }
        return false;
    }

    public boolean RetirarDinero(double d){
        if(d>0){
            saldo = saldo-d;
            return true;
        }
        return false;
    }

    public double obtenerSaldo(){
        return saldo;
    }

/*
        Getters and setters de numero de cuenta
         */

    public int obtenerNumeroCuenta(){
        return numeroCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


}


