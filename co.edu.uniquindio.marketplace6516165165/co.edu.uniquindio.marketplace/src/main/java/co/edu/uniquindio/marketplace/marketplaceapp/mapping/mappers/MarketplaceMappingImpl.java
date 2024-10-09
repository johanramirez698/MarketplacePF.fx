package co.edu.uniquindio.marketplace.marketplaceapp.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.marketplaceapp.service.iMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements iMarketplaceMapping {


    public List<VendedorDto> getVendedoresDto (List <Vendedor> listaVendedores) {
        if (listaVendedores == null) {
            return null;
        }
        List<VendedorDto> listaVendedoresDto = new ArrayList<VendedorDto>(listaVendedores.size());
        for (Vendedor vendedor : listaVendedores) {
            listaVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }
        return listaVendedoresDto;
    }


    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContrasena());
        
    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellidos(vendedorDto.apellidos())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .usuario(vendedorDto.usuario())
                .contrasena(vendedorDto.contrasena())
                .build();
    }
}
