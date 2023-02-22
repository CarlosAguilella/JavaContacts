package controller;

public class NuevoContactoDTO {
    public int numeroAgenda;
    public String nombre;
    public String telefono;

    public NuevoContactoDTO(int numeroAgenda, String nombre, String telefono) {
        this.numeroAgenda = numeroAgenda;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
