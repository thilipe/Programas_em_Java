package jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class ContainerDeJanelas extends JFrame {

	public ContainerDeJanelas() {

		JMenuBar barraMenu = new JMenuBar();

		JMenu menu = new JMenu("Menu");

		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Jogo desenvolvido por Yann Braga! implementado pelo o Felipe",
						"Informações", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JMenuItem novo = new JMenuItem("Jogar de Novo");
		novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContainerDeJanelas();
			}

		});

		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(novo);
		menu.add(new JSeparator());
		menu.add(sair);

		barraMenu.add(menu);

		setJMenuBar(barraMenu);

		add(new Fase());
		setTitle("Jogo do avião");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

}
