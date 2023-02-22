 import controller.Controller;

 public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();


        new RellenadorDeAgendas().rellenar(controller.model.agendas);
        
        controller.acorrer();
    }
}