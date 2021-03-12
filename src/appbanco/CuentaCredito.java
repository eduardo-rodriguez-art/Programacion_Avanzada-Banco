package appbanco;

public class CuentaCredito extends Cuenta{
    double limiteCredito;

    @Override
    public boolean RetirarDinero(double d) {
        if((-saldo+d)<=limiteCredito){
            saldo = saldo - d;
            return true;
        }
        return false;
    }

    public void setLimiteCredito(double l){
        limiteCredito = l;
    }
}
