package org.executequery.gui.browser;

import org.executequery.databasemediators.DatabaseConnection;
import org.executequery.gui.browser.comparer.Comparer;
import org.executequery.localization.Bundles;
import org.executequery.repository.DatabaseConnectionRepository;
import org.executequery.repository.RepositoryCache;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComparerDBPanel extends JPanel {

    public ComparerDBPanel() {
        initComponents();
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        //jTextArea2.setLineWrap(true);

        jTextArea1.append("1st DB is an example - 2nd DB will be modified" + '\n'
                + "Start with connecting to DBs");
        dcs = new ArrayList<DatabaseConnection>();
        dbBox1.removeAllItems();
        dbBox2.removeAllItems();
        List<DatabaseConnection> connections = ((DatabaseConnectionRepository) RepositoryCache.load(DatabaseConnectionRepository.REPOSITORY_ID)).findAll();
        for(DatabaseConnection dc:connections)
        {
            if (dc.isConnected())
            {
                dcs.add(dc);
                dbBox1.addItem(dc.getName());
                dbBox2.addItem(dc.getName());
            }
        }

    }
    Comparer comparer;
    List<DatabaseConnection> dcs;
    public static final String TITLE= Bundles.get(ComparerDBPanel.class,"ComparerDB");
    public static final String FRAME_ICON = "ComparerDB_16.png";
    public class FileTypeFilter extends FileFilter {

        private String extension;
        private String description;

        public FileTypeFilter(String extension, String description) {
            this.extension = extension;
            this.description = description;
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            return file.getName().endsWith(extension);
        }

        public String getDescription() {
            return description + String.format(" (*%s)", extension);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSaveScript = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        dbBox1 = new JComboBox();
        dbBox2 = new JComboBox();
        dbBox1label = new JLabel();
        dbBox2label = new JLabel();

        dbBox1label.setText("First Connection");
        dbBox2label.setText("Second Connection");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Connections"));


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(dbBox1label)
                                                        .addComponent(dbBox2label)
                                                        )
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(dbBox1)
                                                        .addComponent(dbBox2)
                                                )
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap())
                                )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(dbBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dbBox1label)
                                        )
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(dbBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dbBox2label)
                                        )
                                .addGap(7, 7, 7))

        );



        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnSaveScript.setText("Save script");
        btnSaveScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveScriptActionPerformed(evt);
            }
        });


        jButton1.setText("Compare");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Domains");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Tables");

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Views");

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Procedures");

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Triggers");

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Generators");

        jCheckBox7.setSelected(true);
        jCheckBox7.setText("Exceptions");

        jCheckBox8.setSelected(true);
        jCheckBox8.setText("UDFs");

        jCheckBox9.setSelected(true);
        jCheckBox9.setText("Roles");

        jCheckBox10.setSelected(true);
        jCheckBox10.setText("Indices");

        jCheckBox11.setSelected(true);
        jCheckBox11.setText("Primary keys");

        jCheckBox12.setSelected(true);
        jCheckBox12.setText("Foreign keys");

        jCheckBox13.setSelected(true);
        jCheckBox13.setText("Uniques");

        jCheckBox14.setSelected(true);
        jCheckBox14.setText("Checks");

        jButton2.setText("All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jCheckBox12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jCheckBox4)
                                        .addComponent(jCheckBox5)
                                        .addComponent(jCheckBox11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox6)
                                        .addComponent(jCheckBox8)
                                        .addComponent(jCheckBox9)
                                        .addComponent(jCheckBox10)
                                        .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox14)
                                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSaveScript, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8))
                                        .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE,500,Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        )
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSaveScript)
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

    }// </editor-fold>//GEN-END:initComponents




    //GEN-LAST:event_btnConnectDBActionPerformed

    private void btnSaveScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveScriptActionPerformed
        /*String s = "";

         for (int i = 0; i < comparer.script.size(); i++){
         s = s + comparer.script.get(i);
         }

         try{
         BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output_file.txt"), "Cp1251"));
         w.write(s);
         w.flush();
         w.close();}
         catch(IOException ex){}*/

        if (comparer==null)
        {
            jTextArea1.append("\nNothing to save - script is empty");
            return;
        }
        if (comparer.script.isEmpty()) {
            jTextArea1.append("\nNothing to save - script is empty");
            return;
        }

        JFileChooser filesave = new JFileChooser("C:\\");

        //FileNameExtensionFilter filter = new FileNameExtensionFilter("*.*");
        //filesave.setFileFilter(filter);
        FileFilter sqlFilter = new FileTypeFilter(".sql", "SQL files");
        FileFilter txtFilter = new FileTypeFilter(".txt", "Text files");

        filesave.addChoosableFileFilter(sqlFilter);
        filesave.addChoosableFileFilter(txtFilter);
        filesave.setAcceptAllFileFilterUsed(false);

        int ret = filesave.showDialog(null, "Save Script");

        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = filesave.getSelectedFile();

            String text, n = "\n";

            String name = file.getAbsoluteFile().toString();

            int dot = name.lastIndexOf(".");
            dot = dot == -1 ? name.length() : dot;

            String name_ = name.substring(0, dot)
                    + filesave.getFileFilter().getDescription().substring(filesave.getFileFilter().getDescription().indexOf("(*") + 2,
                    filesave.getFileFilter().getDescription().lastIndexOf(")"));
            comparer.script.add("русский текст");
            try (FileOutputStream path = new FileOutputStream(name_)) {
                for (int i = 0; i < comparer.script.size(); i++) {
                    text = comparer.script.get(i);

                    //String str = new String(text.getBytes(), "Cp1251");
                    byte[] buffer = text.getBytes();

                    path.write(buffer, 0, buffer.length);

                    /*byte[] bufferN = n.getBytes();
                     path.write(bufferN, 0, bufferN.length);*/
                }

                jTextArea1.append("\nScript was saved:\n" + "«" + name_ + "»");
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }
    }




    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (dcs.size()<2||dbBox1.getSelectedIndex()==dbBox2.getSelectedIndex()) {
            jTextArea1.append("\nError: Unable to compare");
            return;
        }
        comparer = new Comparer(dcs.get(dbBox1.getSelectedIndex()),dcs.get(dbBox2.getSelectedIndex()));
        jTextArea1.append("\nComparing...\n");

        jTextArea2.setText(null);
        comparer.script.clear();
        comparer.createdObjects.clear();
        comparer.alteredObjects.clear();
        comparer.droppedObjects.clear();


        String charset = "";
        String dialect = "";

        String query = "select rdb$database.rdb$character_set_name\n"
                + "from rdb$database\n";

        try {
            ResultSet rs = comparer.secondConnection.execute(query,true).getResultSet();

            while (rs.next()) {

                charset = rs.getString(1).trim();
            }

            rs.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }

        query = "select mon$database.mon$sql_dialect\n"
                + "from mon$database\n";

        try {
            ResultSet rs = comparer.secondConnection.execute(query,true).getResultSet();

            while (rs.next()) {

                dialect = rs.getString(1).trim();
            }

            rs.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }

        comparer.script.add("set names " + charset + ";\n\n");
        comparer.script.add("set sql dialect " + dialect + ";\n\n");
        comparer.script.add("connect '" + comparer.secondConnection.getDatabaseConnection().getName() + " ' user '" + comparer.secondConnection.getDatabaseConnection().getUserName() + "' "
                + "password '" + comparer.secondConnection.getDatabaseConnection().getUnencryptedPassword() + "';\n\n");
        comparer.script.add("set autoddl on;\n\n");

        comparer.lists = "";
        comparer.dropFKs(jCheckBox12.isSelected());
        jTextArea1.append("\n============= Foreign keys to drop =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropPKs(jCheckBox11.isSelected());
        jTextArea1.append("\n============= Primary keys to drop =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropUniques(jCheckBox13.isSelected());
        jTextArea1.append("\n=============== Uniques to drop ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropChecks(jCheckBox14.isSelected());
        jTextArea1.append("\n=============== Checks to drop  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createExceptions(jCheckBox7.isSelected());
        jTextArea1.append("\n============= Exceptions to create  =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterExceptions(jCheckBox7.isSelected());
        jTextArea1.append("\n============== Exceptions to alter ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createGenerators(jCheckBox6.isSelected());
        jTextArea1.append("\n============= Generators to create  =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterGenerators(jCheckBox6.isSelected());
        jTextArea1.append("\n============== Generators to alter ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createUDFs(jCheckBox8.isSelected());
        jTextArea1.append("\n=============== UDFs to create  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterUDFs(jCheckBox8.isSelected());
        jTextArea1.append("\n================ UDFs to alter ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createDomains(jCheckBox2.isSelected());
        jTextArea1.append("\n============== Domains to create ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterDomains(jCheckBox2.isSelected());
        jTextArea1.append("\n=============== Domains to alter ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropIndices(jCheckBox10.isSelected());
        jTextArea1.append("\n================ Indices to drop  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropTriggers(jCheckBox5.isSelected());
        jTextArea1.append("\n=============== Triggers to drop  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropViews(jCheckBox3.isSelected());
        jTextArea1.append("\n================ Views to drop ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createTables(jCheckBox1.isSelected());
        jTextArea1.append("\n=============== Tables to create  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterTables(jCheckBox1.isSelected());
        jTextArea1.append("\n================ Tables to alter ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropTables(jCheckBox1.isSelected());
        jTextArea1.append("\n================ Tables to drop ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createProcedures(jCheckBox4.isSelected());
        jTextArea1.append("\n============== Procedures to create =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterProcedures(jCheckBox4.isSelected());
        jTextArea1.append("\n============== Procedures to alter ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropProcedures(jCheckBox4.isSelected());
        jTextArea1.append("\n============== Procedures to drop  ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createViews(jCheckBox3.isSelected());
        comparer.retViews(true);
        jTextArea1.append("\n================ Views to create  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterViews(jCheckBox3.isSelected());
        jTextArea1.append("\n================= Views to alter ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createTriggers(jCheckBox5.isSelected());
        jTextArea1.append("\n=============== Triggers to create  ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createChecks(jCheckBox14.isSelected());
        jTextArea1.append("\n=============== Checks to create  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterChecks(jCheckBox14.isSelected());
        jTextArea1.append("\n================ Checks to alter ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createUniques(jCheckBox13.isSelected());
        jTextArea1.append("\n=============== Uniques to create ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterUniques(jCheckBox13.isSelected());
        jTextArea1.append("\n================ Uniques to alter  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createPKs(jCheckBox11.isSelected());
        jTextArea1.append("\n============= Primary keys to create =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterPKs(jCheckBox11.isSelected());
        jTextArea1.append("\n=============  Primary keys to alter ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createFKs(jCheckBox12.isSelected());
        jTextArea1.append("\n============= Foreign keys to create =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterFKs(jCheckBox12.isSelected());
        jTextArea1.append("\n============== Foreign keys to alter  =============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropDomains(jCheckBox2.isSelected());
        jTextArea1.append("\n=============== Domains to drop ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropUDFs(jCheckBox8.isSelected());
        jTextArea1.append("\n================ UDFs to drop  ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropExceptions(jCheckBox7.isSelected());
        jTextArea1.append("\n============== Exceptions to drop  ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.dropGenerators(jCheckBox6.isSelected());
        jTextArea1.append("\n============== Generators to drop  ==============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterTriggers(jCheckBox5.isSelected());
        jTextArea1.append("\n=============== Triggers to alter  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.computedField(true);
        comparer.fillViews(true);
        comparer.fillProcedures(true);
        comparer.fillTriggers(true);
        comparer.recreateChecks(true);

        comparer.lists = "";
        comparer.createIndices(jCheckBox10.isSelected());
        jTextArea1.append("\n=============== Indices to create ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.alterIndices(jCheckBox10.isSelected());
        jTextArea1.append("\n================ Indices to alter  ===============\n\n");
        jTextArea1.append(comparer.lists);

        comparer.fillIndices(true);

        comparer.lists = "";
        comparer.dropRoles(jCheckBox9.isSelected());
        jTextArea1.append("\n================ Roles to drop  ================\n\n");
        jTextArea1.append(comparer.lists);

        comparer.lists = "";
        comparer.createRoles(jCheckBox9.isSelected());
        jTextArea1.append("\n================ Roles to create ===============\n\n");
        jTextArea1.append(comparer.lists);

        for (int i = 0; i < comparer.script.size(); i++) {
            //System.out.println(comparer.script.get(i));
            jTextArea2.append(comparer.script.get(i));
        }
        /*for (int i = 0; i < comparer.warnings.size(); i++) {
         System.out.println(i + 1 + ": " + comparer.warnings.get(i));
         }*/




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jCheckBox1.isSelected() == true
                && jCheckBox2.isSelected() == true
                && jCheckBox3.isSelected() == true
                && jCheckBox4.isSelected() == true
                && jCheckBox5.isSelected() == true
                && jCheckBox6.isSelected() == true
                && jCheckBox7.isSelected() == true
                && jCheckBox8.isSelected() == true
                && jCheckBox9.isSelected() == true
                && jCheckBox10.isSelected() == true
                && jCheckBox11.isSelected() == true
                && jCheckBox12.isSelected() == true
                && jCheckBox13.isSelected() == true
                && jCheckBox14.isSelected() == true) {
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            jCheckBox5.setSelected(false);
            jCheckBox6.setSelected(false);
            jCheckBox7.setSelected(false);
            jCheckBox8.setSelected(false);
            jCheckBox9.setSelected(false);
            jCheckBox10.setSelected(false);
            jCheckBox11.setSelected(false);
            jCheckBox12.setSelected(false);
            jCheckBox13.setSelected(false);
            jCheckBox14.setSelected(false);
        } else {
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(true);
            jCheckBox3.setSelected(true);
            jCheckBox4.setSelected(true);
            jCheckBox5.setSelected(true);
            jCheckBox6.setSelected(true);
            jCheckBox7.setSelected(true);
            jCheckBox8.setSelected(true);
            jCheckBox9.setSelected(true);
            jCheckBox10.setSelected(true);
            jCheckBox11.setSelected(true);
            jCheckBox12.setSelected(true);
            jCheckBox13.setSelected(true);
            jCheckBox14.setSelected(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

   //GEN-LAST:event_btnInstall_libActionPerformed



    String bundleString(String key)
    {
        return Bundles.get(ComparerDBPanel.class,key);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton btnSaveScript;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel dbBox1label;
    private javax.swing.JLabel dbBox2label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JComboBox dbBox1;
    private javax.swing.JComboBox dbBox2;


    // End of variables declaration//GEN-END:variables

}