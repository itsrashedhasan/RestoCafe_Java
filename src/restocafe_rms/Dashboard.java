/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restocafe_rms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;



import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        showPieChart();
        showLineChart();
        showHistogram();
        showBarChart();
        
        
         jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(235, 103, 28));
        jTable1.getTableHeader().setForeground(new Color(255,255,255));
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getTableHeader().getWidth(), 30));
    

// Set the header height


    }
    
    
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Burger" , new Double( 20 ) );  
      barDataset.setValue( "Pizza" , new Double( 20 ) );   
      barDataset.setValue( "Pasta" , new Double( 40 ) );    
      barDataset.setValue( "French Fry" , new Double( 10 ) );  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Product Sales by Pie Chart",barDataset, false,true,false);//explain
      
        var piePlot =(PiePlot) piechart.getPlot();
      
     //  changing pie chart blocks colors
       piePlot.setSectionPaint("Burger", new Color(255,255,102));
        piePlot.setSectionPaint("Pizza", new Color(102,255,102));
        piePlot.setSectionPaint("Pasta", new Color(255,102,153));
        piePlot.setSectionPaint("French Fry", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        var barChartPanel = new ChartPanel(piechart);
        panelBarChart1.removeAll();
        panelBarChart1.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart1.validate();
    }
    
    
        public void showHistogram(){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
         // Set the bar color for the histogram
               Color barColor = new Color(235, 103, 28);
        
         JFreeChart chart = ChartFactory.createHistogram("Product Histogram","Data", "Sales", dataset,PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        
         // Get the renderer and set the bar color
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, barColor);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        panelHistory.removeAll();
        panelHistory.add(barpChartPanel2, BorderLayout.CENTER);
        panelHistory.validate();
    }
        


    
     public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Sales Margin","Monthly","Amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(235,103,28);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }
     
   
       
       
          public void showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        JFreeChart chart = ChartFactory.createBarChart("Sales by Bar Chart","Monthly","Amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(235,103,28);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        showBarChart.removeAll();
        showBarChart.add(barpChartPanel, BorderLayout.CENTER);
        showBarChart.validate();
        
        
    }
    
     public void addtables(String id ,String Name,int Qty ,Double Price){
    
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
       DecimalFormat df = new DecimalFormat("00.00") ;       
       double totPrice = Price * Double.valueOf(Qty) ;
       
       String TotalPrice = df.format(totPrice);
        // product allready add chk
        
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            
            if (Name == jTable1.getValueAt(row, 1)) {
                
                dt.removeRow(jTable1.convertRowIndexToModel(row));
                
            } 
        }
        
        Vector v = new Vector();
        v.add(id);
        v.add(Name);
        v.add(Qty);
        v.add(TotalPrice); // total price
        dt.addRow(v);
        
    
    }
     
        public void cal(){
    //cal total table values
   
   int numOfRow = jTable1.getRowCount() ;
   int count =0;
   double tot = 0.0 ;
   
       for (int i = 0; i < numOfRow; i++) {
           
           double value = Double.valueOf(jTable1.getValueAt(i, 3).toString());
          
           tot += value ;
           count++;
           
       }
       DecimalFormat df = new DecimalFormat("00.00") ;
       total.setText(df.format(tot));
       
       String stringValue = String.valueOf(count);
       totalsales.setText(stringValue);
   
   } 
     
       
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sidepanel = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dashboard = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        menu1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        menu2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        dashboard1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        dashboard2 = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        Dash = new javax.swing.JPanel();
        Dashboard = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        totalincome = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        todayincome = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        totalsales = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panelHistory = new javax.swing.JPanel();
        showBarChart = new javax.swing.JPanel();
        panelBarChart1 = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();
        men = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        Menu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        Logout3 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        Logout4 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        Logout5 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        Logout6 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        Logout7 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        Logout8 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        Logout9 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        Logout10 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        Logout11 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        Logout12 = new javax.swing.JButton();
        ord = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        Order = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        payment = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pay = new javax.swing.JTextField();
        Order1 = new javax.swing.JLabel();
        Order2 = new javax.swing.JLabel();
        Order3 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        bal = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 750));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepanel.setBackground(new java.awt.Color(255, 241, 179));
        sidepanel.setPreferredSize(new java.awt.Dimension(250, 700));

        username.setBackground(new java.awt.Color(143, 134, 134));
        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(105, 93, 94));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("Name");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logoSmall.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setBackground(new java.awt.Color(50, 14, 14));
        jLabel3.setFont(new java.awt.Font("Script MT Bold", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 14, 14));
        jLabel3.setText("RestoCafe");

        Logout.setBackground(new java.awt.Color(235, 103, 28));
        Logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.setBorderPainted(false);
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.setFocusPainted(false);
        Logout.setFocusable(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator1.setForeground(new java.awt.Color(143, 134, 134));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/MainProfileLogo.png"))); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator2.setForeground(new java.awt.Color(143, 134, 134));
        jSeparator2.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(75, 61, 61));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(143, 134, 134));
        jLabel1.setText("GENERAL");

        jPanel2.setBackground(new java.awt.Color(235, 103, 28));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ic_dashboard_white.png"))); // NOI18N

        dashboard.setBackground(new java.awt.Color(235, 103, 28));
        dashboard.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setText("DASHBOARD");
        dashboard.setBorderPainted(false);
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.setFocusPainted(false);
        dashboard.setFocusable(false);
        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5))
            .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(235, 103, 28));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ic_test_reports_w.png"))); // NOI18N

        menu.setBackground(new java.awt.Color(235, 103, 28));
        menu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("MENU");
        menu.setBorderPainted(false);
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setFocusPainted(false);
        menu.setFocusable(false);
        menu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6))
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(235, 103, 28));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/order icon.png"))); // NOI18N

        menu1.setBackground(new java.awt.Color(235, 103, 28));
        menu1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menu1.setForeground(new java.awt.Color(255, 255, 255));
        menu1.setText("ORDER");
        menu1.setBorderPainted(false);
        menu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu1.setFocusPainted(false);
        menu1.setFocusable(false);
        menu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8))
            .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBackground(new java.awt.Color(235, 103, 28));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/table .png"))); // NOI18N

        menu2.setBackground(new java.awt.Color(235, 103, 28));
        menu2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menu2.setForeground(new java.awt.Color(255, 255, 255));
        menu2.setText("TABLE RESERVE");
        menu2.setBorderPainted(false);
        menu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu2.setFocusPainted(false);
        menu2.setFocusable(false);
        menu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9))
            .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jSeparator3.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator3.setForeground(new java.awt.Color(143, 134, 134));

        jLabel7.setBackground(new java.awt.Color(75, 61, 61));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(143, 134, 134));
        jLabel7.setText("TOOLS");

        jPanel4.setBackground(new java.awt.Color(235, 103, 28));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/setting.png"))); // NOI18N

        dashboard1.setBackground(new java.awt.Color(235, 103, 28));
        dashboard1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboard1.setForeground(new java.awt.Color(255, 255, 255));
        dashboard1.setText("SETTING");
        dashboard1.setBorderPainted(false);
        dashboard1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard1.setFocusPainted(false);
        dashboard1.setFocusable(false);
        dashboard1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboard1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10))
            .addComponent(dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBackground(new java.awt.Color(235, 103, 28));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/flag.png"))); // NOI18N

        dashboard2.setBackground(new java.awt.Color(235, 103, 28));
        dashboard2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboard2.setForeground(new java.awt.Color(255, 255, 255));
        dashboard2.setText("FEEDBACK");
        dashboard2.setBorderPainted(false);
        dashboard2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard2.setFocusPainted(false);
        dashboard2.setFocusable(false);
        dashboard2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboard2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11))
            .addComponent(dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout sidepanelLayout = new javax.swing.GroupLayout(sidepanel);
        sidepanel.setLayout(sidepanelLayout);
        sidepanelLayout.setHorizontalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidepanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(89, 89, 89))
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addGroup(sidepanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        sidepanelLayout.setVerticalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        jPanel1.add(sidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 262, 761));

        jTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane.setForeground(new java.awt.Color(255, 255, 255));

        Dash.setBackground(new java.awt.Color(255, 255, 255));
        Dash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(143, 134, 134));
        Dashboard.setText("DASHBOARD");
        Dash.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 42, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator4.setForeground(new java.awt.Color(143, 134, 134));
        Dash.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 80, 857, 10));

        jPanel8.setBackground(new java.awt.Color(255, 241, 179));
        jPanel8.setPreferredSize(new java.awt.Dimension(260, 78));

        totalincome.setBackground(new java.awt.Color(50, 14, 14));
        totalincome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        totalincome.setForeground(new java.awt.Color(50, 14, 14));
        totalincome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalincome.setText("00");

        jLabel13.setBackground(new java.awt.Color(50, 14, 14));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(143, 134, 134));
        jLabel13.setText("Total Income");
        jLabel13.setToolTipText("");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/income icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalincome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(totalincome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dash.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 102, -1, 120));

        jSeparator7.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator7.setForeground(new java.awt.Color(143, 134, 134));
        Dash.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 240, 857, 10));

        jPanel9.setBackground(new java.awt.Color(255, 241, 179));

        todayincome.setBackground(new java.awt.Color(50, 14, 14));
        todayincome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        todayincome.setForeground(new java.awt.Color(50, 14, 14));
        todayincome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        todayincome.setText("00");

        jLabel16.setBackground(new java.awt.Color(50, 14, 14));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(143, 134, 134));
        jLabel16.setText("Today's Income");
        jLabel16.setToolTipText("");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/income icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(todayincome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(todayincome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Dash.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 102, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 241, 179));
        jPanel11.setPreferredSize(new java.awt.Dimension(260, 78));

        totalsales.setBackground(new java.awt.Color(50, 14, 14));
        totalsales.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        totalsales.setForeground(new java.awt.Color(50, 14, 14));
        totalsales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalsales.setText("00");

        jLabel19.setBackground(new java.awt.Color(50, 14, 14));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(143, 134, 134));
        jLabel19.setText("Sold Products");
        jLabel19.setToolTipText("");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/total order .png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalsales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(totalsales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        Dash.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 102, -1, 120));

        panelHistory.setBackground(new java.awt.Color(51, 51, 255));
        panelHistory.setPreferredSize(new java.awt.Dimension(420, 310));
        panelHistory.setLayout(new java.awt.BorderLayout());
        Dash.add(panelHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, 210));

        showBarChart.setLayout(new java.awt.BorderLayout());
        Dash.add(showBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 420, 210));

        panelBarChart1.setBackground(new java.awt.Color(204, 0, 51));
        panelBarChart1.setPreferredSize(new java.awt.Dimension(420, 310));
        panelBarChart1.setLayout(new java.awt.BorderLayout());
        Dash.add(panelBarChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 190));

        panelLineChart.setLayout(new java.awt.BorderLayout());
        Dash.add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 420, 190));

        jTabbedPane.addTab("tab1", Dash);

        men.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator5.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator5.setForeground(new java.awt.Color(143, 134, 134));

        Menu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Menu.setForeground(new java.awt.Color(143, 134, 134));
        Menu.setText("MENU");

        jPanel10.setBackground(new java.awt.Color(235, 103, 28));

        jPanel12.setBackground(new java.awt.Color(255, 241, 179));
        jPanel12.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(105, 93, 94));
        jLabel27.setText("Burger");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(105, 93, 94));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("TK: 10");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/burger.jpg"))); // NOI18N

        jSpinner3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner3.setToolTipText("");
        jSpinner3.setBorder(null);

        Logout3.setBackground(new java.awt.Color(235, 103, 28));
        Logout3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout3.setForeground(new java.awt.Color(255, 255, 255));
        Logout3.setText("ADD");
        Logout3.setBorderPainted(false);
        Logout3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout3.setFocusPainted(false);
        Logout3.setFocusable(false);
        Logout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel28))
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 241, 179));
        jPanel15.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(105, 93, 94));
        jLabel30.setText("Pizza");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(105, 93, 94));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("TK: 20");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pizza.png"))); // NOI18N

        jSpinner4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner4.setToolTipText("");
        jSpinner4.setBorder(null);

        Logout4.setBackground(new java.awt.Color(235, 103, 28));
        Logout4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout4.setForeground(new java.awt.Color(255, 255, 255));
        Logout4.setText("ADD");
        Logout4.setBorderPainted(false);
        Logout4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout4.setFocusPainted(false);
        Logout4.setFocusable(false);
        Logout4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 241, 179));
        jPanel16.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(105, 93, 94));
        jLabel33.setText("Pasta");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(105, 93, 94));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("TK: 30");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pasta.jpg"))); // NOI18N

        jSpinner5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner5.setToolTipText("");
        jSpinner5.setBorder(null);

        Logout5.setBackground(new java.awt.Color(235, 103, 28));
        Logout5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout5.setForeground(new java.awt.Color(255, 255, 255));
        Logout5.setText("ADD");
        Logout5.setBorderPainted(false);
        Logout5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout5.setFocusPainted(false);
        Logout5.setFocusable(false);
        Logout5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 241, 179));
        jPanel17.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(105, 93, 94));
        jLabel36.setText("French Fry");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(105, 93, 94));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("TK: 40");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/french fry.jpg"))); // NOI18N

        jSpinner6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner6.setToolTipText("");
        jSpinner6.setBorder(null);

        Logout6.setBackground(new java.awt.Color(235, 103, 28));
        Logout6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout6.setForeground(new java.awt.Color(255, 255, 255));
        Logout6.setText("ADD");
        Logout6.setBorderPainted(false);
        Logout6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout6.setFocusPainted(false);
        Logout6.setFocusable(false);
        Logout6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel37))
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 241, 179));
        jPanel18.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(105, 93, 94));
        jLabel39.setText("Fried Chicken");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(105, 93, 94));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("TK: 50");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fried Chicken.jpg"))); // NOI18N

        jSpinner7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner7.setToolTipText("");
        jSpinner7.setBorder(null);

        Logout7.setBackground(new java.awt.Color(235, 103, 28));
        Logout7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout7.setForeground(new java.awt.Color(255, 255, 255));
        Logout7.setText("ADD");
        Logout7.setBorderPainted(false);
        Logout7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout7.setFocusPainted(false);
        Logout7.setFocusable(false);
        Logout7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 241, 179));
        jPanel19.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(105, 93, 94));
        jLabel42.setText("Cold Coffee");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(105, 93, 94));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("TK: 25");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cold Coffe.jpg"))); // NOI18N

        jSpinner8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner8.setToolTipText("");
        jSpinner8.setBorder(null);

        Logout8.setBackground(new java.awt.Color(235, 103, 28));
        Logout8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout8.setForeground(new java.awt.Color(255, 255, 255));
        Logout8.setText("ADD");
        Logout8.setBorderPainted(false);
        Logout8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout8.setFocusPainted(false);
        Logout8.setFocusable(false);
        Logout8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 241, 179));
        jPanel20.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(105, 93, 94));
        jLabel45.setText("Water");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(105, 93, 94));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("TK: 5");

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Water.jpg"))); // NOI18N

        jSpinner9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner9.setToolTipText("");
        jSpinner9.setBorder(null);

        Logout9.setBackground(new java.awt.Color(235, 103, 28));
        Logout9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout9.setForeground(new java.awt.Color(255, 255, 255));
        Logout9.setText("ADD");
        Logout9.setBorderPainted(false);
        Logout9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout9.setFocusPainted(false);
        Logout9.setFocusable(false);
        Logout9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 241, 179));
        jPanel21.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(105, 93, 94));
        jLabel48.setText("Mojo");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(105, 93, 94));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("TK: 10");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mojo.jpg"))); // NOI18N

        jSpinner10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner10.setToolTipText("");
        jSpinner10.setBorder(null);

        Logout10.setBackground(new java.awt.Color(235, 103, 28));
        Logout10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout10.setForeground(new java.awt.Color(255, 255, 255));
        Logout10.setText("ADD");
        Logout10.setBorderPainted(false);
        Logout10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout10.setFocusPainted(false);
        Logout10.setFocusable(false);
        Logout10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel49))
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 241, 179));
        jPanel23.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(105, 93, 94));
        jLabel51.setText("Sandwich");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(105, 93, 94));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("TK: 75");

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sandwich.jpg"))); // NOI18N

        jSpinner11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner11.setToolTipText("");
        jSpinner11.setBorder(null);

        Logout11.setBackground(new java.awt.Color(235, 103, 28));
        Logout11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout11.setForeground(new java.awt.Color(255, 255, 255));
        Logout11.setText("ADD");
        Logout11.setBorderPainted(false);
        Logout11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout11.setFocusPainted(false);
        Logout11.setFocusable(false);
        Logout11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 241, 179));
        jPanel24.setPreferredSize(new java.awt.Dimension(240, 225));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(105, 93, 94));
        jLabel54.setText("Green Tea");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(105, 93, 94));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("TK: 35");

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/green tea.jpg"))); // NOI18N

        jSpinner12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner12.setToolTipText("");
        jSpinner12.setBorder(null);

        Logout12.setBackground(new java.awt.Color(235, 103, 28));
        Logout12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout12.setForeground(new java.awt.Color(255, 255, 255));
        Logout12.setText("ADD");
        Logout12.setBorderPainted(false);
        Logout12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout12.setFocusPainted(false);
        Logout12.setFocusable(false);
        Logout12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Logout12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1165, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel10);

        javax.swing.GroupLayout menLayout = new javax.swing.GroupLayout(men);
        men.setLayout(menLayout);
        menLayout.setHorizontalGroup(
            menLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(menLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        menLayout.setVerticalGroup(
            menLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Menu)
                .addGap(6, 6, 6)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("tab2", men);

        ord.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator6.setBackground(new java.awt.Color(143, 134, 134));
        jSeparator6.setForeground(new java.awt.Color(143, 134, 134));

        Order.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Order.setForeground(new java.awt.Color(143, 134, 134));
        Order.setText("ORDER");

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Item Name", "Quantity", "Price"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(187, 187, 187));
        jTable1.setShowHorizontalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        b.setBackground(new java.awt.Color(255, 255, 255));
        b.setColumns(20);
        b.setRows(5);
        jScrollPane3.setViewportView(b);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        payment.setBackground(new java.awt.Color(235, 103, 28));
        payment.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Pay");
        payment.setBorder(null);
        payment.setBorderPainted(false);
        payment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment.setFocusPainted(false);
        payment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(235, 103, 28));
        jButton2.setText("Delete");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 103, 28)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pay.setBackground(new java.awt.Color(255, 255, 255));
        pay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pay.setForeground(new java.awt.Color(70, 73, 75));
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pay.setDoubleBuffered(true);
        pay.setDragEnabled(true);
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        Order1.setBackground(new java.awt.Color(0, 0, 0));
        Order1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        Order1.setForeground(new java.awt.Color(70, 73, 75));
        Order1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Order1.setText("Total: ");

        Order2.setBackground(new java.awt.Color(51, 51, 51));
        Order2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        Order2.setForeground(new java.awt.Color(70, 73, 75));
        Order2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Order2.setText("Amount:");

        Order3.setBackground(new java.awt.Color(51, 51, 51));
        Order3.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        Order3.setForeground(new java.awt.Color(70, 73, 75));
        Order3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Order3.setText("Change:");

        total.setBackground(new java.awt.Color(51, 51, 51));
        total.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        total.setForeground(new java.awt.Color(70, 73, 75));
        total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total.setText("00");

        bal.setBackground(new java.awt.Color(51, 51, 51));
        bal.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        bal.setForeground(new java.awt.Color(70, 73, 75));
        bal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bal.setText("00");

        jButton4.setBackground(new java.awt.Color(235, 103, 28));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Receipt");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Order2)
                    .addComponent(Order1)
                    .addComponent(Order3))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Order1)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Order2)
                    .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Order3)
                    .addComponent(bal))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ordLayout = new javax.swing.GroupLayout(ord);
        ord.setLayout(ordLayout);
        ordLayout.setHorizontalGroup(
            ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Order)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        ordLayout.setVerticalGroup(
            ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Order)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("tab3", ord);

        jPanel1.add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, -39, 990, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboard2ActionPerformed
        // TODO add your handling code here:
        Feedback FeedbackFrame = new Feedback();
        FeedbackFrame.setVisible(true);
        FeedbackFrame.pack();
        FeedbackFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_dashboard2ActionPerformed

    private void dashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboard1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "This feature will be added later");
    }//GEN-LAST:event_dashboard1ActionPerformed

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed
        JOptionPane.showMessageDialog(null, "This feature will be added later");
    }//GEN-LAST:event_menu2ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        int YesOrNo = JOptionPane.showConfirmDialog(null,"Do You Want To Logout?","Confirmation Message", JOptionPane.YES_NO_OPTION);
        if(YesOrNo == 0)
        {
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }else{
            //jTextField1.setText("No");
        }

    }//GEN-LAST:event_LogoutActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_dashboardActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_menuActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_menu1ActionPerformed

    private void Logout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout3ActionPerformed
        // TODO add your handling code here:
          int i = (int) jSpinner3.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-01", "Burger", i, 10.0);
        
        cal();
    }//GEN-LAST:event_Logout3ActionPerformed

    private void Logout4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout4ActionPerformed
        // TODO add your handling code here:
        
        
         int i = (int) jSpinner4.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-02", "Pizza", i, 20.0);
        
        cal();
    }//GEN-LAST:event_Logout4ActionPerformed

    private void Logout5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout5ActionPerformed
        // TODO add your handling code here:
        
        int i = (int) jSpinner5.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-03", "Pasta", i, 30.0);
        
        cal();
    }//GEN-LAST:event_Logout5ActionPerformed

    private void Logout6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout6ActionPerformed
        // TODO add your handling code here:
         int i = (int) jSpinner6.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-04", "French Fry", i, 40.0);
        
        cal();
    }//GEN-LAST:event_Logout6ActionPerformed

    private void Logout7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout7ActionPerformed
        // TODO add your handling code here:
         int i = (int) jSpinner7.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-05", "Fried Chicken", i, 50.0);
        
        cal();
    }//GEN-LAST:event_Logout7ActionPerformed

    private void Logout8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout8ActionPerformed
        // TODO add your handling code here:
         int i = (int) jSpinner8.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-06", "Cold Coffee", i, 25.0);
        
        cal();
    }//GEN-LAST:event_Logout8ActionPerformed

    private void Logout9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout9ActionPerformed
        // TODO add your handling code here:
        
          int i = (int) jSpinner9.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-07", "Water", i, 5.0);
        
        cal();
    }//GEN-LAST:event_Logout9ActionPerformed

    private void Logout10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout10ActionPerformed
        // TODO add your handling code here:
          int i = (int) jSpinner10.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-08", "Mojo", i, 10.0);
        
        cal();
    }//GEN-LAST:event_Logout10ActionPerformed

    private void Logout11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout11ActionPerformed
        // TODO add your handling code here:
          int i = (int) jSpinner11.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-09", "Sandwich", i, 75.0);
        
        cal();
    }//GEN-LAST:event_Logout11ActionPerformed

    private void Logout12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout12ActionPerformed
        // TODO add your handling code here:
          int i = (int) jSpinner12.getValue();
          
      
        //q1.setText(String.valueOf(i));
        
        addtables("PRD-10", "Green Tea", i, 35.0);
        
        cal();
    }//GEN-LAST:event_Logout12ActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
       setTodayIncome(total.getText());
        setTotalIncome(total.getText());
        
     if (pay.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "You need to put your amount first!");
} else {
    double tot = Double.valueOf(total.getText());
    double paid = Double.valueOf(pay.getText());
    double balance = paid - tot;

    DecimalFormat df = new DecimalFormat("00.00");
   
    bal.setText(String.valueOf(df.format(balance)));
    JOptionPane.showMessageDialog(null, "Congratulations! Your payment is complete.");
}

    }//GEN-LAST:event_paymentActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel(); 
        
        
        
        if(jTable1.getSelectedRowCount()==1){
            
             String r = dt.getValueAt(jTable1.getSelectedRow(), 0).toString();
       
        //remove product
        int rw = jTable1.getSelectedRow();
        dt.removeRow(rw); 
        }
        else{
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "Table is Empty!");
            }
            else{
                 JOptionPane.showMessageDialog(null, "Please select single row for delete!");
            }
        }
             
        
        
        
        cal(); // after iteam delete calculate total
     

    }//GEN-LAST:event_jButton2ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         // bill print
        
        try {
            
           b.setText("                                               RestoCafe \n");
            b.setText(b.getText() + "                                            Daffodil Road, \n");
            b.setText(b.getText() + "                                       Ashulia, Savar, Dhaka \n");
            b.setText(b.getText() + "                                          +8801974476459 \n");
            b.setText(b.getText() + "---------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "  Item \t\tQuantity \tPrice" +"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------------------\n");
            
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            
            // get table Product details
            
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                
                String Name = df.getValueAt(i, 1).toString();
                String Qty = df.getValueAt(i, 2).toString();
                String Price = df.getValueAt(i, 3).toString();
                
                b.setText(b.getText() +"  "+ Name+"\t\t"+Qty +"\t"+Price + "\n");
            }
            
            b.setText(b.getText() + "---------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "  Sub Total : " + total.getText() +"\n");
            b.setText(b.getText() + "  Cash        : " + pay.getText() +"\n");
            b.setText(b.getText() + "  Change   : " + bal.getText() +"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "                                     Thanks For Your Order...!"+"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "                  copyright © 2023 RestoCafe. All rights reserved"+"\n");
            
           
        b.print(); //print
        
        
            
        } catch (Exception e) {
            
            System.out.println(e);
            
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

       public void setUser(String name){
        username.setText(name);
    }
       
         public void setTodayIncome(String name){
        todayincome.setText(name);
    }
         
           public void setTotalIncome(String name){
        totalincome.setText(name);
    }
//            public void setTotalSales(String name){
//        totalsales.setText(name);
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dash;
    private javax.swing.JLabel Dashboard;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Logout10;
    private javax.swing.JButton Logout11;
    private javax.swing.JButton Logout12;
    private javax.swing.JButton Logout3;
    private javax.swing.JButton Logout4;
    private javax.swing.JButton Logout5;
    private javax.swing.JButton Logout6;
    private javax.swing.JButton Logout7;
    private javax.swing.JButton Logout8;
    private javax.swing.JButton Logout9;
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel Order;
    private javax.swing.JLabel Order1;
    private javax.swing.JLabel Order2;
    private javax.swing.JLabel Order3;
    private javax.swing.JTextArea b;
    private javax.swing.JLabel bal;
    private javax.swing.JButton dashboard;
    private javax.swing.JButton dashboard1;
    private javax.swing.JButton dashboard2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel men;
    private javax.swing.JButton menu;
    private javax.swing.JButton menu1;
    private javax.swing.JButton menu2;
    private javax.swing.JPanel ord;
    private javax.swing.JPanel panelBarChart1;
    private javax.swing.JPanel panelHistory;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JTextField pay;
    private javax.swing.JButton payment;
    private javax.swing.JPanel showBarChart;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JLabel todayincome;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalincome;
    private javax.swing.JLabel totalsales;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

}
