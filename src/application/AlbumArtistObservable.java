package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ObservableValue;

public class AlbumArtistObservable {
	private List<AlbumArtistObserver> observers;
	
	public AlbumArtistObservable() {
		this.observers = new ArrayList<>();
	}
	
	public void addObserver(AlbumArtistObserver observer) {
		this.observers.add(observer);
	}
	
	public void notifyObservers(ObservableValue<? extends AlbumArtist> arg0,
			AlbumArtist arg1, 
			AlbumArtist arg2) {
		for (AlbumArtistObserver observer: this.observers) {
			observer.notifyObserver(arg0, arg1, arg2);
		}
	}
	
	
}
