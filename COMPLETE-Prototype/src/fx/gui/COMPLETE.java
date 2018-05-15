package fx.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class COMPLETE extends Application {


	private static final Border DEFAULT_BORDER = 
			new Border(
					new BorderStroke(
							Color.DIMGRAY,
							BorderStrokeStyle.SOLID,
							new CornerRadii(1.0),null
					));

	public static void main(String[] args)  {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("COMPLETE - Tauschbörse");
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(800);
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(800);
				
		//Top Part
		Pane banner = createTextBanner("COMPLETE - Tauschbörse", 800, 50);
		BorderPane rootPane = new BorderPane();
		rootPane.setTop(banner);
		rootPane.setBorder(DEFAULT_BORDER);
		
		//Navigation pane
		BorderPane contPane = new MainPane();
		HBox.setHgrow(contPane, Priority.ALWAYS);
		rootPane.setCenter(contPane);
		
		Scene scene = new Scene(rootPane);
		
		BorderPane mainContent = new BorderPane();
		mainContent.setTop(new MainPane());
				
		primaryStage.setScene(scene);
		
		
		primaryStage.show(); 
	}

	private Pane createTextBanner(String text, int width, int height) {
		Pane p = new VBox();
		p.minHeight(30);
		p.maxHeight(50);
		p.setBorder(DEFAULT_BORDER);
		
		Label l1 = new Label(text);
		l1.setFont(new Font("Arial",20));
		
		p.getChildren().add(l1);
		return p;
	}
}
