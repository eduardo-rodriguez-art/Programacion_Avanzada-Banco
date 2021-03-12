package appbanco;

public class CuentaInversion extends Cuenta{
    double ISR;
    double ISRRetenido;
    double utilidad;
    double tasaInversion;

    //* constructor
    public CuentaInversion(double ISR, double tasaInversion){
        utilidad = 0;
        ISRRetenido = 0;
        this.ISR = ISR;
        this.tasaInversion = tasaInversion;
    }

    /**
     * Metodos para calcular, retiro de dinero,
     * acumulacion de utilidades
     * e implementacion del ISR
     */

    @Override
    public boolean RetirarDinero(double d) {
        if(saldo >= d){
            if((saldo-utilidad)>d){
                saldo = saldo - d;
                return true;
            }else{ // si le restas la utilidad, el retiro fue mayor
                saldo = saldo - d;
                ISRRetenido = ISRRetenido+((utilidad-saldo)*ISR);
                utilidad = saldo;
                return true;
            }
        }
        return false;
    }

    public void calcularUtilidadMensual(){
        utilidad = utilidad+(saldo*(tasaInversion/12));
        saldo = saldo+(saldo*(tasaInversion/12));
    }
}
