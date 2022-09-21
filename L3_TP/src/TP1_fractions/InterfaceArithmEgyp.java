package TP1_fractions;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class InterfaceArithmEgyp extends Fraction{

	JFrame frmTpFractions;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceArithmEgyp window = new InterfaceArithmEgyp();
					window.frmTpFractions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceArithmEgyp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTpFractions = new JFrame();
		frmTpFractions.setTitle("TP1 : fractions");
		frmTpFractions.setBounds(100, 100, 442, 227);		
		frmTpFractions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTpFractions.getContentPane().setLayout(null);
		
		/* 
		 * insert little java cup icon (but doesn't display anything)
		 * 
		ImageIcon img = new ImageIcon("/Users/karenasoyan/eclipse-workspace/L3_TP/src/TP1_fractions/InterfaceArithmEgyp.png");
	    frmTpFractions.setIconImage(img.getImage());
		*/
		
		// label expression arithmétique
		JLabel lblNewLabel = new JLabel("évaluer une expression fraction");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblNewLabel.setBounds(6, 6, 249, 35);
		lblNewLabel.setForeground(Color.BLUE);
		frmTpFractions.getContentPane().add(lblNewLabel);
		
		
		// label fraction égyptienne
		JLabel lblFractionsgyptiennes = new JLabel("fractions égyptiennes");
		lblFractionsgyptiennes.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblFractionsgyptiennes.setForeground(Color.BLUE);
		lblFractionsgyptiennes.setBounds(6, 124, 207, 28);
		frmTpFractions.getContentPane().add(lblFractionsgyptiennes);
		
		
		// création champ de texte pour expression arithmétique
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(6, 33, 430, 42);
		
		// appuyer entrée sur clavier dans le champ de texte pour expression arithmétique
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String exprArithm = textField_1.getText();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField_1.setText(exprArithm + Fraction.calcul(exprArithm).toString());
					//textField_1.setEditable(false);
				}
			}
		});
		frmTpFractions.getContentPane().add(textField_1);
		
		
		// création champ de texte pour fraction égyptienne
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(6, 147, 430, 42);
		
		
		// appuyer entrée sur clavier dans le champ de texte pour fraction égyptienne
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String fracEgyp = textField_2.getText();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField_2.setText(fracEgyp + Fraction.egypFrac(fracEgyp).toString());
					//textField_2.setEditable(false);
				}
			}
		});
		frmTpFractions.getContentPane().add(textField_2);
		
		// le hint
		JTextPane txtpnTaperUneExpression = new JTextPane();
		txtpnTaperUneExpression.setFont(new Font("Courier New", Font.PLAIN, 13));
		txtpnTaperUneExpression.setBackground(new Color(204, 153, 255));
		txtpnTaperUneExpression.setForeground(new Color(0, 0, 0));
		txtpnTaperUneExpression.setText("taper une expression terminée par = (la barre de fraction est /)");
		txtpnTaperUneExpression.setBounds(6, 72, 430, 28);
		frmTpFractions.getContentPane().add(txtpnTaperUneExpression);
		
		
	}
}