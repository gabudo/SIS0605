package views.listar;

import interfaces.InterfaceAluno;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JButton;

public class ListarAluno extends Listar<InterfaceAluno> {

    private final String[] colunas = {"Id", "Nome", "Matrícula", "Média"};

    public ListarAluno(JButton botaoListar, JButton botaoExcluir) {
        init();

        botaoListar.addActionListener((ActionEvent ae) -> init());

        botaoExcluir.addActionListener((ActionEvent ae) -> excluir());
    }

    public void init() {

        removeAll();

        ArrayList<InterfaceAluno> dados = dados("Aluno");

        ArrayList<Object[]> linhas = new ArrayList<>();

        try {

            for (InterfaceAluno d : dados) {
                linhas.add(new Object[]{
                    d.getId(),
                    d.getNome(),
                    d.getMatricula(),
                    d.getMedia()
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
