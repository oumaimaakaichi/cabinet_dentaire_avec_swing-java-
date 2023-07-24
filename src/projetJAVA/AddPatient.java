package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AddPatient extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfBirthdate;
	private JTextField tfAddress;
	private JTextField tfProfession;
	private JTextField tfPhoneNumber;
	
private JButton btnCreate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient();
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
	public AddPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1286, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Container c = getContentPane();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(556, -17, 289, 250);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\7151da6eb86744a3cbe21b5b7abcca16-removebg-preview (1).png"));
		contentPane.add(lblNewLabel);
		
		tfFirstName = new JTextField();
		tfFirstName.setBorder(null);
		tfFirstName.setBounds(203, 310, 367, 43);
		tfFirstName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBorder(null);
		tfLastName.setBounds(817, 310, 338, 43);
		tfLastName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfLastName.setColumns(10);
		contentPane.add(tfLastName);
		
		tfBirthdate = new JTextField();
		tfBirthdate.setBorder(null);
		tfBirthdate.setBounds(203, 383, 367, 43);
		tfBirthdate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfBirthdate.setColumns(10);
		contentPane.add(tfBirthdate);
		setTitle("Add Patient");
		tfAddress = new JTextField();
		tfAddress.setBorder(null);
		tfAddress.setBounds(817, 383, 338, 43);
		tfAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfAddress.setColumns(10);
		contentPane.add(tfAddress);
		
		tfProfession = new JTextField();
		tfProfession.setBorder(null);
		tfProfession.setBounds(203, 472, 367, 43);
		tfProfession.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfProfession.setColumns(10);
		contentPane.add(tfProfession);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setBorder(null);
		tfPhoneNumber.setBounds(817, 472, 338, 43);
		tfPhoneNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfPhoneNumber.setColumns(10);
		contentPane.add(tfPhoneNumber);
		
		JLabel lblNewLabel_1 = new JLabel("First name:");
		lblNewLabel_1.setBounds(79, 315, 584, 28);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name:");
		lblNewLabel_1_1.setBounds(673, 315, 578, 28);
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Birthdate:");
		lblNewLabel_1_2.setBounds(79, 388, 584, 28);
		lblNewLabel_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address:");
		lblNewLabel_1_3.setBounds(673, 388, 578, 28);
		lblNewLabel_1_3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Profession:");
		lblNewLabel_1_4.setBounds(79, 477, 584, 28);
		lblNewLabel_1_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone :");
		lblNewLabel_1_5.setBounds(673, 477, 578, 28);
		lblNewLabel_1_5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_5);
		
		 btnCreate = new JButton("Create");
		 btnCreate.setBounds(615, 556, 172, 34);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				if (e.getSource() == btnCreate) {
		            createPatient();
				}
		        
			}
		});
		btnCreate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCreate.setBackground(new Color(255, 255, 240));
		contentPane.add(btnCreate);
		
		JButton afficher = new JButton("");
		afficher.setBounds(26, 577, 88, 34);
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AssistanceAcceuil as = new AssistanceAcceuil();
				as.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\téléchargé__1_-removebg-preview (1) (2).png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(240, 255, 255));
		contentPane.add(afficher);
		
		JList list = new JList();
		list.setBounds(149, 180, 101, -21);
		contentPane.add(list);
	}
private void createPatient() {
		
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String birthdate = tfBirthdate.getText();
        String address = tfAddress.getText();
        String profession = tfProfession.getText();
        String phoneNumber = tfPhoneNumber.getText();
        

        String fileName = "src/projetJAVA/Patients/"+firstName+"_"+lastName+".txt";
        
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("First Name: " + firstName + "\n");
            fw.write("Last Name: " + lastName + "\n");
            fw.write("Birthdate: " + birthdate + "\n");
            fw.write("Address: " + address + "\n");
            fw.write("Profession: " + profession + "\n");
            fw.write("Phone Number: " + phoneNumber + "\n");
            fw.write("medicalcare: " +""+ " \n");
            fw.close();
            
            JOptionPane.showMessageDialog(null, "Add Successful!");
            dispose(); 
            
            PatienTAll Ass = new PatienTAll();
			Ass.setVisible(true);  
        
        } catch (IOException e) {
        	
        	
        	System.out.println("error"); 
        } 
        
        
        
        
        
   
        
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    
}	
}
