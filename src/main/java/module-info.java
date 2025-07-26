module com.truco {
   // requires javafx.controls;
   // requires javafx.fxml;
  requires static lombok;
  requires java.rmi;

    exports com.truco;
  exports com.truco.service;  
  exports com.truco.model; 
  
  opens com.truco to javafx.fxml;
  opens com.truco.service;


}
