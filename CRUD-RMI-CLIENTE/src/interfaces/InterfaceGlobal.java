package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceGlobal<T> extends Remote {

    public int getId() throws RemoteException;

    public void setId(int id) throws RemoteException;

    public void adicionar() throws RemoteException;

    public void excluir(int id) throws RemoteException;

    public ArrayList<T> listar() throws RemoteException;

}
