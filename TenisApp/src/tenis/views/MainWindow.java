/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.views;

import java.awt.*;
import javax.swing.JOptionPane;
import tenis.logic.ViewController;
import tenis.library.Program_Mode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Braulio Rivera
 */
public class MainWindow extends javax.swing.JFrame {

    public MainWindow(ViewController pWindowController) {
        initComponents();
        _WindowController = pWindowController;
        this.setVisible(rootPaneCheckingEnabled);
        Lock();
        
    }
    

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        try {
            _WindowController.paint(g);
        } catch (AWTException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        AddButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        ColorButton = new javax.swing.JButton();
        SizeSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        LineButton = new javax.swing.JButton();
        CircleButton = new javax.swing.JButton();
        PointButton = new javax.swing.JButton();
        ThicknessSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        drawingPane = new javax.swing.JLayeredPane();
        ReportButton = new javax.swing.JButton();
        EditButton = new javax.swing.JToggleButton();
        ArcadeButton = new javax.swing.JToggleButton();
        FireButton = new javax.swing.JToggleButton();
        LoadButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ModelsList = new javax.swing.JList();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        AddButton.setText("+");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ColorButton.setText("Color");
        ColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorButtonActionPerformed(evt);
            }
        });

        SizeSpinner.setModel(new javax.swing.SpinnerNumberModel(15, 1, 50, 1));
        SizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SizeSpinnerStateChanged(evt);
            }
        });

        jLabel1.setText("Tamano");

        LineButton.setText("Line");
        LineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineButtonActionPerformed(evt);
            }
        });

        CircleButton.setText("Circle");
        CircleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CircleButtonActionPerformed(evt);
            }
        });

        PointButton.setText("Point");
        PointButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PointButtonActionPerformed(evt);
            }
        });

        ThicknessSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        ThicknessSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ThicknessSpinnerStateChanged(evt);
            }
        });

        jLabel2.setText("Thickness");

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        drawingPane.setBackground(new java.awt.Color(255, 255, 255));
        drawingPane.setOpaque(true);

        ReportButton.setText("Report");

        EditButton.setSelected(true);
        EditButton.setText("EDIT");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        ArcadeButton.setText("ARCADE");
        ArcadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcadeButtonActionPerformed(evt);
            }
        });

        FireButton.setText("FIRE");
        FireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireButtonActionPerformed(evt);
            }
        });

        LoadButton.setText("Load");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        ModelsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ModelsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ModelsList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(LineButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CircleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PointButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ColorButton)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThicknessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButton)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(EditButton)
                        .addGap(69, 69, 69)
                        .addComponent(ArcadeButton)
                        .addGap(80, 80, 80)
                        .addComponent(FireButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReportButton)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(drawingPane)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ReportButton)
                            .addComponent(EditButton)
                            .addComponent(ArcadeButton)
                            .addComponent(FireButton))
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawingPane, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ColorButton)
                            .addComponent(SizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(LineButton)
                            .addComponent(CircleButton)
                            .addComponent(PointButton)
                            .addComponent(ThicknessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(ClearButton))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String inputValue = JOptionPane.showInputDialog(AddButton, "Design Name: ", null, WIDTH);
        if (inputValue.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No puede crear un diseño sin nombre");
        }
        else{
            _WindowController.clean();
            Unlock();
            _WindowController.createDesign();
            _WindowController.saveDesign(inputValue);
            _Model.insertElementAt(inputValue, _Model.getSize());
            ModelsList.setModel(_Model);
            ModelsList.setSelectedIndex(_Model.getSize()-1);
            AddButton.setEnabled(false);
            SaveButton.setEnabled(true);
            
            repaint();
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        _WindowController.setDesign(ModelsList.getSelectedValue().toString());
        _WindowController.saveDesign(ModelsList.getSelectedValue().toString());
        AddButton.setEnabled(true);
        SaveButton.setEnabled(false);
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        _WindowController.mouseDrag(evt);
        evt.getComponent().repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        _WindowController.mousePress(evt);
        evt.getComponent().repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        _WindowController.mouseReleased(evt);        
        evt.getComponent().repaint();
    }//GEN-LAST:event_formMouseReleased

    private void ColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorButtonActionPerformed
        _WindowController.putColor(this);
        //EditorPainter.putColor(this);
        repaint();
    }//GEN-LAST:event_ColorButtonActionPerformed

    private void SizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SizeSpinnerStateChanged
        _WindowController.updateRadius((int) SizeSpinner.getValue());
        repaint();
    }//GEN-LAST:event_SizeSpinnerStateChanged

    private void LineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineButtonActionPerformed
        _WindowController.drawLine();
        repaint();
    }//GEN-LAST:event_LineButtonActionPerformed

    private void CircleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CircleButtonActionPerformed
        _WindowController.drawCircle();
        repaint();
    }//GEN-LAST:event_CircleButtonActionPerformed

    private void ThicknessSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ThicknessSpinnerStateChanged
        //_WindowController.updateThickness((int) jSpinner1.getValue());
        //repaint();
    }//GEN-LAST:event_ThicknessSpinnerStateChanged

    private void PointButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PointButtonActionPerformed
        _WindowController.drawPoint();
        repaint();
    }//GEN-LAST:event_PointButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        _WindowController.clean();
        repaint();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ArcadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcadeButtonActionPerformed
        LockFireArcade();
        _WindowController.setMode(Program_Mode.ARCADE);
        EditButton.setSelected(false);
        FireButton.setSelected(false);
        //repaint();
    }//GEN-LAST:event_ArcadeButtonActionPerformed

    private void FireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireButtonActionPerformed
        LockFireArcade();
        _WindowController.setMode(Program_Mode.FIRE);
        EditButton.setSelected(false);
        ArcadeButton.setSelected(false);
        //repaint();
    }//GEN-LAST:event_FireButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        Unlock();
        _WindowController.setMode(Program_Mode.EDIT);
        _WindowController.updateRadius1();
        ArcadeButton.setSelected(false);
        FireButton.setSelected(false);
        repaint();
    }//GEN-LAST:event_EditButtonActionPerformed

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        List<String> Designs = _WindowController.loadDesign();   
        for (String name : Designs){
            _Model.insertElementAt(name, _Model.getSize());
            ModelsList.setModel(_Model);
        }
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void ModelsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ModelsListValueChanged
        if (!ModelsList.isSelectionEmpty()){
            _WindowController.getDesign(ModelsList.getSelectedValue().toString());
        }
    }//GEN-LAST:event_ModelsListValueChanged
    
  
    private ViewController _WindowController;
    private DefaultListModel<String> _Model = new DefaultListModel<>();
    
    void Lock(){
        LineButton.setEnabled(false);
        CircleButton.setEnabled(false);
        ColorButton.setEnabled(false);
        ClearButton.setEnabled(false);
        PointButton.setEnabled(false);
        ReportButton.setEnabled(false);
        SizeSpinner.setEnabled(false);
        ThicknessSpinner.setEnabled(false);
        FireButton.setEnabled(false);
        ArcadeButton.setEnabled(false);
        EditButton.setEnabled(false);
    }
    void LockFireArcade(){
        LineButton.setEnabled(false);
        CircleButton.setEnabled(false);
        ColorButton.setEnabled(false);
        ClearButton.setEnabled(false);
        PointButton.setEnabled(false);
        ReportButton.setEnabled(false);
        SizeSpinner.setEnabled(false);
        ThicknessSpinner.setEnabled(false);
    }
    void Unlock(){
        LineButton.setEnabled(true);
        CircleButton.setEnabled(true);
        ColorButton.setEnabled(true);
        ClearButton.setEnabled(true);
        PointButton.setEnabled(true);
        ReportButton.setEnabled(true);
        SizeSpinner.setEnabled(true);
        ThicknessSpinner.setEnabled(true);
        FireButton.setEnabled(true);
        ArcadeButton.setEnabled(true);
        EditButton.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JToggleButton ArcadeButton;
    private javax.swing.JButton CircleButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton ColorButton;
    private javax.swing.JToggleButton EditButton;
    private javax.swing.JToggleButton FireButton;
    private javax.swing.JButton LineButton;
    private javax.swing.JButton LoadButton;
    private javax.swing.JList ModelsList;
    private javax.swing.JButton PointButton;
    private javax.swing.JButton ReportButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JSpinner SizeSpinner;
    private javax.swing.JSpinner ThicknessSpinner;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLayeredPane drawingPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
