/******************************************************
‘***  Project 3 - Inheritance and Polymorphism
‘***  Gabriel Brown
‘******************************************************
‘*** To Demonstrate Inheritance and Polymorphism
‘***
‘******************************************************
‘*** 10/03/2017
‘******************************************************
‘*****************************************************/
package brown3342project4;
import java.util.Date;

/**
 *
 * @author gb011
 */
public class Movie extends StoreItem{
    private static int movieCount;
    private String director;
    private String[] actors;
    private String[] actresses; 

    public Movie(String title, String author, Date dateAcquired, int purchasePrice, 
            int askingPrice,String director, String[] actors, String[] actresses)
    {
        super(title, author, dateAcquired, purchasePrice, askingPrice);
        this.director = director;
        this.actors = actors;
        this.actresses = actresses;
        movieCount++;
    }

    public static int getMovieCount() {
        return movieCount;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String[] getActresses() {
        return actresses;
    }

    public void setActresses(String[] actresses) {
        this.actresses = actresses;
    }
    
    public void remove()  // called when removing a book item, decrements the bookCount
    {
        movieCount--;
    }
    
    public String printableString()
    {
        return "this is a movie?";
    }
}
