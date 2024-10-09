module co.edu.uniquindio.marketplace.marketplaceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.marketplace.marketplaceapp to javafx.fxml;
    exports co.edu.uniquindio.marketplace.marketplaceapp;

    exports co.edu.uniquindio.marketplace.marketplaceapp.controller;
    opens co.edu.uniquindio.marketplace.marketplaceapp.controller;

    exports co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;
    opens co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;
}