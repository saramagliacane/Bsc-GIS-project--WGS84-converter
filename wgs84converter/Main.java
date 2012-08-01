/*
 * Main.java
 * TODO: implementare meglio la combobox
 * per ora si aggiunge a mano i nomi
 * e si è limitati a Attributi con costruttori(stringa)
 * Created on 19 maggio 2008, 18.09
 */

package wgs84converter;

import converter.Converter;
import attributi.*;
import oggetti.*;
import java.awt.Color;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  Sara Magliacane
 */
public class Main extends javax.swing.JFrame {
    public class MyInputVerifier extends InputVerifier {
        
        double maxvalue;
        boolean maxvalueset;
        double minvalue;
        boolean minvalueset;
        boolean integer;
        
        public MyInputVerifier (double minvalue, double maxvalue) {
            this.minvalue = minvalue;
            this.maxvalue = maxvalue;
            maxvalueset = true;
            minvalueset = true;
            this.integer = false;
        }
        
        public MyInputVerifier (int minvalue, int maxvalue) {
            this.minvalue = minvalue;
            this.maxvalue = maxvalue;
            maxvalueset = true;
            minvalueset = true;
            integer = true;
        }
        
        public MyInputVerifier (int minvalue, int maxvalue, boolean integer) {
            this.minvalue = minvalue;
            this.maxvalue = maxvalue;
            maxvalueset = true;
            minvalueset = true;
            this.integer = integer;
        }
        
        public MyInputVerifier (int maxvalue) {
            this.maxvalue = maxvalue;
            maxvalueset = true;
            integer = true;
        }
        
        public MyInputVerifier (boolean integer) {
            this.integer = integer;
        }
        
        public boolean verify(JComponent input) {
            final JTextComponent source = (JTextComponent) input;
            String text = source.getText();
            if (text.equals("") || text.equals(null)) {
                input.setBackground(Color.WHITE);
                return true;
            }
            double value;
            try {
                value = Double.parseDouble(text);
            }
            catch (Exception e) {
                input.setBackground(Color.RED);
                return false;
            }
            if (integer) {
                if (value % 1 != 0) {
                    input.setBackground(Color.RED);
                    return false;
                }
            }
            if (maxvalueset)
            {
                if (value >= maxvalue) {
                    input.setBackground(Color.RED);
                    return false;
                }
            }
            if (minvalueset) {
                if (minvalue > value) {
                     input.setBackground(Color.RED);
                    return false;
                }
            }
            input.setBackground(Color.WHITE);
            return true;
        }
    }
    
    /** Creates new form Main */
    public Main() {
        initComponents();
        initPunti();
        
    }
    
    public void initPunti() {
      Punto.Lanaro.setAttributo(new UTMo (5066854.358, 405339.313, 547.103));
      Punto.Trecam.setAttributo(new UTMo (5054346.905, 407838.028, 274.727));
      Punto.Franco.setAttributo(new UTMo (5059572.341, 409446.428, 410.075));
      Punto.Bercis.setAttributo(new UTMo (5067059.624, 396213.021, 202.124));
      Punto.Cares.setAttributo(new UTMo (5049700.854, 408750.471, 162.642));
      Punto.Ermada.setAttributo(new UTMo (5072349.315, 393309.393, 325.271));
      Punto.Sleon.setAttributo(new UTMo (5068909.479, 400722.712, 403.978));
      Punto.Duino.setAttributo(new UTMo (5071584.090, 390657.508, 19.203));
      
      Punto.Ermada.setAttributo(new Tipo("Vetta"));
      Punto.Duino.setAttributo(new Note("Casa"));
      
      
      puntiNoti = new HashMap <String, Punto> ();
      puntiNoti.put("Lanaro", Punto.Lanaro);
      puntiNoti.put("Trecam", Punto.Trecam);
      puntiNoti.put("Franco", Punto.Franco);
      puntiNoti.put("Bercis", Punto.Bercis);
      puntiNoti.put("Cares", Punto.Cares);
      puntiNoti.put("Ermada", Punto.Ermada);
      puntiNoti.put("Sleon", Punto.Sleon);
      puntiNoti.put("Duino", Punto.Duino);
      
      
      DefaultListModel myModel = (DefaultListModel)jList1.getModel();
      Iterator i = puntiNoti.keySet().iterator();
      myModel.clear();
      while (i.hasNext()) {
            String nome = (String) i.next();
            myModel.addElement(nome);   
        }
      
      DefaultComboBoxModel cModel = ( DefaultComboBoxModel) jComboBox1.getModel();
      cModel.removeAllElements();
      cModel.addElement("Tipo");
      cModel.addElement("Note");
      
      
    }
    
      
                  
 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Main Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jText_nome = new javax.swing.JTextField();
        jText_latgr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jText_latmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jText_latsec = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jText_longr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jText_lonmin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jText_lonsec = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jText_quo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jText_attributo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_descr = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Convertitore coordinate WGS84");

