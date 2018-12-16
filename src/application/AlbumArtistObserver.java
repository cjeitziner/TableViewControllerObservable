package application;

import javafx.beans.value.ObservableValue;

public interface AlbumArtistObserver {
	void notifyObserver(ObservableValue<? extends AlbumArtist> arg0,
			AlbumArtist arg1, 
			AlbumArtist arg2);
}
