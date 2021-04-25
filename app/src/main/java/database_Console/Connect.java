package database_Console;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


 
public class Connect {

	  
	  public static ArrayList<restaurants> addRes(String Filter) {	//addRes creates an ArrayList of restaurants all of one type such as "American" restaurants or "Asian" restaurants
		  ArrayList<restaurants> ret = new ArrayList<restaurants>();
		  try (
			         Connection conn = DriverManager.getConnection(//establish connection
			               "jdbc:mysql://u6eb1j75vspxbyl5:pzjIVB9isz5H1CdCqTPI@bqsehgnm2oox4pactlh7-mysql.services.clever-cloud.com:3306/bqsehgnm2oox4pactlh7",
			               "u6eb1j75vspxbyl5", "pzjIVB9isz5H1CdCqTPI");  
			 
			         Statement stmt = conn.createStatement();
			      ) {
			         String strSelect = "SELECT * FROM bqsehgnm2oox4pactlh7.restaurants WHERE category LIKE '" + Filter+"'"; //sql query to get restaurants of one type
			         ResultSet rset = stmt.executeQuery(strSelect);

			         while(rset.next()) {
			            String title = rset.getString("title");
			            String rating = rset.getString("rating");
			            String category = rset.getString("category");
			            String subCategory = rset.getString("subCategory");
			            String address = rset.getString("address");
			            String phoneNumber = rset.getString("phoneNumber");
			            String googleLink = rset.getString("googleLink");
			            ret.add(new restaurants(title, rating, category, subCategory, address, phoneNumber, googleLink));
			         }

			         return ret; 
			      } catch(SQLException ex) {
			         ex.printStackTrace();
			      }
		return null;
	  }
	  
	  public static User getUser(String email, String password) {//simple function to create a User object with that information, also checks to see if account info is correct
		return new User(email,password);
	  }

