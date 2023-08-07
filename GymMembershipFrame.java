package za.ac.tut.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import za.ac.tut.membership.Member;

/**
 *
 * @author MemaniV
 */
public class GymMembershipFrame extends JFrame {
    //panels
    private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractsPnl;
    private JPanel personalTrainerOptionPnl;
    private JPanel membershipPnl;
    private JPanel commentsPnl;
    private JPanel btnsPnl;
    private JPanel headingClientCombinedPnl;
    private JPanel membershipCommentsCombinedPnl;
    private JPanel mainPnl;
    
    //labels
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel personalTrainerLbl;
    private JLabel contractTypeLbl;
    
    //textfields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //combobox
    private JComboBox genderComboBox;
    
    //radio buttons
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;
    
    //checkbox
    private JCheckBox personalTrainerChkBx;
    
    //buttongroup
    private ButtonGroup btnGrp;
    
    //textarea
    private JTextArea commentsArea;
    
    //scrollpane
    private JScrollPane scrollableTxtArea;
    
    
    //menu bar
    private JMenuBar menuBar;
    
    //menu 
    private JMenu filemenu;
    
    //menu item
    private JMenuItem openFileMenuItem;
    private JMenuItem viewFileMenuItem;
    private JMenuItem findFileMenuItem;
    private JMenuItem updateFileMenuItem;
    private JMenuItem deleteFileMenuItem;
    private JMenuItem clearFileMenuItem;
    private JMenuItem exitFileMenuItem;
    
    //arraylist
    private ArrayList<Member> theMember;
          
    //construct the gui
    public GymMembershipFrame(){
        //set the frame
        setTitle("Gym membership");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
             
        //creating arrayList
        theMember = new ArrayList<>();
        
        //create panels
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        clientPnl = new JPanel(new GridLayout(4,1,1,1));
        clientPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Client details"));
        
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contractsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        membershipPnl = new JPanel(new GridLayout(2,1,1,1));
        membershipPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Contract options"));
        
        commentsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //btnsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingClientCombinedPnl = new JPanel(new BorderLayout());
        membershipCommentsCombinedPnl = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        
        //create labels
        headingLbl = new JLabel("Membership Form");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLbl.setForeground(Color.BLUE);
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        nameLbl = new JLabel("Name:       ");
        surnameLbl = new JLabel("Surname: ");
        idNoLbl = new JLabel("Id no:         ");
        genderLbl = new JLabel("Gender:     ");     
        contractTypeLbl = new JLabel("Type of contract: ");
        personalTrainerLbl = new JLabel("Select the checkbox if you need a personal trainer ");
        
        //create textfields
        nameTxtFld = new JTextField(10);
        surnameTxtFld = new JTextField(10);
        idNoTxtFld = new JTextField(10);
        
        //create combobox
        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");

        //create radio buttons
        monthToMonthRadBtn = new JRadioButton("Month-to-month");
        sixMonthsRadBtn = new JRadioButton("Six months");
        annualRadBtn = new JRadioButton("Annual");  
        
        //create csheck box
        personalTrainerChkBx = new JCheckBox();
        
        //create button group
        btnGrp = new ButtonGroup();
        btnGrp.add(monthToMonthRadBtn);
        btnGrp.add(sixMonthsRadBtn);
        btnGrp.add(annualRadBtn);
        
        //create text area
        commentsArea = new JTextArea(15,50);
        commentsArea.setEditable(false);
        commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Member(s) details"));
        
        scrollableTxtArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //create jmenu item 
        openFileMenuItem = new JMenuItem("Open");
        openFileMenuItem.addActionListener(new RegisterBtnListener());
               
        viewFileMenuItem = new JMenuItem("View");
        viewFileMenuItem.addActionListener(new DisplayBtnListener());
        
        findFileMenuItem = new JMenuItem("Find");
        findFileMenuItem.addActionListener(new FindBtnListener());
        
        updateFileMenuItem = new JMenuItem("Update");
        updateFileMenuItem.addActionListener(new UpdateBtnListener());
        
        deleteFileMenuItem = new JMenuItem("Delete");
        deleteFileMenuItem.addActionListener(new DeleteBtnListener());
        
        clearFileMenuItem = new JMenuItem("Clear");
        clearFileMenuItem.addActionListener(new ClearBtnListener());
        
        exitFileMenuItem = new JMenuItem("Exit");
        exitFileMenuItem.addActionListener(new ExitBtnListener());
        
        //creating menu
        filemenu = new JMenu("File");
        
        //creating menu bar
        menuBar = new JMenuBar();
        
        //add components to panels
        headingPnl.add(headingLbl); //--> first collective panel
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        idNoPnl.add(idNoLbl);
        idNoPnl.add(idNoTxtFld);
        
        genderPnl.add(genderLbl);
        genderPnl.add(genderComboBox);
        
        clientPnl.add(namePnl); //---> second collective panel
        clientPnl.add(surnamePnl);
        clientPnl.add(idNoPnl);
        clientPnl.add(genderPnl);
        
        headingClientCombinedPnl.add(headingPnl, BorderLayout.NORTH);
        headingClientCombinedPnl.add(clientPnl, BorderLayout.CENTER);
        
        contractsPnl.add(contractTypeLbl);
        contractsPnl.add(monthToMonthRadBtn); //---> third collective panel
        contractsPnl.add(sixMonthsRadBtn);
        contractsPnl.add(annualRadBtn);
        
        personalTrainerOptionPnl.add(personalTrainerLbl);
        personalTrainerOptionPnl.add(personalTrainerChkBx);
        
        membershipPnl.add(contractsPnl);
        membershipPnl.add(personalTrainerOptionPnl);
        
        commentsPnl.add(scrollableTxtArea); //---> fourth collective panel
        
        membershipCommentsCombinedPnl.add(membershipPnl, BorderLayout.NORTH);
        membershipCommentsCombinedPnl.add(commentsPnl, BorderLayout.CENTER);
        
        filemenu.add(openFileMenuItem); //--> fifth colelctive panel
        filemenu.add(viewFileMenuItem);
        filemenu.add(findFileMenuItem);
        filemenu.add(updateFileMenuItem);
        filemenu.add(deleteFileMenuItem);
        filemenu.add(clearFileMenuItem);
        filemenu.add(exitFileMenuItem);
                
        mainPnl.add(headingClientCombinedPnl, BorderLayout.NORTH);
        mainPnl.add(membershipCommentsCombinedPnl, BorderLayout.CENTER);
        
        menuBar.add(filemenu);
        
        setJMenuBar(menuBar);
        
        add(mainPnl);
      
        pack();
        
        setResizable(false);
        
        setVisible(true);
    }
    
