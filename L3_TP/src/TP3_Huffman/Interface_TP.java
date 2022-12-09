Interface_TP // spécifier package
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class App_TP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_TP window = new App_TP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App_TP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelHaut = new JPanel();
		frame.getContentPane().add(panelHaut);
		panelHaut.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCodages = new JPanel();
		panelHaut.add(panelCodages, BorderLayout.NORTH);
		panelCodages.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Codage 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelCodages.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codage 2");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCodages.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CodageDifference");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCodages.add(lblNewLabel_2);
		
		JPanel panelAffichage = new JPanel();
		panelHaut.add(panelAffichage, BorderLayout.CENTER);
		panelAffichage.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelCodage1 = new JPanel();
		panelAffichage.add(panelCodage1);
		panelCodage1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDico1 = new JPanel();
		panelCodage1.add(panelDico1, BorderLayout.EAST);
		panelDico1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Dictionnaire1");
		panelDico1.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JScrollPane scrollDico1 = new JScrollPane();
		panelDico1.add(scrollDico1, BorderLayout.CENTER);
		
		JPanel panelArbre = new JPanel();
		panelCodage1.add(panelArbre, BorderLayout.CENTER);
		panelArbre.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Arbre1");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelArbre.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JScrollPane scrollArbre1 = new JScrollPane();
		panelArbre.add(scrollArbre1, BorderLayout.CENTER);
		
		JButton boutonArbre1 = new JButton("Créer depuis texte clair");
		panelArbre.add(boutonArbre1, BorderLayout.SOUTH);
		
		JPanel panelCodage2 = new JPanel();
		panelAffichage.add(panelCodage2);
		panelCodage2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDico2 = new JPanel();
		panelCodage2.add(panelDico2, BorderLayout.EAST);
		panelDico2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Dictionnaire2");
		panelDico2.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JScrollPane scrollDico2 = new JScrollPane();
		panelDico2.add(scrollDico2, BorderLayout.CENTER);
		
		JPanel panelArbre2 = new JPanel();
		panelCodage2.add(panelArbre2, BorderLayout.CENTER);
		panelArbre2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Arbre2");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panelArbre2.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JScrollPane scrollArbre2 = new JScrollPane();
		panelArbre2.add(scrollArbre2, BorderLayout.CENTER);
		
		JButton boutonArbre2 = new JButton("Créer depuis Texte clair");
		panelArbre2.add(boutonArbre2, BorderLayout.SOUTH);
		
		JPanel panelDifference = new JPanel();
		panelAffichage.add(panelDifference);
		panelDifference.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDicoDiff = new JPanel();
		panelDifference.add(panelDicoDiff, BorderLayout.EAST);
		panelDicoDiff.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("DictionnaireDiff");
		panelDicoDiff.add(lblNewLabel_7, BorderLayout.NORTH);
		
		JScrollPane scrollDicoDiff = new JScrollPane();
		panelDicoDiff.add(scrollDicoDiff, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panelDifference.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("ArbreDiff");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_8, BorderLayout.NORTH);
		
		JScrollPane scrollArbreDiff = new JScrollPane();
		panel_1.add(scrollArbreDiff, BorderLayout.CENTER);
		
		JPanel panelBas = new JPanel();
		frame.getContentPane().add(panelBas);
		panelBas.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelTexteClair = new JPanel();
		panelBas.add(panelTexteClair);
		panelTexteClair.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBoutonsCodage = new JPanel();
		panelTexteClair.add(panelBoutonsCodage, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_9 = new JLabel("Coder avec : ");
		panelBoutonsCodage.add(lblNewLabel_9);
		
		JButton boutonCodage1 = new JButton("Codage 1");
		panelBoutonsCodage.add(boutonCodage1);
		
		JButton boutonCodage2 = new JButton("Codage 2");
		panelBoutonsCodage.add(boutonCodage2);
		
		JButton boutonCodageDiff = new JButton("Codage Différence");
		panelBoutonsCodage.add(boutonCodageDiff);
		
		JLabel lblNewLabel_10 = new JLabel("Texte Clair");
		panelTexteClair.add(lblNewLabel_10, BorderLayout.NORTH);
		
		JTextArea textClairArea = new JTextArea();
		panelTexteClair.add(textClairArea, BorderLayout.CENTER);
		
		JPanel panelTexteCode = new JPanel();
		panelBas.add(panelTexteCode);
		panelTexteCode.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelTexteCode.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_11 = new JLabel("Décoder avec : ");
		panel.add(lblNewLabel_11);
		
		JButton boutonDeCodage1 = new JButton("Décodage 1");
		panel.add(boutonDeCodage1);
		
		JButton boutonDeCodage2 = new JButton("Décodage 2");
		panel.add(boutonDeCodage2);
		
		JButton boutonDeCodage3 = new JButton("Décodage Différence");
		panel.add(boutonDeCodage3);
		
		JLabel lblNewLabel_12 = new JLabel("Texte Codé");
		panelTexteCode.add(lblNewLabel_12, BorderLayout.NORTH);
		
		JTextArea textCodeArea = new JTextArea();
		panelTexteCode.add(textCodeArea, BorderLayout.CENTER);
	
	
	
		//JButton boutonArbre1 = new JButton("Créer depuis Texte clair");
			boutonArbre1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {				
					try {
						h1 = new Huffman(textAreaClair.getText());
						panelDessinArbre1.setCodage(h1);
						StringBuffer sDico = new StringBuffer();
						Map<Character, String> dico = h1.getDictionnaire();
						for (Character c : dico.keySet())
							sDico.append(c).append(" : ").append(dico.get(c)).append('\n');
						textAreaDico1.setText(sDico.toString());
						message("Codage créé (" + dico.size() + " caractères)", Color.BLACK);
						BtnCodage1.setEnabled(true);
						btnCodage1.setEnabled(true);
					} catch (IllegalArgumentException iae) {
						message("Impossible de créer le codage : " + iae.getMessage(), Color.RED);
					}
					if (h2!=null) {
						try {
							hDiff = h1.difference(h2);
							panelDessinArbre3.setCodage(hDiff);
							StringBuffer sDicoDiff = new StringBuffer();
							Map<Character, String> dicoDiff = hDiff.getDictionnaire();
							for (Character c : dicoDiff.keySet())
								sDicoDiff.append(c).append(" : ").append(dicoDiff.get(c)).append('\n');
							textAreaDico3.setText(sDicoDiff.toString());
							BtnCodageDiff.setEnabled(true);
							btnCodageDiff.setEnabled(true);
						} catch (RuntimeException iae) {
							message("Impossible de créer le codage différence: " + iae.getMessage(), Color.RED);
						}
					}
					//--------------------------------------
				}
			});

		JButton btnNewButton_1 = new JButton("Créer depuis Texte clair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					h2 = new Huffman(textAreaClair.getText());
					panelDessinArbre2.setCodage(h2);
					StringBuffer sDico = new StringBuffer();
					Map<Character, String> dico = h2.getDictionnaire();
					for (Character c : dico.keySet())
						sDico.append(c).append(" : ").append(dico.get(c)).append('\n');
					textAreaDico2.setText(sDico.toString());
					message("Codage créé (" + dico.size() + " caractères)", Color.BLACK);
					BtnCodage2.setEnabled(true);
					btnCodage2.setEnabled(true);
				} catch (IllegalArgumentException iae) {
					message("Impossible de créer le codage : " + iae.getMessage(), Color.RED);
				}
				if (h1!=null) {
					try {
						hDiff = h1.difference(h2);
						panelDessinArbre3.setCodage(hDiff);
						StringBuffer sDicoDiff = new StringBuffer();
						Map<Character, String> dicoDiff = hDiff.getDictionnaire();
						for (Character c : dicoDiff.keySet())
							sDicoDiff.append(c).append(" : ").append(dicoDiff.get(c)).append('\n');
						textAreaDico3.setText(sDicoDiff.toString());
						BtnCodageDiff.setEnabled(true);
						btnCodageDiff.setEnabled(true);
					} catch (RuntimeException iae) {
						message("Impossible de créer le codage différence: " + iae.getMessage(), Color.RED);
					}
				}
				//--------------------------------------
			}
		});

	}

	

}
