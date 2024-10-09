package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

import java.util.List;
public interface iModelFactoryService {
    List<VendedorDto> obtenerVendedores();

    boolean agregarVendedor(VendedorDto vendedorDto);
}