    //Helper method writering file with list and path parameters
    private void writerFileMember(ArrayList<Member> theMember , String path) throws IOException
    {
        String msg = "";
        
        FileWriter fw = new FileWriter(path, false);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (Member display : theMember) 
            msg+=display.toString()+"\n";
        
        bw.write(msg);
        
        bw.close();;
    }
    
    //Helper method for reading the file to store it into a list
    private String readFileMember() throws FileNotFoundException, IOException
    {
        String error  = "Something went wrong\n";
        
        String path = "NoFile.txt";
        
        JFileChooser jfc = new JFileChooser();
        
        int value = jfc.showOpenDialog(GymMembershipFrame.this);
        
        if(value == JFileChooser.APPROVE_OPTION)
        {
            File file = jfc.getSelectedFile();
            
            path = file.getPath();
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
         
            String line = br.readLine();
            
            while(line !=null)
            {
                String data [] = line.split(",");
               
                String name = data[0];
                String surname = data[1];
                String idNo = data[2];
                String gender = data[3];
                String contractType = data[4];
                Boolean isPersonalTrainerNeeded =  Boolean.parseBoolean(data[5]);
                
                Member member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerNeeded);
                
                theMember.add(member);
                
                line = br.readLine();
            }
           
        }
        
        else
        {
            error ="The if statemnt failed. The return value is "+value;
            JOptionPane.showMessageDialog(GymMembershipFrame.this, error, "Error" , JOptionPane.ERROR_MESSAGE);
        }
        
