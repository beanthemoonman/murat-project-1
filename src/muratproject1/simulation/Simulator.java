package muratproject1.simulation;

import java.util.ArrayList;

import muratproject1.people.Store;
import muratproject1.products.Movie;
import muratproject1.products.types.Comedy;
import muratproject1.products.types.Drama;
import muratproject1.products.types.Horror;
import muratproject1.products.types.NewRelease;
import muratproject1.products.types.Romance;

public class Simulator {
	
	public Simulator(){
		
	}
	
	public Report runSimulation(int days){
		
		//initialize report
		Report report = new Report();
		
		// initialize a list of RentalReturnEvents that will track each return to be used when generating the Report.
		ArrayList<RentalReturnEvent> rentalReturnEvents = new ArrayList<RentalReturnEvent>();
		
		//initialize the movies with the video store inventory
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		// Add 4 Comedy Movies
		movies.add(new Movie("Airplane!", new Comedy()));
		movies.add(new Movie("Back to the Future", new Comedy()));
		movies.add(new Movie("Monty Python and the Holy Grail", new Comedy()));
		movies.add(new Movie("Pineapple Express", new Comedy()));
		
		// Add 4 Drama Movies
		movies.add(new Movie("The Shawshank Redemption", new Drama()));
		movies.add(new Movie("The Godfather", new Drama()));
		movies.add(new Movie("The Godfather: Part II", new Drama()));
		movies.add(new Movie("The Godfather: Part III", new Drama()));
		
		// Add 4 Horror Movies
		movies.add(new Movie("The Hills Have Eyes", new Horror()));
		movies.add(new Movie("The Thing", new Horror()));
		movies.add(new Movie("The Exorcist", new Horror()));
		movies.add(new Movie("Dawn of the Dead", new Horror()));
		
		// Add 4 New Release Movies
		movies.add(new Movie("The LEGO Batman Movie", new NewRelease()));
		movies.add(new Movie("John Wick: Chapter 2", new NewRelease()));
		movies.add(new Movie("Fifty Shades Darker", new NewRelease()));
		movies.add(new Movie("A Dog's Purpose", new NewRelease()));
		
		// Add 4 Romance Movies
		movies.add(new Movie("Casablanca", new Romance()));
		movies.add(new Movie("Vertigo", new Romance()));
		movies.add(new Movie("Forest Gump", new Romance()));
		movies.add(new Movie("Eternal Sunshine of the Spotless Mind", new Romance()));
		
		// initialize store
		Store store = new Store(movies);
		
		
		// Run
		for(int i = 0; i < days; i++){
			
			//do sim
			
			// Check for Rental returns first thing each day
			for(int j=0; j < store.numMovies(); j++) {
				if(store.getRental(j).dayPassedHowManyAreLeft() == 0) {
					rentalReturnEvents.add(new RentalReturnEvent(
							store.getRental(j).rentedMovie.getName(), 
							store.getRental(j).getDaysRented(),
							(store.getRental(j).rentedMovie.getMoneyDue(store.getRental(j).getDaysRented()))));
				}
			}
			
			
			// Customers come in
			
		}
		
		
		return report;
	}
}
