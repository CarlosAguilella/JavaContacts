package controller;

import model.Agenda;
import model.Contacto;
import model.Model;
import view.View;

import java.util.InputMismatchException;
import java.util.List;

public class Controller {
    View view = new View();
    public Model model = new Model();

    public void acorrer() {
        for (; ; ) {
            try {
                view.mostrarMenu();
                int opcion = view.pedirOpcion();
                if (opcion == 1) {

                    List<Agenda> todasLasAgendas = model.dameLaListaDeAgendas();
                    view.mostrarContactos(todasLasAgendas);

                } else if (opcion == 2) {
                    List<Agenda> agendaList = model.dameLaListaDeAgendas();
                    NuevoContactoDTO datos = view.pedirDatosContactoNuevo(agendaList);
                    model.guardarContacto(datos);

                } else if (opcion == 3) {
                    AgendaDTO datosAgenda = view.pedirNombreNuevaAgenda();

                    model.crearAgenda(datosAgenda);
                } else if (opcion == 4) {
                    List<Agenda> agendas = model.dameLaListaDeAgendas();

                    view.mostrarListaAgendas(agendas);
                } else if (opcion == 5) {
                    String q = view.pedirQueBusca();
                    List<Contacto> c = model.buscarContactosConQuery(q);
                    view.muestraContactos(c);

                } else if (opcion == 6) {

                    String nombreOriginal = view.pedirContactoAModificar();

                    Contacto contacto = model.buscarContactoConQuery(nombreOriginal);

                    view.muestraContacto(contacto);

                    ModificacionContactoDTO modificacionContactoDTO = view.pedirDatosAModificar();

                    model.modificarContactosConMod(contacto, modificacionContactoDTO);

                } else if (opcion == 7) {
                    String eliminado = view.eliminarAgenda();
                    model.eliminarAgenda(eliminado);
                } else if (opcion == 8) {
                    String contactoEliminado = view.eliminarContacto();
                    model.eliminarContacto(contactoEliminado);


                }else if (opcion == 9) {
                    view.cerrarApp();
                    break;

                } else if (opcion == 10) {
                    System.out.println("\uD83D\uDE13\uD83D\uDE13Lamentamos tener que decirle que esta opción todavía está en desarrollo\uD83D\uDE2A\uD83D\uDE2A");
                    System.out.println("Elige otra opción y disculpa las molestias.\uD83D\uDE4F\uD83D\uDE4F");

                } else {
                    System.out.println("Por favor elige una opcion valida...");
                }
            } catch (IndexOutOfBoundsException | InputMismatchException exception) {
                System.out.println("Error");
            }
        }
    }
}

