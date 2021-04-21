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

	  
	  public static ArrayList<restaurants> addRes(String Filter) {
		  ArrayList<restaurants> ret = new ArrayList<restaurants>();
		  try (
			         Connection conn = DriverManager.getConnection(
			               "jdbc:mysql://u6eb1j75vspxbyl5:pzjIVB9isz5H1CdCqTPI@bqsehgnm2oox4pactlh7-mysql.services.clever-cloud.com:3306/bqsehgnm2oox4pactlh7",
			               "u6eb1j75vspxbyl5", "pzjIVB9isz5H1CdCqTPI");  
			 
			         Statement stmt = conn.createStatement();
			      ) {
			         String strSelect = "SELECT * FROM bqsehgnm2oox4pactlh7.restaurants WHERE category LIKE '" + Filter+"'"; 
			         ResultSet rset = stmt.executeQuery(strSelect);
			         
			         while(rset.next()) {
			            String title = rset.getString("title");
			            String rating = rset.getString("rating");
			            String category = rset.getString("category");
			            String subCategory = rset.getString("subCategory");
			            String address = rset.getString("address");
			            String phoneNumber = rset.getString("phoneNumber");
			            String googleLink = rset.getString("googleLink");
			            //System.out.println(title + ", " + rating + ", " + category+ ", " + address + "\n");
			            //Output = title + ", " + rating + ", " + category+ ", " + address + "\n";
			            ret.add(new restaurants(title, rating, category, subCategory, address, phoneNumber, googleLink));
			            //++rowCount;
			            
			         }

			         return ret; 
			      } catch(SQLException ex) {
			         ex.printStackTrace();
			      }
		return null;
	  }
	  
	  public static User getUser(String email, String password) {
		User me = null;

			me = new User(email,password);

		return me;
	  }


	public static void userDataSync(User u) {
		  	try (
			         Connection conn = DriverManager.getConnection(
			               "jdbc:mysql://u6eb1j75vspxbyl5:pzjIVB9isz5H1CdCqTPI@bqsehgnm2oox4pactlh7-mysql.services.clever-cloud.com:3306/bqsehgnm2oox4pactlh7",
			               "u6eb1j75vspxbyl5", "pzjIVB9isz5H1CdCqTPI");  
			 
			         Statement stmt = conn.createStatement();
				  
			      ) {
			  String strSelect = "UPDATE bqsehgnm2oox4pactlh7.LoginInformation SET LikesAmerican = \""+u.LikesAmerican+"\", LikesAsian = \""+u.LikesAsian+"\", LikesBakery = \""+u.LikesBakery+"\", LikesBar = \""+u.LikesBar+"\", LikesBreakfast = \""+u.LikesBreakfast+"\", LikesCafe = \""+u.LikesCafe+"\", LikesCaribbean = \""+u.LikesCaribbean+"\", LikesChicken = \""+u.LikesChicken+"\", LikesEuropean = \""+u.LikesEuropean+"\", LikesFastFood = \""+u.LikesFastFood+"\", LikesHealthFood = \""+u.LikesHealthFood+"\", LikesLatinAmerican = \""+ u.LikesLatinAmerican +"\", LikesPizza = \""+u.LikesPizza+"\", LikesSandwich = \""+u.LikesSandwich+"\", LikesSeafood = \""+u.LikesSeafood+"\" WHERE UserID LIKE " + u.UserID+ ";"; 
			  System.out.println(strSelect);
			  stmt.executeUpdate(strSelect);
			  
			  strSelect = "UPDATE bqsehgnm2oox4pactlh7.LoginInformation SET AmericanPriority = \""+u.AmericanPriority+"\", AsianPriority = \""+u.AsianPriority+"\", BakeryPriority = \""+u.BakeryPriority+"\", BarPriority = \""+u.BarPriority+"\", BreakfastPriority = \""+u.BreakfastPriority+"\", CafePriority = \""+u.CafePriority+"\", CaribbeanPriority = \""+u.CaribbeanPriority+"\", ChickenPriority = \""+u.ChickenPriority+"\", EuropeanPriority = \""+u.EuropeanPriority+"\", FastFoodPriority = \""+u.FastFoodPriority+"\", HealthFoodPriority = \""+u.HealthFoodPriority+"\", LatinAmericanPriority = \""+ u.LatinAmericanPriority +"\", PizzaPriority = \""+u.PizzaPriority+"\", SandwichPriority = \""+u.SandwichPriority+"\", SeafoodPriority = \""+u.SeafoodPriority+"\" WHERE UserID LIKE " + u.UserID+ ";"; 
			  System.out.println(strSelect);
			  stmt.executeUpdate(strSelect);
			 
			  
	  	  } catch(SQLException ex) {
	         ex.printStackTrace();
	      }
		  
	  }
	  
	  public static int GenerateRandom(int min, int max){
		  	  int ran = (int)Math.floor(Math.random()*(max-min+1)+min);
		      System.out.println("Random value in int from "+min+" to "+max+ ": "+ran);
		      return ran;
		    }
	  
	  public static String GenerateRandomRes(ArrayList<restaurants> ResType){
		  return ResType.get(GenerateRandom(0,ResType.size()-1)).printRes();
	    }
	
	  public static void main(String[] args) {
	   
	   	//createUser("nayj9@rocketmail.com", "Dumm7Aa@", "Nate", "Brooks");
	   	
	    //User me = getUser("itsnatebrooks@gmail.com", "Dumm7Aa@");
	    User me = getUser("ruey01@gmail.com", "Dumm8Aa@");
	    //User me = getUser("nayj9@rocketmail.com", "Dumm7Aa@");
	    
	    //me.updatePreferences("Yes", "No", "Yes", "No", "Yes", "No", "Yes", "No", "Yes", "No", "Yes", "No", "Yes", "No", "Yes");
	    me.printUserInfo();
	    me.updatePriority();
	    System.out.println("\nToday's Suggestion: "+me.todaySuggestion);
	    
	    ArrayList<restaurants> today = addRes(me.todaySuggestion);
	    System.out.println(GenerateRandomRes(today));

	    userDataSync(me);
	    
	    
		
	   
   }
}
