package client;
import ServerInterface.Dictionary;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Client extends javax.swing.JFrame {
  String host;                                  
  int port;
  Dictionary  dictionary;
 //----------------------------------------------------------------------------- 
  public Client() {
   initComponents();
   try {
        host=JOptionPane.showInputDialog(this, " IP of Server Host");
        port=Integer.parseInt(JOptionPane.showInputDialog(null,"Port of Server:"));
        Registry reg = LocateRegistry.getRegistry(host, port);        
        dictionary = (Dictionary)reg.lookup(Dictionary.LOOKUPNAME);
       } catch (RemoteException | NotBoundException ex) {
         Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       }  
    }
 //----------------------------------------------------------------------------- 
    @SuppressWarnings("unchecked")
 //-----------------------------------------------------------------------------    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wordLabel = new javax.swing.JLabel();
        definitionsLabel = new javax.swing.JLabel();
        wordTextField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        findButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        definitionsTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wordLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        wordLabel.setText("English Word");

        definitionsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        definitionsLabel.setText("English Definitions");

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exitButton.setText("ُExit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        findButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        definitionsTextArea.setColumns(20);
        definitionsTextArea.setRows(5);
        jScrollPane1.setViewportView(definitionsTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(definitionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(wordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(findButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton)
                    .addComponent(definitionsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(wordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wordLabel)))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed
    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
    try{ 
       // String word = wordTextField.getText();
      // String Definition = dictionary.findDefinition(word);
     //  definitionsTextArea.setText(Definition);
definitionsTextArea.setText(dictionary.findDefinition(wordTextField.getText()));
        }catch (RemoteException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_findButtonActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel definitionsLabel;
    private javax.swing.JTextArea definitionsTextArea;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton findButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JTextField wordTextField;
    // End of variables declaration//GEN-END:variables
}
