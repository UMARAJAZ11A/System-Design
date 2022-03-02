import java.util.Date;
import java.util.UUID;

public class Ticket {

	public Ticket( String ownerName, Date bookingTime, int noOfSeats, Show bookedShow) {
		
		this.id = generateUniqueId();
		this.ownerName = ownerName;
		this.bookingTime = bookingTime;
		this.noOfSeats = noOfSeats;
		this.bookedShow = bookedShow;
	}
	private int id ;
	private String ownerName ;
	private Date bookingTime ;
	private int noOfSeats ;
	private Show bookedShow ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public Show getBookedShow() {
		return bookedShow;
	}
	public void setBookedShow(Show bookedShow) {
		this.bookedShow = bookedShow;
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
