package interfaces;

import java.rmi.RemoteException;

public interface InterfaceCarro extends InterfaceGlobal<InterfaceCarro> {

    public String getModelo() throws RemoteException;

    public void setModelo(String modelo) throws RemoteException;

    public int getAno() throws RemoteException;

    public void setAno(int ano) throws RemoteException;

    public double getNota() throws RemoteException;

    public void setNota(double nota) throws RemoteException;

}
