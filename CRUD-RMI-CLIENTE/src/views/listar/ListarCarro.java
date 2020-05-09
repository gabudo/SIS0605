package views.listar;

import interfaces.InterfaceCarro;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JButton;

public class ListarCarro extends Listar<InterfaceCarro> {

    private final String[] colunas = {"Id", "Modelo", "Ano", "Nota"};

    public ListarCarro(JButton botaoListar, JButton botaoExcluir) {
        init();

        botaoListar.addActionListener((ActionEvent ae) -> init());

        botaoExcluir.addActionListener((ActionEvent ae) -> excluir());
    }

    public void init() {

        removeAll();

        ArrayList<InterfaceCarro> dados = dados("Carro");

        ArrayList<Object[]> linhas = new ArrayList<>();

        try {

            for (InterfaceCarro d : dados) {
                linhas.add(new Object[]{
                    d.getId(),
                    d.getModelo(),
                    d.getAno(),
                    d.getNota()
                });
            }

            add(tabela(colunas, linhas));

        } catch (RemoteException re) {
            System.err.println("Erro remoto: " + re.toString());
        } catch (Exception e) {
            System.err.println("Erro local: " + e.toString());
        }

        repaint();
        validate();
    }

}
