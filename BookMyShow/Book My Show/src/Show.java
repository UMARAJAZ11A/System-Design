import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Show {
	
	
	public Show( Date time, Movie movie, Theater theater  ) {
//		super();
		this.id = generateUniqueId();
		this.time = time;
		this.movie = movie;
		this.theater = theater ;
		
		this.availableSeats = theater.getCapacity() ;
	}
	private int id ;
	private Date time ;
	private Movie movie ;
	private Theater theater ;
	
	private int availableSeats ;
	
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	


	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
    public static int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
    
    public void display() {
    	
    	System.out.println("This Show is Scheduled for Date : " + time);
    	System.out.println("Movie Name : " + movie.getName());
    	System.out.println("Show is Organized in Theater : " + theater.getName());
    	System.out.println("Total Booked Seats : " + theater.getCapacity());
    	System.out.println("Total Available Seats : " + availableSeats + "\n");
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter y|Y to get the details of Movie : \n or \n Enter any Character to Continue");
    	char ch = 'n' ;
    	ch = sc.next().charAt(0) ;
    	sc.close();
    	
    	if(ch=='Y'||ch=='y')
    	{
    		movie.display();
    	}
    }
	
}