        return path;
    }
      
    //helper method for clearing fields
    private void clearFields()
    {
        //clear the fields
        nameTxtFld.setText("");
        surnameTxtFld.setText("");
        idNoTxtFld.setText("");
        personalTrainerChkBx.setSelected(false);
        btnGrp.clearSelection();
        commentsArea.setText("");
            
        //set focus back to the nsme text field
        nameTxtFld.setFocusable(true);
    }
    
    //helper method for geting contract type
    private String getContractType() 
    {
        String contractType = "Nothing is selected";

        if(monthToMonthRadBtn.isSelected())
            contractType = monthToMonthRadBtn.getText();
        else
            if(sixMonthsRadBtn.isSelected())
                contractType = sixMonthsRadBtn.getText();
        else
            if(annualRadBtn.isSelected())
                contractType= annualRadBtn.getText();

        return contractType;
    }

    //anonymous class for deleting a member. It handles the DELETE button.
    private class DeleteBtnListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //write source code here to accomplish the task
            
            try 
            {
                String idNo = idNoTxtFld.getText();
                
                String path = readFileMember();
                
                for (int i = 0; i < theMember.size(); i++) 
                {
                    String idNum = theMember.get(i).getIdNo();
                    
                    if(idNum.equals(idNo))
                        theMember.remove(i);
                }
                
                writerFileMember(theMember, path);
                
                String msg = "Member is removed!";
                JOptionPane.showMessageDialog(GymMembershipFrame.this, msg , "Display" ,JOptionPane.PLAIN_MESSAGE);
            } 
            
            catch (IOException ex) 
            {
                String error ="Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(GymMembershipFrame.this, error , "Error" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //anonymous class for updatering a member. It handles the UPDATE button.
    private class UpdateBtnListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //write source code here to accomplish the task
            
            String idNo = idNoTxtFld.getText();
            
            try 
            {
                String path = readFileMember();
                
                FileWriter fw = new FileWriter(path , false);
                
                for (int i = 0; i < theMember.size(); i++) 
                {
                    String idNum = theMember.get(i).getIdNo();
                    
                    if(idNum.equals(idNo))
                    {
                        String name = nameTxtFld.getText();
                        String surname = surnameTxtFld.getText();
                        String gender = genderComboBox.getSelectedItem().toString();
                        String contractType = getContractType();
                        Boolean isPersonalTrainerNeeded =  personalTrainerChkBx.isSelected();
                        
                        Member member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerNeeded);
                    
                        theMember.set(i, member);
                    } 
                }
                
                writerFileMember(theMember , path);
                
                String msg ="Member is updated!";
                JOptionPane.showMessageDialog(GymMembershipFrame.this, msg ,"Display" , JOptionPane.PLAIN_MESSAGE);
            } 
            
            catch (IOException ex) 
            {
                String error = "Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(GymMembershipFrame.this, error ,"Error" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //anonymous class for find a member. It handles the FIND button.
    private class FindBtnListener implements ActionListener 
    {
        String msg="";
        
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //write source code here to accomplish the task
            
            String idNo = idNoTxtFld.getText();
            try 
            {
                readFileMember();
                
                for (Member display : theMember)
                {
                    if(display.getIdNo().equals(idNo))
                        msg += display.toString();
                }
                commentsArea.setText(msg);
                
                idNoTxtFld.setText(null);
            }
            
            catch (IOException ex) 
            {
                String error = "Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(GymMembershipFrame.this, error,"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
   
    //anonymous class for registering a member. It handles the REGISTER button.
    private class RegisterBtnListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {      
            //write source code here to accomplish the task
            
            String error = "Something went wrong\n";
            
            String name = nameTxtFld.getText();
            String surname = surnameTxtFld.getText();
            String idNo = idNoTxtFld.getText();
            String gender = genderComboBox.getSelectedItem().toString();
            String contractType = getContractType();
            Boolean isPersonalTrainerNeeded =  personalTrainerChkBx.isSelected();
            
            Member member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerNeeded);
            
            JFileChooser jfc = new JFileChooser();
            
            int value = jfc.showSaveDialog(GymMembershipFrame.this);
            
            if(value == JFileChooser.APPROVE_OPTION)
            {
                try 
                {    
                    File file = jfc.getSelectedFile();
                    
                    FileWriter fw = new FileWriter(file ,true );
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    String msg = member.toString();
                    
                    bw.write(msg);
                    
                    bw.newLine();
                    
                    bw.close();
                    
                    clearFields();
                    
                } 
                
                catch (IOException ex) 
                {
                    error+=ex.getMessage();
                    commentsArea.setText(error);
                }
                
                finally
                {
                    String msg = "Member is registered!";
                    JOptionPane.showMessageDialog(GymMembershipFrame.this, msg , "Display", JOptionPane.PLAIN_MESSAGE);
                }
            }
            
        }
    }
    
    //anonymous class for displaying the file contents on the text area. It handles the DISPLAY MEMBERS button.
    private class DisplayBtnListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            //write source code here to ccomplish the task
            String error = "Something went wrong\n";
            
            JFileChooser jfc = new JFileChooser();
            
            int value = jfc.showOpenDialog(GymMembershipFrame.this);
            
            if(value ==JFileChooser.APPROVE_OPTION)
            {
                try 
                {
                    File file = jfc.getSelectedFile();
               
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    
                    String line = br.readLine();
                    
                    String data = "";
                    
                    while (line != null)
                    {                        
                        data+=line+"\n";
                        
                        line = br.readLine();
                        
                    }
                    
                    commentsArea.setText(data);
                } 
                
                catch (FileNotFoundException ex) 
                {
                    error="File not found";
                    commentsArea.setText(error);
                } 
                
                catch (IOException ex) 
                {
                    error +=ex.getMessage();
                    commentsArea.setText(error);
                }
                
            }
        }
    }
    
        //anonnymous class for clearing the fields. It handles the CLEAR button.
    private class ClearBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            //write source code here to accomplish the task
            clearFields();
        }
    }

    //anonymous class for exiting the application. It handles the EXIT button.    
    private class ExitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //write source code here to accomplish the task
            System.exit(0);
        }
    }

}


