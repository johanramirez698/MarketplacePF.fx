package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;

import java.util.List;

public class VendedorController {
    ModelFactory modelFactory;
    public VendedorController() {
        modelFactory = ModelFactory.getInstancia();
    }

    public List<VendedorDto> obtenerVendedores() {
        return modelFactory.obtenerVendedores();
    }

    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return modelFactory.agregarVendedor(vendedorDto);
    }

    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }

    public boolean actualizarVendedor(String cedula, VendedorDto vendedorDto) {return modelFactory.actualizarVendedor(cedula, vendedorDto);}




}
