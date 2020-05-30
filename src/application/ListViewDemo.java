package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application{
	
	private String[] flagTitles = {"US", "Spain", "Iceland", "Italy", "India"};
	private ImageView [] imgViews = {new ImageView("us.gif"), new ImageView("spain.gif"),
			new ImageView("iceland.gif"), new ImageView("italy.gif"), new ImageView("india.gif")};
	@Override
	public void start(Stage stage) throws Exception {
		ListView<String> lv = new ListView<String>(FXCollections.observableArrayList(flagTitles));
		lv.setPrefSize(400, 400);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		FlowPane imagePane = new FlowPane(10, 10);
		
		//event handling
		lv.getSelectionModel().selectedItemProperty().addListener(e -> {
			imagePane.getChildren().clear();
			for (int i = 0; i < lv.getSelectionModel().getSelectedIndices().size(); i++) {
				imagePane.getChildren().add(imgViews[lv.getSelectionModel().getSelectedIndices().get(i)]);
			}
		});
		
		//Scene
		BorderPane pane = new BorderPane();
		pane.setLeft(new ScrollPane(lv));
		pane.setRight(imagePane);
		Scene scene = new Scene(pane, 450, 170);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
