package interfaces;

import java.rmi.RemoteException;

public interface InterfaceCardapio extends InterfaceGlobal<InterfaceCardapio> {

    public String getPrato() throws RemoteException;

    public void setPrato(String prato) throws RemoteException;

    public double getPreco() throws RemoteException;

    public void setPreco(double preco) throws RemoteException;

    public int getPorcoes() throws RemoteException;

    public void setPorcoes(int porcoes) throws RemoteException;

}
