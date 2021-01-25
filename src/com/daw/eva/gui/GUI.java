package com.daw.eva.gui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class GUI {
    JFrame frame;
    JPanel paneliz, panelde, panelab, panelar, panelex, panellist;
    JLabel nombre, apellido1, apellido2, telefono, dni, id_empleat, cargo, jornada, estudios, salario;
    JTextField textFieldNombre, textFieldApellido1, textFieldApellido2, textFieldTelefono, textFieldDni, 
            textFieldId, textFieldCargo, textFieldJornada, textFieldEstudios, textFieldSalario;
    JButton btnAcceptar, btnCancelar, btnMostrarError;
    JTextArea list;

    GUI() {
        frame = new JFrame();       //pantalla principal.
        paneliz  = new JPanel();    //panel izquierda, donde pondremos los textos (JLabel) de los inputbox.
        panelde  = new JPanel();    //panel derecha, donde pondremos los inputbox (JTextField).
        panelab  = new JPanel();    //panel abajo, donde pondremos los botones (JButton).
        panellist  = new JPanel();
        panelar  = new JPanel();    //panel donde pondremos los paneles izquierdo (paneliz) y derecho (panelde).
        panelex = new JPanel();     //panel donde pondremos los paneles panelar y panelab. Este panel tiene todos los paneles.
        
        nombre = new JLabel();		//Etiquetas que salen en la pantalla.
        apellido1 = new JLabel();
        apellido2 = new JLabel();
        telefono = new JLabel();
        dni = new JLabel();
        id_empleat = new JLabel();
        cargo = new JLabel();
        jornada= new JLabel();
        estudios= new JLabel();
        salario= new JLabel();

        textFieldNombre = new JTextField();	//Las cajitas donde el usuari meterá los datos que se le piden.
        textFieldApellido1 = new JTextField();
        textFieldApellido2 = new JTextField();
        textFieldTelefono = new JTextField();
        textFieldDni = new JTextField();
        textFieldId = new JTextField();
        textFieldCargo = new JTextField();
        textFieldJornada = new JTextField();
        textFieldEstudios = new JTextField();
        textFieldSalario = new JTextField();
        
        btnAcceptar = new JButton();		//Los botones.
        btnCancelar = new JButton();
        btnMostrarError = new JButton();
        
        list = new JTextArea();

        
        frame.setTitle("Formulario");
        frame.setLayout(new FlowLayout());     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(500,370);

        
        nombre.setText("Nombre");
        apellido1.setText("Apellido 1");
        apellido2.setText("Apellido 2");
        telefono.setText("Telefono");
        dni.setText("DNI");
        id_empleat.setText("ID empleado");
        cargo.setText("Cargo");
        jornada.setText("Jornada");
        estudios.setText("Estudios");
        salario.setText("Salario");

        btnAcceptar.setText("Aceptar");
        btnCancelar.setText("Sortir");
        btnMostrarError.setText("Mostrar Error");

        
        paneliz.setLayout(new GridLayout(10,0));    //Grid(10,0) = tabla de 10 filas y sin columnas.
        paneliz.add(nombre);
        paneliz.add(apellido1);
        paneliz.add(apellido2);
        paneliz.add(telefono);
        paneliz.add(dni);
        paneliz.add(id_empleat);
        paneliz.add(cargo);
        paneliz.add(jornada);
        paneliz.add(estudios);
        paneliz.add(salario);

        panelde.setLayout(new GridLayout(10,0));
        panelde.add(textFieldNombre);
        panelde.add(textFieldApellido1);
        panelde.add(textFieldApellido2);
        panelde.add(textFieldTelefono);
        panelde.add(textFieldDni);
        panelde.add(textFieldId);
        panelde.add(textFieldCargo);
        panelde.add(textFieldJornada);
        panelde.add(textFieldEstudios);
        panelde.add(textFieldSalario);

        panelar.setLayout(new GridLayout(1,1));
        panelar.setPreferredSize(new Dimension(350,200));
        panelar.add(paneliz);
        panelar.add(panelde);

        panelab.setLayout(new FlowLayout());
        panelab.setPreferredSize(new Dimension(200,50));
        panelab.add(btnAcceptar);
        panelab.add(btnCancelar);
        panelab.add(btnMostrarError);

        panelex.setLayout(new GridLayout(2,0));
        panelex.add(panelar);
        panelex.add(panelab);
        
        frame.add(panelex);
       
        btnAcceptar.addActionListener(new AccioBtnAcceptar());   //btn Aceptar.
    }


     class AccioBtnAcceptar implements ActionListener{
         public void actionPerformed(ActionEvent e){
             try {
             if ( textFieldNombre.getText().matches(".*[0-9]+.*"))
                throw new Exception("los nombres no tienen numeros");
             if ( textFieldApellido1.getText().matches(".*[0-9]+.*"))
                 throw new Exception("los apellidos no tienen numeros");
                } catch (Exception e1) {
                     System.out.println("vaciamos nombre");
                    textFieldNombre.setText("");
                }
             
             System.out.println("Recogemos los datos y los validamos" + textFieldNombre.getText() );
         }
     }


    public static void main(String[] args) {
 
        GUI pa = new GUI();
 
    }
 
}