	public static void createUser(String email, String password, String fName, String lName) {
		int maxUID = 0;
		try (
				Connection conn = DriverManager.getConnection(//establish connection
						"jdbc:mysql://u6eb1j75vspxbyl5:pzjIVB9isz5H1CdCqTPI@bqsehgnm2oox4pactlh7-mysql.services.clever-cloud.com:3306/bqsehgnm2oox4pactlh7",
						"u6eb1j75vspxbyl5", "pzjIVB9isz5H1CdCqTPI");

				Statement stmt = conn.createStatement();
		) {
									//sql query to see if account exists
			String strSelect = "SELECT * FROM bqsehgnm2oox4pactlh7.LoginInformation WHERE Email LIKE '" + email+ "'";
			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()) {	//return if account exists
				System.out.println("Error: Account Creation Failed, account with that email already exists");
				System.out.println(strSelect);
				return;
			}
									//gets the current highest UserID and maxes sure that the new user is that +1
			strSelect = "SELECT MAX(UserID) FROM bqsehgnm2oox4pactlh7.LoginInformation";
			rset = stmt.executeQuery(strSelect);

			while(rset.next()) {
				maxUID = rset.getInt(1);
			}
			int newUID = maxUID+1;

									//adds the new user into tht database
			strSelect = "INSERT INTO bqsehgnm2oox4pactlh7.LoginInformation (UserID, Email, Password, fName, LName) VALUES ("+newUID+", \""+email+"\", \""+password+"\", \""+fName+"\", \""+lName+"\");";
			System.out.println(strSelect);
			stmt.executeUpdate(strSelect);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public static void userDataSync(User u) {//syncs all user object info, with a user in the database, such as the users preferences and restaurant priority which is a measure of how long it has been since that restaurant type was last reccomended
		  	try (
			         Connection conn = DriverManager.getConnection(//establish connection
			               "jdbc:mysql://u6eb1j75vspxbyl5:pzjIVB9isz5H1CdCqTPI@bqsehgnm2oox4pactlh7-mysql.services.clever-cloud.com:3306/bqsehgnm2oox4pactlh7",
			               "u6eb1j75vspxbyl5", "pzjIVB9isz5H1CdCqTPI");  
			 
			         Statement stmt = conn.createStatement();
				  
			      ) {					//sql query to sync all prefrences
			  String strSelect = "UPDATE bqsehgnm2oox4pactlh7.LoginInformation SET LikesAmerican = \""+u.LikesAmerican+"\", LikesAsian = \""+u.LikesAsian+"\", LikesBakery = \""+u.LikesBakery+"\", LikesBar = \""+u.LikesBar+"\", LikesBreakfast = \""+u.LikesBreakfast+"\", LikesCafe = \""+u.LikesCafe+"\", LikesCaribbean = \""+u.LikesCaribbean+"\", LikesChicken = \""+u.LikesChicken+"\", LikesEuropean = \""+u.LikesEuropean+"\", LikesFastFood = \""+u.LikesFastFood+"\", LikesHealthFood = \""+u.LikesHealthFood+"\", LikesLatinAmerican = \""+ u.LikesLatinAmerican +"\", LikesPizza = \""+u.LikesPizza+"\", LikesSandwich = \""+u.LikesSandwich+"\", LikesSeafood = \""+u.LikesSeafood+"\" WHERE UserID LIKE " + u.UserID+ ";"; 
			  System.out.println(strSelect);
			  stmt.executeUpdate(strSelect);
										//sql query to sync all priority
			  strSelect = "UPDATE bqsehgnm2oox4pactlh7.LoginInformation SET AmericanPriority = \""+u.AmericanPriority+"\", AsianPriority = \""+u.AsianPriority+"\", BakeryPriority = \""+u.BakeryPriority+"\", BarPriority = \""+u.BarPriority+"\", BreakfastPriority = \""+u.BreakfastPriority+"\", CafePriority = \""+u.CafePriority+"\", CaribbeanPriority = \""+u.CaribbeanPriority+"\", ChickenPriority = \""+u.ChickenPriority+"\", EuropeanPriority = \""+u.EuropeanPriority+"\", FastFoodPriority = \""+u.FastFoodPriority+"\", HealthFoodPriority = \""+u.HealthFoodPriority+"\", LatinAmericanPriority = \""+ u.LatinAmericanPriority +"\", PizzaPriority = \""+u.PizzaPriority+"\", SandwichPriority = \""+u.SandwichPriority+"\", SeafoodPriority = \""+u.SeafoodPriority+"\" WHERE UserID LIKE " + u.UserID+ ";"; 
			  System.out.println(strSelect);
			  stmt.executeUpdate(strSelect);
			 
			  
	  	  } catch(SQLException ex) {
	         ex.printStackTrace();
	      }
		  
	  }
	  
	  public static int GenerateRandom(int min, int max){//generate random number value (used for testing)
		  	  int ran = (int)Math.floor(Math.random()*(max-min+1)+min);
		      System.out.println("Random value in int from "+min+" to "+max+ ": "+ran);
		      return ran;
		    }
	  
	  public static String GenerateRandomRes(ArrayList<restaurants> ResType){//generate random res from the array list (used for testing)
		  return ResType.get(GenerateRandom(0,ResType.size()-1)).printRes();
	    }
	
	  public static void main(String[] args) {//small main to demo what the app could do if it was full funcitonal
	   
	   	//createUser("nbrooks7827@floridapoly.edu", "FakePASS", "Nathan", "Brooks");
	   	
	    User me = getUser("nbrooks7827@floridapoly.edu", "FakePASS"); //login with email and pass

	    System.out.println(me.printUserInfo()); //print basic user info

	    me.updatePriority();//pick todays suggestion and update the queue
	    System.out.println("\nToday's Suggestion: "+me.todaySuggestion);
	    
	    ArrayList<restaurants> today = addRes(me.todaySuggestion);//chose one restaurant from todays suggested type
	    System.out.println(GenerateRandomRes(today));

	    userDataSync(me);//sync all info to the database
	    
	    
		
	   
   }
}
