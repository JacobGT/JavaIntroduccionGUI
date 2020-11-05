package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionListeners extends JFrame{
    private JPanel panel;
    private JLabel saludo;
    private JTextField cajaTexto;
    private JButton boton;
    private JTextArea areaTexto;
    int x, y;
    String texto;
    
    public ActionListeners() {
        setBounds(50, 50, 500, 500);
        setTitle("Eventos");
        
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void iniciarComponentes(){
        colocarPanel();
        //colocarEtiqueta();
        colocarCajaDeTexto();
        //colocarBoton();
        colocarAreaTexto();
    }
    
    private void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }
    
    private void colocarEtiqueta(){
        JLabel etiqueta = new JLabel("Ingrese su nombre: ");
        etiqueta.setBounds(30, 10, 250, 30);
        etiqueta.setFont(new Font("cooper black", Font.BOLD, 20));
        panel.add(etiqueta);
    }
    
    private void colocarCajaDeTexto(){
        cajaTexto = new JTextField();
        cajaTexto.setBounds(30, 350, 300, 30);
        panel.add(cajaTexto);
        
        eventosDelTeclado();
    }
    
    private void colocarAreaTexto(){
        areaTexto = new JTextArea();
        areaTexto.setBounds(20, 20, 300, 300);
        areaTexto.setEditable(false);
       panel.add(areaTexto);
    }
    
    private void colocarBoton(){
        boton = new JButton("Click Aqui");
        boton.setBounds(150, 350, 150, 40);
        boton.setFont(new Font("arial", 0, 15));
        panel.add(boton);
        
        saludo = new JLabel();
        saludo.setBounds(50, 200, 300, 40);
        saludo.setFont(new Font("arial", 1, 20));
        panel.add(saludo);
        
        //eventoOyenteDeAccion();
        //eventoOyenteDeRaton();
        //eventoDeMovimientoRaton();
        //eventoRuedaDelRaton();

    }
    
    private void eventoOyenteDeAccion(){
        //Agregar Evento de tipo ActionListener
        ActionListener oyenteDeAccion = new ActionListener() { //ActionListener es un interface
            //en las siguientes lineas se implementan todos los metodos abstractos de la interface ActionListener
            @Override
            public void actionPerformed(ActionEvent ae) {
                //aqui adentro ponemos la accion que queremos que suceda
                saludo.setText("Hola " + cajaTexto.getText() + ". Como estás?");
                cajaTexto.setText("");
            }
        };
        
        boton.addActionListener(oyenteDeAccion);//event de action listener / necesita parametro un objeto de tipo action listener   
    }
    
    private void eventoOyenteDeRaton(){
        MouseListener oyenteDeRaton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                areaTexto.append("mouseClicked  hiciste click\n");
                //mousClicked es para cuando hacemos click y soltamos ADENTRO del boton si soltamos afuera del boton, no cuenta
            }

            @Override
            public void mousePressed(MouseEvent me) {
                areaTexto.append("mousePressed  presionaste el boton\n");
                //mousPressed es para cuando presionamos el boton
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                areaTexto.append("mouseRleased  dejaste de presionar el boton\n");
                //mouseRelease es para cuando presionas y sueltas el boton afuera del boton
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                areaTexto.append("mouseEntered  el mouse esta adentro del boton\n");
                //mouseEntered es para el cursor esté ADENTRO del boton
            }

            @Override
            public void mouseExited(MouseEvent me) {
                areaTexto.append("mouseExited  el mouse salio del area del boton\n");
                //mouseExited es para cuando el cursor sale del area del boton            
            }
        };
        //agregamos oyente de raton / no se puede instanciar un objeto de una interface
        boton.addMouseListener(oyenteDeRaton);//pasamos de parametro un objeto de tipo MouseListener
        
    }
    
    private void eventoDeMovimientoRaton(){
        MouseMotionListener oyenteDeMovimientoRaton = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                //es para cuando arrastramos el mouse
                areaTexto.append(boton.getText()+"arrastraste mouse\n");
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                //es para cuando el mouse se mueve adentro del boton
                x=(int)me.getPoint().getX();//agarramos las coordenadas de mouse en x
                y=(int)me.getPoint().getY();//agarramos las coordenadas de mouse en y
                texto = "X: " + x + " Y: " + y;//las pasamos a una variable
                areaTexto.setText(texto);//las ponemos en el texto
                repaint();//refresca todo
            }
        };
        
        boton.addMouseMotionListener(oyenteDeMovimientoRaton);
    }
    
    private void eventoRuedaDelRaton(){
        MouseWheelListener oyenteDeRuedaRaton = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) {
                //es para cuando se mueve la rueda del boton
                areaTexto.append("Girando rueda de mouse ");
                int direccion = mwe.getWheelRotation();
                if (direccion == -1){
                    areaTexto.append("para arriba\n");
                } else { //-1 es girando para arriba 1 es girando para abajo
                    areaTexto.append("para abajo\n");
                }
                //para ver como mover texto https://youtu.be/8l_hpqCFA_4
            }
        };
        
        boton.addMouseWheelListener(oyenteDeRuedaRaton);
    }
    
    private void eventosDelTeclado(){
        KeyListener oyenteDeTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                //cuando presionas a characteres iunicos osea no acepta ctrl, shift, etc.
                areaTexto.append("keyTyped: " + ke.getKeyChar() + "\n");
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //cuando presionas y/o mantienes presionado cual quier tecla es un keyPressed
                areaTexto.append("keyPressed: " + ke.getKeyChar() + "\n");
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //es como keyPressed pero lo lee cuando se suelta la tecla
                areaTexto.append("keyReleased: " + ke.getKeyChar() + "\n");
                
            }
        };
        
        cajaTexto.addKeyListener(oyenteDeTeclado);//agregamos oyente de teclado
    }    
}