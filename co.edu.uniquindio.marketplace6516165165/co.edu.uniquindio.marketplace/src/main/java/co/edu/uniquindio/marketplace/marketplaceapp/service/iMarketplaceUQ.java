package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

import java.util.List;

public interface iMarketplaceUQ {
    boolean crearVendedor(String nombre, String apellidos, String direccion, String cedula, String usuario, String contrasena);
    void eliminarVendedor(String cedula);
    void eliminarVendedor(String cedula, String usuario);
    List<Vendedor> obtenerVendedores();
    Vendedor obtenerVendedor(String cedula);
    void mostrarInformacionVendedores();
    void buscarVendedor(String cedula);
    boolean actualizarVendedor(String nombre, String apellidos, String direccion, String cedula, String usuario, String contrasena);
}
