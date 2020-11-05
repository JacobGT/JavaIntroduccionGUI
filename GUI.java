package gui;


public class GUI {

    
    public static void main(String[] args) {
        Ventana v1 = new Ventana(); //Instanciamos un objeto ventana
        v1.setVisible(false);// Lo hacemos visible
        
        ActionListeners aL1 = new ActionListeners(); //Instanciamos el objeto ActionListeners
        aL1.setVisible(true);//lo hacemos visible
    }
    
}
