package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class AlbumArtistDetailsModel {
		
	//private ObservableValue<AlbumArtist> albumArtist;
	private StringProperty album;
	private StringProperty artist;
	
	public AlbumArtistDetailsModel() {
		this.album = new SimpleStringProperty();
		this.artist = new SimpleStringProperty();
	}
	
	public StringProperty albumProperty() {
		return this.album;
	}
	
	public String getAlbum() {
		return this.album.getValue();
	}
	
	public void setAlbum(String album) {
		this.album.setValue(album);
	}
	
	public StringProperty artistProperty() {
		return this.artist;
	}
	
	public String getArtist() {
		return this.artist.getValue();
	}
	
	public void setArtist(String artist) {
		this.artist.setValue(artist);
	}
	
}
