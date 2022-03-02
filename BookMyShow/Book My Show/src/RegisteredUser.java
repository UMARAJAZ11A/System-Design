import java.util.ArrayList;
import java.util.UUID;

public class RegisteredUser extends User{

	public RegisteredUser( String name , String password, String type) {
		super(generateUniqueId(),name,password,type);
		this.bookingHistory =new ArrayList<>() ;
	}

	private ArrayList<Ticket> bookingHistory ;

	public ArrayList<Ticket> getBookingHistory() {
		return bookingHistory;
	}

	public String addBooking(Ticket booking) {
		if(booking!=null)
		{
			this.bookingHistory.add(booking);
			return "Booking Added Successfully!" ;
		}
		else
		{
			return "Error : Booking is Not Cofirmed,Please Try Again" ;
		}
		
		
	}
	public String removeBooking(Ticket booking) {
		for(int i=0;i<bookingHistory.size();i++)
		{
			if(bookingHistory.get(i).getId()==booking.getId())
			{
				bookingHistory.remove(i) ;
				return "Booking Cancled Successfully!" ;
			}
		}
		return "Error : Booking is Not Cancled,Please Try Again" ;

		
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
