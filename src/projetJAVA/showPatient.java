package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class showPatient extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	  private JTable table;
	  private JLabel lblNewLabel_1;
	  private JLabel lblNewLabel_2;
	  private JLabel lblNewLabel_3;
	  private JLabel lblNewLabel_4;
	  private JLabel lblNewLabel_5;
	  private JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	  
	  
	  public void removeempty(BufferedReader reader) {
		  
		  try {
	           

	            // Read the lines of the file into a List<String>
	            List<String> lines = new ArrayList<>();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                lines.add(line);
	            }

	            // Remove empty lines from the list
	            lines.removeIf(String::isEmpty);

	            // Close the input file
	            reader.close();

	            // Open the same file for writing (this will overwrite the original file)
	            BufferedWriter writer = new BufferedWriter(new FileWriter("swing-project/projetJAVA/src/projetJAVA/Patients.txt"));

	            // Write the remaining lines back to the file
	            for (String s : lines) {
	                writer.write(s);
	                writer.newLine();
	            }

	            
	            
	            
	            // Close the output file
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		  
		  
	
	        
		  
		  
		  
	  
	  
	  
	  
	  
	  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showPatient frame = new showPatient();
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
	public showPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(300, 188, 825, 381);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
		
		
		
		
		 String[] columnNames = {"First Name", "Last Name", "Birthdate", "Address", "Profession", "Phone Number"};

	        // Create a table model with the given column names
	        DefaultTableModel model = new DefaultTableModel(columnNames, 0);  

	        
	     // Get the directory path
	        String dirPath = "C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\src\\projetJAVA\\Patients";

	        // Create a file object for the directory
	        File dir = new File(dirPath);

	        // Get all the files in the directory
	        File[] files = dir.listFiles();

	        // Loop through the files
	        
	        for (File file : files) {
	            // Check if the file is a .txt file
	            if (file.isFile() && file.getName().endsWith(".txt")) {
	                try {
	                    // Read data from the file
	                    BufferedReader br = new BufferedReader(new FileReader(file));
	                    String line;
	                    String[] data = new String[6];
	                    while ((line = br.readLine()) != null) {
	                        // Split the line by colon
	                        String[] parts = line.split(": ");
	                        switch (parts[0]) {
	                            case "First Name":
	                                data[0] = parts[1];
	                                break;
	                            case "Last Name":
	                                data[1] = parts[1];
	                                break;
	                            case "Birthdate":
	                                data[2] = parts[1];
	                                break;
	                            case "Address":
	                                data[3] = parts[1];
	                                break;
	                            case "Profession":
	                                data[4] = parts[1];
	                                break;
	                            case "Phone Number":
	                                data[5] = parts[1];
	                                break;
	                        }
	                    }
	                    br.close();
	                    // Add the data as a new row to the table model
	                    model.addRow(data);
	                    // Write the data to the Patients.txt file
	                    FileWriter writer = new FileWriter("src/projetJAVA/Patients.txt", true);
	                    for (int i = 0; i < data.length; i++) {
	                        if (data[i] != null) { // check if the string is not null
	                            writer.write(data[i]);
	                            if (i != data.length - 1) {
	                                writer.write(";");
	                            }
	                        }
	                    }
	                    writer.write("\n");
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } 
	            
	            
	            
	            
	            
	        } 
        
     // Create the JTable with the table model
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
        table = new JTable(model); 
        table.setIntercellSpacing(new Dimension(10, 10));
        table.setRowHeight(25);
        table.setRowMargin(3);
        table.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        
        
        
        
        
        
        
        table.setCellSelectionEnabled(true);  
        ListSelectionModel select= table.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() {  
          public void valueChanged(ListSelectionEvent e) {  
            String Data = null;  
            int[] row = table.getSelectedRows();  
            int[] columns = table.getSelectedColumns();  
            for (int i = 0; i < row.length; i++) {  
              for (int j = 0; j < columns.length; j++) {  
                Data = (String) table.getValueAt(row[i], columns[j]);  
              } }  
            System.out.println("element selectionne est : " + Data);    
          }       
        });  

        // Add the table to a JScrollPane and add the JScrollPane to the JFrame
        JScrollPane scrollPane = new JScrollPane(); 
       
		
		
		
		
		


table.setBounds(0,44,825,320);          

panel_1.add(scrollPane);
panel_1.add(table);
JPanel panel = new JPanel();
panel.setBackground(new Color(176, 224, 230));
panel.setBounds(0, 0, 126, 43);
panel_1.add(panel);
lblNewLabel_1 = new JLabel("First Name");
lblNewLabel_1.setForeground(new Color(255, 255, 255));
lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
panel.add(lblNewLabel_1);
JPanel panel_2 = new JPanel();
panel_2.setBackground(new Color(176, 224, 230));
panel_2.setBounds(119, 0, 151, 43);
panel_1.add(panel_2);
panel_2.setLayout(null);
lblNewLabel_2 = new JLabel("Last Name");
lblNewLabel_2.setBounds(27, 0, 114, 33);
lblNewLabel_2.setForeground(new Color(255, 255, 255));
lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
panel_2.add(lblNewLabel_2);
JPanel panel_3 = new JPanel();
panel_3.setBackground(new Color(176, 224, 230));
panel_3.setBounds(270, 0, 143, 43);
panel_1.add(panel_3);
panel_3.setLayout(null);
lblNewLabel_3 = new JLabel("Birthdate");
lblNewLabel_3.setBounds(10, 5, 104, 26);
lblNewLabel_3.setForeground(new Color(255, 255, 255));
lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
panel_3.add(lblNewLabel_3);
JPanel panel_4 = new JPanel();
panel_4.setBackground(new Color(176, 224, 230));
panel_4.setBounds(409, 0, 132, 43);
panel_1.add(panel_4);
panel_4.setLayout(null);
lblNewLabel_4 = new JLabel("Address");
lblNewLabel_4.setBounds(10, 5, 92, 26);
lblNewLabel_4.setForeground(new Color(255, 255, 255));
lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
panel_4.add(lblNewLabel_4);
JPanel panel_5 = new JPanel();
panel_5.setBackground(new Color(176, 224, 230));
panel_5.setBounds(536, 0, 132, 43);
panel_1.add(panel_5);
setResizable(false);
panel_5.setLayout(null);
lblNewLabel_5 = new JLabel("Profession");
lblNewLabel_5.setBounds(10, 5, 101, 26);
lblNewLabel_5.setForeground(new Color(255, 255, 255));
lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
panel_5.add(lblNewLabel_5);
JPanel panel_6 = new JPanel();
panel_6.setBackground(new Color(176, 224, 230));
panel_6.setBounds(666, 0, 159, 43);
panel_1.add(panel_6);
lblNewLabel_6 = new JLabel("Phone number");
lblNewLabel_6.setForeground(new Color(255, 255, 255));
lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
panel_6.add(lblNewLabel_6);
JButton afficher = new JButton("");
afficher.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		dispose(); 
		Patients patients = new Patients();
		patients.setVisible(true); 
	}
});
afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\2588586_3_5 (1).png"));
afficher.setForeground(new Color(30, 144, 255));
afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
afficher.setBackground(new Color(255, 250, 250));
afficher.setBounds(52, 575, 69, 35);
contentPane.add(afficher);


