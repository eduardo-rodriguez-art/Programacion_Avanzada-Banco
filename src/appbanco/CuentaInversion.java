package appbanco;

public class CuentaInversion extends Cuenta{

    double tasaInversion;
    double ISR;
    double ISRRetenido;
    double utilidad;

    public CuentaInversion(double ISR, double tasaInversion){
        ISRRetenido = 0;
        utilidad = 0;
        this.ISR = ISR;
        this.tasaInversion = tasaInversion;
    }

    /*
    ISR = 10%
    TASAINVERSION = 10%
    SALDO = 0
    --------------- INGRESO DE 1000 PESOS
    SALDO=1000
    UTILIDAD = 0
    ----- YA PASO UN MES EJEMPLO
    - SALDO=1100
    UTILIDAD=100
    ----------- INGRESO 900 PESOS
    SALDO = 2000
    UTILIDAD=100
    ---------------
    SALDO = 2200 = 1000+900+300
    UTILIDAD = 300

    CASO 1 -> RETIRO DE 2000
    YO RETIRO 1900 PERO NO RETIENEN ISR PORQUE ES MI DINERO
    100->UTILIDAD
    PERO COMO ES DE UTILIDAD Y EL ISR RETENIDO ES DE 10%
    SOLO ME DAN 1990 PESOS  10 SE VAN AL SALDO RETENIDO

     */

    @Override
    public boolean RetirarDinero(double d){
        if(saldo >= d){

            if((saldo - utilidad)>d){
                saldo -= d;
                return true;
            }else{
                saldo = saldo - d;
                ISRRetenido = (ISRRetenido+(utilidad-saldo)*ISR);
                utilidad=saldo;
                return true;
            }
        }
        return false;
    }

    public void CalcularUtilidadMensual(){
        utilidad = utilidad + (saldo*(tasaInversion/12));
        saldo = saldo + (saldo*(tasaInversion/12));
    }

}
