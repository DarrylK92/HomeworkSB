package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class MainController {
	private String[] flagTitles = {"US", "Spain", "Iceland", "Italy", "India"};
	private ImageView [] imgViews = {new ImageView("us.gif"), new ImageView("spain.gif"),
			new ImageView("iceland.gif"), new ImageView("italy.gif"), new ImageView("india.gif")};
	
	@FXML
	private BorderPane pane;
	
	@FXML
	private ScrollPane scrollPane;
	
	@FXML
	private ListView<String> lv;
	ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
	
	@FXML
	private FlowPane imagePane;
	
	@FXML
	public void initialize() {
		lv.setItems(items);
    }
	
	public void select() {
		lv.setItems(items);
		imagePane.getChildren().clear();
		for (int i = 0; i < lv.getSelectionModel().getSelectedIndices().size(); i++) {
			imagePane.getChildren().add(imgViews[(int) lv.getSelectionModel().getSelectedIndices().get(i)]);
		}
	}
}
