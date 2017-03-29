
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;

public class GUI extends JFrame {
	HashMap<String,Integer> full= new HashMap<String,Integer>();
	HashMap<String,book> fullobj= new HashMap<String,book>();
    public reader userreader;
    static ArrayList<book> authoral=new ArrayList<book>();
    ArrayList<book> titleal=new ArrayList<book>();
    public GUI(){
        setSize(1000,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        main_frame d=new main_frame();
        setVisible(true);


    }

    public static void main(String[] args){


        GUI a=new GUI();

    }

    public class main_frame{
        int cnt=21;
        JPanel whole,left_panel,Top_panel,right_panel,new_panel;
        boolean chec=false;
        String[] columns = {"Sno", "Name", "Student/Mentor"};
        Object[][] data = {{"1", "Gullall Singh", "Mentor"}, {"2", "Krishan", "Student"}, {"3", "NIkhil Verma ", "Student "}};

        JTable table = new JTable(data, columns);
        //

        public void reset()
        {
            removeAll();
            main_frame l=new main_frame();
            validate();
            repaint();
        }

        main_frame(){
            whole =new JPanel(null);
            System.out.println("hjk");
            userreader=new reader();
            try {
                File inputFile = new File("dblp.xml");
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                //reader userreader = new reader();
                saxParser.parse(inputFile, userreader);
            }
            catch (Exception e) {
                //System.out.println("fghjk");
                e.printStackTrace();
            }
            //System.out.println("hoii");

            int che=0;
            left_panel=new JPanel(null);
            left_panel.setBounds(0,75,350,675);
            left_panel.setBackground(Color.cyan);

            new_panel=new JPanel(null);
            new_panel.setBounds(40,180,350,675);
            new_panel.setBackground(Color.cyan);

            String[] s={"Query","Query1","Query2"};
            JComboBox query=new JComboBox(s);
            query.setSelectedIndex(0);
            query.setBounds(120,120,100,40);


            //boolean chec=false;
            query.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String available_options=(String)query.getSelectedItem();
                    switch (available_options){
                        case "Query":break;
                        case "Query1":
                            right_panel.removeAll();
                            validate();
                            repaint();
                            authoral.clear();
                            new_panel.removeAll();
                            left_panel.remove(new_panel);

                            String[] p={"Search By","Author Name","Title Tag"};
                            JComboBox searchby=new JComboBox(p);
                            searchby.setSelectedIndex(0);
                            searchby.setBounds(80,00,100,40);


                            new_panel.add(searchby);


                            JTextField name=new JTextField();
                            name.setText("Name/Title Tag");
                            name.setBounds(0,80,130,20);
                            name.setEditable(false);
                            name.setBackground(Color.BLUE);
                            name.setForeground(Color.BLACK);
                            new_panel.add(name);

                            JTextField name_feild=new JTextField();
                            name_feild.setBounds(140,80,145,20);
                            new_panel.add(name_feild);

                            
                            
                            JButton next1=new JButton("Next");
                            next1.setBounds(10,400,120,40);
                            new_panel.add(next1);
                            
//                            JButton previous1=new JButton("Previous");
//                            previous1.setBounds(150,400,120,40);
//                            new_panel.add(previous1);

                            

                            JTextField res=new JTextField();
                            res.setText("No. of Results");
                            res.setBounds(50,300,130,20);
                            res.setEditable(false);
                            res.setBackground(Color.BLUE);
                            res.setForeground(Color.BLACK);
                            new_panel.add(res);

                            JTextField resname=new JTextField();
                            resname.setBounds(180,300,130,20);
                            	new_panel.add(resname);


                            final JRadioButton SortByDate=new JRadioButton("Sort By Date");
                            SortByDate.setBounds(50,230,200,20);
                            
                            final JRadioButton SortByRelevance=new JRadioButton("Sort By Relevance");
                            SortByRelevance.setBounds(50,260,200,20);
                            
                            final JRadioButton SinceYear=new JRadioButton("Since Year");
                            
                            JTextField year_feild=new JTextField();
                            SinceYear.setBounds(50,110,100,20);
                            SinceYear.addActionListener(new ActionListener()
                            {
                            
                            	public void actionPerformed(ActionEvent e)
                            	{
                            		JTextField year=new JTextField();
                                    year.setText("Since Year");
                                    year.setBounds(0,140,100,20);
                                    year.setEditable(false);
                                    year.setBackground(Color.blue);
                                    year.setForeground(Color.BLACK);
                                    new_panel.add(year);
                                    
                                    
                                    year_feild.setBounds(120,140,145,20);
                                    new_panel.add(year_feild);
                                    validate();
                                    repaint();
                            	}

								
                         	});
                            
                            JTextField custom_range_feild=new JTextField();
                            JTextField custom_range_feild2=new JTextField();
                            final JRadioButton customRange=new JRadioButton("Custom Range");
                            customRange.setBounds(50,170,200,20);
                            customRange.addActionListener(new ActionListener()
                            {
                            
                            	public void actionPerformed(ActionEvent e)
                            	{
                            		JTextField custom_range=new JTextField();
                                    custom_range.setText("Custom Range");
                                    custom_range.setBounds(0,200,130,20);
                                    custom_range.setEditable(false);
                                    custom_range.setBackground(Color.blue);
                                    custom_range.setForeground(Color.BLACK);
                                    
                                    new_panel.add(custom_range);
                                    
                                    
                                    custom_range_feild.setBounds(140,200,65,20);
                                    new_panel.add(custom_range_feild);

                                    
                                    custom_range_feild2.setBounds(210,200,65,20);
                                    new_panel.add(custom_range_feild2);
                                    validate();
                                    repaint();
                            	}

								
                         	});
                            
                            ButtonGroup group=new ButtonGroup();
                            ButtonGroup group1=new ButtonGroup();
                            DefaultTableModel model = new DefaultTableModel();

                            model.addColumn("S.NO");
                            model.addColumn("A.Name");
                            model.addColumn("Title");
                            model.addColumn("No of pages");
                            model.addColumn("Year");
                            model.addColumn("volume");
                            model.addColumn("journal");
                            JTable Table = new JTable(model);



                            searchby.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                {
                                   // new GUI()
                                    //right_panel.removeAll();
                                    String selectedoption = (String) searchby.getSelectedItem();
                                    authoral.clear();
                                    if(selectedoption=="Author Name")

                                    {
                                       // int count1=0;
                                       // model.setRowCount(0);
                                        SortByDate.addActionListener(new ActionListener()
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                if(chec)
                                                {
                                                    right_panel.removeAll();
                                                    chec=false;

                                                }
                                                authoral.clear();
                                                //right_panel.remove(ScrollPane);
                                                String s=name_feild.getText();
                                                System.out.println(s);
                                                try
                                                {
                                                	Collections.sort(userreader.bookinformation);
                                                }
                                                catch(Exception e1)
                                                {
                                                	Collections.sort(userreader.bookinformation);
                                                }
                                                	
                                                String y=year_feild.getText();
                                                int sy=0,sy1=0,sy2=0;
                                                try{
                                                    sy=Integer.parseInt(y);
                                                }
                                                catch(Exception e1)
                                                {
                                                	sy=0;
                                                }
                                                //else
                                                
                                                String y1=custom_range_feild.getText();
                                                try{
                                                    sy1=Integer.parseInt(y1);
                                                }
                                                catch(Exception e1)
                                                {
                                                	sy1=0;
                                                }
                                                int count1=0;
                                                int count2=0;
                                                String y2=custom_range_feild2.getText();
                                                try{
                                                    sy2=Integer.parseInt(y2);
                                                }
                                                catch(Exception e1)
                                                {
                                                	sy2=0;
                                                }
                                                int flag1=0;
                                                entity_resolution k=new entity_resolution();
                                                for(book b : userreader.bookinformation)
                                                {
                                                    // System.out.println("uiy");
                                                	try{
                                                    if(s!=null)
                                                    {
                                                        if(b.getAuthor()!=null)
                                                        {
                                                            if (k.enr(b.getAuthor(), s) && sy <= Integer.parseInt(b.getYear())) {
                                                                authoral.add(b);
                                                                flag1 = 1;
                                                                count1 = count1 + 1;
                                                                

                                                            }
                                                        }
                                                    }
                                                    else
                                                    {
                                                        if(b.getAuthor()!=null)
                                                        {
                                                            if ((k.enr(b.getAuthor(), s) )) {
                                                            	if( ((sy1 <= Integer.parseInt(b.getYear())) && (sy2 >= Integer.parseInt(b.getYear()))))
                                                            	{
                                                            		authoral.add(b);
                                                                    flag1 = 1;
                                                                    count1 = count1 + 1;
                                                            	}
                                                            		
                                                                

                                                            }
                                                        }
                                                    }
                                                	}
                                                	catch(Exception e7)
                                                	{
                                                		
                                                	}


                                                }

                                                if(count1==0)
                                                {
                                                    resname.setText("No. Result found");
                                                }
                                                else
                                                    resname.setText(String.valueOf(count1));
                                                if(flag1==0)
                                                {
                                                    JPanel pane=new JPanel();
                                                    JOptionPane.showMessageDialog(pane,"PLEASE ENTER VALID AUTHOR NAME/TITLE TAG","WARNING MESSAGE",JOptionPane.WARNING_MESSAGE);
                                                }
                                                right_panel.removeAll();
                                                validate();
                                                repaint();

                                                //DefaultTableModel model = new DefaultTableModel();
                                                

//                                                JButton next1=new JButton("NEXT");
//                                                next1.setBounds(150,500,100,40);
//                                                right_panel.add(next1);
                                                
                                                int cot=0;
                                                Iterator iter;
                                                iter =  authoral.iterator();
                                                Object[] olddata={};
                                                model.setRowCount(0);
                                                //int last=20;
                                                while(iter.hasNext() && cot<20)
                                                {

                                                    //model.setRowCount(0);
                                                    book element= (book) iter.next();
                                                    Object[] hold={cot+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                    model.insertRow(cot,hold);
                                                    System.out.println(cot);
                                                    cot++;
                                                    //last++;



                                                }


                                                //JScrollPane scrollPane=new JScrollPane(Table);
                                                

                                                next1.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        int ctr1=0;
                                                        //if(())
                                                        model.setRowCount(0);
//                                                        model.addColumn("S.NO");
//                                                        model.addColumn("Author Name");
//                                                        model.addColumn("Number of Books");

                                                        System.out.print("l");
                                                      //  Iterator ir=RequiredName.iterator();
                                                        //int cnt=2;
                                                        while(iter.hasNext() && ctr1<20)
                                                        {
                                                           // System.out.print("D");
                                                            book element= (book) iter.next();

                                                            Object[] hold={ctr1+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                            model.insertRow(ctr1,hold);

                                                            invalidate();
                                                            repaint();
                                                            ctr1++;
                                                            //cnt++;


                                                        }
                                                    }
                                                });

                                               // model.setRowCount(0);
                                               // right_panel.removeAll();
                                                //validate();
                                                //repaint();


                                                JScrollPane scrollPane=new JScrollPane(Table);

                                                Table.setFillsViewportHeight(true);
                                                scrollPane.setBounds(0,50,600,600);
                                                right_panel.add(scrollPane);





                                            }


                                        });

                                        SortByRelevance.addActionListener(new ActionListener()
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                if(chec)
                                                {
                                                    right_panel.removeAll();
                                                    chec=false;

                                                }
                                                authoral.clear();
                                                //right_panel.remove(ScrollPane);
                                                String s=name_feild.getText();
                                                System.out.println(s);
                                                try{
                                                Collections.sort(userreader.bookinformation);
                                                }
                                                catch(Exception e1)
                                                {
                                                	
                                                }
                                                String y=year_feild.getText();
                                                int sy=0,sy1=0,sy2=0;
                                                if(!y.equals(""))
                                                    sy=Integer.parseInt(y);

                                                String y1=custom_range_feild.getText();
                                                if(!y1.equals(""))
                                                    sy1=Integer.parseInt(y1);
                                                int count1=0;
                                                int count2=0;
                                                String y2=custom_range_feild2.getText();
                                                if(!y2.equals(""))
                                                    sy2=Integer.parseInt(y2);
                                                int flag1=0;
                                                entity_reso_rel k=new entity_reso_rel();
                                                HashMap<String,Integer> km=new HashMap<String,Integer>();
                                                for(book b : userreader.bookinformation)
                                                {
                                                    // System.out.println("uiy");
                                                	try{
                                                    if(sy!=0) {
                                                    	//System.out.println(s);
                                                        if (b.getAuthor() != null)
                                                        {
                                                            if (sy <= Integer.parseInt(b.getYear())) {
                                                                k.m(b.getAuthor(),s,full,fullobj,b);
                                                                flag1 = 1;
                                                                count1 = count1 + 1;



                                                            }
                                                    }
                                                    }
                                                    else
                                                    {
                                                        try{
                                                    	if (b.getAuthor() != null)
                                                        {
                                                            if (sy1 <= Integer.parseInt(b.getYear()) && sy2 >= Integer.parseInt(b.getYear())  ) {
                                                            	k.m(b.getAuthor(),s,full,fullobj,b);
                                                                flag1 = 1;
                                                                count1 = count1 + 1;
                                                                ;


                                                            }
                                                        }
                                                        }
                                                        catch(Exception e188)
                                                        {
                                                        	
                                                        }
                                                    }
                                                	}
                                                	catch(Exception e8)
                                                	{
                                                		
                                                	}


                                                }

                                                if(count1==0)
                                                {
                                                    resname.setText("No. Result found");
                                                }
                                                else
                                                    resname.setText(String.valueOf(count1));
                                                if(flag1==0)
                                                {
                                                    JPanel pane=new JPanel();
                                                    JOptionPane.showMessageDialog(pane,"PLEASE ENTER VALID AUTHOR NAME","WARNING MESSAGE",JOptionPane.WARNING_MESSAGE);
                                                }
                                                right_panel.removeAll();
                                                validate();
                                                repaint();
                                                int l=3;

                                                while(l!=-1)
                                                {
                                                    for(Map.Entry<String,Integer> ee:full.entrySet())
                                                    {
                                                        if(ee.getValue()==l)
                                                        {
                                                            //System.out.println(ee.getKey()+" "+l);
                                                        	authoral.add(fullobj.get(ee.getKey()));
                                                        }
                                                        //System.out.println("juii");

                                                    }
                                                    l--;
                                                }

                                                //DefaultTableModel model = new DefaultTableModel();
                                                DefaultTableModel model = new DefaultTableModel();

                                                model.addColumn("S.NO");
                                                model.addColumn("A.Name");
                                                model.addColumn("Title");
                                                model.addColumn("No of pages");
                                                model.addColumn("Year");
                                                model.addColumn("volume");
                                                model.addColumn("journal");
                                                JTable Table = new JTable(model);

                                                int cot=0;
                                                Iterator iter;
                                                iter =  authoral.iterator();
                                                Object[] olddata={};
                                                model.setRowCount(0);
                                                
                                                // model.setRowCount(0);
                                                // right_panel.removeAll();
                                                //validate();
                                                //repaint();
                                                while(iter.hasNext() && cot<20)
                                                {

                                                    //model.setRowCount(0);
                                                    book element= (book) iter.next();
                                                    Object[] hold={cot+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                    model.insertRow(cot,hold);
                                                    System.out.println(cot);
                                                    cot++;
                                                    //last++;



                                                }
                                                next1.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        int ctr1=0;
                                                        //if(())
                                                        model.setRowCount(0);
//                                                        model.addColumn("S.NO");
//                                                        model.addColumn("Author Name");
//                                                        model.addColumn("Number of Books");

                                                        System.out.print("l");
                                                      //  Iterator ir=RequiredName.iterator();
                                                        //int cnt=2;
                                                        while(iter.hasNext() && ctr1<20)
                                                        {
                                                           // System.out.print("D");
                                                            book element= (book) iter.next();

                                                            Object[] hold={ctr1+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                            model.insertRow(ctr1,hold);

                                                            invalidate();
                                                            repaint();
                                                            ctr1++;
                                                            //cnt++;


                                                        }
                                                    }
                                                });


                                                JScrollPane scrollPane=new JScrollPane(Table);

                                                Table.setFillsViewportHeight(true);
                                                scrollPane.setBounds(0,50,600,600);
                                                right_panel.add(scrollPane);





                                            }


                                        });


                                    }
                                    if(selectedoption=="Title Tag")

                                    {
                                       // int count1=0;
                                       // model.setRowCount(0);
                                        SortByDate.addActionListener(new ActionListener()
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                if(chec)
                                                {
                                                    right_panel.removeAll();
                                                    chec=false;

                                                }
                                                titleal.clear();
                                                //right_panel.remove(ScrollPane);
                                                String s=name_feild.getText();
                                                System.out.println(s);
                                                try
                                                {
                                                	Collections.sort(userreader.bookinformation);
                                                }
                                                catch(Exception e1)
                                                {
                                                	Collections.sort(userreader.bookinformation);
                                                }
                                                	
                                                String y=year_feild.getText();
                                                int sy=0,sy1=0,sy2=0;
                                                try{
                                                    sy=Integer.parseInt(y);
                                                }
                                                catch(Exception e1)
                                                {
                                                	sy=0;
                                                }
                                                //else
                                                
                                                String y1=custom_range_feild.getText();
                                                try{
                                                    sy1=Integer.parseInt(y1);
                                                }
                                                catch(Exception e1)
                                                {
                                                	sy1=0;
                                                }
                                                int count1=0;
                                                int count2=0;
                                                String y2=custom_range_feild2.getText();
                                                try{
                                                    sy2=Integer.parseInt(y2);
                                                }
                                                catch(Exception e1)
                                                {
                                                	sy2=0;
                                                }
                                                int flag1=0;
                                                entity_resolution k=new entity_resolution();
                                                for(book b : userreader.bookinformation)
                                                {
                                                    // System.out.println("uiy");
                                                	try{
                                                    if(s!=null)
                                                    {
                                                        if(b.getTitle()!=null)
                                                        {
                                                            if (k.enr(b.getTitle(), s) && sy <= Integer.parseInt(b.getYear())) {
                                                                titleal.add(b);
                                                                flag1 = 1;
                                                                count1 = count1 + 1;
                                                                

                                                            }
                                                        }
                                                    }
                                                    else
                                                    {
                                                        if(b.getTitle()!=null)
                                                        {
                                                            if ((k.enr(b.getTitle(), s) )) {
                                                            	if( ((sy1 <= Integer.parseInt(b.getYear())) && (sy2 >= Integer.parseInt(b.getYear()))))
                                                            	{
                                                            		titleal.add(b);
                                                                    flag1 = 1;
                                                                    count1 = count1 + 1;
                                                            	}
                                                            		
                                                                

                                                            }
                                                        }
                                                    }
                                                	}
                                                	catch(Exception e10)
                                                	{
                                                		
                                                	}


                                                }

                                                if(count1==0)
                                                {
                                                    resname.setText("No. Result found");
                                                }
                                                else
                                                    resname.setText(String.valueOf(count1));
                                                if(flag1==0)
                                                {
                                                    JPanel pane=new JPanel();
                                                    JOptionPane.showMessageDialog(pane,"PLEASE ENTER VALID AUTHOR NAME/TITLE TAG","WARNING MESSAGE",JOptionPane.WARNING_MESSAGE);
                                                }
                                                right_panel.removeAll();
                                                validate();
                                                repaint();

                                                //DefaultTableModel model = new DefaultTableModel();
                                                

//                                                JButton next1=new JButton("NEXT");
//                                                next1.setBounds(150,500,100,40);
//                                                right_panel.add(next1);
                                                
                                                int cot=0;
                                                Iterator iter;
                                                iter =  titleal.iterator();
                                                Object[] olddata={};
                                                model.setRowCount(0);
                                                //int last=20;
                                                while(iter.hasNext() && cot<20)
                                                {

                                                    //model.setRowCount(0);
                                                    book element= (book) iter.next();
                                                    Object[] hold={cot+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                    model.insertRow(cot,hold);
                                                    System.out.println(cot);
                                                    cot++;
                                                    //last++;



                                                }


                                                //JScrollPane scrollPane=new JScrollPane(Table);
                                                

                                                next1.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        int ctr1=0;
                                                        //if(())
                                                        model.setRowCount(0);
//                                                        model.addColumn("S.NO");
//                                                        model.addColumn("Author Name");
//                                                        model.addColumn("Number of Books");

                                                        System.out.print("l");
                                                      //  Iterator ir=RequiredName.iterator();
                                                        //int cnt=2;
                                                        while(iter.hasNext() && ctr1<20)
                                                        {
                                                           // System.out.print("D");
                                                            book element= (book) iter.next();

                                                            Object[] hold={ctr1+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                            model.insertRow(ctr1,hold);

                                                            invalidate();
                                                            repaint();
                                                            ctr1++;
                                                            //cnt++;


                                                        }
                                                    }
                                                });

                                               // model.setRowCount(0);
                                               // right_panel.removeAll();
                                                //validate();
                                                //repaint();


                                                JScrollPane scrollPane=new JScrollPane(Table);

                                                Table.setFillsViewportHeight(true);
                                                scrollPane.setBounds(0,50,600,600);
                                                right_panel.add(scrollPane);





                                            }


                                        });

                                        SortByRelevance.addActionListener(new ActionListener()
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                if(chec)
                                                {
                                                    right_panel.removeAll();
                                                    chec=false;

                                                }
                                                titleal.clear();
                                                //right_panel.remove(ScrollPane);
                                                String s=name_feild.getText();
                                                System.out.println(s);
                                                try{
                                                Collections.sort(userreader.bookinformation);
                                                }
                                                catch(Exception e1)
                                                {
                                                	Collections.sort(userreader.bookinformation);
                                                }
                                                String y=year_feild.getText();
                                                int sy=0,sy1=0,sy2=0;
                                                if(!y.equals(""))
                                                    sy=Integer.parseInt(y);

                                                String y1=custom_range_feild.getText();
                                                if(!y1.equals(""))
                                                    sy1=Integer.parseInt(y1);
                                                int count1=0;
                                                int count2=0;
                                                String y2=custom_range_feild2.getText();
                                                if(!y2.equals(""))
                                                    sy2=Integer.parseInt(y2);
                                                int flag1=0;
                                                entity_reso_rel k=new entity_reso_rel();
                                                HashMap<String,Integer> km=new HashMap<String,Integer>();
                                                for(book b : userreader.bookinformation)
                                                {
                                                    // System.out.println("uiy");
                                                    if(sy!=0) {
                                                    	//System.out.println(s);
                                                        if (b.getTitle() != null)
                                                        {
                                                            try{
                                                        	if (sy <= Integer.parseInt(b.getYear())) {
                                                                k.m(b.getTitle(),s,full,fullobj,b);
                                                                flag1 = 1;
                                                                count1 = count1 + 1;



                                                            }
                                                            }
                                                            catch(Exception e5)
                                                            {
                                                            	
                                                            }
                                                    }
                                                    }
                                                    else
                                                    {
                                                        try{
                                                    	if (b.getTitle() != null)
                                                        {
                                                            if (sy1 <= Integer.parseInt(b.getYear()) && sy2 >= Integer.parseInt(b.getYear())  ) {
                                                            	k.m(b.getTitle(),s,full,fullobj,b);
                                                                flag1 = 1;
                                                                count1 = count1 + 1;
                                                                ;


                                                            }
                                                        }
                                                        }
                                                        catch(Exception e6)
                                                        {
                                                        	
                                                        }
                                                    }


                                                }

                                                if(count1==0)
                                                {
                                                    resname.setText("No. Result found");
                                                }
                                                else
                                                    resname.setText(String.valueOf(count1));
                                                if(flag1==0)
                                                {
                                                    JPanel pane=new JPanel();
                                                    JOptionPane.showMessageDialog(pane,"PLEASE ENTER VALID AUTHOR NAME","WARNING MESSAGE",JOptionPane.WARNING_MESSAGE);
                                                }
                                                right_panel.removeAll();
                                                validate();
                                                repaint();
                                                int l=3;

                                                while(l!=-1)
                                                {
                                                    for(Map.Entry<String,Integer> ee:full.entrySet())
                                                    {
                                                        if(ee.getValue()==l)
                                                        {
                                                            //System.out.println(ee.getKey()+" "+l);
                                                        	authoral.add(fullobj.get(ee.getKey()));
                                                        }
                                                        //System.out.println("juii");

                                                    }
                                                    l--;
                                                }

                                                //DefaultTableModel model = new DefaultTableModel();
                                                DefaultTableModel model = new DefaultTableModel();

                                                model.addColumn("S.NO");
                                                model.addColumn("A.Name");
                                                model.addColumn("Title");
                                                model.addColumn("No of pages");
                                                model.addColumn("Year");
                                                model.addColumn("volume");
                                                model.addColumn("journal");
                                                JTable Table = new JTable(model);

                                                int cot=0;
                                                Iterator iter;
                                                iter =  authoral.iterator();
                                                Object[] olddata={};
                                                model.setRowCount(0);
                                                
                                                // model.setRowCount(0);
                                                // right_panel.removeAll();
                                                //validate();
                                                //repaint();
                                                cot=0;
                                                while(iter.hasNext() && cot<20)
                                                {

                                                    //model.setRowCount(0);
                                                    book element= (book) iter.next();
                                                    Object[] hold={cot+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                    model.insertRow(cot,hold);
                                                    System.out.println(cot);
                                                    cot++;
                                                    //last++;



                                                }
                                                next1.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        int ctr1=0;
                                                        //if(())
                                                        model.setRowCount(0);
//                                                        model.addColumn("S.NO");
//                                                        model.addColumn("Author Name");
//                                                        model.addColumn("Number of Books");

                                                        System.out.print("l");
                                                      //  Iterator ir=RequiredName.iterator();
                                                        //int cnt=2;
                                                        while(iter.hasNext() && ctr1<20)
                                                        {
                                                           // System.out.print("D");
                                                            book element= (book) iter.next();

                                                            Object[] hold={ctr1+1,element.getAuthor(),element.getTitle(),element.getNoofPages(),element.getYear(),element.getVolume(),element.getJournal()};
                                                            model.insertRow(ctr1,hold);

                                                            invalidate();
                                                            repaint();
                                                            ctr1++;
                                                            //cnt++;


                                                        }
                                                    }
                                                });


                                                JScrollPane scrollPane=new JScrollPane(Table);

                                                Table.setFillsViewportHeight(true);
                                                scrollPane.setBounds(0,50,600,600);
                                                right_panel.add(scrollPane);





                                            }


                                        });


                                    }

                                }});










                            group1.add(SinceYear);
                            group1.add(customRange);
                            group.add(SortByDate);
                            group.add(SortByRelevance);


                            new_panel.add(SortByDate);
                            new_panel.add(SortByRelevance);
                            new_panel.add(SinceYear);
                            new_panel.add(customRange);
                            left_panel.add(new_panel);

                            validate();
                            repaint();

                            ;
                            break;
                        case "Query2":
                            new_panel.removeAll();
                            right_panel.remove(table);
                            right_panel.removeAll();

                            left_panel.remove(new_panel);
                            JTextField output =new JTextField();


                            JTextField one=new JTextField(10);


                           // int count3=0;
                            one.setText("No. of Publications");
                            one.setBounds(10,100,130,20);
                            one.setEditable(false);
                            one.setBackground(Color.cyan);

                            JTextField totype=new JTextField();
                            totype.setBounds(150,100,100,20);

                            JButton search = new JButton("Search");
                            search.setBounds(10,140,100,40);
                            ArrayList<String> RequiredName=new ArrayList<String>();
                            Hashtable<String,Integer> hastTable = new Hashtable<String,Integer>();
                            JTextField rest=new JTextField("Number of Result");
                            rest.setText("No. of Results");
                            rest.setBounds(50,300,130,20);
                            rest.setEditable(false);
                            rest.setBackground(Color.cyan);
                            new_panel.add(rest);

                            JButton next=new JButton("NEXT");
                            next.setBounds(150,500,100,40);
                            right_panel.add(next);

                            JButton Previous=new JButton("PREVIOUS");
                            Previous.setBounds(300,500,150,40);
                            right_panel.add(Previous);
                            DefaultTableModel model1 = new DefaultTableModel();
                            model1.addColumn("S.NO");
                            model1.addColumn("Author Name");
                            model1.addColumn("Number of Books");

                            JTable Table1 = new JTable(model1);
                            Table1.setFillsViewportHeight(true);
                            Table1.setBounds(0,50,550,400);
                            right_panel.add(Table1);
                            validate();
                            repaint();
                            search.addActionListener(new ActionListener()
                            {

                                @Override
                                public void actionPerformed(ActionEvent arg0)
                                {

                                    String val=totype.getText();
                                    ArrayList<book> allinfo=userreader.getall();
                                    Iterator authoriter=allinfo.iterator();
                                    Hashtable<String,Integer> hastTable = new Hashtable<String,Integer>();
                                    while(authoriter.hasNext())
                                    {
                                        book currentbook= (book) authoriter.next();
                                        String authorname=currentbook.getAuthor();
                                        if(authorname!=null)
                                        {
                                        	if(hastTable.containsKey(authorname))
                                        	{
                                            int currentvalue=((Integer)hastTable.get(authorname)).intValue();
                                            hastTable.put(authorname,new Integer(currentvalue+1));
                                        	}
                                        
                                        else
                                        {
                                            hastTable.put(authorname,new Integer(1));
                                         }
                                        }
                                    }
                                    Set s=hastTable.keySet();
                                    int count3=0;
                                    Iterator iteratehasttable=s.iterator();
                                    while(iteratehasttable.hasNext())
                                    {
                                        String authorna=(String)iteratehasttable.next();
                                        if(authorna!=null)
                                        {
                                        	if((Integer)hastTable.get(authorna).intValue()>(Integer.parseInt((val))))
                                        	{

                                        		RequiredName.add(authorna);
                                        		count3=count3+1;
                                        		System.out.println(count3);

               
                                        	}
                                        }



                                    }

                                    if(count3==0)
                                    {
                                        rest.setText("NO output found ");
                                    }
                                    else
                                    {
                                        rest.setText(String.valueOf(count3));
                                    }
                                    
                                    int ctr=0;
                                    Iterator ir=RequiredName.iterator();
                                    while(ir.hasNext() && ctr<20)
                                    {
                                        String element= (String) ir.next();
                                        Object[] hold={ctr+1,element,(Integer)hastTable.get(element).intValue()};
                                        model1.insertRow(ctr,hold);
                                        invalidate();
                                        repaint();
                                        ctr++;
                                    }

                                    //JScrollPane scrollPane=new JScrollPane(Table);
                                    

                                    next.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            int ctr=0;
                                            //if(())
                                            model1.setRowCount(0);
//                                            model.addColumn("S.NO");
//                                            model.addColumn("Author Name");
//                                            model.addColumn("Number of Books");

                                            System.out.print("l");
                                          //  Iterator ir=RequiredName.iterator();
                                            //int cnt=2;
                                            while(ir.hasNext() && ctr<20)
                                            {
                                               // System.out.print("D");
                                                String element= (String) ir.next();

                                                Object[] hold={cnt,element,(Integer)hastTable.get(element).intValue()};

                                                model1.insertRow(ctr,hold);

                                                invalidate();
                                                repaint();
                                                ctr++;
                                                cnt++;


                                            }
                                        }
                                    });
                                   /* for(String temp:RequiredName)
                                    {
                                        System.out.println(temp);
                                    }*/


                                }


                            });




                            JButton reset=new JButton("Reset");
                            reset.setBounds(150,140,100,40);
                            new_panel.add(search);
                            new_panel.add(reset);
                            new_panel.add(one);
                            new_panel.add(totype);
                            reset.addActionListener(new ActionListener()
                           	{
                            	public void actionPerformed(ActionEvent e)
                            	{
                            		authoral.clear();
                            		model1.setRowCount(0);
                            	}
                           	}
                            		
                            		
                            		);
                            validate();
                            repaint();
                            left_panel.add(new_panel);



                            break;
                    }
                }
            });
            left_panel.add(query);

            whole.add(left_panel);
            System.out.println("hjk");


            Top_panel=new JPanel(null);
            Top_panel.setBounds(0,0,1000,75);
            Top_panel.setBackground(Color.cyan);

            JLabel heading=new JLabel("DBLP Query Engine");
            heading.setBounds(270,10,600,55);
            heading.setFont(new Font("Serif", Font.PLAIN, 50));
            Top_panel.add(heading);

            whole.add(Top_panel);



            right_panel=new JPanel(null);
            right_panel.setBounds(350,75,650,675);
            right_panel.setBackground(Color.cyan);
            whole.add(right_panel);

                JScrollPane scrollPane = new JScrollPane(table);
                table.setFillsViewportHeight(true);
                table.setBounds(0, 200, 600, 600);
                right_panel.add(table);


            add(whole);
        }


    }






}