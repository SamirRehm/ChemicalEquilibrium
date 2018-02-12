package chemistry;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Data {
    private static int reactantCounter = 1;
    private static ObservableList<Chemistry.Reaction> data = FXCollections.observableArrayList(new Chemistry.Reaction());
    public static ObservableList<Chemistry.Reaction> getData() {
        return data;
    }
    
        public static TableColumn createReactantColumn(TableColumn reactantsColumn) {
        getData().get(0).reactantsList.add(new SimpleStringProperty(""));
        TableColumn<Chemistry.Reaction, String> Reactants2Column = new TableColumn<>("Reactant " + reactantCounter);
        Reactants2Column.setMinWidth(100);
        Reactants2Column.setCellValueFactory(new PropertyValueFactory<>("reactant" + reactantCounter));
        Reactants2Column.setCellFactory(TextFieldTableCell.<Chemistry.Reaction>forTableColumn());
        int i = reactantCounter++;
        Reactants2Column.setOnEditCommit((TableColumn.CellEditEvent<Chemistry.Reaction, String> t) -> {
                ((Chemistry.Reaction) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setReactant(t.getNewValue(), i);});
        return Reactants2Column;
    }
}