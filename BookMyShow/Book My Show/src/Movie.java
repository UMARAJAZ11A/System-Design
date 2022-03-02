import java.util.UUID;

public class Movie {
	
	public Movie( String name, int rating, Genre genre, Region region, Language language) {
		
		this.id = generateUniqueId();
		this.name = name;
		this.rating = rating;
		this.genre = genre;
		this.region = region;
		this.language = language;
	}

	private int id ;
	private String name ;
	private int rating ;
	private Genre genre ;
	private Region region ;
	private Language language ;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}
	public void display() {
    	
    	System.out.println("Name      : " + name);
    	System.out.println("Rating    : " + rating);
    	System.out.println("Genre     : " +  genre);
    	System.out.println("Language  : " + language);
    	System.out.println("Region    : " + region);
    	
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
