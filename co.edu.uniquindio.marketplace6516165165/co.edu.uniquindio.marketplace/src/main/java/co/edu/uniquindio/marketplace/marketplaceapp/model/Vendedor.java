package co.edu.uniquindio.marketplace.marketplaceapp.model;



import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
    private Muro muro;
    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private String usuario;
    private String contrasena;
    List<Producto> listaProductos=new ArrayList<>();
    List<Vendedor> listaVendedores=new ArrayList<>();
    List<Vendedor> listaVendedoresAliados=new ArrayList<>();

    public static VendedorBuilder builder(){
        return new VendedorBuilder();
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public List<Vendedor> getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    public Muro getMuro() {
        return muro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "apellidos='" + apellido + '\'' +
                ", muro=" + muro +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cedula='" + cedula + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '}';

    }

    public Vendedor(String apellido, String cedula, String contrasena, String direccion, List<Producto> listaProductos, List<Vendedor> listaVendedores, List<Vendedor> listaVendedoresAliados, Muro muro, String nombre, String usuario) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.listaProductos = listaProductos;
        this.listaVendedores = listaVendedores;
        this.listaVendedoresAliados = listaVendedoresAliados;
        this.muro = muro;
        this.nombre = nombre;
        this.usuario = usuario;
    }
}
