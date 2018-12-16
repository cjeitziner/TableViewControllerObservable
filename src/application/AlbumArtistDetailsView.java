package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AlbumArtistDetailsView {
	private final Label title;
	private final Label album;
	private final Label artist;

	public AlbumArtistDetailsView(String title) {
		this.title = new Label(title);
		this.album = new Label();
		this.artist = new Label();
	}
	
	public Pane getPane() {
		final VBox vBox = new VBox();
		vBox.setSpacing(5);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		
		final HBox artistBox = new HBox();
		artistBox.getChildren().addAll(new Label("Artist: "), this.artist);
		
		final HBox albumBox = new HBox();
		albumBox.getChildren().addAll(new Label("Album: "), this.album);
				
		vBox.getChildren().addAll(this.title, artistBox, albumBox);
		return vBox;
	}
		
	public Label getAlbum() {
		return this.album;
	}

	public Label getArtist() {
		return this.artist;
	}

}
