package views.listar;

import interfaces.InterfaceGlobal;
import java.awt.Dimension;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static principal.Consts.IP_SERVIDOR;
import static principal.Consts.PORTA_SERVIDOR;

public class Listar<T> extends JPanel {

    private T remoto;

    private final JTable tabela = new JTable();
    private JScrollPane barraRolagem;
    private DefaultTableModel model;
    private final DefaultTableCellRenderer center = new DefaultTableCellRenderer();

    public ArrayList<T> dados(String url) {
        try {

            remoto = (T) Naming
                    .lookup("rmi://" + IP_SERVIDOR + ":" + PORTA_SERVIDOR + "/" + url);

            return ((InterfaceGlobal) remoto).listar();

        } catch (RemoteException re) {
            System.err.println("Erro remoto: " + re.toString());
        } catch (Exception e) {
            System.err.println("Erro local: " + e.toString());
        }

        return null;

    }

    public JScrollPane tabela(String[] colunas, ArrayList<Object[]> linhas) {

        model = new DefaultTableModel(new Object[][]{}, colunas);

        center.setHorizontalAlignment(JLabel.CENTER);
        tabela.setDefaultRenderer(Object.class, center);

        for (Object[] linha : linhas) {
            model.addRow(linha);
        }

        tabela.setModel(model);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(75);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(75);

        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setPreferredSize(new Dimension(300, 150));

        return barraRolagem;

    }

    public final void excluir() {

        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada >= 0) {

            int id = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0)
                    .toString());

            try {
                ((InterfaceGlobal) remoto).excluir(id);

                model.removeRow(linhaSelecionada);

            } catch (RemoteException re) {
                System.err.println("Erro remoto: " + re.toString());
            } catch (Exception e) {
                System.err.println("Erro local: " + e.toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        }

    }

}
