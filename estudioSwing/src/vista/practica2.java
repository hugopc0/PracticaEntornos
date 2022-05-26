package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class practica2 extends JFrame /*implements KeyListener*/ {

	private JPanel panel;
	private JLabel lbl51, lbl52, lbl53, lbl54;
	private JLabel lbl55;
	private JLabel lbl56;
	private JLabel lbl57;
	private JLabel lbl58;
	private JLabel lbl59;
	private JTextField text51;
	private JTextField text52;
	private JTextField text53;
	private JTextField text54;
	private JTextField text55;
	private JTextField text56;
	private JTextField text57;
	private JTextField text58;
	private JTextField text59;
	private JButton btnCorregir;
	private JButton btnBorrar;
	private List<JTextField> numeros;
	private List<JLabel> mult;
	//private int n[];

	public practica2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		int num = (int) (Math.random() * 9 + 1);
		int n[] = new int[9];
		int x = 0;
		for (int y = 0; y < n.length; y++) {
			do {
				x = (int) (Math.random() * 9 + 1);
			} while (repe(x, n));
			n[y] = x;
		}
		numeros = new ArrayList<JTextField>();
		mult = new ArrayList<JLabel>();
		definirVentana(num, n);
		eventos(num, n);
		setVisible(true);
	}

	private boolean repe(int x, int[] n) {
		boolean repe = false;
		for (int y = 0; y < n.length; y++) {
			if (n[y] == x) {
				repe = true;
			}
		}
		return repe;
	}

	private void eventos(int num, int[] n) {
		for (JTextField nums : numeros) {
			nums.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					if(((caracter < '0') || (caracter > '9')) &&(caracter != KeyEvent.VK_BACK_SPACE)&&(caracter != 44)) {
						e.consume();
					}
				}
			});
		}
		btnCorregir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				for (JTextField nums : numeros) {
					if (!nums.getText().equals("")) {
						int resultado = Integer.parseInt(nums.getText());
						if (resultado == num * n[x]) {
							nums.setBackground(Color.GREEN);
						} else {
							nums.setBackground(Color.RED);
						}
					} else {
						nums.setBackground(Color.RED);
					}
					x++;
				}
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//num = (int) (Math.random() * 9 + 1);
				for (JTextField nums : numeros) {
					nums.setText("");
					nums.setBackground(Color.WHITE);
				}
				int c = 0;
				Arrays.fill(n, 0);
				int x = 0;
				for (JLabel mul : mult) {
					do {
						x = (int) (Math.random() * 9 + 1);
					} while (repe(x, n));
					n[c] = x;
					c++;
					mul.setText(num + " * " + x + " = ");
				}
			}
		});
	}

	private void definirVentana(int num, int[] n) {
		lbl51 = new JLabel(num + " * " + n[0] + " = ");
		lbl51.setBounds(10, 24, 46, 14);
		panel.add(lbl51);
		mult.add(lbl51);
		
		lbl52 = new JLabel(num + " * " + n[1] + " = ");
		lbl52.setBounds(10, 49, 46, 14);
		panel.add(lbl52);
		mult.add(lbl52);
		
		lbl53 = new JLabel(num + " * " + n[2] + " = ");
		lbl53.setBounds(10, 74, 46, 14);
		panel.add(lbl53);
		mult.add(lbl53);
		
		lbl54 = new JLabel(num + " * " + n[3] + " = ");
		lbl54.setBounds(10, 99, 46, 14);
		panel.add(lbl54);
		mult.add(lbl54);
		
		lbl55 = new JLabel(num + " * " + n[4] + " = ");
		lbl55.setBounds(10, 124, 46, 14);
		panel.add(lbl55);
		mult.add(lbl55);
		
		lbl56 = new JLabel(num + " * " + n[5] + " = ");
		lbl56.setBounds(10, 149, 46, 14);
		panel.add(lbl56);
		mult.add(lbl56);
		
		lbl57 = new JLabel(num + " * " + n[6] + " = ");
		lbl57.setBounds(10, 174, 46, 14);
		panel.add(lbl57);
		mult.add(lbl57);
		
		lbl58 = new JLabel(num + " * " + n[7] + " = ");
		lbl58.setBounds(10, 199, 46, 14);
		panel.add(lbl58);
		mult.add(lbl58);
		
		lbl59 = new JLabel(num + " * " + n[8] + " = ");
		lbl59.setBounds(10, 224, 46, 14);
		panel.add(lbl59);
		mult.add(lbl59);
		
		text51 = new JTextField();
		text51.setBounds(66, 21, 86, 20);
		panel.add(text51);
		text51.setColumns(10);
		numeros.add(text51);
		
		text52 = new JTextField();
		text52.setColumns(10);
		text52.setBounds(66, 46, 86, 20);
		panel.add(text52);
		numeros.add(text52);
		
		text53 = new JTextField();
		text53.setColumns(10);
		text53.setBounds(66, 71, 86, 20);
		panel.add(text53);
		numeros.add(text53);
		
		text54 = new JTextField();
		text54.setColumns(10);
		text54.setBounds(66, 96, 86, 20);
		panel.add(text54);
		numeros.add(text54);
		
		text55 = new JTextField();
		text55.setColumns(10);
		text55.setBounds(66, 121, 86, 20);
		panel.add(text55);
		numeros.add(text55);
		
		text56 = new JTextField();
		text56.setColumns(10);
		text56.setBounds(66, 146, 86, 20);
		panel.add(text56);
		numeros.add(text56);
		
		text57 = new JTextField();
		text57.setColumns(10);
		text57.setBounds(66, 171, 86, 20);
		panel.add(text57);
		numeros.add(text57);
		
		text58 = new JTextField();
		text58.setColumns(10);
		text58.setBounds(66, 196, 86, 20);
		panel.add(text58);
		numeros.add(text58);
		
		text59 = new JTextField();
		text59.setColumns(10);
		text59.setBounds(66, 221, 86, 20);
		panel.add(text59);
		numeros.add(text59);
		
		btnCorregir = new JButton("Corregir");
		btnCorregir.setBounds(248, 195, 114, 43);
		panel.add(btnCorregir);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(248, 145, 114, 43);
		panel.add(btnBorrar);
	}
}