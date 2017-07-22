/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miBlockDeNotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;


public class MiBlockDeNotas extends javax.swing.JFrame
{
       
        public MiBlockDeNotas()
	{   
               this.setLocationRelativeTo(this);
               this.setTitle("Sin Título");
		initComponents();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoMenuItem = new javax.swing.JMenuItem();
        abrirMenuItem = new javax.swing.JMenuItem();
        guardarMenuItem = new javax.swing.JMenuItem();
        guardarcomoMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        copiarMenuItem = new javax.swing.JMenuItem();
        cortarMenuItem = new javax.swing.JMenuItem();
        pegarMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        jMenu1.setText("Archivo");

        nuevoMenuItem.setText("Nuevo");
        nuevoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoMenuItem);

        abrirMenuItem.setText("Abrir");
        abrirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(abrirMenuItem);

        guardarMenuItem.setText("Guardar");
        guardarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(guardarMenuItem);

        guardarcomoMenuItem.setText("Guardar como ...");
        guardarcomoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarcomoMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(guardarcomoMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(salirMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        copiarMenuItem.setText("Copiar");
        copiarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(copiarMenuItem);

        cortarMenuItem.setText("Cortar");
        cortarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortarMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(cortarMenuItem);

        pegarMenuItem.setText("Pegar");
        pegarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(pegarMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void cerrar(){
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this,"¿En realidad desea cerrar la aplicación?","Mensaje de Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
        System.exit(0);
        }
    }
    
    private void abrirMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_abrirMenuItemActionPerformed
    {//GEN-HEADEREND:event_abrirMenuItemActionPerformed
    if (archivoAbiertoFile == null)
    {
        if (apretado==1)
        {
            Object [] opciones ={"Guardar","No Guardar","Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea guardar el archivo antes de abrir otro?","Mensaje de alerta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Guardar");
            if(eleccion == JOptionPane.YES_OPTION)
            {
                try
                {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showSaveDialog(this);
                    File GUARDAR =fileChooser.getSelectedFile();
                    if(GUARDAR != null)
                    {
                        try (FileWriter GUARDADO = new FileWriter(GUARDAR)) {
                            GUARDADO.write(textArea.getText());
                            
                        }
                    }
                }               
                catch(IOException exp){}
                
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showOpenDialog(this);
                if(ret != JFileChooser.APPROVE_OPTION)
                    return;
                archivoAbiertoFile = fileChooser.getSelectedFile();
                FileReader archivoReader;
                try
                {
                    archivoReader = new FileReader(archivoAbiertoFile);
                }
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                try
                {
                    textArea.read(archivoReader, null);
                    this.setTitle(archivoAbiertoFile.getName());
                }
                catch (IOException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                apretado=0;
            }
            if(eleccion == JOptionPane.NO_OPTION)
            {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showOpenDialog(this);
                if(ret != JFileChooser.APPROVE_OPTION)
                    return;
                archivoAbiertoFile = fileChooser.getSelectedFile();
                FileReader archivoReader;
                try
                {
                    archivoReader = new FileReader(archivoAbiertoFile);
                }
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                try
                {
                    textArea.read(archivoReader, null);
                    this.setTitle(archivoAbiertoFile.getName());
                }
                catch (IOException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        else
        {
            JFileChooser fileChooser = new JFileChooser();
            int ret = fileChooser.showOpenDialog(this);
            if(ret != JFileChooser.APPROVE_OPTION)
                return;
            archivoAbiertoFile = fileChooser.getSelectedFile();
            FileReader archivoReader;
            try
            {
                archivoReader = new FileReader(archivoAbiertoFile);
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            try
            {
                textArea.read(archivoReader, null);
                this.setTitle(archivoAbiertoFile.getName());
            }
            catch (IOException ex)
            {
                Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    else
    {
        if(apretado==1)
        {
            
            Object [] opciones ={"Guardar","No Guardar","Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea guardar el archivo antes de abrir otro?","Mensaje de alerta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Guardar");
            if(eleccion == JOptionPane.YES_OPTION)
            {
                try
                {
                   
                    {
                        try (FileWriter GUARDADO = new FileWriter(archivoAbiertoFile)) {
                            GUARDADO.write(textArea.getText());
                        }
                    }
                }               
                catch(IOException exp){}
                
                
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showOpenDialog(this);
                if(ret != JFileChooser.APPROVE_OPTION)
                    return;
                archivoAbiertoFile = fileChooser.getSelectedFile();
                FileReader archivoReader;
                try
                {
                    archivoReader = new FileReader(archivoAbiertoFile);
                }
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                try
                {
                    textArea.read(archivoReader, null);
                    this.setTitle(archivoAbiertoFile.getName());
                }
                catch (IOException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                }
                apretado=0;
                
            }
            if(eleccion == JOptionPane.NO_OPTION)
            {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showOpenDialog(this);
                if(ret != JFileChooser.APPROVE_OPTION)
                    return;
                archivoAbiertoFile = fileChooser.getSelectedFile();
                FileReader archivoReader;
                try
                {
                    archivoReader = new FileReader(archivoAbiertoFile);
                }
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                try
                {
                    textArea.read(archivoReader, null);
                    this.setTitle(archivoAbiertoFile.getName());
                }
                catch (IOException ex)
                {
                    Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                }
                apretado=0;
            }
        }
        else
        {
            JFileChooser fileChooser = new JFileChooser();
            int ret = fileChooser.showOpenDialog(this);
            if(ret != JFileChooser.APPROVE_OPTION)
                return;
            archivoAbiertoFile = fileChooser.getSelectedFile();
            FileReader archivoReader;
            try
            {
                archivoReader = new FileReader(archivoAbiertoFile);
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            try
            {
                textArea.read(archivoReader, null);
                this.setTitle(archivoAbiertoFile.getName());
            }
            catch (IOException ex)
            {
                Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    }//GEN-LAST:event_abrirMenuItemActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_salirMenuItemActionPerformed
    {//GEN-HEADEREND:event_salirMenuItemActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void nuevoMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nuevoMenuItemActionPerformed
    {//GEN-HEADEREND:event_nuevoMenuItemActionPerformed
	if(archivoAbiertoFile!=null)
        {
            textArea.setText("");
            apretado=0;
        }
        if(textArea.getText().length()>0)
        {
            Object [] opciones ={"Guardar","No Guardar","Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea guardar el archivo editado?","Mensaje de alerta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Guardar");
            if (eleccion == JOptionPane.YES_OPTION)
            {
                try
                {
                    String nombre = "";
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showSaveDialog(this);
                    File GUARDAR =fileChooser.getSelectedFile();
                    if(GUARDAR != null)
                    {
                        nombre=fileChooser.getSelectedFile().getName();
                        try (FileWriter GUARDADO = new FileWriter(GUARDAR)) {
                            GUARDADO.write(textArea.getText());
                        }
                    }
                }               
                catch(IOException exp){}
                textArea.setText("");
                apretado=0;
            }
            if (eleccion == JOptionPane.NO_OPTION)
            {
                textArea.setText("");
                apretado=0;
            }
        }
    }//GEN-LAST:event_nuevoMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
    if(archivoAbiertoFile==null)
    {    if(apretado==1)
        {
                
                Object [] opciones ={"Guardar","No Guardar","Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea guardar el archivo antes de cerrar?","Mensaje de alerta",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Guardar");
                if (eleccion == JOptionPane.YES_OPTION)
                {
                    try
                    {                    
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.showSaveDialog(this);
                        File GUARDAR =fileChooser.getSelectedFile();
                        if(GUARDAR != null)
                        {
                            try (FileWriter GUARDADO = new FileWriter(GUARDAR)) {
                                GUARDADO.write(textArea.getText());
                            }
                        }
                    }               
                    catch(IOException exp){}
                    System.exit(0);
                }
                else
                {
                    if (eleccion == JOptionPane.NO_OPTION)
                        System.exit(0);
                }
        }
        else
        {
            if (apretado!=1)
                System.exit(0);
            cerrar();
        }
    }
    if(archivoAbiertoFile!=null)
    {
        if(apretado==1)
        {
            Object [] opciones ={"Guardar","No Guardar","Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea guardar las modificaciones hechas en el archivo?","Mensaje de alerta",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Guardar");
            if (eleccion == JOptionPane.YES_OPTION)
            {
                guardarMenuItemActionPerformed(null);
                System.exit(0);
            }
            else
            {
                if (eleccion == JOptionPane.NO_OPTION)
                    System.exit(0);
            }
            
        }
        else
            System.exit(0);
    }
    
    }//GEN-LAST:event_formWindowClosing

    private void copiarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarMenuItemActionPerformed
        
        textArea.copy();
        
    }//GEN-LAST:event_copiarMenuItemActionPerformed

    private void cortarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortarMenuItemActionPerformed
        
        textArea.cut();
        
    }//GEN-LAST:event_cortarMenuItemActionPerformed
 
    private void pegarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarMenuItemActionPerformed
       
        textArea.paste();
      
    }//GEN-LAST:event_pegarMenuItemActionPerformed

    private void guardarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMenuItemActionPerformed

        if(archivoAbiertoFile!=null)
        {
            try(FileWriter GUARDADO = new FileWriter(archivoAbiertoFile)) 
            {   
                GUARDADO.write(textArea.getText());

            }
            catch(IOException ex)
            {
                Logger.getLogger(MiBlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
            apretado=0;
            
        }
        else
        {
            try
            {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(this);
                File GUARDAR =fileChooser.getSelectedFile();
                if(GUARDAR != null)
                {
                    try (FileWriter GUARDADO = new FileWriter(GUARDAR)) {
                        GUARDADO.write(textArea.getText());
                        archivoAbiertoFile=GUARDAR;
                        apretado=0;
                    }
                }
            }               
            catch(IOException exp){}
        }
        
    }//GEN-LAST:event_guardarMenuItemActionPerformed

    private void guardarcomoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarcomoMenuItemActionPerformed
        try
                {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showSaveDialog(this);
                    File GUARDAR =fileChooser.getSelectedFile();
                    if(GUARDAR != null)
                    {
                        try (FileWriter GUARDADO = new FileWriter(GUARDAR)) {
                            GUARDADO.write(textArea.getText());
                        }
                    }
                    apretado=0;
                }               
                catch(IOException exp){}
        
    }//GEN-LAST:event_guardarcomoMenuItemActionPerformed

    private void textAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyTyped
        apretado=1;
    }//GEN-LAST:event_textAreaKeyTyped

    
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(MiBlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(MiBlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(MiBlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(MiBlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new MiBlockDeNotas().setVisible(true);
			}
		});
	}
	
	private int apretado;
	private File archivoAbiertoFile;
	private String textoSeleccionado = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirMenuItem;
    private javax.swing.JMenuItem copiarMenuItem;
    private javax.swing.JMenuItem cortarMenuItem;
    private javax.swing.JMenuItem guardarMenuItem;
    private javax.swing.JMenuItem guardarcomoMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem nuevoMenuItem;
    private javax.swing.JMenuItem pegarMenuItem;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
