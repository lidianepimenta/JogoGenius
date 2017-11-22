package br.com.cybertech.genius.frontend;

/*******************************************************************************
 *
 *                      CLASSE PRINCIPAL - FORMULÁRIO.
 *

 * @author Felipe Gil     
 * @author Leandro Medeiros   
 * @author Lidiane Pimenta
 * @author Thiago Sanches  
 *
 ******************************************************************************/

import br.com.cybertech.genius.game.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {

    private Genius game;
    private int currentTry;
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    protected void labelsSetEnabled(boolean flag) {
        this.lblGreen.setEnabled(flag);
        this.lblRed.setEnabled(flag);
        this.lblYellow.setEnabled(flag);
        this.lblBlue.setEnabled(flag);
    }

    protected void sleep(final int seconds) {
        this.lblBlue.repaint();
        this.lblGreen.repaint();
        this.lblYellow.repaint();
        this.lblRed.repaint();
        
        try {
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }        
    }
    
    protected void showMoves() {
        GeniusMove move;
        
        for(int idx = 0; idx <= this.game.getCurrentLevel(); idx++) {
            move = this.game.getMoveAt(idx);
            
            switch(move.getId()) {
                case GeniusMove.TYPE_GREEN:
                    move.playSound();
                    this.lblGreen.setIcon(move.getOnImage());
                    //this.sleep(1);
                    this.lblGreen.setIcon(move.getOffImage());
                break;

                case GeniusMove.TYPE_RED:
                    move.playSound();
                    this.lblRed.setIcon(move.getOnImage());
                    //this.sleep(1);
                    this.lblRed.setIcon(move.getOffImage());
                break;

                case GeniusMove.TYPE_YELLOW:
                    move.playSound();
                    this.lblYellow.setIcon(move.getOnImage());
                    //this.sleep(1);
                    this.lblYellow.setIcon(move.getOffImage());
                break;

                case GeniusMove.TYPE_BLUE:
                    move.playSound();
                    this.lblBlue.setIcon(move.getOnImage());
                    //this.sleep(1);
                    this.lblBlue.setIcon(move.getOffImage());
                break;
            }
        }
    } 

    protected void testMove(int moveId) {
        //this.sleep(1);
        
        if (this.game.hasLost(new GeniusMove(moveId), this.currentTry)) {
            JOptionPane.showMessageDialog(rootPane, "Perdeu!");
            this.labelsSetEnabled(false);
            this.btnStart.setEnabled(true);
        }
        
        else if (this.currentTry == this.game.getCurrentLevel()) {
            this.currentTry++;
            this.lblScore.setText(String.valueOf(this.currentTry));

            if (this.game.newMove())
                this.showMoves();
            else
                JOptionPane.showMessageDialog(rootPane, "Parabéns, você zerou este game!");
        }
    }
    
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        this.labelsSetEnabled(true);
        this.btnStart.setEnabled(false);
        
        this.game = new Genius(10);
        this.game.start();
        this.game.newMove();
        
        this.currentTry = 0;
        
        this.showMoves();
    }

 /*****************************************************************************
  *                         CLIQUES NAS ETIQUETAS.                            *
  *****************************************************************************/
    private void lblGreenMouseClicked(java.awt.event.MouseEvent evt) {
        GeniusMove.playSound(GeniusMove.TYPE_GREEN);
        this.testMove(GeniusMove.TYPE_GREEN);
    }
    
    private void lblRedMouseClicked(java.awt.event.MouseEvent evt) {
        GeniusMove.playSound(GeniusMove.TYPE_RED);
        this.testMove(GeniusMove.TYPE_RED);
    }

    private void lblYellowMouseClicked(java.awt.event.MouseEvent evt) {
        GeniusMove.playSound(GeniusMove.TYPE_YELLOW);
        this.testMove(GeniusMove.TYPE_YELLOW);
    }

    private void lblBlueMouseClicked(java.awt.event.MouseEvent evt) {
        GeniusMove.playSound(GeniusMove.TYPE_BLUE);
        this.testMove(GeniusMove.TYPE_BLUE);
    }

 /*****************************************************************************
  *                       MOUSE ENTRA NA ETIQUETAS.                           *
  *****************************************************************************/
    private void lblGreenMouseEntered(java.awt.event.MouseEvent evt) {
        this.lblGreen.setIcon(GeniusMove.getImage(GeniusMove.TYPE_GREEN + "_on"));
    }

    private void lblRedMouseEntered(java.awt.event.MouseEvent evt) {
        this.lblRed.setIcon(GeniusMove.getImage(GeniusMove.TYPE_RED + "_on"));
    }

    private void lblYellowMouseEntered(java.awt.event.MouseEvent evt) {
        this.lblYellow.setIcon(GeniusMove.getImage(GeniusMove.TYPE_YELLOW + "_on"));
    }
    
    private void lblBlueMouseEntered(java.awt.event.MouseEvent evt) {
        this.lblBlue.setIcon(GeniusMove.getImage(GeniusMove.TYPE_BLUE + "_on"));
    }

 /*****************************************************************************
  *                        MOUSE SAI DA ETIQUETAS.                            *
  *****************************************************************************/
    private void lblGreenMouseExited(java.awt.event.MouseEvent evt) {
        this.lblGreen.setIcon(GeniusMove.getImage(GeniusMove.TYPE_GREEN + "_off"));
    }

    private void lblRedMouseExited(java.awt.event.MouseEvent evt) {
        this.lblRed.setIcon(GeniusMove.getImage(GeniusMove.TYPE_RED + "_off"));
    }

    private void lblYellowMouseExited(java.awt.event.MouseEvent evt) {
        this.lblYellow.setIcon(GeniusMove.getImage(GeniusMove.TYPE_YELLOW + "_off"));
    }

    private void lblBlueMouseExited(java.awt.event.MouseEvent evt) {
        this.lblBlue.setIcon(GeniusMove.getImage(GeniusMove.TYPE_BLUE + "_off"));
    }

	
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGreen = new javax.swing.JLabel();
        lblRed = new javax.swing.JLabel();
        lblBlue = new javax.swing.JLabel();
        lblYellow = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cyber Tech - Genius");

        lblGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cybertech/genius/frontend/images/1_off.png"))); // NOI18N
        lblGreen.setEnabled(false);
        lblGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGreenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGreenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGreenMouseExited(evt);
            }
        });

        lblRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cybertech/genius/frontend/images/2_off.png"))); // NOI18N
        lblRed.setEnabled(false);
        lblRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRedMouseExited(evt);
            }
        });

        lblBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cybertech/genius/frontend/images/4_off.png"))); // NOI18N
        lblBlue.setEnabled(false);
        lblBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBlueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBlueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBlueMouseExited(evt);
            }
        });

        lblYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cybertech/genius/frontend/images/3_off.png"))); // NOI18N
        lblYellow.setEnabled(false);
        lblYellow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYellowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblYellowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblYellowMouseExited(evt);
            }
        });

        lblScore.setFont(new java.awt.Font("Arial", 1, 72)); // NOI18N
        lblScore.setText("0");

        btnStart.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblYellow)
                .addGap(18, 18, 18)
                .addComponent(lblBlue)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblScore))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRed)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblScore)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnStart)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRed)
                    .addComponent(lblGreen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYellow)
                    .addComponent(lblBlue))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblBlue;
    private javax.swing.JLabel lblGreen;
    private javax.swing.JLabel lblRed;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblYellow;
    // End of variables declaration//GEN-END:variables
}
