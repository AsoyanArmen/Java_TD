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

public class AppliHuffmanDifference {

	private JFrame frmTmCodage;
	private JTextArea textAreaClair;
	private JTextArea textAreaCode;
	private JLabel lblMessage;
	private DessinHuffman panelDessinArbre1;
	private DessinHuffman panelDessinArbre2;
	private DessinHuffman panelDessinArbre3;
	private JTextArea textAreaDico1;
	private JTextArea textAreaDico2;
	private JTextArea textAreaDico3;

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
		frmTmCodage.setBounds(100, 100, 1030, 600);
		frmTmCodage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblMessage = new JLabel(" ");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		frmTmCodage.getContentPane().add(lblMessage, BorderLayout.SOUTH);

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
	}

	private void message(String texte, Color col) {
		lblMessage.setForeground(col);
		lblMessage.setText(texte);
	}

	private void statut() {
		int lgClair = textAreaClair.getText().length();
		String stat = "Texte clair : " + lgClair + "caractères = " + lgClair * 16 + " bits / texte codé : ";
		stat += textAreaCode.getText().length() + " bits.";
		message(stat, Color.BLACK);
	}
}
