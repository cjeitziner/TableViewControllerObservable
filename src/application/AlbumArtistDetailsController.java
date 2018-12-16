package application;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class AlbumArtistDetailsController implements AlbumArtistObserver {
	private AlbumArtistDetailsModel model;
	private AlbumArtistDetailsView view;
	
	public AlbumArtistDetailsController(AlbumArtistDetailsModel model,
			AlbumArtistDetailsView view) {
		this.model = model;
		this.view = view;
	}
	
	
	public void connect() {
		StringProperty album = this.model.albumProperty();
		this.view.getAlbum().textProperty().bind(album);

		StringProperty artist = this.model.artistProperty();
		this.view.getArtist().textProperty().bind(artist);
	}
	
	void updateDetails(AlbumArtist albumArtist) {
		System.out.println(String.format("Changed to: %s", albumArtist.getAlbumTitle()));
		this.model.setAlbum(albumArtist.getAlbumTitle());
		this.model.setArtist(albumArtist.getArtistName());
	}

	@Override
	public void notifyObserver(ObservableValue<? extends AlbumArtist> arg0, AlbumArtist arg1, AlbumArtist arg2) {
		updateDetails(arg2);		
	}
	
}
