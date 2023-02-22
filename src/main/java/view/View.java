package view;

import controller.AgendaDTO;
import controller.ModificacionContactoDTO;
import controller.NuevoContactoDTO;
import model.Agenda;
import model.Contacto;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    int screenSize = 70; //89?

    public void mostrarMenu() {
        System.out.println("\033[47m" +"\033[30m"+ StringUtils.center("\uD83C\uDF7D \uD83C\uDF71MENU\uD83C\uDF71 \uD83C\uDF7D", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       1\uFE0F⃣. \uD83D\uDD0Dver contactos\uD83D\uDD0D", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       2\uFE0F⃣. \uD83E\uDD75añadir contactos\uD83E\uDD75", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       3\uFE0F⃣. \uD83E\uDD1Dcrear agendas\uD83E\uDD1D", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       4\uFE0F⃣. \uD83D\uDD0Dver lista agendas\uD83D\uDD0D", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       5\uFE0F⃣. \uD83D\uDD0Dbuscar contacto\uD83D\uDD0D", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       6\uFE0F⃣. \uD83E\uDDD9\u200D♂\uFE0Fmodificar contacto\uD83E\uDDD9\u200D♂\uFE0F", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       7\uFE0F⃣. \uD83D\uDE35\u200D\uD83D\uDCABeliminar agenda\uD83D\uDE35\u200D\uD83D\uDCAB", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       8\uFE0F⃣. \uD83D\uDD1Celiminar contacto\uD83D\uDD1C", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       9\uFE0F⃣. ❌cerrar programa❌", screenSize) + "\033[0m");
        System.out.println("\033[45m" +"\033[30m"+ StringUtils.rightPad("       1\uFE0F⃣0\uFE0F⃣. ❌coming soon❌", screenSize) + "\033[0m");



    }

    public int pedirOpcion() {
        System.out.println("\033[42m" +"\033[30m"+ StringUtils.center("Opcion:", screenSize) + "\033[0m");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }


    public void mostrarContactos(List<Agenda> agendas) {
        System.out.println("\033[41m" +"\033[30m"+ StringUtils.center("LISTA DE CONTACTOS", screenSize) + "\033[0m");


        for (Agenda agenda : agendas) {
            System.out.println("\033[0m" +"\033[30m"+ StringUtils.center(agenda.nom, screenSize) + "\033[0m");

            for (Contacto contacto : agenda.contactos) {
                System.out.println(
                        "\033[42m" +"\033[30m"+
                        StringUtils.leftPad("->->->->->->->->Nombre:   " +
                                        StringUtils.rightPad(contacto.nombre, 12) +
                                        "-------Telf:  " +
                                        StringUtils.rightPad(contacto.telefono, 12) +
                                        "<-<-<-<-<-<-<-<-" ,
                                screenSize) +
                        "\033[0m"
                );
            }
        }
    }

    public AgendaDTO pedirNombreNuevaAgenda() {
        System.out.println("\033[46m" +"\033[30m"+ "Introduce el nombre de la agenda que quieres crear" + "\033[0m");

        String nombreAgenda = scanner.nextLine();

        System.out.println("\033[45m" +"\033[30m"+ "Introduce la descripcion de la agenda que quieres crear" + "\033[0m");

        String descripcionAgenda = scanner.nextLine();

        return new AgendaDTO(nombreAgenda, descripcionAgenda);
    }

    public NuevoContactoDTO pedirDatosContactoNuevo(List<Agenda> llistaAgendesQueTe) {
        System.out.println("\033[43m" +"\033[30m"+ "A que agenda quieres añadir el contacto? (0,  1,  2,  etc.)" + "\033[0m");

        llistaAgendesQueTe.forEach(agenda -> System.out.println("\033[45m" + agenda.nom + "\033[0m"));
        System.out.println("\033[43m" +"\033[30m"+ "introduzca los numeros de agenda..." + "\033[0m");
        int numeroAgenda = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\033[43m" +"\033[30m"+ "introduzca nombre:" + "\033[0m");
        String nombre = scanner.nextLine();
        System.out.println("\033[43m" +"\033[30m"+ "introduzca telefono: " + "\033[0m");
        String telefono = scanner.nextLine();
        return new NuevoContactoDTO(numeroAgenda, nombre, telefono);
    }

    public void mostrarListaAgendas(List<Agenda> agendas) {
        System.out.println("\033[43m" +"\033[30m"+ "ESTAS SON TUS AGENDAS" + "\033[0m");

        agendas.forEach(agenda -> System.out.println("\033[45m" +"\033[30m"+ agenda.nom + " " + "\033[51m" + "(" + agenda.contactos.size() + ")" + "\033[0m"));
    }

    public String pedirQueBusca() {
        System.out.println("Que quieres buscar?");
        String query = scanner.nextLine();
        return query;
    }

    public void muestraContactos(List<Contacto> contactos) {
        if (contactos.isEmpty()) {
            System.out.println("No se encontraron contactos");
        } else {
            for (Contacto contacto : contactos){
                System.out.println(contacto.nombre + " : " + contacto.telefono);
            }
        }
    }

    public String pedirContactoAModificar() {
        System.out.println("Que contacto quieres modificar?");
        String mod = scanner.nextLine();
        return mod;
    }

    public ModificacionContactoDTO pedirDatosAModificar() {
        System.out.println("Pon el nuevo nombre del contacto");
        String nombre = scanner.nextLine();
        System.out.println("Pon el nuevo telefono del contacto");
        String telefono = scanner.nextLine();
        return new ModificacionContactoDTO(nombre, telefono);
    }

    public void muestraContacto(Contacto contacto) {

    }

    public String eliminarAgenda() {
        String nombreAgenda = scanner.nextLine();
        return nombreAgenda;
    }

    public String eliminarContacto() {
        String nombreContactoAEliminar = scanner.nextLine();
        return nombreContactoAEliminar;

    }
}