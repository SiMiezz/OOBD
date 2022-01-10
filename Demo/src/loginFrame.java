import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField pwdField;
	private JComboBox BoxSceltaLogin;
	private Controller theController;
	
	public JComboBox getBoxSceltaLogin() {
		return BoxSceltaLogin;
	}

	public void setBoxSceltaLogin(JComboBox boxSceltaLogin) {
		BoxSceltaLogin = boxSceltaLogin;
	}

	public loginFrame(Controller c) {
		theController=c;
		
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setBounds(230, 140, 150, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblID = new JLabel("ID/Matricola");
		lblID.setLabelFor(txtID);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(100, 142, 120, 14);
		contentPane.add(lblID);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setBounds(100, 175, 120, 14);
		contentPane.add(lblPwd);
		
		JButton btnGo = new JButton("LOGIN");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String pwd = String.valueOf(pwdField.getPassword());
				
				if(c.checkUser(id, pwd)) {
					c.confirmLogin();
				}
				else {
					c.alertLogin();
				}
				
				txtID.setText(null);
				pwdField.setText(null);
			}
		});
		btnGo.setBounds(399, 340, 150, 35);
		contentPane.add(btnGo);
		
		pwdField = new JPasswordField();
		pwdField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPwd.setLabelFor(pwdField);
		pwdField.setBounds(230, 173, 150, 20);
		contentPane.add(pwdField);
		
		BoxSceltaLogin = new JComboBox();
		BoxSceltaLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BoxSceltaLogin.setBackground(Color.WHITE);
		BoxSceltaLogin.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		BoxSceltaLogin.setSelectedIndex(1);
		BoxSceltaLogin.setToolTipText("");
		BoxSceltaLogin.setBounds(278, 206, 100, 20);
		contentPane.add(BoxSceltaLogin);
		
		JButton btnRegistrati = new JButton("REGISTRATI");
		btnRegistrati.setForeground(Color.BLUE);
		btnRegistrati.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.goRegistrazioneFrame();
			}
		});
		btnRegistrati.setBounds(10, 346, 120, 25);
		contentPane.add(btnRegistrati);
		
		JLabel lblLoginTitle = new JLabel("LOGIN");
		lblLoginTitle.setForeground(Color.RED);
		lblLoginTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTitle.setBounds(20, 11, 529, 25);
		contentPane.add(lblLoginTitle);
		
		JLabel lblRegistrati = new JLabel("Non sei registrato?");
		lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistrati.setForeground(Color.BLUE);
		lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrati.setBounds(10, 321, 120, 14);
		contentPane.add(lblRegistrati);
	}
}
