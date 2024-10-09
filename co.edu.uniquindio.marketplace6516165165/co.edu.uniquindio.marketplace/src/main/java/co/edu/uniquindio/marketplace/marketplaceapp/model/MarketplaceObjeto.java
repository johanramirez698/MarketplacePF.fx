package co.edu.uniquindio.marketplace.marketplaceapp.model;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceObjeto {

    private String nombre;
    List<Producto> listaProductos=new ArrayList<>();
    List<Vendedor> listaVendedores=new ArrayList<>();
    List<Publicacion> listaPublicaciones= new ArrayList<>();
    List<Mensaje> listaMensajes=new ArrayList<>();
    List<Comentario> listaComentarios=new ArrayList<>();

    public MarketplaceObjeto() {
    }

    public boolean crearVendedor(String nombre,String apellidos, String direccion, String cedula, String usuario, String contrasena) {
        Vendedor vendedorEncontrado= obtenerVendedor(cedula);
        if (vendedorEncontrado == null) {
            Vendedor vendedor = getBuildVendedor(nombre, apellidos, direccion, cedula, usuario, contrasena);
            getListaVendedores().add(vendedor);
            return true;
        }else{
            return false;
        }
    }

    public boolean crearVendedor(Vendedor nuevoVendedor) {
        Vendedor vendedorEcontrado=obtenerVendedor(nuevoVendedor.getCedula());
        if (vendedorEcontrado == null) {
            getListaVendedores().add(nuevoVendedor);
            return true;
        }else{
            return false;
        }
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    private Vendedor getBuildVendedor(String nombre, String apellidos, String direccion, String cedula, String usuario, String contrasena){
        return Vendedor.builder()
                .nombre(nombre)
                .apellidos(apellidos)
                .cedula(cedula)
                .direccion(direccion)
                .usuario(usuario)
                .contrasena(contrasena)
                .build();
    }

    private Vendedor obtenerVendedor(String cedula) {
        Vendedor vendedor=null;
        for (Vendedor vendedor1: getListaVendedores()) {
            if (vendedor1.getCedula().equals(cedula)) {
                vendedor = vendedor1;
                break;
            }
        }
        return vendedor;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }
}
