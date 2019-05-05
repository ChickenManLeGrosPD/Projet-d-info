package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Map;

public class ButtonsForPlacingFurniture extends JPanel implements ActionListener{
	private Map map;
	private int numberOfButtons;
	private GridBagLayout box = new GridBagLayout();
	private GridBagConstraints limits = new GridBagConstraints();
	public ButtonsForPlacingFurniture() {
		initButton(new JButton("DONE"));
		initButton(new JButton("CANCEL"));
		this.setLayout(box);
		this.setOpaque(false);
		map = MapDrawer.getInstance().getCurrentMap();
		this.setVisible(true);
		limits.weightx = 1;
	}
	private void initButton(JButton button) {
		button.addActionListener(this);
		limits.insets = new Insets(0,0,0,10);
		button.setBackground(Color.CYAN.darker());
		button.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		switch(numberOfButtons) {
		case 0 : limits.anchor = GridBagConstraints.LINE_START ; this.add(button, limits);break;
		case 1 : limits.anchor = GridBagConstraints.LINE_END ; this.add(button,limits); break;
		}
		numberOfButtons++;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)  arg0.getSource()).getText() == "DONE") {
			map.placeNextObject();
		}
		else {
			map.getObjects().remove(map.getLastObjectPlace());
			map.setLastObjectPlace(null);
		}
	}

}