        jLabel11.setText("Coordinate ellissoidiche WGS84:");

        jLabel1.setText("Nome punto :");

        jText_nome.setText("NomePunto");

        jText_latgr.setInputVerifier(new MyInputVerifier(0,360,true));
        jText_latgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_latgrActionPerformed(evt);
            }
        });

        jLabel6.setText("°");

        jText_latmin.setInputVerifier(new MyInputVerifier(0,60,true));

        jLabel7.setText("'");

        jText_latsec.setInputVerifier(new MyInputVerifier(0,60,false));

        jLabel9.setText("Latitudine:");

        jLabel8.setText("\"");

        jText_longr.setInputVerifier(new MyInputVerifier(0,360,true));

        jLabel3.setText("°");

        jText_lonmin.setInputVerifier(new MyInputVerifier(0,60,true));

        jLabel4.setText("'");

        jText_lonsec.setInputVerifier(new MyInputVerifier(0,60,false));

        jLabel5.setText("\"");

        jLabel10.setText("Longitudine:");

        jText_quo.setInputVerifier(new MyInputVerifier(false));

        jLabel2.setText("Quota:");

        jButton1.setText("Converti");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Converti(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reset(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel());

        jText_attributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_attributoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jText_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jText_latgr, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jText_longr, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jText_latmin)
                                            .addComponent(jText_lonmin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jText_latsec, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jText_lonsec, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                            .addComponent(jText_quo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jText_attributo, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jText_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jText_latgr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_latmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_latsec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jText_lonmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_longr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_lonsec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jText_quo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_attributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jTextArea_descr.setColumns(20);
        jTextArea_descr.setRows(5);
        jScrollPane1.setViewportView(jTextArea_descr);

        jList1.setModel(new javax.swing.DefaultListModel() );
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setRequestFocusEnabled(false);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Carica(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton3.setText(">");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AggiungiInLista(evt);
            }
        });

        jButton4.setText("<");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rimuovi(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, 0, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_latgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_latgrActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jText_latgrActionPerformed

    private void Converti(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Converti
       
              try {
                Punto p = CreaPunto();
                p = Converter.convert(p);
                jTextArea_descr.setText(p.mostra());
                               
                }
                catch (Exception e) {
                
                }     
            
    }//GEN-LAST:event_Converti
    
    private Punto CreaPunto(){                          
       
        String nome="Non definito";    
        Punto p = null;
              
        if      (!jText_latgr.getText().equals("")&&
                !jText_longr.getText().equals("") &&
                !jText_latmin.getText().equals("") &&
                !jText_lonmin.getText().equals("")&&
                !jText_latsec.getText().equals("") &&
                !jText_lonsec.getText().equals("") &&
                !jText_quo.getText().equals(""))
        {
            try {
               
                if (jText_nome.getText().equals(""));
                else nome = jText_nome.getText();
                p = new Punto(nome, new WGS84(Double.parseDouble(jText_latgr.getText()),
                        Double.parseDouble(jText_latmin.getText()),
                        Double.parseDouble(jText_latsec.getText()),
                        Double.parseDouble(jText_longr.getText()),
                        Double.parseDouble(jText_lonmin.getText()),
                        Double.parseDouble(jText_lonsec.getText()),
                        Double.parseDouble(jText_quo.getText())));
                
                DefaultComboBoxModel cModel = ( DefaultComboBoxModel) jComboBox1.getModel();
                try {
                if((cModel.getSelectedItem()!= null) &&(!jText_attributo.getText().equals(""))){
                        String attributo = cModel.getSelectedItem().toString();
                        Class c = Class.forName("attributi." +attributo);
                        Constructor cc = c.getConstructor(String.class);
                        p.setAttributo((Attributi)cc.newInstance(jText_attributo.getText()));
                }
                } catch (Exception e) {} 
              
                }
                catch (Exception e) {p=null;} 
              
            }
            else p = null;
        return p;
       
    }     
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Reset(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reset
         jText_latgr.setText(null);
         jText_longr.setText(null);
         jText_latmin.setText(null);
         jText_lonmin.setText(null);
         jText_latsec.setText(null);
         jText_lonsec.setText(null);
         jText_quo.setText(null);
         jText_nome.setText(null);
         jTextArea_descr.setText(null);
         jList1.setSelectedIndex(-1);        
         jComboBox1.setSelectedIndex(-1);
         jText_attributo.setText(null);
    }//GEN-LAST:event_Reset

    private void Carica(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Carica
        Punto p;
        jComboBox1.setSelectedIndex(-1);                           
        jText_attributo.setText(null);
        
        if(puntiNoti.containsKey(jList1.getSelectedValue().toString())){  
            p = puntiNoti.get(jList1.getSelectedValue().toString());
            p = Converter.convert(p);
            jTextArea_descr.setText(p.mostra());
            WGS84 wgsPunto = (WGS84) p.getAttributo("WGS84");
            jText_latgr.setText(""+ (int)wgsPunto.getLatgr());
            jText_latmin.setText(""+ (int)wgsPunto.getLatmin());
            jText_latsec.setText(""+ Utilities.tronc(wgsPunto.getLatsec(),5));
            jText_longr.setText(""+ (int)wgsPunto.getLongr());
            jText_lonmin.setText(""+ (int)wgsPunto.getLonmin());
            jText_lonsec.setText(""+ Utilities.tronc(wgsPunto.getLonsec(),5));
            jText_quo.setText(""+ wgsPunto.getQuota());
            jText_nome.setText(p.getNome());            
            
            
            
            DefaultComboBoxModel cModel = ( DefaultComboBoxModel) jComboBox1.getModel();
            
            for (int i= 0; i<cModel.getSize(); i++){
                        
                String tipo = (String)cModel.getElementAt(i);
                Attributi attributo =  p.getAttributo(tipo);
                if (attributo!= null) {
                   String valore = attributo.toString();
                   jComboBox1.setSelectedItem(attributo.getClass().getSimpleName());                           
                   jText_attributo.setText(valore);
                }
           }
        }
    }//GEN-LAST:event_Carica

    private void AggiungiInLista(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AggiungiInLista
        Punto p = CreaPunto();
        String temp = jText_nome.getText();
        if ((p!= null )&&(!temp.equals(""))){
                puntiNoti.put(temp, p);
                DefaultListModel myModel = (DefaultListModel) jList1.getModel();
                myModel.addElement(temp);                     
        }
    }//GEN-LAST:event_AggiungiInLista

    private void Rimuovi(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rimuovi
        Carica(evt);   
        String temp = jList1.getSelectedValue().toString();
        puntiNoti.remove(temp);
        DefaultListModel myModel = (DefaultListModel) jList1.getModel();
        myModel.removeElement(temp); 
        
        
    }//GEN-LAST:event_Rimuovi

    private void jText_attributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_attributoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jText_attributoActionPerformed
     
    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
     
      
                java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    new Main().setVisible(true);
                }
                });
            
        
       
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_descr;
    private javax.swing.JTextField jText_attributo;
    private javax.swing.JTextField jText_latgr;
    private javax.swing.JTextField jText_latmin;
    private javax.swing.JTextField jText_latsec;
    private javax.swing.JTextField jText_longr;
    private javax.swing.JTextField jText_lonmin;
    private javax.swing.JTextField jText_lonsec;
    private javax.swing.JTextField jText_nome;
    private javax.swing.JTextField jText_quo;
    // End of variables declaration//GEN-END:variables
    private HashMap <String, Punto> puntiNoti; 
          
}
