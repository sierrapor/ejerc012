package es.cic.grupo1.Servejerc12.Model;

import java.util.List;

public class Fabricante {
    private Long id;
    private String nombre;
    private List<Coche> coches;

    public Fabricante() {
    }

    public Fabricante(Long id, String nombre, List<Coche> coches) {
        this.id = id;
        this.nombre = nombre;
        this.coches = coches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}