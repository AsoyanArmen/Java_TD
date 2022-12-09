package huffman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class AppliHuffmanDifference {

	private JFrame frmTmCodage;
	private JTextArea textAreaClair;
	private JTextArea textAreaCode;
	private JLabel MessageInformatif;
	private DessinHuffman panelDessinArbre1;
	private DessinHuffman panelDessinArbre2;
	private DessinHuffman panelDessinArbre3;
	private JTextArea textAreaDico1;
	private JTextArea textAreaDico2;
	private JTextArea textAreaDico3;
	private Huffman h1;
	private Huffman h2;
	private Huffman hDiff;
	private JButton BtnCodage1;
	private JButton BtnCodage2;
	private JButton BtnCodageDiff;
	private JButton btnCodage1;
	private JButton btnCodage2;
	private JButton btnCodageDiff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppliHuffmanDifference window = new AppliHuffmanDifference();
					window.frmTmCodage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppliHuffmanDifference() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTmCodage = new JFrame();
		frmTmCodage.setTitle("TM3 - Codage de Huffman");
		frmTmCodage.setBounds(100, 100, 603, 392);
		frmTmCodage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MessageInformatif = new JLabel(" ");
		MessageInformatif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MessageInformatif.setHorizontalAlignment(SwingConstants.CENTER);
		frmTmCodage.getContentPane().add(MessageInformatif, BorderLayout.SOUTH);

		JPanel panelCentre = new JPanel();
		frmTmCodage.getContentPane().add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelCodages = new JPanel();
		panelCentre.add(panelCodages);
		panelCodages.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelCodage1 = new JPanel();
		panelCodages.add(panelCodage1);
		panelCodage1.setLayout(new BorderLayout(0, 0));

		JPanel panelDico1 = new JPanel();
		panelCodage1.add(panelDico1, BorderLayout.EAST);
		panelDico1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDico1.setLayout(new BorderLayout(0, 0));

		JLabel lblDico = new JLabel("Dictionnaire");
		lblDico.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDico.setHorizontalAlignment(SwingConstants.CENTER);
		panelDico1.add(lblDico, BorderLayout.NORTH);

		JScrollPane scrollPaneDico1 = new JScrollPane();
		scrollPaneDico1.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDico1.add(scrollPaneDico1, BorderLayout.CENTER);

		textAreaDico1 = new JTextArea();
		scrollPaneDico1.setViewportView(textAreaDico1);

		JPanel panelArbre1 = new JPanel();
		panelCodage1.add(panelArbre1, BorderLayout.CENTER);
		panelArbre1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelArbre1.setLayout(new BorderLayout(0, 0));

		JLabel lblArbre1 = new JLabel("Arbre");
		lblArbre1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArbre1.setHorizontalAlignment(SwingConstants.CENTER);
		panelArbre1.add(lblArbre1, BorderLayout.NORTH);

		JScrollPane scrollPaneArbre1 = new JScrollPane();
		panelArbre1.add(scrollPaneArbre1, BorderLayout.CENTER);

		panelDessinArbre1 = new DessinHuffman();
		scrollPaneArbre1.setViewportView(panelDessinArbre1);

		JPanel PanelBoutonsCréer1 = new JPanel();
		panelArbre1.add(PanelBoutonsCréer1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Créer depuis Texte clair");
		btnNewButton.addActionListener(new ActionListener() {
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
		PanelBoutonsCréer1.add(btnNewButton);

		JLabel lblCodage1 = new JLabel("Codage 1");
		lblCodage1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCodage1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCodage1.add(lblCodage1, BorderLayout.NORTH);

		JPanel panelCodage2 = new JPanel();
		panelCodages.add(panelCodage2);
		panelCodage2.setLayout(new BorderLayout(0, 0));

		JLabel lblCodage2 = new JLabel("Codage 2");
		lblCodage2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCodage2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCodage2.add(lblCodage2, BorderLayout.NORTH);

		JPanel panelDico2 = new JPanel();
		panelCodage2.add(panelDico2, BorderLayout.EAST);
		panelDico2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDico2.setLayout(new BorderLayout(0, 0));

		JLabel lblDico2 = new JLabel("Dictionnaire");
		lblDico2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDico2.setHorizontalAlignment(SwingConstants.CENTER);
		panelDico2.add(lblDico2, BorderLayout.NORTH);

		JScrollPane scrollPaneDico2 = new JScrollPane();
		scrollPaneDico2.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDico2.add(scrollPaneDico2, BorderLayout.CENTER);

		textAreaDico2 = new JTextArea();
		scrollPaneDico2.setViewportView(textAreaDico2);

		JPanel panelArbre2 = new JPanel();
		panelCodage2.add(panelArbre2, BorderLayout.CENTER);
		panelArbre2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelArbre2.setLayout(new BorderLayout(0, 0));

		JLabel lblArbre2 = new JLabel("Arbre");
		lblArbre2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArbre2.setHorizontalAlignment(SwingConstants.CENTER);
		panelArbre2.add(lblArbre2, BorderLayout.NORTH);

		JScrollPane scrollPaneArbre2 = new JScrollPane();
		panelArbre2.add(scrollPaneArbre2, BorderLayout.CENTER);

		panelDessinArbre2 = new DessinHuffman();
		scrollPaneArbre2.setViewportView(panelDessinArbre2);

		JPanel PanelBoutoncréer2 = new JPanel();
		panelArbre2.add(PanelBoutoncréer2, BorderLayout.SOUTH);

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
		PanelBoutoncréer2.add(btnNewButton_1);

		JPanel panelCodage3 = new JPanel();
		panelCodages.add(panelCodage3);
		panelCodage3.setLayout(new BorderLayout(0, 0));

		JPanel panelDico3 = new JPanel();
		panelCodage3.add(panelDico3, BorderLayout.EAST);
		panelDico3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDico3.setLayout(new BorderLayout(0, 0));

		JLabel lblDico3 = new JLabel("Dictionnaire");
		lblDico3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDico3.setHorizontalAlignment(SwingConstants.CENTER);
		panelDico3.add(lblDico3, BorderLayout.NORTH);

		JScrollPane scrollPaneDico3 = new JScrollPane();
		scrollPaneDico3.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDico3.add(scrollPaneDico3, BorderLayout.CENTER);

		textAreaDico3 = new JTextArea();
		scrollPaneDico3.setViewportView(textAreaDico3);

		JPanel panelArbre3 = new JPanel();
		panelCodage3.add(panelArbre3, BorderLayout.CENTER);
		panelArbre3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelArbre3.setLayout(new BorderLayout(0, 0));

		JLabel lblArbre3 = new JLabel("Arbre");
		lblArbre3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArbre3.setHorizontalAlignment(SwingConstants.CENTER);
		panelArbre3.add(lblArbre3, BorderLayout.NORTH);

		JScrollPane scrollPaneArbre3 = new JScrollPane();
		panelArbre3.add(scrollPaneArbre3, BorderLayout.CENTER);

		panelDessinArbre3 = new DessinHuffman();
		scrollPaneArbre3.setViewportView(panelDessinArbre3);

		JLabel lblCodage3 = new JLabel("Codage Diff\u00E9rence");
		lblCodage3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodage3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelCodage3.add(lblCodage3, BorderLayout.NORTH);

		JPanel panelTextes = new JPanel();
		panelTextes.setBorder(null);
		panelCentre.add(panelTextes);
		panelTextes.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelClair = new JPanel();
		panelClair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTextes.add(panelClair);
		panelClair.setLayout(new BorderLayout(0, 0));

		JLabel lblClair = new JLabel("Texte clair");
		lblClair.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelClair.add(lblClair, BorderLayout.NORTH);

		JScrollPane scrollPaneClair = new JScrollPane();
		scrollPaneClair.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelClair.add(scrollPaneClair, BorderLayout.CENTER);

		textAreaClair = new JTextArea();
		scrollPaneClair.setViewportView(textAreaClair);

		JPanel PanelBoutonsTexteClair = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PanelBoutonsTexteClair.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelClair.add(PanelBoutonsTexteClair, BorderLayout.SOUTH);

		Label LabelCoderAVEC = new Label("Coder avec");
		LabelCoderAVEC.setAlignment(Label.RIGHT);
		LabelCoderAVEC.setFont(new Font("Al Nile", Font.BOLD, 13));
		PanelBoutonsTexteClair.add(LabelCoderAVEC);

		BtnCodage1 = new JButton("Codage 1");
		BtnCodage1.setEnabled(false);
		BtnCodage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verifCodage(h1);
					String res = h1.code(textAreaClair.getText());
					textAreaCode.setText(res);
					statut();
				} catch (CaractereInconnuException e1) {
					message("Impossible de coder : au moins un caractère est absent du codage.", Color.RED);
				}
			}
		});
		BtnCodage1.setHorizontalAlignment(SwingConstants.RIGHT);
		PanelBoutonsTexteClair.add(BtnCodage1);

		BtnCodage2 = new JButton("Codage 2");
		BtnCodage2.setEnabled(false);
		BtnCodage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verifCodage(h2);
					String res = h2.code(textAreaClair.getText());
					textAreaCode.setText(res);
					statut();
				} catch (CaractereInconnuException e1) {
					message("Impossible de coder : au moins un caractère est absent du codage.", Color.RED);
				}
			}
		});
		BtnCodage2.setHorizontalAlignment(SwingConstants.RIGHT);
		PanelBoutonsTexteClair.add(BtnCodage2);

		BtnCodageDiff = new JButton("Codage Différence");
		BtnCodageDiff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verifCodage(hDiff);
					String res = hDiff.code(textAreaClair.getText());
					textAreaCode.setText(res);
					statut();
				} catch (CaractereInconnuException e1) {
					message("Impossible de coder : au moins un caractère est absent du codage.", Color.RED);
				}
			}
		});
		BtnCodageDiff.setEnabled(false);
		BtnCodageDiff.setHorizontalAlignment(SwingConstants.RIGHT);
		PanelBoutonsTexteClair.add(BtnCodageDiff);

		JPanel panelCode = new JPanel();
		panelCode.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTextes.add(panelCode);
		panelCode.setLayout(new BorderLayout(0, 0));

		JLabel lblTexteCod = new JLabel("Texte cod\u00E9");
		lblTexteCod.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCode.add(lblTexteCod, BorderLayout.NORTH);

		JScrollPane scrollPaneCode = new JScrollPane();
		scrollPaneCode.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCode.add(scrollPaneCode, BorderLayout.CENTER);

		textAreaCode = new JTextArea();
		scrollPaneCode.setViewportView(textAreaCode);

		JPanel PanelBoutonsTexteCodé = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) PanelBoutonsTexteCodé.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelCode.add(PanelBoutonsTexteCodé, BorderLayout.SOUTH);

		Label LabelDecoderAVEC = new Label("Décoder avec");
		LabelDecoderAVEC.setAlignment(Label.RIGHT);
		LabelDecoderAVEC.setFont(new Font("Dialog", Font.BOLD, 12));
		PanelBoutonsTexteCodé.add(LabelDecoderAVEC);

		btnCodage1 = new JButton("Codage 1");
		btnCodage1.setEnabled(false);
		btnCodage1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCodage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String res = h1.decode(textAreaCode.getText());
					textAreaClair.setText(res);
					statut();
				} catch (FinDeTexteInattendueException e1) {
					message("Impossible de décoder : fin de texte inattendue.", Color.RED);
				}
			}
		});
		PanelBoutonsTexteCodé.add(btnCodage1);

		btnCodage2 = new JButton("Codage 2");
		btnCodage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String res = h2.decode(textAreaCode.getText());
					textAreaClair.setText(res);
					statut();
				} catch (FinDeTexteInattendueException e1) {
					message("Impossible de décoder : fin de texte inattendue.", Color.RED);
				}
			}
		});
		btnCodage2.setEnabled(false);
		btnCodage2.setHorizontalAlignment(SwingConstants.RIGHT);
		PanelBoutonsTexteCodé.add(btnCodage2);

		btnCodageDiff = new JButton("Codage Différence");
		btnCodageDiff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String res = hDiff.decode(textAreaCode.getText());
					textAreaClair.setText(res);
					statut();
				} catch (FinDeTexteInattendueException e1) {
					message("Impossible de décoder : fin de texte inattendue.", Color.RED);
				}
			}
		});
		btnCodageDiff.setEnabled(false);
		btnCodageDiff.setHorizontalAlignment(SwingConstants.RIGHT);
		PanelBoutonsTexteCodé.add(btnCodageDiff);
	}

	private void message(String texte, Color col) {
		MessageInformatif.setForeground(col);
		MessageInformatif.setText(texte);
	}

	private void statut() {
		int lgClair = textAreaClair.getText().length();
		String stat = "Texte clair : " + lgClair + "caractères = " + lgClair * 16 + " bits / texte codé : ";
		stat += textAreaCode.getText().length() + " bits.";
		message(stat, Color.BLACK);
	}
	
	private void verifCodage(Huffman h) {
		if (h == null)
			message("Aucun codage n'a été crée !", Color.RED);

	}
}