setTitle("Show patient");
JTextField searchField = new JTextField();
searchField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
searchField.setBounds(533, 143, 329, 35);
contentPane.add(searchField);

JButton searchButton = new JButton("Search");
searchButton.setBackground(new Color(176, 224, 230));
searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

searchButton.setBounds(889, 143, 153, 35);
contentPane.add(searchButton);
JLabel lblNewLabel = new JLabel("Patient Name");
lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
lblNewLabel.setBounds(381, 143, 133, 35);
contentPane.add(lblNewLabel);
JLabel lblNewLabel_7 = new JLabel("Patients List");
lblNewLabel_7.setForeground(new Color(0, 0, 0));
lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
lblNewLabel_7.setBounds(590, 29, 225, 57);
contentPane.add(lblNewLabel_7);
JLabel lblNewLabel_8 = new JLabel("");
lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\mo-removebg-preview.png"));
lblNewLabel_8.setBounds(10, 85, 426, 510);
contentPane.add(lblNewLabel_8);




// Add an ActionListener to the search button
searchButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Get the search term from the search field
        String searchTerm = searchField.getText();

        // Create a new table model for the rows that match the search term
        String[] columnNames = {"First Name", "Last Name", "Birthdate", "Address", "Profession", "Phone Number"};
        DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < model.getRowCount(); i++) {
            String firstName = (String) model.getValueAt(i, 0);
            if (firstName != null && firstName.startsWith(searchTerm)) {
                // Add the row to the new table model if it matches the search term
                String[] row = new String[columnNames.length];
                for (int j = 0; j < columnNames.length; j++) {
                    row[j] = (String) model.getValueAt(i, j);
                }
                newModel.addRow(row);
            }
        }

        // Set the JTable's model to the new table model
        table.setModel(newModel);
    }
});






		
		
		
	}
	public JPanel getContentPane() {
		return contentPane;
	}
}
