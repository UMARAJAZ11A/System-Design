import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class BookMyShow {

	
	private  ArrayList<RegisteredUser> users = new ArrayList<>() ;
	private  ArrayList<Theater> theaters = new ArrayList<>();
	private  ArrayList<Movie> movies = new ArrayList<>() ;
	
	public BookMyShow() {
		
		users =new ArrayList<>() ;
		theaters = new ArrayList<>();
		movies = new ArrayList<>();
		
		
	}

	public  void addUser()
	{
		//Scanner sc = new Scanner(System.in) ;
		String name ;
		String password ;
		String type ;
		System.out.println("Welcome To Book My Show Application,Please Register to Book Tickets") ;
		System.out.println("Please Enter your Name (minimum length 1)") ;
		name = sc.nextLine();
		System.out.println("Please Enter your Password (minimun len 4)") ;
		password = sc.nextLine();
		System.out.println("Please Enter User Type : \n 1.Admin \n 2.User \n 3.Theater ") ;
		int tp = sc.nextInt();
		sc.nextLine() ;
		if(tp==1)
			type = "Admin" ;
		else if(tp==2)
			type = "User" ;
		else if(tp==3)
			type = "Theater" ;
		else
			type = "" ;
		if(name.length()<1||password.length()<4||(type!="Admin"&&type!="User"&&type!="Theater"))
		{
			//sc.close();
			System.out.println("Error: User Not Created,Please provide the input according to the instruction given,Please Try Again") ;
			return ;
		}
		try
		{
				RegisteredUser user = new RegisteredUser(name,password,type);
				users.add(user) ;
				
				if(type=="Theater")
				{
					Screen screen = Screen.SingleScreen;
					Theater theater = new Theater(user.getId(),name,screen,100) ;
					theaters.add(theater);
					theaters.get(0).display();
					users.get(0).display();
					System.out.println("Theater Created Successfully!") ;
				}
			
				System.out.println("User Created Successfully!") ;
		}
		catch(Exception e)
		{
			System.out.println("Error: User Not Created,Something went wrong \n Please Try Again") ;
		}
		
		//sc.close();
	}

	public  String removeUser(RegisteredUser user)
	{
		// code to delete user
		if(user!=null)
		{
			for(int i=0;i<users.size();i++)
			{
				if(users.get(i).getId()==user.getId())
				{
					users.remove(i);
					
					return "User Removed Successfully!" ;
				}
			}
		}
		return "Error: User Not Removed,Please Try Again" ;
	}
	public  String addTheater(Theater theater)
	{
		if(theater!=null)
		{
			theaters.add(theater);
			
			return "Theater Created Successfully!" ;
		}
		return "Error: Theater Not Created,Please Try Again" ;
	}
	public String removeTheater(Theater theater)
	{
		//remove theater ;
		if(theater!=null)
		{
			for(int i=0;i<theaters.size();i++)
			{
				if(theaters.get(i).getId()==theater.getId())
				{
					theaters.remove(i);
					
					return "Theater Removed Successfully!" ;
				}
			}
		}
		return "Error: Theater Not Removed,Please Try Again" ;
	}
	public  void addMovie()
	{
		//remove theater ;
		//Scanner sc = new Scanner(System.in);
		String name ;
		int rating ;
		
    	System.out.println("Enter Name Of The Movie : ");
    	name = sc.nextLine();
    	System.out.println("Rating : " );
    	rating = sc.nextInt() ;
    	
    	
		try
		{
				Movie movie = new Movie(name , rating , Genre.Action , Region.North, Language.Hndi) ;
				movies.add(movie) ;
				
			
				System.out.println("Movie Created Successfully!") ;
		}
		catch(Exception e)
		{
			System.out.println("Error: User Not Created,Something went wrong \n Please Try Again") ;
		}
		
		//sc.close();
	}
	public String removeMovie(Movie movie)
	{
		//remove theater ;
		if(movie!=null)
		{
			for(int i=0;i<movies.size();i++)
			{
				if(movies.get(i).getId()==movie.getId())
				{
					movies.remove(i);
					
					return "Movie Removed Successfully!" ;
				}
			}
		}
		return "Error: Movie Not Removed,Please Try Again" ;
	}
	public  RegisteredUser login(String type)
	{
		//Scanner sc = new Scanner(System.in) ;
		String name ;
		String password ;
		System.out.println("Welcome To Book My Show Application,Please Enter Credientials to Login") ;
		System.out.println("Please Enter your Name") ;
		name = sc.nextLine();
		System.out.println("Please Enter your Password" ) ;
		password = sc.nextLine();
		//sc.close();
		if(name==""||password=="")
		{
			System.out.println("Enter Credientials are Wrong,Please Enter Again") ;
			return null ;
		}
		else
		{
			for(int i=0;i<users.size();i++)
			{
				
				if(users.get(i).getName().compareTo(name)==0&&users.get(i).getPassword().compareTo(password)==0&&users.get(i).getType().compareTo(type)==0)
				{
					System.out.println("You Are Logged In As A :" + type );
					return users.get(i) ;
				}
			}
			System.out.println("No User Exists With this Credientials,Please Enter Again") ;
			return null ;
		}
	}
	
	public  void displayAllMovies() {
		for(int i=0;i<movies.size();i++)
		{
			System.out.println( "Movie : " + i+1);
			movies.get(i).display();
		}
	}
	public  void displayAllTheaters() {
		
		if(theaters.size()==0)
		{
			System.out.println( "No Theater is added Yet,Please Request Theaters to Register");
			return ;
		}
		
		for(int i=0;i<theaters.size();i++)
		{
			System.out.println("Theater : " + i+1) ;
			theaters.get(i).display();
		}
    	//Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter the Index Of The Theater to get the details of all the shows Available In the Theater ");
    	System.out.println( "or \n Enter 0 to Continue");
    	int ch = 0 ;
    	ch = sc.next().charAt(0) ;
    	//sc.close();
    	
    	if(ch>0&&ch<=theaters.size())
    	{
    		theaters.get(ch).displayAllShows();
    	}
	}
	
	public  void displayAllUsers() {
		
		if(users.size()==0)
		{
			System.out.println( "No User is added Yet,Please Request User to Register");
			return ;
		}
		
		for(int i=0;i<users.size();i++)
		{
			System.out.println("Users : " + i+1) ;
			users.get(i).display();
		}
    	return ;
	}
	
	public  int search(String key , String value)
	{
		if(key=="Movie")
		{
			for(int i=0;i<movies.size();i++)
			{
				if(movies.get(i).getName()==value)
				{
					movies.get(i).display(); 
					return 0;
				}
			}
			System.out.println("No Movie Found With The Name :" + value) ;
			return 0;
		}
		else if(key=="Theater")
		{
			for(int i=0;i<theaters.size();i++)
			{
				if(theaters.get(i).getName()==value)
				{
					theaters.get(i).display(); 
					return 0;
				}
			}
			System.out.println("No Theater Found With The Name :" + value) ;
			return 0;
		}
		else if(key=="User")
		{
			for(int i=0;i<users.size();i++)
			{
				if(users.get(i).getName()==value)
				{
					users.get(i).display();
					return 0;
				}
			}
			System.out.println("No User Found With The Name :" + value) ;
			return 0;
			
		}
		else
		{
			System.out.println("Invalid Key Value Pair :" + "Key : " + key + " Value : " + value) ;
			return 0;
		}
	}
	
	
	public  void showMenu(String userType , RegisteredUser user)
	{
	//	Scanner sc = new Scanner(System.in);
		int ch = 0 ;
		switch(userType)
		{
			case "User" 	: 	
								System.out.println("Welcome Registered User,Here is Menu");
								System.out.println("0.Exit");
								System.out.println("1.Show All Movies");
								System.out.println("2.Show All Theaters");
								System.out.println("3.Search Movie");
								System.out.println("4.Search For Theater");
								System.out.println("5.Book A Show");
								System.out.println("6.Delete Your Profile");

								ch = sc.nextInt() ;
								sc.nextLine() ;
								switch(ch)
								{
									case 0 : 	break  ;
									
									case 1 : 	displayAllMovies() ;
												break ;
									
									case 2 : 	displayAllTheaters() ;
												break ;
									
									case 3 : 
												String movie ;
												System.out.println("Enter The Name Of The Movie");
												movie = sc.nextLine() ;
												search("Movie" , movie) ;
												break ;
									case 4 : 
												String theater ;
												System.out.println("Enter The Name Of The Theater");
												theater = sc.nextLine() ;
												search("Theater" , theater) ;
												break ;	
												
									case 5 :    
												for(int i=0;i<theaters.size();i++)
												{
														System.out.println("Theater : "+ i+1) ; 
														theaters.get(i).displayAllShows(); 
														
												}
												System.out.println("Book A Show! Please Enter The Index Of Theater Followed By Index Of Show ") ; 
												System.out.println("Please Enter -1 , If you Dont Want to Book A Show") ;
												int a = -1 , b = -1 ;
												a = sc.nextInt() ;
												if(a!=-1)
												b = sc.nextInt() ;
												
												if(a!=-1&&b!=-1)
												{
													int seats ;
													int avl =  theaters.get(a).getShows().get(b).getAvailableSeats() ;
													System.out.println("Total Seats Available : " + avl ) ;
													System.out.println("Enter Number Of Seats You Want To Book");
													seats = sc.nextInt() ;
													sc.nextLine() ;
													Date date = new Date() ;
													Ticket ticket = new Ticket(user.getName(), date , seats , theaters.get(a).getShows().get(b) ) ;
													user.addBooking(ticket) ;
													theaters.get(a).getShows().get(b).setAvailableSeats(avl-seats);
												}
												
												
									case 6 :   removeUser(user) ;
									
									default : System.out.println("Wrong Choice!,Please Try Again") ;
								}
								break ;
								//Show All Movies
							
								//Show all theaters
								//search for movie search("Movie")
								//search for theater
								//search for show
								//book a ticket
								//delete User 
				
			case "Admin" 	:	
								
								System.out.println("Welcome,You Are An Admin,Here is Menu");
								System.out.println("0.Exit");
								System.out.println("1.Show All User");
								System.out.println("2.Show All Movies");
								System.out.println("3.Show All Theaters");
								System.out.println("4.Search For User");
								System.out.println("5.Search Movie");
								System.out.println("6.Search For Theater");
								System.out.println("7.Delete User");
								System.out.println("8.Delete Movie");
								System.out.println("9.Delete Theater");
				
								ch = sc.nextInt() ;
								sc.nextLine() ;
								switch(ch)
								{
									case 0 : 	break  ;
									
									case 1 : 	
												displayAllUsers();
												break ;
										
									case 2 : 
												displayAllMovies() ;
												break ;
										
									case 3 : 
												displayAllTheaters() ;
												break ;
										
									case 4 : 
												String us ;
												System.out.println("Enter The Name Of The User");
												us = sc.nextLine() ;
												search("User" , us) ;
												break ;
										
									case 5 : 
												String movie ;
												System.out.println("Enter The Name Of The Movie");
												movie = sc.nextLine() ;
												search("Movie" , movie) ;
												break ;
										
									case 6 : 
												String th ;
												System.out.println("Enter The Name Of The Theater");
												th = sc.nextLine() ;
												search("Theater" , th) ;
												break ;	
									
									case 7 : 	
												displayAllUsers();
												int i ;
												System.out.println("Enter The Index Of User To Be Deleted");
												i = sc.nextInt() ;
												sc.nextLine() ;
												removeUser(users.get(i)) ;
												break ;
												
									case 8 :   
												displayAllMovies();
												int m ;
												System.out.println("Enter The Index Of Movie To Be Deleted");
												m = sc.nextInt() ;
												sc.nextLine() ;
												removeMovie(movies.get(m)) ;
												
												break ;
									case 9 : 	
												displayAllTheaters();
												int theater ;
												System.out.println("Enter The Index Of Theater To Be Deleted");
												theater = sc.nextInt() ;
												sc.nextLine() ;
												removeTheater(theaters.get(theater)) ;
												break ;
									
									
									
									default : System.out.println("Wrong Choice!,Please Try Again") ;
								}
								break ;
								//delete theater
								//delete user
								//delete movie
								//delete show
								//show all users
								//show all theaters
								//show all shows
								
								
				
			case "Guest" 	: 	
								System.out.println("Welcome Guest User,Here is Menu");
								System.out.println("0.Exit");
								System.out.println("1.Show All Movies");
								System.out.println("2.Show All Theaters");
								System.out.println("3.Search Movie");
								System.out.println("4.Search For Theater");
				
								ch = sc.nextInt() ;
								switch(ch)
								{
									case 0 : 	break  ;
									
									case 1 : 	displayAllMovies() ;
												break ;
									
									case 2 : 	displayAllTheaters() ;
												break ;
									
									case 3 : 
												String movie ;
												System.out.println("Enter The Name Of The Movie");
												movie = sc.nextLine() ;
												search("Movie" , movie) ;
												break ;
									case 4 : 
												String theater ;
												System.out.println("Enter The Name Of The Theater");
												theater = sc.nextLine() ;
												search("Theater" , theater) ;
												break ;									
									
									default : System.out.println("Wrong Choice!,Please Try Again") ;
								}
								break ;
								//search movies
								//search shows
								//Show All Movies
								//Show All Shows
								//Show all theaters
								//addMovie
				
		
			case "Theater"  :   
								System.out.println("Welcome,Theater,Here is Menu");
								System.out.println("0.Exit");
								System.out.println("1.Create A Show");
								System.out.println("2.Delete A Show");
								System.out.println("3.Add A Movie");
								System.out.println("4.Delete A Movie");
								
								ch = sc.nextInt() ;
								sc.nextLine() ;
								switch(ch)
								{
									case 0  : break;
									
									case 1 : 
												displayAllMovies();
												System.out.println("Select A Movie For Which Show Needs To Be Created") ;
												int dx = 0 ;
												dx = sc.nextInt();
												if(dx>0&&dx<=movies.size())
												{
													
													for(int i=0;i<theaters.size();i++)
													{
														if(theaters.get(i).getId()==user.getId())
														{
															theaters.get(i).addShow(movies.get(dx)) ;
															break ;
														}
													}
												}
												else
												{
													System.out.println("Wrong Index , Please Try Again") ;
												}
												break ;
									
									case 2 : 
												Theater th = null ;
												for(int i=0;i<theaters.size();i++)
												{
													if(theaters.get(i).getId()==user.getId())
													{
														th = theaters.get(i) ;
														break ;
													}
												}
												if(th!=null)
												{
													th.displayAllShows();
													System.out.println("Enter The Index of Show To Be Deleted");
													int idx = sc.nextInt() ;
													sc.nextLine() ;
													if(idx>0&&idx<=th.getShows().size())
													{												
														th.removeShows(th.getShows().get(idx));
													}
													else
													{
														System.out.println("Please Enter The Correct Index");
													}
													
												}
												break ;
									
									case 3 : 	addMovie();
												break ;
									
									case 4 :    
												displayAllMovies() ;
												System.out.println("Enter The Index of Movie To Be Deleted");
												int id = sc.nextInt() ;
												sc.nextLine() ;
												if(id>0&&id<=movies.size())
												{
													removeMovie(movies.get(id));													
												}
												else
												{
													System.out.println("Please Enter The Correct Index");
												}
												break ;
									
									default : System.out.println("Wrong Choice!,Please Try Again") ;
								}
								//Create a Show 
								//add Movie
								//delete 
				
			default  		:   System.out.println("No User Exist With User Type : " + user) ;
		}
		//sc.close();
		return ;
	}

	public void displayUser(int userType)
	{
		
		//Scanner sc = new Scanner(System.in)  ;
		char ch = 'y' ;
		RegisteredUser user ;
		switch(userType)
		{
			case 1 :  	
						addUser() ;
						break ;
						
			
			case 2 :   	
						user = login("User") ;
						if(user!=null)
						{
									while(ch=='y'||ch=='Y')
									{										
										showMenu("User",user) ;
										System.out.println("Please Enter(y|Y) Continue User Activity") ;
										ch = sc.next().charAt(0) ;
									}
									System.out.println("User Logged Out") ;
						}
						break ;
			
			case 3 :   	
						while(ch=='y'||ch=='Y')
						{										
							showMenu("Guest",null);
							System.out.println("Please Enter(y|Y) Continue Guest User Activity") ;
							ch = sc.next().charAt(0) ;
						}
						System.out.println("End Of User Guest Activity") ;
						break ;
			
			case 4 :   
						user = login("Theater") ;
						if(user!=null)
						{
							while(ch=='y'||ch=='Y')
							{										
								showMenu("Theater",user) ;
								System.out.println("Please Enter(y|Y) Continue Theater_User Activity") ;
								ch = sc.next().charAt(0) ;
							}
							System.out.println("Theater_User Logged Out") ;
						}
						break ;
			
			
			case 5 :   
						user = login("Admin") ;
						if(user!=null);
						{
							while(ch=='y'||ch=='Y')
							{										
								showMenu("Admin",user) ;
								System.out.println("Please Enter(y|Y) Continue Admin Activity") ;
								ch = sc.next().charAt(0) ;
							}
							System.out.println("Admin Logged Out") ;
						}
						break ;
			
			default : 	
						System.out.println("Please Enter Valid User Type (1 - 5)") ;
		}
		//sc.close();
		return ;
		
	}
	
	Scanner sc = new Scanner(System.in);
	public void display()
	{
		char ch = 'y' ;
		
		
		while(ch=='y'||ch=='Y')
		{
			System.out.println("Welcome to BookMyShow Application");
			System.out.println("Menu");
			System.out.println("1.Register A New User");
			System.out.println("2.Login As A User");
			System.out.println("3.Guest User");
			System.out.println("4.Login As A Theater");
			System.out.println("5.Login As An Admin");
			
			System.out.println("Enter The Value (1 - 5)\n");
			
			int userType = sc.nextInt();
			sc.nextLine() ;
			displayUser(userType) ;
			
			System.out.println("Please Enter(y|Y) Continue On The Application") ;
			
			ch = sc.next().charAt(0) ;
			
		}
		System.out.println("GoodBy! Thank You For Using Our Application");
		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BookMyShow app = new BookMyShow();
		
		app.display();
	}

}
