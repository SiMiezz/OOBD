import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class homePageStud extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtData;
	private JTextField txtCF;
	private JTextField txtMatricola;
	Controller TheController;
	private JTable tableCorsi;
	DefaultTableModel modelCorsi;
	private JTable tableIscrizioni;
	DefaultTableModel modelIscrizioni;
	private JTable tableLezioni;
	DefaultTableModel modelLezioni;
	
	private void switchPanel(JLayeredPane layeredPane, JPanel panelInserisci) {
		layeredPane.removeAll();
        layeredPane.add(panelInserisci);
        layeredPane.repaint();
        layeredPane.revalidate();
	}

	public homePageStud(Controller c, String matricola, String pwd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 525);
		
		TheController=c;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 564, 442);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelProfilo = new JPanel();
		panelProfilo.setBackground(new Color(176, 224, 230));
		panelProfilo.setLayout(null);
		layeredPane.add(panelProfilo, "name_367346658513700");
		
		JLabel lblNewLabel = new JLabel("PROFILO STUDENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 11, 554, 31);
		panelProfilo.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(168, 80, 200, 22);
		panelProfilo.add(txtNome);
		
		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCognome.setText((String) null);
		txtCognome.setEditable(false);
		txtCognome.setColumns(10);
		txtCognome.setBounds(168, 115, 200, 22);
		panelProfilo.add(txtCognome);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setText("<dynamic>\r\n");
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(168, 150, 200, 22);
		panelProfilo.add(txtData);
		
		txtCF = new JTextField();
		txtCF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCF.setText((String) null);
		txtCF.setEditable(false);
		txtCF.setColumns(10);
		txtCF.setBounds(168, 185, 200, 22);
		panelProfilo.add(txtCF);
		
		txtMatricola = new JTextField();
		txtMatricola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatricola.setText("<dynamic>");
		txtMatricola.setEditable(false);
		txtMatricola.setColumns(10);
		txtMatricola.setBounds(168, 220, 200, 22);
		panelProfilo.add(txtMatricola);
		
		Studente stud = new Studente();
		
		stud.setMatricola(matricola);
		stud.setPassword(pwd);
		stud.setNome(c.getStud(matricola).getNome());
		stud.setCognome(c.getStud(matricola).getCognome());
		stud.setData(c.getStud(matricola).getData());
		stud.setCf(c.getStud(matricola).getCf());
		stud.setIscrizioni(c.getIscrizioni(stud));
		
		txtNome.setText(stud.getNome());
		txtCognome.setText(stud.getCognome());
		
		Date data = stud.getData();
		String strdata = data.toString();
		
		txtData.setText(strdata);
		txtCF.setText(stud.getCf());
		txtMatricola.setText(matricola);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(38, 84, 120, 14);
		panelProfilo.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCognome.setBounds(38, 115, 120, 22);
		panelProfilo.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di nascita");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(38, 154, 120, 14);
		panelProfilo.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCf.setBounds(38, 189, 120, 14);
		panelProfilo.add(lblCf);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricola.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatricola.setBounds(38, 224, 120, 14);
		panelProfilo.add(lblMatricola);
		
		JPanel panelCorsi = new JPanel();
		panelCorsi.setBackground(new Color(176, 224, 230));
		panelCorsi.setLayout(null);
		layeredPane.add(panelCorsi, "name_367386059393600");
		
		JLabel lblCorsi = new JLabel("VISUALIZZA CORSI");
		lblCorsi.setForeground(Color.RED);
		lblCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorsi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCorsi.setBounds(10, 11, 544, 14);
		panelCorsi.add(lblCorsi);
		
		JScrollPane scrollPaneCorsi = new JScrollPane();
		scrollPaneCorsi.setBounds(10, 36, 544, 270);
		panelCorsi.add(scrollPaneCorsi);
		
		tableCorsi = new JTable();
		tableCorsi.setRowSelectionAllowed(false);
		tableCorsi.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		modelCorsi= new DefaultTableModel();
		Object[] columnCorsi= {"ID", "Nome", "Descrizione", "Presenze min", "Partecipanti max"};
		Object [] rowCorsi= new Object[5];
		tableCorsi.setModel(modelCorsi);
		modelCorsi.setColumnIdentifiers(columnCorsi);
		scrollPaneCorsi.setViewportView(tableCorsi);
		
		JPanel panelIscrizioni = new JPanel();
		panelIscrizioni.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelIscrizioni, "name_367500255637100");
		panelIscrizioni.setLayout(null);
		
		JLabel lblIscrizioni = new JLabel("VISUALIZZA ISCRIZIONI");
		lblIscrizioni.setForeground(Color.RED);
		lblIscrizioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIscrizioni.setBounds(10, 11, 544, 14);
		panelIscrizioni.add(lblIscrizioni);
		
		JScrollPane scrollPaneIscrizioni = new JScrollPane();
		scrollPaneIscrizioni.setBounds(10, 36, 544, 270);
		panelIscrizioni.add(scrollPaneIscrizioni);
		
		tableIscrizioni = new JTable();
		tableIscrizioni.setRowSelectionAllowed(false);
		tableIscrizioni.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		modelIscrizioni = new DefaultTableModel();
		Object[] columnIscrizioni= {"ID", "Nome", "Descrizione"};
		Object [] rowIscrizioni= new Object[3];
		tableIscrizioni.setModel(modelIscrizioni);
		modelIscrizioni.setColumnIdentifiers(columnIscrizioni);
		scrollPaneIscrizioni.setViewportView(tableIscrizioni);
		
		JPanel panelNewIscrizione = new JPanel();
		panelNewIscrizione.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelNewIscrizione, "name_367633326808700");
		panelNewIscrizione.setLayout(null);
		
		JLabel lblNewIscrizione = new JLabel("EFFETTUA ISCRIZIONE");
		lblNewIscrizione.setForeground(Color.RED);
		lblNewIscrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewIscrizione.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewIscrizione.setBounds(10, 11, 544, 14);
		panelNewIscrizione.add(lblNewIscrizione);
		
		JLabel lblAlertIscrizione = new JLabel("Seleziona l'id del corso");
		lblAlertIscrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertIscrizione.setForeground(Color.BLUE);
		lblAlertIscrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertIscrizione.setBounds(141, 36, 285, 14);
		panelNewIscrizione.add(lblAlertIscrizione);
		
		JScrollPane scrollPaneNewIscrizione = new JScrollPane();
		scrollPaneNewIscrizione.setBounds(143, 61, 283, 168);
		panelNewIscrizione.add(scrollPaneNewIscrizione);
		
		JTextArea txtNewIscrizione = new JTextArea();
		scrollPaneNewIscrizione.setViewportView(txtNewIscrizione);
		txtNewIscrizione.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtNewIscrizione.setEditable(false);
		
		JButton btnIscriviti = new JButton("ISCRIVITI");
		btnIscriviti.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIscriviti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNewIscrizione.getSelectedText() != null) {
					int id = Integer.valueOf(txtNewIscrizione.getSelectedText());
					
					if(c.iscriviti(stud,c.getCorso(id))) {
						c.confirmInsertIscrizione();
					}
					else {
						c.alertInsertIscrizione();
					}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnIscriviti.setBounds(326, 240, 100, 23);
		panelNewIscrizione.add(btnIscriviti);
		
		JPanel panelLezioni = new JPanel();
		panelLezioni.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelLezioni, "name_367792570924600");
		panelLezioni.setLayout(null);
		
		JLabel lblLezioni = new JLabel("VISUALIZZA LEZIONI");
		lblLezioni.setForeground(Color.RED);
		lblLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblLezioni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLezioni.setBounds(10, 11, 544, 14);
		panelLezioni.add(lblLezioni);
		
		JScrollPane scrollPaneLezioni = new JScrollPane();
		scrollPaneLezioni.setBounds(10, 36, 544, 270);
		panelLezioni.add(scrollPaneLezioni);
		
		tableLezioni = new JTable();
		tableLezioni.setRowSelectionAllowed(false);
		tableLezioni.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		modelLezioni = new DefaultTableModel();
		Object[] columnLezioni= {"ID", "Titolo", "Data inizio", "Orario inizio", "Nome corso"};
		Object [] rowLezioni= new Object[5];
		tableLezioni.setModel(modelLezioni);
		modelLezioni.setColumnIdentifiers(columnLezioni);
		scrollPaneLezioni.setViewportView(tableLezioni);
		
		JPanel panelPartecipa = new JPanel();
		panelPartecipa.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelPartecipa, "name_367912807561300");
		panelPartecipa.setLayout(null);
		
		JLabel lblPartecipaLezioni = new JLabel("PARTECIPA LEZIONE");
		lblPartecipaLezioni.setForeground(Color.RED);
		lblPartecipaLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartecipaLezioni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPartecipaLezioni.setBounds(10, 11, 544, 14);
		panelPartecipa.add(lblPartecipaLezioni);
		
		JLabel lblAlertPartecipa = new JLabel("Seleziona l'id della lezione");
		lblAlertPartecipa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertPartecipa.setForeground(Color.BLUE);
		lblAlertPartecipa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertPartecipa.setBounds(141, 36, 285, 14);
		panelPartecipa.add(lblAlertPartecipa);
		
		JScrollPane scrollPanePartecipa = new JScrollPane();
		scrollPanePartecipa.setBounds(141, 61, 281, 166);
		panelPartecipa.add(scrollPanePartecipa);
		
		JTextArea txtPartecipa = new JTextArea();
		scrollPanePartecipa.setViewportView(txtPartecipa);
		txtPartecipa.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtPartecipa.setEditable(false);
		
		JButton btnPartecipa = new JButton("PARTECIPA");
		btnPartecipa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPartecipa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPartecipa.getSelectedText() != null) {
					int id = Integer.valueOf(txtPartecipa.getSelectedText());
					
					if(c.partecipa(stud, id)) {
						c.confirmInsertPresenza();
					}
					else {
						c.alertInsertPresenza();
					}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnPartecipa.setBounds(316, 238, 110, 23);
		panelPartecipa.add(btnPartecipa);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		JMenu mnProfilo = new JMenu("PROFILO");
		mnProfilo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnProfilo);
		
		JMenuItem mntmProfilo = new JMenuItem("Visualizza Profilo");
		mntmProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelProfilo);
			}
		});
		mnProfilo.add(mntmProfilo);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stud.setMatricola(null);
				stud.setPassword(null);
				stud.setNome(null);
				stud.setCognome(null);
				stud.setData(null);
				stud.setCf(null);
				stud.setIscrizioni(null);
				
				c.logout();
			}
		});
		mnProfilo.add(mntmLogout);
		
		JMenu mnCorsi = new JMenu("CORSI");
		mnCorsi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnCorsi);
		
		JMenuItem mntmVisualizzaCorsi = new JMenuItem("Visualizza Corsi");
		mntmVisualizzaCorsi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelCorsi);
				
				modelCorsi.setRowCount(0);
                for (CorsoFormazione corso:c.getAllCorsi()) {
                	rowCorsi[0]= corso.getIdCorso();
                	rowCorsi[1]= corso.getNome();
                	rowCorsi[2]= corso.getDescrizione();
                	rowCorsi[3]= corso.getPresenzeMin();
                	rowCorsi[4]= corso.getMaxPartecipanti();
                	modelCorsi.addRow(rowCorsi);
        		}
				
			}
		});
		mnCorsi.add(mntmVisualizzaCorsi);
		
		JMenu mnIscrizioni = new JMenu("ISCRIZIONI");
		mnIscrizioni.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnIscrizioni);
		
		JMenuItem mntmVisualizzaIscrizioni = new JMenuItem("Visualizza Iscrizioni");
		mntmVisualizzaIscrizioni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelIscrizioni);
				
				stud.setIscrizioni(c.getIscrizioni(stud));
				
				modelIscrizioni.setRowCount(0);
				for(Iscritto iscrizione:stud.getIscrizioni()) {
					rowIscrizioni[0]= iscrizione.getCorso().getIdCorso();
					rowIscrizioni[1]= iscrizione.getCorso().getNome();
					rowIscrizioni[2]= iscrizione.getCorso().getDescrizione();
					modelIscrizioni.addRow(rowIscrizioni);
				}
			}
		});
		mnIscrizioni.add(mntmVisualizzaIscrizioni);
		
		JMenuItem mntmAggiungiIscrizioni = new JMenuItem("Effettua Iscrizione");
		mntmAggiungiIscrizioni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmAggiungiIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelNewIscrizione);
				
				txtNewIscrizione.setText(null);
				for(CorsoFormazione corso:c.getCorsiNoIscrizione(stud)) {
					txtNewIscrizione.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
				}
			}
		});
		mnIscrizioni.add(mntmAggiungiIscrizioni);
		
		JMenu mnLezioni = new JMenu("LEZIONI");
		mnLezioni.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnLezioni);
		
		JMenuItem mntmVisualizzaLezioni = new JMenuItem("Visualizza Lezioni");
		mntmVisualizzaLezioni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaLezioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelLezioni);
				
				modelLezioni.setRowCount(0);
				for(Lezione lezione:c.getLezioni(stud)) {
					rowLezioni[0]= lezione.getIdlezione();
					rowLezioni[1]= lezione.getTitolo();
					rowLezioni[2]= lezione.getDatainizio();
					rowLezioni[3]= lezione.getOrarioinizio();
					rowLezioni[4]= lezione.getCorso().getNome();
					modelLezioni.addRow(rowLezioni);
				}
			}
		});
		mnLezioni.add(mntmVisualizzaLezioni);
		
		JMenuItem mntmPartecipaLezioni = new JMenuItem("Partecipa Lezione");
		mntmPartecipaLezioni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmPartecipaLezioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelPartecipa);
				
				txtPartecipa.setText(null);
				for(Lezione lezione:c.getLezioniNoPartecipa(stud)) {
					txtPartecipa.append(lezione.getIdlezione() + " " + lezione.getTitolo() + " " + lezione.getDatainizio() + "\n");
				}
			}
		});
		mnLezioni.add(mntmPartecipaLezioni);
	}
}
