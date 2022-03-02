import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Theater {

	public Theater(int id , String name, Screen screen, int capacity) {
//		super();
		this.id = id;
		this.name = name;
		this.screen = screen;
		this.capacity = capacity;
		this.shows = new ArrayList<>() ;
	}

	private int id ;
	private String name ;
	private Screen screen ;
	private int capacity ;
	private ArrayList<Show> shows ;
	
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void addShow(Movie movie) {
		
		Scanner sc = new Scanner(System.in);
		
		Date date = new Date();
    	
    	System.out.println("Enter Movie Name : ");
    	name = sc.nextLine() ;
    	try
		{
	    		Show show = new Show(date,movie,this) ;
				
				shows.add(show) ;
				
			
				System.out.println("Show Created Successfully!") ;
		}
		catch(Exception e)
		{
			System.out.println("Error: Show Not Created,Something went wrong \n Please Try Again") ;
		}
		
		sc.close();
	}
	
	public ArrayList<Show> getShows(){
		return shows ;
	}
	
	public String removeShows(Show show) {
		
		if(show!=null)
		{
			for(int i=0;i<shows.size();i++)
			{
				if(shows.get(i).getId()==show.getId())
				{
					shows.remove(i) ;
					return "Show Removed From the Theater :" + name + " Successfully!" ;
				}
			}
			
		}
		
		return "Error: Show is Nor Removed,Please Try again" ;
		
	}
	public void displayAllShows() {
		if(shows.size()==0)
		{
			System.out.println("No Shows Available On This Theater") ;
		}
		else
		{
			System.out.println("Total No Of Shows Available On This Theater" + shows.size()) ; 
			for(int i=0;i<shows.size();i++)
			{
				System.out.println("Show : " + i+1)  ;
				shows.get(i).display();
				
			}
		}
	}

	public void display() {
    	
		System.out.println("Details Of this Theater :" );
    	System.out.println("Name          : " +  name);
    	System.out.println("Screen        : " +  screen);
    	System.out.println("Capacity      : " +  capacity);
    	System.out.println("No. of Shows  : " +  shows.size());
    	
    	
    	
    	
	}
	
    public static int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
}
