package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Constantes;

public class MenuInGame extends JPanel{
	private JButton Resume = new JButton("RESUME");
	private JButton Quit = new JButton("QUIT");
	private JButton SaveAndQuit = new JButton("SAVE AND QUIT");
	private JButton Help = new JButton("HELP");
	private GridBagLayout box;
	private GridBagConstraints limits = new GridBagConstraints();
	private ArrayList<JButton> Buttons = new ArrayList<JButton>();
	private JPanel panel = new JPanel();
	public MenuInGame() {
		
		this.box = new GridBagLayout();
		this.box.preferredLayoutSize(this);
		Icon imgIcon = new ImageIcon(Constantes.menuInGame);
		JLabel label = new JLabel(imgIcon);
		label.setBounds(0, 0, 1920, 1080);
		this.add(panel,BorderLayout.CENTER);
		this.add(label, BorderLayout.CENTER);
		this.setLayout(new BorderLayout());
		panel.setLayout(this.box);
		panel.setBounds(0, 0, 1920, 1000);
		panel.setOpaque(false);
		limits.weightx = 1;
		limits.weighty = 1;
		initButton(Resume);
		initButton(Quit);
		initButton(SaveAndQuit);
		initButton(Help);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public ArrayList<JButton> getButtons(){
		return Buttons;
	}
	private void initButton(JButton b) {
		Buttons.add(b);
		b.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		b.setForeground(Color.WHITE);
		b.setBackground(Color.BLUE);
		limits.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(b);
		box.setConstraints(b, limits);
		b.setPreferredSize(new Dimension(600,150));
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.setAlignmentY(Component.CENTER_ALIGNMENT);
	}
}
