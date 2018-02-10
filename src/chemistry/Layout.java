/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemistry;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Samir Rehmtulla
 */
public class Layout {
    
    public static void setStage(Stage stage) {
        stage.setTitle("Chemical Equilibrium");
        stage.setWidth(450);
        stage.setHeight(550);
    }
    
    public static Label setLabel() {
        final Label label = new Label("Chemical Equilibrium");
        label.setFont(new Font("Arial", 20));
        return label;
    }
    
    public static TableColumn initializeReactantsColumn() {
        TableColumn<Chemistry.Reaction, String> ReactantsColumn = new TableColumn<>("Reactants");
        ReactantsColumn.setMinWidth(100);
        return ReactantsColumn;
    }
    
    public static TableColumn initializeArrowColumn() {
        TableColumn<Chemistry.Reaction, String> arrowColumn = new TableColumn<>("⇌");
        arrowColumn.setMinWidth(100);
        return arrowColumn;
    }
    
    public static TableColumn initializeProductsColumn() {
        TableColumn<Chemistry.Reaction, String> ProductsColumn = new TableColumn<>("Products");
        ProductsColumn.setMinWidth(100);
        return ProductsColumn;
    }
}
