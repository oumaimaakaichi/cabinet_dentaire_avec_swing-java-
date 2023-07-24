package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ShowAllPatients extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllPatients frame = new ShowAllPatients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowAllPatients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 649);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 String[] columnNames = {"First Name", "Last Name", "Birthdate", "Address", "Profession", "Phone Number"};

	        // Create a table model with the given column names
	        DefaultTableModel model = new DefaultTableModel(columnNames, 0);  
	        

		File directory = new File("src/projetJAVA/Patients");
	    if (directory.exists()) {
	      File[] files = directory.listFiles();
	      for (File file : files) {
	    	  String line = "";
	        try {
	          BufferedReader br = new BufferedReader(new FileReader(file));
	          while ((line = br.readLine()) != null) {
	        
	          String[] data = line.split(";");
	          model.addRow(data);
             //	System.out.print(line);
System.out.print(data);
	          }
	         
	          
	          
	          
	          
	          
	          
	          
	          
	          br.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	          System.out.println("here");
	        }
	        
	        
	        table = new JTable(model); 
	        
	        
	        
	        
	        
	        
	        
	        table.setCellSelectionEnabled(true);  
	        ListSelectionModel select= table.getSelectionModel();  
	        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
	        select.addListSelectionListener(new ListSelectionListener() {  
	          public void valueChanged(ListSelectionEvent e) {  
	            String Data = null;  
	            int[] row = table.getSelectedRows();  
	            System.out.println(row);
	            int[] columns = table.getSelectedColumns();  
	            for (int i = 0; i < row.length; i++) {  
	              for (int j = 0; j < columns.length; j++) {  
	                Data = (String) table.getValueAt(row[i], columns[j]);  
	                System.out.print(Data);
	              } }  
	            System.out.println("element selectionne est : " + Data);    
	          }       
	        });  
	        
	        
	        
	      }
	    } else {
	      System.out.println("Le répertoire n'existe pas !");
	    }
	    JScrollPane scrollPane = new JScrollPane(); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setLayout(null);
		panel_1.setBounds(302, 95, 758, 426);
		contentPane.add(panel_1);
		
	
		scrollPane.setBounds(28, 28, 0, 0);
		panel_1.add(scrollPane);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {"First Name", "Last Name", "Birthdate", "Address", "Profession", "Phone Number"}
		));
		table.setForeground(UIManager.getColor("Button.disabledForeground"));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setCellSelectionEnabled(true);
		table.setBounds(28, 72, 709, 333);
		panel_1.add(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(28, 19, 99, 52);
		panel_1.add(panel);
		panel.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(13, 5, 109, 37);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(127, 19, 114, 52);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(21, 5, 101, 37);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBounds(237, 19, 114, 52);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Birthdate");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(25, 10, 97, 32);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(173, 216, 230));
		panel_4.setBounds(348, 19, 114, 52);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(29, 10, 93, 32);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(173, 216, 230));
		panel_5.setBounds(459, 19, 131, 52);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Profession");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(27, 10, 95, 32);
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(173, 216, 230));
		panel_6.setBounds(590, 19, 147, 52);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Phone number");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(24, 10, 113, 32);
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Patients list");
		lblNewLabel.setForeground(new Color(70, 130, 180));
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(560, 35, 340, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\mo.jpg"));
		lblNewLabel_7.setBounds(40, 35, 379, 549);
		contentPane.add(lblNewLabel_7);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AssistanceAcceuil ac = new AssistanceAcceuil();
				ac.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(22, 568, 80, 34);
		contentPane.add(afficher);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DeletePatient d = new DeletePatient();
				d.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Cooper Black", Font.BOLD, 15));
		btnNewButton.setBounds(992, 555, 113, 34);
		contentPane.add(btnNewButton);
	}
}
