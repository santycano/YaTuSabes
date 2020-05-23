package co.edu.udea.Schema;

public class ClientData {
    private String nit;
    private String name;
    private String addres;

    public ClientData(String nit, String name, String addres) {
        this.nit = nit;
        this.name = name;
        this.addres = addres;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
