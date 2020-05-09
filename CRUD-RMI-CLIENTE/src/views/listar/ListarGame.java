package views.listar;

import interfaces.InterfaceGame;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JButton;

public class ListarGame extends Listar<InterfaceGame> {

    private final String[] colunas = {"Id", "Nome", "Ano", "Nota"};

    public ListarGame(JButton botaoListar, JButton botaoExcluir) {
        init();

        botaoListar.addActionListener((ActionEvent ae) -> init());

        botaoExcluir.addActionListener((ActionEvent ae) -> excluir());
    }

    public void init() {

        removeAll();

        ArrayList<InterfaceGame> dados = dados("Game");

        ArrayList<Object[]> linhas = new ArrayList<>();

        try {

            for (InterfaceGame d : dados) {
                linhas.add(new Object[]{
                    d.getId(),
                    d.getNome(),
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
