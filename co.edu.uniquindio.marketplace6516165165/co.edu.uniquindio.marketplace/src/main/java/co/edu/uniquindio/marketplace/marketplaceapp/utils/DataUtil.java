package co.edu.uniquindio.marketplace.marketplaceapp.utils;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Marketplace;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

public class DataUtil {
    public static MarketplaceObjeto inicializarDatos(){
        MarketplaceObjeto marketplaceObjeto= new MarketplaceObjeto();
        Vendedor vendedor = Vendedor.builder()
                .apellidos("Perilla")
                .cedula("111701535")
                .direccion("13 CON 14 wallstreet")
                .nombre("Betancur Jhonata")
                .usuario("XXTENACIONXX")
                .contrasena("BCSPN")
                .build();
        marketplaceObjeto.getListaVendedores().add(vendedor);

        return marketplaceObjeto;
    }
}
