package gui;


public class GUI {

    
    public static void main(String[] args) {
        Ventana v1 = new Ventana(); //Instanciamos un objeto ventana
        v1.setVisible(false);// Lo hacemos visible
        
        Welcome bienvenido = new Welcome();
        //bienvenido.show();
        
        FrmCalculadora calc = new FrmCalculadora();
        calc.setLocation(1300, 350);
        //calc.show();
        
        ActionListeners aL1 = new ActionListeners();
        aL1.setVisible(true);
    }
    
}
