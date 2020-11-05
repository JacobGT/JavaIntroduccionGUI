package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{ 
    public JPanel p1;
    
    public Ventana() {
        setSize(600, 1050); //Establecemos el tamaño de la ventana
        //setLocation(300, 250); //Establecemos la posicion inicial de la ventana
        //setBounds(300, 250, 500, 700); //este metodo utiliza y unifica los metodos setLocation y setSize en ese mismo orden
        // this.setBounds(x, y, width, height);
        setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana relativa a el centro de la pantalla
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Establecemos que el codigo se detenga al cerrar la ventana
        setTitle("Inicio / Tutorial"); //Establecemos el titulo de la ventana
        
        //this.getContentPane();//Obtenemos el contenido de la ventana
        this.getContentPane().setBackground(Color.BLACK);//Establecemos el color de la ventana
        getContentPane().setForeground(Color.green);//Establecemos el color de las letras
        
        setResizable(false); //Establecemos si la ventana puede cambiar de tamaño
        //setMinimumSize(new Dimension (200, 200));//Establecemos un tamaño minimo
        //setMaximumSize(new Dimension (700, 900)); //Establecemos un tamaño maximo  
        
        iniciarComponentes();
        
    }
    
    private void iniciarComponentes() {
        crearPaneles();
        crearEtiquetas();
        crearBotones();
        crearRadioBotones();
        crearCajasDeTexto();
        crearAreasDeTexto();
        crearCasillasDeVerificacion();
        crearListasDespegables();
    }
    
    private void crearPaneles() {
        //Paneles
        p1 = new JPanel();
        getContentPane().add(p1);//Agregamos el panel a la ventana
        p1.setLayout(null);//Desactivamos el layout default
        //p1.setBackground(Color.BLACK);
         
        }
    private void crearEtiquetas() {
        //Etiquetas
        //Las etiquetas puden ser texto o imagenes
        //Las siguientes dos lineas es una forma de hacerlo
        //String texto = "Aqui ponemos el texto.";
        //JLabel l1 = new JLabel(texto);//Creamos etiqueta de texto
        //Tambien se puede hacer lo siguiente //JLabel label = new JLabel("Aqui ponemos el texto.");
        
        //JLabel l1 = new JLabel(); este es un tipo de constructor
        JLabel l1 = new JLabel("Lion Heart", SwingConstants.CENTER);//este es otro tipo de constructor que define donde va a estar el texto 
        //en la etiqueta. puede ser: LEFT, CENTER, RIGHT, LEADING o TRAILING del parametro SwingConstants
        //l1.setHorizontalAlignment(SwingConstant); //Esta es otra forma de hacerlo
        //l1.setText("Hola."); //Este es otra forma de hacerlo.
        //Si no desactivamos el layout en el panel, la etiqueta aparece en el entro
        
        l1.setBounds(180, 10, 200, 40);//Si desactivamos el layout default ya podemos definir los bordes y posicion
        //l1.setForeground(Color.GREEN);
        //l1.setOpaque(true);//Quitamos la transparencia de la qtiqueta 
        //l1.setBackground(Color.white);//Le ponemos color de fondo a la etiqueta
        
        
        l1.setFont( new Font("times new roman", Font.BOLD, 30));//Est sirve para modificar la fuente del texto. Primero hay que pasar los parametros de: nombre, estilo, y tamaño
        // en el segundo parametro: 1 = bold, 2 = italic, 3 = bold & italic
        p1.add(l1);//Agregamos etiqueta al panel
        
        //JLabel l2 = new JLabel( new ImageIcon("unnamed.jpg")); //Esta es una manera de crear la etiqueta de imagen
        ImageIcon imagen = new ImageIcon("unnamed.jpg");
        JLabel l2 = new JLabel();
        l2.setBounds(90, 60, 400, 400);
        l2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));//cambiamos de tamaño la imagen
        //getScaledInstance(widht, height, hints); hints es el tipo de escalado
        // en el height y width se puede agarrar el de la etiqueta: l2.getwidth()
        p1.add(l2);
    }
    
    private void crearBotones(){
        JButton b1= new JButton();
        // con el constructor se le puede pasar como parametro una accion, texto, icono, o texto e icono O sin nada
        b1.setText("Click");//Tambien se puede hacer esto para establecer texto al boton
        b1.setEnabled(true);//Establece si la funcion del boton estan habilitadas o deshabilitada
        b1.setMnemonic('a');//Esto permite hacer "click" con el character indicado en el teclado: ejemplo alt + a
        b1.setBounds(200, 500, 100, 40);
        b1.setForeground(Color.red);//Establecemos el color de la fuente
        b1.setFont(new Font("cooper black", 0, 15));//Establecemos fuente, tipo y tamaño de text del boton
        b1.setBackground(Color.BLACK);//Establecemos color de fondo de boton. en algunas versiones antiguas de java hay que .setOpaque(true); antes de poder cambiar el color
        p1.add(b1);
        
       JButton b2 = new JButton();
       b2.setBounds(230, 550, 50,50);
       ImageIcon clickAqui = new ImageIcon("click.png");//guardamos nuestra imagen en un objeto tipo imagen-icono
       b2.setIcon(new ImageIcon (clickAqui.getImage().getScaledInstance(b2.getWidth(), b2.getHeight(), Image.SCALE_SMOOTH)));
       //en la linea de arriba ponemos la imagen en el boton y la re escalamos a el nuevo tamaño
       p1.add(b2);
    }
    
    private void crearRadioBotones(){
        JRadioButton rB1= new JRadioButton("Opcion 1", true);
        //el constructor puede incluir texto, icono, booleano, y otras variantes que se pueden ver en el api de Java y su documentacion
        rB1.setBounds(200, 600, 100, 50);
        p1.add(rB1);
        
        JRadioButton rB2= new JRadioButton("Opcion 2", false);
        rB2.setBounds(200, 630, 100, 50);
        p1.add(rB2);
        
        JRadioButton rB3= new JRadioButton("Opcion 3", false);
        rB3.setBounds(200, 660, 100, 50);
        p1.add(rB3);
        
        //Si lo dejamos solo así, se pudiera marcar los botones como opciones multiples, osea muchos a la misma vez
        ButtonGroup grupoRadioBotones = new ButtonGroup();//Creamos un grupo de radio botones para agruparlos
        //y los agregamos en las siguientes lineas
        grupoRadioBotones.add(rB1);
        grupoRadioBotones.add(rB2);
        grupoRadioBotones.add(rB3);
        //Esto hace que solo uno se pueda seleccionar a la misma vez / tambien podemos usar el metodo .setEnabled(booleano); para poner si esta disponible o no
        //Tambien se puede cambiar el texto del radio boton despues con el .setText(String); o .setFont(); esto y más se puede ver en la documentacion y el api de java
    }
    
    private void crearCajasDeTexto(){
        JTextField cDT1 = new JTextField();
        //Estas son cajas de texto de solo una linea / como parametro le podemos pasar texto, # de columnas, ambas, ninguna, etc.
        //no se puede usar el set bounds y el parametro de columnas juntos, ya que el parametros de columnas es como el width del textbox
        cDT1.setBounds(200, 700, 100, 30);
        //Estos textfields y textareas hacen uso de los metodos setter y getters, osea .setText(); .getText();
        p1.add(cDT1);
    }
    
    private void crearAreasDeTexto(){
        JTextArea aDT1 = new JTextArea();
        //Estos son areas de texto de varias lineas / los parametros que se pueden pasar son: documentos, string, rows, columns, etc. 
        aDT1.setBounds(140, 750, 300, 200);
        //puedes usar los metodos getter y setter, cambiar el background, foreground, font, etc.
        //lo que podemos usar en el are texto que no podemos usar el text field es el metodo append
        aDT1.setText("No se ven todos los componentes de esta ventana");
        aDT1.append("/nEdita el codigo para que se vean");//añade mas texto al area al final
        aDT1.setEditable(false);//Establecemos si el usuario puede editar el contenido del area de texto
        p1.add(aDT1);
    }
    
    private void crearCasillasDeVerificacion(){
        JCheckBox cB1 = new JCheckBox();
        //se puede inicializar sin nada, icono, booleano, string, accion, etc.
        //se pueden utilizar los setter y getters
        cB1.setBounds(200, 750, 100, 30);
        cB1.setText("Opcion 1");
        cB1.setSelected(true);
        //funciona similar a radio button la diferencia principal es que checkbox esta hecho para seleccion multiple y el radio button esta hecho para solo seleccionar una opcion
        p1.add(cB1);
    }
    
    private void crearListasDespegables(){
        String [] paises = {"Guatemala", "Israel", "Estados Unidos", "Rusia", "España"};//Creamos un array de String
        JComboBox lD1 = new JComboBox(paises);//como parametro se le puede dejar vacio, pasar un vector, o un array de items
        lD1.setBounds(200, 750, 100, 30);
        lD1.addItem("Alemania");//agregamos objetos al combo box
        //en el combo box la primera opcion va a ser el primer item en el arreglo
        lD1.setSelectedItem("Israel");//Selecciona el primer objeto visto
        p1.add(lD1);
    }
    
}
