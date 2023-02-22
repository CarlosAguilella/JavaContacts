package model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    public String nom;
    public String descripcion;
    public List<Contacto> contactos;


    public Agenda(String nom, String descripcion) {
        this.nom = nom;
        this.descripcion = descripcion;
        this.contactos = new ArrayList<>();
    }

}