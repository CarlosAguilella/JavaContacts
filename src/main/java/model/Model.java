package model;

import controller.AgendaDTO;
import controller.ModificacionContactoDTO;
import controller.NuevoContactoDTO;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Agenda> agendas = new ArrayList<>();

    public void guardarContacto(NuevoContactoDTO datos) {
        datos.nombre=datos.nombre.substring(0,1).toUpperCase()+datos.nombre.substring(1).toLowerCase();
        agendas.get(datos.numeroAgenda).contactos.add(new Contacto(datos.nombre, datos.telefono));
    }


    public List<Contacto> dameLaListaDeContactos(int numeroAgenda) {
        return agendas.get(numeroAgenda).contactos;
    }

    public void crearAgenda(AgendaDTO datos) {
        Agenda agendaNueva = new Agenda(datos.nombre, datos.descripcion);
        agendas.add(agendaNueva);
    }

    public List<Agenda> dameLaListaDeAgendas() {
        return agendas;
    }

    public List<Contacto> buscarContactosConQuery(String q) {
        List<Contacto> encontrados = new ArrayList<>();
        for (Agenda agenda : agendas){
            for (Contacto contacto : agenda.contactos){
                if (contacto.nombre.toLowerCase().contains(q.toLowerCase())) {
                    encontrados.add(contacto);
                }
            }
        }
        return encontrados;
    }

    public Contacto buscarContactoConQuery(String q) {
        for (Agenda agenda : agendas){
            for (Contacto contacto : agenda.contactos){
                if (contacto.nombre.toLowerCase().contains(q.toLowerCase())) {
                    return contacto;
                }
            }
        }
        return null;
    }

    public void modificarContactosConMod(Contacto original, ModificacionContactoDTO datos) {
        original.nombre = datos.nombre;
        original.telefono = datos.telefono;
    }
    public void eliminarAgenda(String eliminado){
        agendas.removeIf(agenda -> eliminado.toLowerCase().equals(agenda.nom.toLowerCase()));
    }

    public void eliminarContacto(String a) {
        for (Agenda agenda : agendas){
            agenda.contactos.removeIf(contacto -> contacto.nombre.toLowerCase().equals(a.toLowerCase()));
        }
    }
}
