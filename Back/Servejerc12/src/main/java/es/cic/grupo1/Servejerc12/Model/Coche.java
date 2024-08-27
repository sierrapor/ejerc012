package es.cic.grupo1.Servejerc12.Model;

public class Coche {
    private Long id;
    private String modelo;
    private int anio;
    private Fabricante fabricante;

    public Coche() {
    }

    public Coche(Long id, String modelo, int anio, Fabricante fabricante) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
        this.fabricante = fabricante;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getanio() {
        return anio;
    }

    public void setanio(int anio) {
        this.anio = anio;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}