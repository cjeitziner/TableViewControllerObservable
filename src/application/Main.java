package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Sqlite Tableview sample");
			primaryStage.setWidth(800);
			primaryStage.setHeight(800);

			final AlbumArtistObservable albumArtistObservable = new AlbumArtistObservable();			
			
			final AlbumArtistModel model = new AlbumArtistModel();
			final AlbumArtistView view = new AlbumArtistView("Albums");
			final AlbumArtistController controller = new AlbumArtistController(model,
					                     view,
					                     albumArtistObservable);

			controller.loadAlbumArtistView();

			final AlbumArtistDetailsModel modelDetails = new AlbumArtistDetailsModel();
			final AlbumArtistDetailsView viewDetails = new AlbumArtistDetailsView("Details");
			final AlbumArtistDetailsController controllerDetails = new AlbumArtistDetailsController(modelDetails, viewDetails);
			controllerDetails.connect();

			final AlbumArtistDetailsModel modelDetails2 = new AlbumArtistDetailsModel();
			final AlbumArtistDetailsView viewDetails2 = new AlbumArtistDetailsView("Details2");
			final AlbumArtistDetailsController controllerDetails2 = new AlbumArtistDetailsController(modelDetails2, viewDetails2);
			controllerDetails2.connect();
						
			albumArtistObservable.addObserver(controllerDetails);
			albumArtistObservable.addObserver(controllerDetails2);
			
			SplitPane splitPane = new SplitPane();
			splitPane.setOrientation(Orientation.HORIZONTAL);
			
			SplitPane subSplitPane = new SplitPane();
			subSplitPane.setOrientation(Orientation.VERTICAL);
			subSplitPane.getItems().addAll(viewDetails.getPane(), viewDetails2.getPane());
			
			splitPane.getItems().addAll(view.getPane(), subSplitPane);

			Scene scene = new Scene(splitPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
