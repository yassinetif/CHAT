/**
 * @author Yassine M'CHAAR
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Fenetre extends JFrame implements ActionListener,KeyListener{

		//On crée nos différents conteneurs
	  private JPanel containerLabelNom = new JPanel();
	  private JPanel containerNom = new JPanel();
	  private JPanel containerBtn = new JPanel();
	  private JPanel containerLabelIp = new JPanel();
	  private JPanel containerIp = new JPanel();
	  private JPanel containerLabelPort = new JPanel();
	  private JPanel containerPort = new JPanel();
	  
	  private JPanel containerLabelUser = new JPanel();
	  private JPanel containerUser = new JPanel();
	  
	  private JPanel containerLabelDiscussion = new JPanel();
	  private JPanel containerDiscussion = new JPanel();
	  
	  private JPanel containerLabelMessage = new JPanel();
	  private JPanel containerMessage = new JPanel();
	  
	  private JPanel containerBtnEnvoyer = new JPanel();
	  private JTextField nom = new JTextField();
	  private JButton btnConnexion = new JButton("Connexion");
	  private JTextField ip = new JTextField();
	  private JTextField port = new JTextField();
	  private JTextArea user = new JTextArea(20,8);
	  private JTextArea discussion = new JTextArea(15,20);
	  private JTextArea message = new JTextArea(5,20); 
	  private JButton envoyer = new JButton("envoyer");
	  
	  private boolean connecte=true;
	  private boolean deconnecte=false;
	  private PrintWriter out;
	  private BufferedInputStream in;
	  private Socket socket;
	//Constructeur de la fenetre
	  public Fenetre(){	  
		 	this.setSize(500, 600);
		    this.setTitle("Window");
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    
		//initialisation des composants
		   
		   JLabel labelNom = new JLabel("Nom");
		   labelNom.setPreferredSize(new Dimension(30,20));
		   containerLabelNom.add(labelNom);
		   
		   nom.setPreferredSize(new Dimension(150,20));
		   containerNom.add(nom);
		   
		   
		   
		   btnConnexion.setPreferredSize(new Dimension(150,20));
		   btnConnexion.setEnabled(false);
		   containerBtn.add(btnConnexion);
		  
		   
		   
		
		   JLabel labelIp = new JLabel(" IP ");
		   labelIp.setPreferredSize(new Dimension(30,20));
		   containerLabelIp.add(labelIp);
		   
		   
		   ip.setPreferredSize(new Dimension(150,20));
		   containerIp.add(ip);
		   
		   JLabel labelPort = new JLabel("   Port ");
		   labelPort.setPreferredSize(new Dimension(50,20));
		   containerLabelPort.add(labelPort);
		   
		   
		   port.setPreferredSize(new Dimension(150,20));
		   containerPort.add(port);
		
		   	   
		    
		    JLabel labelUser = new JLabel("Connectés");
		    containerLabelUser.add(labelUser);
		    
		    
		    user.setEditable(false);
		    user.setPreferredSize(new Dimension(100,420));
		    containerUser.setBackground(Color.white);
		    containerUser.setBorder(BorderFactory.createLineBorder(Color.black));
		    containerUser.add(user);
			
			
		   JLabel labelDiscussion = new JLabel("Discussion");
		   containerLabelDiscussion.add(labelDiscussion);
		   
		  
		   discussion.setEditable(false);
		   discussion.setPreferredSize(new Dimension(320,260));
		   containerDiscussion.setBorder(BorderFactory.createLineBorder(Color.black));
		   containerDiscussion.setBackground(Color.white);
		   containerDiscussion.add(discussion);
		   
		   JLabel labelMessage = new JLabel("Message");
		   containerLabelMessage.add(labelMessage);
		   
		    
		   message.setPreferredSize(new Dimension(335,100));
		   message.setEditable(false);
		   containerMessage.setBorder(BorderFactory.createLineBorder(Color.black));
		   containerMessage.add(message);
		  
		   
		   envoyer.setPreferredSize(new Dimension(335,30));
		   //envoyer.setEditable(false);
		   containerBtnEnvoyer.add(envoyer);
		   
		    this.setSize(500, 600);
		    this.setTitle("Window");
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    
		    //Le conteneur principal
		    JPanel content = new JPanel();
		    content.setPreferredSize(new Dimension(500,600));
		 
		    //On définit le layout manager
		    content.setLayout(new GridBagLayout());
				
		    //L'objet servant à positionner les composants
		    GridBagConstraints gbc = new GridBagConstraints();
				
		    
		    
		  //------------containerLabelNom--------------------
		    gbc.gridx = 0;
		    gbc.gridy = 0;
		    //La taille en hauteur et en largeur
		    gbc.gridheight = 1;
		    gbc.gridwidth = 1;
		    gbc.anchor = GridBagConstraints.LINE_START;
		    content.add(containerLabelNom, gbc);
		    
		    //-----------containerNom-------------------
		    gbc.anchor = GridBagConstraints.LAST_LINE_START;
		    gbc.gridx = 1;
		    gbc.gridwidth = 2; 
		    content.add( containerNom, gbc);
		    
		    //-------------containerBtn--------------------  
		    
		    gbc.gridx = 4;   
		    gbc.gridwidth =GridBagConstraints.REMAINDER;
		    content.add(containerBtn, gbc);
		    
		  //---------------containerLabelIp------------------ 
		    
		    gbc.gridx=0;
		    gbc.gridy = 1;
		    gbc.gridwidth =1;
		    gbc.gridheight =1;
		    content.add(containerLabelIp, gbc);
		    
		  //----------------containerIp--------------
		    
		    gbc.gridx=1;  
		    gbc.gridwidth =2;
		    content.add(containerIp, gbc);
		    
		  //---------------containerLabelPort------------------
		    
		    gbc.gridx=3;	    
		    gbc.gridwidth =1;
		    content.add(containerLabelPort, gbc);
		    
		  //--------------containerPort----------------
		     
		    gbc.gridx=4;		   
		    gbc.gridwidth =GridBagConstraints.REMAINDER;
		    content.add(containerPort, gbc);
		    
		  //---------------containerLabelUser------------------
		    
		    gbc.gridx=0;
		    gbc.gridy = 2;
		    gbc.gridwidth =2;
		    content.add(containerLabelUser, gbc);
		    
		  //--------------containerLabelDiscussion------------
		    
		    gbc.gridx=2;
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(containerLabelDiscussion, gbc);
		    
		  //---------------containerUser------------
		    
		    gbc.anchor = GridBagConstraints.LINE_END;
		    gbc.gridx=0;
		    gbc.gridy =3;
		    gbc.gridwidth =2;
		    gbc.gridheight =5;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(containerUser, gbc);
		    
		  //---------------containerDiscussion-------------- 
		    gbc.anchor = GridBagConstraints.CENTER;
		    gbc.gridx=2;
		    gbc.gridheight =1;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(containerDiscussion, gbc);
		    
		  //----------------containerLabelMessage-------------  
		    gbc.insets = new Insets (0, 20, 0, 0);
		    gbc.gridy =4;
		    gbc.gridheight =1;
		    gbc.anchor = GridBagConstraints.LAST_LINE_START;    
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(containerLabelMessage, gbc);
		    
		  //----------------containerMessage------------
		   
		    gbc.gridy =5;
		    gbc.gridheight =1;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(containerMessage, gbc);
		    
		  //--------------containerBtnEnvoyer-----------------  
		    
		    gbc.gridy =6;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(containerBtnEnvoyer, gbc); 
		    
		  //Listener
			nom.addKeyListener(this);
			ip.addKeyListener(this);
			port.addKeyListener(this);
			envoyer.addActionListener(this);
			btnConnexion.addActionListener(this);
			
		  //On ajoute le conteneur
		    this.setContentPane(content);
		    this.setVisible(true);
	  }
	  public static void main(String[] args){
			Fenetre chat = new Fenetre();
	  }
	 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!(ip.getText().isEmpty())&&!(nom.getText().isEmpty())&&!(port.getText().isEmpty()))
			btnConnexion.setEnabled(true);
		else
			btnConnexion.setEnabled(false);
		this.validate();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnConnexion==e.getSource()){
			if(connecte && !deconnecte){
				try{
					socket = new Socket(ip.getText(),Integer.valueOf(port.getText()));
					out = new PrintWriter(socket.getOutputStream());
					in = new BufferedInputStream(socket.getInputStream());
					out.write("0"+"\n"+nom.getText());
					out.flush();
					
					//String reponse = (String) in.readObject();
					//user.setText(reponse);
					socket.close();
					message.setEditable(true);
					btnConnexion.setText("Deconnexion");
					deconnecte = true;
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				System.out.println("Nom : " + nom.getText());
				System.out.println("IP : " + ip.getText());
				System.out.println("Port : " + port.getText());
			
			}
			
			else if(connecte && deconnecte){
				try{
					socket = new Socket(ip.getText(),Integer.valueOf(port.getText()));
					out = new PrintWriter(socket.getOutputStream());
					in = new BufferedInputStream(socket.getInputStream());
					out.write("0"+nom.getText()+"\n");
					out.flush();
					//String reponse = (String) in.readObject();
					socket.close();
					user.setText("");
					discussion.setText("");
					message.setText("");
					message.setEditable(false);
					btnConnexion.setText("Connexion");
					deconnecte = false;
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			/*******************************************************************************/
			else{
				btnConnexion.setText("Connexion");	
			}
		}
		if(envoyer==e.getSource()){
			try{
				Socket socket = new Socket(ip.getText(),Integer.valueOf(port.getText()));
				out = new PrintWriter(socket.getOutputStream());
				in = new BufferedInputStream(socket.getInputStream());
				out.write("1"+user.getText()+": "+message.getText());
				out.flush(); 
				//String reponse = (String) in.readObject();
				//discussion.setText(reponse);
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			message.setText("");
		}
	}
	
}
