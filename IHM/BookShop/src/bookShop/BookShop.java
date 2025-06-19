package bookShop;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookShop {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEdition;
	private JTextField txtPrice;
	private JTable table;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookShop window = new BookShop();
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
	public BookShop() {
		initialize();
		Connect();
		table_load();
	}

	
	Connection con ;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
		} catch (ClassNotFoundException ex){
			
		} catch (SQLException ex) {
			
		}
	}
	
	public void table_load()
	{
	    try 
	    {
	    pst = con.prepareStatement("select * from book");
	    rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
	} 
	    catch (SQLException e) 
	     {
	        e.printStackTrace();
	  } 
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Shop");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(344, 10, 236, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(28, 108, 425, 246);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookName.setBounds(34, 44, 98, 24);
		panel.add(lblBookName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdition.setBounds(34, 101, 98, 24);
		panel.add(lblEdition);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(34, 164, 98, 24);
		panel.add(lblPrice);
		
		txtName = new JTextField();
		txtName.setBounds(175, 49, 146, 19);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtEdition = new JTextField();
		txtEdition.setColumns(10);
		txtEdition.setBounds(175, 106, 146, 19);
		panel.add(txtEdition);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(175, 169, 146, 19);
		panel.add(txtPrice);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookname,edition,price;
				
				bookname = txtName.getText();
				edition = txtEdition.getText();
				price = txtPrice.getText();
				
				try {
			        pst = con.prepareStatement("insert into book(name,edition,price)values(?,?,?)");
			        pst.setString(1, bookname);
			        pst.setString(2, edition);
			        pst.setString(3, price);
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
			        table_load();
			                       
			        txtName.setText("");
			        txtEdition.setText("");
			        txtPrice.setText("");
			        txtName.requestFocus();
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(41, 382, 122, 77);
		frame.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(197, 382, 117, 77);
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
		        txtEdition.setText("");
		        txtPrice.setText("");
		        txtName.requestFocus();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(343, 382, 110, 77);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 108, 381, 351);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(28, 485, 425, 77);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
                    
                    String id = txtID.getText();
                        pst = con.prepareStatement("select name,edition,price from book where id = ?");
                        pst.setString(1, id);
                        ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                      
                        String name = rs.getString(1);
                        String edition = rs.getString(2);
                        String price = rs.getString(3);
                        
                        txtName.setText(name);
                        txtEdition.setText(edition);
                        txtPrice.setText(price);

                    }   
                    else
                    {
                        txtName.setText("");
                        txtEdition.setText("");
                        txtPrice.setText("");
                         
                    }
                } 
            
             catch (SQLException ex) {
                   
                }
			}
		});
		txtID.setBounds(161, 34, 142, 19);
		txtID.setColumns(10);
		panel_1.add(txtID);
		
		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookID.setBounds(29, 37, 86, 13);
		panel_1.add(lblBookID);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String bookname,edition,price,bookid;
                
                
                bookname = txtName.getText();
                edition = txtEdition.getText();
                price = txtPrice.getText();
                bookid  = txtID.getText();
                
                 try {
                        pst = con.prepareStatement("update book set name= ?,edition=?,price=? where id =?");
                        pst.setString(1, bookname);
                        pst.setString(2, edition);
                        pst.setString(3, price);
                        pst.setString(4, bookid);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record Update!!!!!");
                        table_load();
                       
                        txtName.setText("");
                        txtEdition.setText("");
                        txtPrice.setText("");
                        txtName.requestFocus();
                    }
                    catch (SQLException e1) {
                        
                        e1.printStackTrace();
                    }
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(552, 481, 110, 77);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String bookid;
		           bookid  = txtID.getText();
		           
		            try {
		                   pst = con.prepareStatement("delete from book where id =?");
		           
		                   pst.setString(1, bookid);
		                   pst.executeUpdate();
		                   JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
		                   table_load();
		                  
		                   txtName.setText("");
		                   txtEdition.setText("");
		                   txtPrice.setText("");
		                   txtName.requestFocus();
		               }
		               catch (SQLException e1) {
		                   
		                   e1.printStackTrace();
		               }
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(704, 481, 110, 77);
		frame.getContentPane().add(btnDelete);
	}
}
