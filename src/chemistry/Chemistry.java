package chemistry;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Chemistry extends Application {
 
    private int reactantCounter = 1;
    private int productCounter = 1;
    private final TableView<Reaction> table = new TableView<>();
    private final ObservableList<Reaction> data = FXCollections.observableArrayList(new Reaction());
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
    
    private TableColumn createReactantColumn(TableColumn reactantsColumn) {
        data.get(0).reactantsList.add(new SimpleStringProperty(""));
        TableColumn<Reaction, String> Reactants2Column = new TableColumn<>("Reactant " + reactantCounter);
        Reactants2Column.setMinWidth(100);
        Reactants2Column.setCellValueFactory(new PropertyValueFactory<>("reactant" + reactantCounter));
        Reactants2Column.setCellFactory(TextFieldTableCell.<Reaction>forTableColumn());
        int i = reactantCounter;
        System.out.println("HELLO");
        Reactants2Column.setOnEditCommit(
            (CellEditEvent<Reaction, String> t) -> {
                ((Reaction) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setReactant(t.getNewValue(), i);
        });
        reactantCounter++;
        return Reactants2Column;
    }
    
        private TableColumn createProductColumn(TableColumn reactantsColumn) {
        data.get(0).productsList.add(new SimpleStringProperty(""));
        TableColumn<Reaction, String> Reactants2Column = new TableColumn<>("Product " + productCounter);
        Reactants2Column.setMinWidth(100);
        Reactants2Column.setCellValueFactory(new PropertyValueFactory<>("product" + productCounter));
        Reactants2Column.setCellFactory(TextFieldTableCell.<Reaction>forTableColumn());
        int i = productCounter;
        Reactants2Column.setOnEditCommit(
            (CellEditEvent<Reaction, String> t) -> {
                ((Reaction) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setProduct(t.getNewValue(), i);
        });
        productCounter++;
        return Reactants2Column;
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        Layout.setStage(stage);
        final Label label = Layout.setLabel();
 
        table.setEditable(true);
        
        TableColumn<Reaction, String> ReactantsColumn = Layout.initializeReactantsColumn();
        TableColumn<Reaction, String> arrowColumn = Layout.initializeArrowColumn();
        TableColumn<Reaction, String> ProductsColumn = Layout.initializeProductsColumn();
            TableColumn nReactant = createReactantColumn(ReactantsColumn);
            ReactantsColumn.getColumns().add(nReactant);
        
        TableColumn nProduct = createProductColumn(ProductsColumn);
        ProductsColumn.getColumns().add(nProduct);
 
        table.setItems(data);
        table.getColumns().addAll(ReactantsColumn, arrowColumn, ProductsColumn);
 
        final Button addButton = new Button("Add Reactant");
        addButton.setOnAction((ActionEvent e) -> {
            System.out.println("reactantadd");
            TableColumn newReactant = createReactantColumn(ReactantsColumn);
            ReactantsColumn.getColumns().add(newReactant);
        });
        
        final Button addButton2 = new Button("Add Product");
        addButton2.setOnAction((ActionEvent e) -> {
            TableColumn newReactant = createProductColumn(ProductsColumn);
            ProductsColumn.getColumns().add(newReactant);
        });
 
        hb.getChildren().addAll(addButton, addButton2);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static class Reaction {
 
        private List<SimpleStringProperty> reactantsList;
        private List<SimpleStringProperty> productsList;
 
        private Reaction() {
            this.reactantsList = new LinkedList<>();
            this.reactantsList.add(new SimpleStringProperty(""));
            this.productsList = new LinkedList<>();
            this.productsList.add(new SimpleStringProperty(""));
        }
 
        public String getReactant1() {
            return reactantsList.get(0).get();
        }

        public void setReactant(String name, int number) {
            reactantsList.get(number-1).set(name);
        }
 
        public String getReactant2() {
            return reactantsList.get(1).get();
        }
 
        public String getProduct1() {
            return productsList.get(0).get();
        }
 
        public void setProduct(String fName, int number) {
            productsList.get(number-1).set(fName);
        }
    }
}