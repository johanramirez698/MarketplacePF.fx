package co.edu.uniquindio.marketplace.marketplaceapp.factory;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.marketplaceapp.service.iMarketplaceMapping;
import co.edu.uniquindio.marketplace.marketplaceapp.service.iModelFactoryService;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements iModelFactoryService {
    private static ModelFactory modelFactory;
    private MarketplaceObjeto marketplaceObjeto;
    private iMarketplaceMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new MarketplaceMappingImpl();
        marketplaceObjeto= DataUtil.inicializarDatos();

    }


    @Override
    public List<VendedorDto> obtenerVendedores() {
        return mapper.getVendedoresDto(marketplaceObjeto.getListaVendedores());

    }

    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        Vendedor vendedor = mapper.vendedorDtoToVendedor(vendedorDto);
        return marketplaceObjeto.crearVendedor(vendedor);

    }

    public boolean eliminarVendedor(String cedula) {
        for (Vendedor vendedor : marketplaceObjeto.getListaVendedores()) {
            if (vendedor.getCedula().equals(cedula)) {
                marketplaceObjeto.getListaVendedores().remove(vendedor);
                return true; // Vendedor eliminado con éxito
            }
        }
        return false; // Vendedor no encontrado
    }

    public boolean actualizarVendedor(String cedula, VendedorDto vendedorActualizado) {
        for (int i = 0; i < marketplaceObjeto.getListaVendedores().size(); i++) {
            Vendedor vendedor = marketplaceObjeto.getListaVendedores().get(i);
            if (vendedor.getCedula().equals(cedula)) {
                // Crear un nuevo vendedor usando el builder con los datos actualizados
                Vendedor nuevoVendedor = new VendedorBuilder()
                        .nombre(vendedorActualizado.nombre())
                        .apellidos(vendedorActualizado.apellidos())
                        .direccion(vendedorActualizado.direccion())
                        .cedula(vendedorActualizado.cedula())
                        .usuario(vendedorActualizado.usuario())
                        .contrasena(vendedorActualizado.contrasena())
                        .listaProductos(vendedor.getListaProductos()) // si deseas mantener la lista de productos
                        .listaVendedores(vendedor.getListaVendedores()) // si deseas mantener la lista de vendedores
                        .listaVendedoresAliados(vendedor.getListaVendedoresAliados()) // si deseas mantener la lista de vendedores aliados
                        .muro(vendedor.getMuro()) // si deseas mantener el muro
                        .build();

                // Reemplazar el vendedor antiguo con el nuevo
                marketplaceObjeto.getListaVendedores().set(i, nuevoVendedor);
                return true; // Actualización exitosa
            }
        }
        return false; // Vendedor no encontrado
    }


}