package interfaces;

import java.rmi.RemoteException;

public interface InterfaceAluno extends InterfaceGlobal<InterfaceAluno> {

    public String getNome() throws RemoteException;

    public void setNome(String nome) throws RemoteException;

    public double getMedia() throws RemoteException;

    public void setMedia(double media) throws RemoteException;

    public int getMatricula() throws RemoteException;

    public void setMatricula(int Matricula) throws RemoteException;

}
