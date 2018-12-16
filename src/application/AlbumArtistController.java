package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

class AlbumArtistChangeListener implements ChangeListener<AlbumArtist> {
	private AlbumArtistObservable albumArtistObservable;

	public AlbumArtistChangeListener(AlbumArtistObservable albumArtistObservable) {
		this.albumArtistObservable = albumArtistObservable;
	}

	@Override
	public void changed(ObservableValue<? extends AlbumArtist> arg0,
			AlbumArtist arg1, 
			AlbumArtist arg2) {
		this.albumArtistObservable.notifyObservers(arg0, arg1, arg2);
	}
}

public class AlbumArtistController {
	private AlbumArtistModel model;
	private AlbumArtistView view;
	private AlbumArtistObservable albumArtistObservable;
	
	public AlbumArtistController(AlbumArtistModel model,
								 AlbumArtistView view,
								 AlbumArtistObservable albumArtistObservable) {
		this.model = model;
		this.view = view;
		this.albumArtistObservable = albumArtistObservable;
		
		this.view.connect(this.model.getData());
		setColumns();
		
		// Connect table with albumArtist Observable
		view.getTable().getSelectionModel().selectedItemProperty().addListener(new AlbumArtistChangeListener(this.albumArtistObservable));
				
		// Set Actions
		setActions();
	}
	
	void loadAlbumArtistView() {
		this.model.readSomeRecordsFromDb();
	}
	
	void loadNext() {
		this.model.next();
		loadAlbumArtistView();
	}
	
	void loadPrev() {
		this.model.prev();
		loadAlbumArtistView();
	}
	
	private void setColumns() {
		TableView<AlbumArtist> table = this.view.getTable();
		this.model.setColumns(table);		
	}
	
	private void setActions() {
		Button nextButton = this.view.getNextButton();		
		nextButton.setOnAction(event -> loadNext());

		Button prevButton = this.view.getPrevButton();
		prevButton.setOnAction(event-> loadPrev());
	}
	
	
		
}
