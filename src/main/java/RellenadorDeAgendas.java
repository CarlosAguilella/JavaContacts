import model.Agenda;
import model.Contacto;

import java.util.List;

public class RellenadorDeAgendas {
    void rellenar(List<Agenda> agendaList) {
        Agenda agenda0 = new Agenda("Personal", "My personal contacts");
        Agenda agenda1 = new Agenda("Work", "My work contacts");
        Agenda agenda2 = new Agenda("Class", "My class contacts");
        Agenda agenda3 = new Agenda("Football", "My team contacts");

        Contacto contacto0 = new Contacto("Pepe", "632598741");
        Contacto contacto1 = new Contacto("Juan", "654987123");
        Contacto contacto2 = new Contacto("Luis", "639821457");
        Contacto contacto3 = new Contacto("Anna", "641235987");
        Contacto contacto4 = new Contacto("Alex", "689754123");
        Contacto contacto5 = new Contacto("Josep", "623159874");
        Contacto contacto6 = new Contacto("JP", "642983517");
        Contacto contacto7 = new Contacto("Gerard", "623155487");
        Contacto contacto8 = new Contacto("Manuel", "669988774");
        Contacto contacto9 = new Contacto("Maria", "632514789");
        Contacto contacto10 = new Contacto("Javier", "654321987");
        Contacto contacto11 = new Contacto("Rafael", "725631489");
        Contacto contacto12 = new Contacto("Andres", "785463219");
        Contacto contacto13 = new Contacto("Pedro", "778896352");
        Contacto contacto14 = new Contacto("Dani", "789654321");
        Contacto contacto15 = new Contacto("Fran", "712345689");

        agenda0.contactos.add(contacto0);
        agenda0.contactos.add(contacto1);
        agenda0.contactos.add(contacto2);
        agenda0.contactos.add(contacto4);
        agenda0.contactos.add(contacto6);
        agenda0.contactos.add(contacto8);

        agenda1.contactos.add(contacto11);
        agenda1.contactos.add(contacto13);
        agenda1.contactos.add(contacto15);
        agenda1.contactos.add(contacto11);
        agenda1.contactos.add(contacto10);

        agenda2.contactos.add(contacto10);
        agenda2.contactos.add(contacto12);
        agenda2.contactos.add(contacto14);

        agenda3.contactos.add(contacto2);
        agenda3.contactos.add(contacto3);
        agenda3.contactos.add(contacto5);
        agenda3.contactos.add(contacto7);
        agenda3.contactos.add(contacto9);

        agendaList.add(agenda0);
        agendaList.add(agenda1);
        agendaList.add(agenda2);
        agendaList.add(agenda3);

    }
}
