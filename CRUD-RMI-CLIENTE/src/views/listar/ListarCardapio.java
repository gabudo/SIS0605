package views.listar;

import interfaces.InterfaceCardapio;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JButton;

public class ListarCardapio extends Listar<InterfaceCardapio> {

    private final String[] colunas = {"Id", "Prato", "Preço", "Porções"};

    public ListarCardapio(JButton botaoListar, JButton botaoExcluir) {
        init();

        botaoListar.addActionListener((ActionEvent ae) -> init());

        botaoExcluir.addActionListener((ActionEvent ae) -> excluir());
    }

    public void init() {

        removeAll();

        ArrayList<InterfaceCardapio> dados = dados("Cardapio");

        ArrayList<Object[]> linhas = new ArrayList<>();

        try {

            for (InterfaceCardapio d : dados) {
                linhas.add(new Object[]{
                    d.getId(),
                    d.getPrato(),
                    d.getPreco(),
                    d.getPorcoes()
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
