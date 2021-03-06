package layout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import views.adicionar.AdicionarAluno;
import views.adicionar.AdicionarCardapio;
import views.adicionar.AdicionarCarro;
import views.adicionar.AdicionarGame;
import views.adicionar.AdicionarProduto;
import views.listar.ListarAluno;
import views.listar.ListarCardapio;
import views.listar.ListarCarro;
import views.listar.ListarGame;
import views.listar.ListarProduto;

public class Janela extends JFrame {

    private final JRadioButton radioAluno = new JRadioButton("Aluno", true);
    private final JRadioButton radioCardapio = new JRadioButton("Cardapio");
    private final JRadioButton radioCarro = new JRadioButton("Carro");
    private final JRadioButton radioGame = new JRadioButton("Game");
    private final JRadioButton radioProduto = new JRadioButton("Produto");

    private final JPanel panelSouth = new JPanel();
    private final JPanel panelCenter = new JPanel();
    private final JPanel panelEast = new JPanel();

    private JButton botaoListar;
    private JButton botaoAdicionar;
    private JButton botaoExcluir;

    public Janela() {
        setTitle("Sistemas Distribuídos");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(radioButton(), BorderLayout.WEST);
        add(panelBotoes(), BorderLayout.SOUTH);
        add(panelAdicionar(new AdicionarAluno(botaoAdicionar)), BorderLayout.CENTER);
        add(panelListar(new ListarAluno(botaoListar, botaoExcluir)), BorderLayout.EAST);
        pack();
        setVisible(true);
    }

    private JPanel panelAdicionar(Component pa) {
        panelCenter.setLayout(new FlowLayout());
        panelCenter.removeAll();
        panelEast.revalidate();
        panelCenter.add(pa);
        panelCenter.repaint();
        panelCenter.validate();

        return panelCenter;
    }

    private JPanel panelListar(Component pl) {
        panelEast.removeAll();
        panelEast.add(pl);
        panelEast.repaint();
        panelEast.validate();

        return panelEast;
    }

    private JPanel panelBotoes() {
        botaoListar = new JButton("LISTAR");
        botaoAdicionar = new JButton("ADICIONAR");
        botaoExcluir = new JButton("EXCLUIR");
        panelSouth.setLayout(new GridLayout(1, 2, 10, 10));
        panelSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelSouth.removeAll();
        panelSouth.add(botaoAdicionar);
        panelSouth.add(botaoListar);
        panelSouth.add(botaoExcluir);
        panelSouth.repaint();
        panelSouth.validate();

        return panelSouth;
    }

    private JPanel radioButton() {

        final ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radioAluno);
        bgroup.add(radioCardapio);
        bgroup.add(radioCarro);
        bgroup.add(radioGame);
        bgroup.add(radioProduto);

        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(radioAluno);
        panel.add(radioCardapio);
        panel.add(radioCarro);
        panel.add(radioGame);
        panel.add(radioProduto);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Selecione"));

        radioAluno.addActionListener((ActionEvent ae) -> {
            panelBotoes();
            panelAdicionar(new AdicionarAluno(botaoAdicionar));
            panelListar(new ListarAluno(botaoListar, botaoExcluir));
        });

        radioCardapio.addActionListener((ActionEvent ae) -> {
            panelBotoes();
            panelAdicionar(new AdicionarCardapio(botaoAdicionar));
            panelListar(new ListarCardapio(botaoListar, botaoExcluir));
        });

        radioCarro.addActionListener((ActionEvent ae) -> {
            panelBotoes();
            panelAdicionar(new AdicionarCarro(botaoAdicionar));
            panelListar(new ListarCarro(botaoListar, botaoExcluir));
        });

        radioGame.addActionListener((ActionEvent ae) -> {
            panelBotoes();
            panelAdicionar(new AdicionarGame(botaoAdicionar));
            panelListar(new ListarGame(botaoListar, botaoExcluir));
        });

        radioProduto.addActionListener((ActionEvent ae) -> {
            panelBotoes();
            panelAdicionar(new AdicionarProduto(botaoAdicionar));
            panelListar(new ListarProduto(botaoListar, botaoExcluir));
        });

        return panel;
    }

}
