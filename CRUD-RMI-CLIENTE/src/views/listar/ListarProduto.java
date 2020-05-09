package views.listar;

import interfaces.InterfaceProduto;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JButton;

public class ListarProduto extends Listar<InterfaceProduto> {

    private final String[] colunas = {"Id", "Descrição", "Preço", "Quantidade"};

    public ListarProduto(JButton botaoListar, JButton botaoExcluir) {
        init();

        botaoListar.addActionListener((ActionEvent ae) -> init());

        botaoExcluir.addActionListener((ActionEvent ae) -> excluir());
    }

    public void init() {

        removeAll();

        ArrayList<InterfaceProduto> dados = dados("Produto");

        ArrayList<Object[]> linhas = new ArrayList<>();

        try {

            for (InterfaceProduto d : dados) {
                linhas.add(new Object[]{
                    d.getId(),
                    d.getDescricao(),
                    d.getPreco(),
                    d.getQuantidade()
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
