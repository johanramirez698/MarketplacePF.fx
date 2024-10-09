package co.edu.uniquindio.marketplace.marketplaceapp.model.builder;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Muro;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorBuilder {
    protected Muro muro;
    protected String nombre;
    protected String apellidos;
    protected String direccion;
    protected String cedula;
    protected String usuario;
    protected String contrasena;
   protected List<Producto> listaProductos=new ArrayList<>();
    protected List<Vendedor> listaVendedores=new ArrayList<>();
    protected List<Vendedor> listaVendedoresAliados=new ArrayList<>();

    public VendedorBuilder muro(Muro muro) {
        this.muro = muro;
        return this;
    }

    public VendedorBuilder nombre(String nombre) {
    this.nombre = nombre;
    return this;
    }
    public VendedorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }
    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }
    public VendedorBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }
    public VendedorBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }
    public VendedorBuilder listaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        return this;
    }
    public VendedorBuilder listaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
        return this;
    }
    public VendedorBuilder listaVendedoresAliados(List<Vendedor> listaVendedoresAliados) {
        this.listaVendedoresAliados = listaVendedoresAliados;
        return this;
    }
    public Vendedor build() {
        return new Vendedor(apellidos,cedula,contrasena,direccion,listaProductos,listaVendedores,listaVendedoresAliados,muro,nombre,usuario);
    }
}

