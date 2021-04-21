package database_Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class User {
	//variables

	public String UserID = "";  
	public String email = "";
	public String password = "";
	public String fName = "";
	public String lName = ""; 
	
	boolean loggedIn = false;
	boolean newUser = true;
	
	String LikesAmerican = "";  
	String LikesAsian = "";
	String LikesBakery = "";
	String LikesBar = "";
	String LikesBreakfast = "";
	String LikesCafe = "";  
	String LikesCaribbean = "";
	String LikesChicken = "";
	String LikesEuropean = "";
	String LikesFastFood = ""; 
	String LikesHealthFood = "";  
	String LikesLatinAmerican = "";
	String LikesPizza = "";
	String LikesSandwich = "";
	String LikesSeafood = ""; 
	
	int AmericanPriority;  
	int AsianPriority;
	int BakeryPriority;
	int BarPriority;
	int BreakfastPriority;
	int CafePriority;  
	int CaribbeanPriority;
	int ChickenPriority;
	int EuropeanPriority;
	int FastFoodPriority; 
	int HealthFoodPriority;  
	int LatinAmericanPriority;
	int PizzaPriority;
	int SandwichPriority;
	int SeafoodPriority; 
	
	String todaySuggestion = "";
	
	//constructor
		public User(String email, String password) {
			try (
			         Connection conn = DriverManager.getConnection(
			               "jdbc:mysql://u6eb1j75vspxbyl5:pzjIVB9isz5H1CdCqTPI@bqsehgnm2oox4pactlh7-mysql.services.clever-cloud.com:3306/bqsehgnm2oox4pactlh7",
			               "u6eb1j75vspxbyl5", "pzjIVB9isz5H1CdCqTPI");  
			 
			         Statement stmt = conn.createStatement();
			      ) {
				String strSelect = "SELECT * FROM bqsehgnm2oox4pactlh7.LoginInformation WHERE Email LIKE '" + email +"'"; 
				ResultSet rset = stmt.executeQuery(strSelect);
		         while(rset.next()) {
		        	if(password.equals(rset.getString("Password"))) {
		        		UserID = rset.getString("UserID");  
			        	this.email = rset.getString("Email");  
			        	this.password = rset.getString("Password");
			        	fName = rset.getString("fName");
			        	lName = rset.getString("LName");
			        	loggedIn = true;
			        	
			        	LikesAmerican = rset.getString("LikesAmerican"); 
			        	LikesAsian = rset.getString("LikesAsian"); 
			        	LikesBakery = rset.getString("LikesBakery"); 
			        	LikesBar = rset.getString("LikesBar"); 
			        	LikesBreakfast = rset.getString("LikesBreakfast"); 
			        	LikesCafe = rset.getString("LikesCafe"); 
			        	LikesCaribbean = rset.getString("LikesCaribbean"); 
			        	LikesChicken = rset.getString("LikesChicken"); 
			        	LikesEuropean = rset.getString("LikesEuropean"); 
			        	LikesFastFood = rset.getString("LikesFastFood"); 
			        	LikesHealthFood = rset.getString("LikesHealthFood");   
			        	LikesLatinAmerican = rset.getString("LikesLatinAmerican"); 
			        	LikesPizza = rset.getString("LikesPizza"); 
			        	LikesSandwich = rset.getString("LikesSandwich"); 
			        	LikesSeafood = rset.getString("LikesSeafood");  
			        	
			        	AmericanPriority = rset.getInt("AmericanPriority"); 
			        	AsianPriority = rset.getInt("AsianPriority");
			        	BakeryPriority = rset.getInt("BakeryPriority");
			        	BarPriority = rset.getInt("BarPriority");
			        	BreakfastPriority = rset.getInt("BreakfastPriority");
			        	CafePriority = rset.getInt("CafePriority");
			        	CaribbeanPriority = rset.getInt("CaribbeanPriority");
			        	ChickenPriority = rset.getInt("ChickenPriority");
			        	EuropeanPriority = rset.getInt("EuropeanPriority");
			        	FastFoodPriority = rset.getInt("FastFoodPriority");
			        	HealthFoodPriority = rset.getInt("HealthFoodPriority");
			        	LatinAmericanPriority = rset.getInt("LatinAmericanPriority");
			        	PizzaPriority = rset.getInt("PizzaPriority");
			        	SandwichPriority = rset.getInt("SandwichPriority");
			        	SeafoodPriority= rset.getInt("SeafoodPriority");
		        		
			        	if(LikesSeafood != null) {
			        		newUser = false;
			        	}
		        	}
		        	else {
		        		break;
		        	}	
		         }
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      }
		}
			
			
			

	  public String getUserID()
	  {
	    return UserID;
	  }
	  public String getemail()
	  {
	    return email;
	  }
	  public String getPassword()
	  {
	    return password;
	  }
	  public String getfName()
	  {
	    return fName;
	  }
	  public String getlName()
	  {
	    return lName;
	  }	  
	  public String getLikesAmerican()
	  {
	    return LikesAmerican;
	  }
	  public String getLikesAsian()
	  {
	    return LikesAsian;
	  }
	  public String getLikesBakery()
	  {
	    return LikesBakery;
	  }
	  public String getLikesBar()
	  {
	    return LikesBar;
	  }
	  public String getLikesBreakfast()
	  {
	    return LikesBreakfast;
	  }
	  public String getLikesCafe()
	  {
	    return LikesCafe;
	  }
	  public String getLikesCaribbean()
	  {
	    return LikesCaribbean;
	  }
	  public String getLikesChicken()
	  {
	    return LikesChicken;
	  }
	  public String getLikesEuropean()
	  {
	    return LikesEuropean;
	  }
	  public String getLikesFastFood()
	  {
	    return LikesFastFood;
	  }
	  public String getLikesHealthFood()
	  {
	    return LikesHealthFood;
	  }
	  public String getLikesLatinAmerican()
	  {
	    return LikesLatinAmerican;
	  }
	  public String getLikesPizza()
	  {
	    return LikesPizza;
	  }
	  public String getLikesSandwich()
	  {
	    return LikesSandwich;
	  }
	  public String getLikesSeafood()
	  {
	    return LikesSeafood;
	  }
	  
	  
	  //methods 
	  String printUserInfo(){
	    String Res = "UniqueID: "+ UserID + "\n " + "E-mail: "+ email + "\n " + "Password: "+ password + "\n " + "First Name: "+ fName + "\n " + "Last Name: "+ lName + "\n\n\n";
	    return Res;
	  }
	  
	  public static int GenerateRandom(int min, int max){
	  	  int ran = (int)Math.floor(Math.random()*(max-min+1)+min);
	      //System.out.println("Random value in int from "+min+" to "+max+ ": "+ran);
	      return ran;
	    }
	  
	  public int yesCount() {
		  int count = 0;
		  
		  if(LikesAmerican.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesAsian.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesBakery.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesBar.equals("Yes")){
			  count++;
		  }
		  
		  if(LikesBreakfast.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesCafe.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesCaribbean.equals("Yes")){
			  count++;
		  }
		  
		  if(LikesChicken.equals("Yes")){
			  count++;
		  }
		  
		  if(LikesEuropean.equals("Yes")){
			  count++;
		  }
		  
		  if(LikesFastFood.equals("Yes")){
			  count++;
		  }
		  
		  if(LikesHealthFood.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesLatinAmerican.equals("Yes")) {
			  count++;
		  }
		  
		  if(LikesPizza.equals("Yes")) {
			  count++;
		  }

		  if(LikesSandwich.equals("Yes")) {
			  count++;
		  }

		  if(LikesSeafood.equals("Yes")){
			  count++;
		  }
		  System.out.println("Count: "+count);
		  return count;
	  }

	  public void updatePriority() {
		  
		  if(newUser == true) {
			  System.out.println("NEW USER");
			  int count = 14;
			  
			  if(getLikesAmerican() == "Yes") {
				  AmericanPriority = count;
				  count--;
				  //System.out.println(AmericanPriority);
			  }else {
				  AmericanPriority = -99;
			  }
			  
			  if(getLikesAsian() == "Yes") {
				  AsianPriority = count;
				  count--;
			  }else {
				  AsianPriority = -99;
			  }
			  
			  if(getLikesBakery() == "Yes") {
				  BakeryPriority = count;
				  count--;
			  }else {
				  BakeryPriority = -99;
			  }
			  
			  if(getLikesBar() == "Yes") {
				  BarPriority = count;
				  count--;
			  }else {
				  BarPriority = -99;
			  }
			  
			  if(getLikesBreakfast() == "Yes") {
				  BreakfastPriority = count;
				  count--;
			  }else {
				  BreakfastPriority = -99;
			  }
			  
			  if(getLikesCafe() == "Yes") {
				  CafePriority = count;
				  count--;
			  }else {
				  CafePriority = -99;
			  }
			  
			  if(getLikesCaribbean() == "Yes") {
				  CaribbeanPriority = count;
				  count--;
			  }else {
				  CaribbeanPriority = -99;
			  }
			  
			  if(getLikesChicken() == "Yes") {
				  ChickenPriority = count;
				  count--;
			  }else {
				  ChickenPriority = -99;
			  }
			  
			  if(getLikesEuropean() == "Yes") {
				  EuropeanPriority = count;
				  count--;
			  }else {
				  EuropeanPriority = -99;
			  }
			  
			  if(getLikesFastFood() == "Yes") {
				  FastFoodPriority = count;
				  count--;
			  }else {
				  FastFoodPriority = -99;
			  }
			  
			  if(getLikesHealthFood() == "Yes") {
				  HealthFoodPriority = count;
				  count--;
			  }else {
				  HealthFoodPriority = -99;
			  }
			  
			  if(getLikesLatinAmerican() == "Yes") {
				  LatinAmericanPriority = count;
				  count--;
			  }else {
				  LatinAmericanPriority = -99;
			  }
			  
			  if(getLikesPizza() == "Yes") {
				  PizzaPriority = count;
				  count--;
			  }else {
				  PizzaPriority = -99;
			  }
			  
			  if(getLikesSandwich() == "Yes") {
				  SandwichPriority = count;
				  count--;
			  }else {
				  SandwichPriority = -99;
			  }
			  
			  if(getLikesSeafood() == "Yes") {
				  SeafoodPriority = count;
				  count--;
			  }else {
				  SeafoodPriority = -99;
			  }
			
		  }
		  else {
			  System.out.println("CURRENT USER");
			  int i = GenerateRandom(12, 14);
			  int min = 14-yesCount();
			  
			  if(AmericanPriority == i) {
				  todaySuggestion = "American";
				  AmericanPriority = min;
			  }
			  
			  if(AsianPriority == i) {
				  todaySuggestion = "Asian";
				  AsianPriority = min;
			  }
			  
			  if(BakeryPriority == i) {
				  todaySuggestion = "Bakery";
				  BakeryPriority = min;
			  }
			  
			  if(BarPriority == i) {
				  todaySuggestion = "Bar";
				  BarPriority = min;
			  }
			  
			  if(BreakfastPriority == i) {
				  todaySuggestion = "Breakfast";
				  BreakfastPriority = min;
			  }

			  if(CafePriority == i) {
				  todaySuggestion = "Cafe";
				  CafePriority = min;
			  }
			  
			  if(CaribbeanPriority == i) {
				  todaySuggestion = "Caribbean";
				  CaribbeanPriority = min;
			  }
			  
			  if(ChickenPriority == i) {
				  todaySuggestion = "Chicken";
				  ChickenPriority = min;
			  }
			  
			  if(EuropeanPriority == i) {
				  todaySuggestion = "European ";
				  EuropeanPriority = min;
			  }

			  if(FastFoodPriority == i) {
				  todaySuggestion = "Fast Food";
				  FastFoodPriority = min;
			  }

			  if(HealthFoodPriority == i) {
				  todaySuggestion = "Health food";
				  HealthFoodPriority = min;
			  }
			  
			  if(LatinAmericanPriority == i) {
				  todaySuggestion = "Latin American";
				  LatinAmericanPriority = min;
			  }

			  if(PizzaPriority == i) {
				  todaySuggestion = "Pizza";
				  PizzaPriority = min;
			  }
			  
			  if(SandwichPriority == i) {
				  todaySuggestion = "Sandwich";
				  SandwichPriority = min;
			  }
			  
			  if(SeafoodPriority == i) {
				  todaySuggestion = "Seafood";
				  SeafoodPriority = min;
			  }
			  
			  
			  if(i == 14) {//update everything -99<x +1
				  if(AmericanPriority > -50) {
					  AmericanPriority++;
				  }
				  if(AsianPriority > -50) {
					  AsianPriority++;
				  }
				  if(BakeryPriority > -50) {
					  BakeryPriority++;
				  }
				  if(BarPriority > -50) {
					  BarPriority++;
				  }
				  if(BreakfastPriority > -50) {
					  BreakfastPriority++;
				  }
				  if(CafePriority > -50) {
					  CafePriority++;
				  }
				  if(CaribbeanPriority > -50) {
					  CaribbeanPriority++;
				  }
				  if(ChickenPriority > -50) {
					  ChickenPriority++;
				  }
				  if(EuropeanPriority > -50) {
					  EuropeanPriority++;
				  }
				  if(FastFoodPriority > -50) {
					  FastFoodPriority++;
				  }
				  if(HealthFoodPriority > -50) {
					  HealthFoodPriority++;
				  }
				  if(LatinAmericanPriority > -50) {
					  LatinAmericanPriority++;
				  }
				  if(PizzaPriority > -50) {
					  PizzaPriority++;
				  }
				  if(SandwichPriority > -50) {
					  SandwichPriority++;
				  }
				  if(SeafoodPriority > -50) {
					  SeafoodPriority++;
				  }
			  }
			  
		if(i == 13) {//update everything -99<x<13 +1
				  if(AmericanPriority > -50 && AmericanPriority < 13) {
					  AmericanPriority++;
				  }
          if(AsianPriority > -50 && AsianPriority < 13) {
					  AsianPriority++;
				  }
          if(BakeryPriority > -50 && BakeryPriority < 13) {
					  BakeryPriority++;
				  }
          if(BarPriority > -50 && BarPriority < 13) {
					  BarPriority++;
				  }
          if(BreakfastPriority > -50 && BreakfastPriority < 13) {
					  BreakfastPriority++;
				  }
          if(CafePriority > -50 && CafePriority < 13) {
					  CafePriority++;
				  }
          if(CaribbeanPriority > -50 && CaribbeanPriority < 13) {
					  CaribbeanPriority++;
				  }
          if(ChickenPriority > -50 && ChickenPriority < 13) {
					  ChickenPriority++;
				  }
          if(EuropeanPriority > -50 && EuropeanPriority < 13) {
					  EuropeanPriority++;
				  }
          if(FastFoodPriority > -50 && FastFoodPriority < 13) {
					  FastFoodPriority++;
				  }
          if(HealthFoodPriority > -50 && HealthFoodPriority < 13) {
					  HealthFoodPriority++;
				  }
          if(LatinAmericanPriority > -50 && LatinAmericanPriority < 13) {
					  LatinAmericanPriority++;
				  }
          if(PizzaPriority > -50 && PizzaPriority < 13) {
					  PizzaPriority++;
				  }
          if(SandwichPriority > -50 && SandwichPriority < 13) {
					  SandwichPriority++;
				  }
          if(SeafoodPriority > -50 && SeafoodPriority < 13) {
					  SeafoodPriority++;
				  }
			  }





       if(i == 12){//update everything -99<x<12 +1
		  if(AmericanPriority > -50 && AmericanPriority < 12) {
					  AmericanPriority++;
				  }
          if(AsianPriority > -50 && AsianPriority < 12) {
					  AsianPriority++;
				  }
          if(BakeryPriority > -50 && BakeryPriority < 12) {
					  BakeryPriority++;
				  }
          if(BarPriority > -50 && BarPriority < 12) {
					  BarPriority++;
				  }
          if(BreakfastPriority > -50 && BreakfastPriority < 12) {
					  BreakfastPriority++;
				  }
          if(CafePriority > -50 && CafePriority < 12) {
					  CafePriority++;
				  }
          if(CaribbeanPriority > -50 && CaribbeanPriority < 12) {
					  CaribbeanPriority++;
				  }
          if(ChickenPriority > -50 && ChickenPriority < 12) {
					  ChickenPriority++;
				  }
          if(EuropeanPriority > -50 && EuropeanPriority < 12) {
					  EuropeanPriority++;
				  }
          if(FastFoodPriority > -50 && FastFoodPriority < 12) {
					  FastFoodPriority++;
				  }
          if(HealthFoodPriority > -50 && HealthFoodPriority < 12) {
					  HealthFoodPriority++;
				  }
          if(LatinAmericanPriority > -50 && LatinAmericanPriority < 12) {
					  LatinAmericanPriority++;
				  }
          if(PizzaPriority > -50 && PizzaPriority < 12) {
					  PizzaPriority++;
				  }
          if(SandwichPriority > -50 && SandwichPriority < 12) {
					  SandwichPriority++;
				  }
          if(SeafoodPriority > -50 && SeafoodPriority < 12) {
					  SeafoodPriority++;
				  }
			  }
			  
		  }
		  
		  
	  }
  		public void updatePreferences( String LikesAmerican, String LikesAsian, String LikesBakery, String LikesBar, String LikesBreakfast, String LikesCafe, String LikesCaribbean, 
		  String LikesChicken, String LikesEuropean, String LikesFastFood, String LikesHealthFood, String LikesLatinAmerican, String LikesPizza, String LikesSandwich, String LikesSeafood) { //int AmericanPriority, int AsianPriority, int BakeryPriority, int BarPriority, int BreakfastPriority, int CafePriority, int CaribbeanPriority, int ChickenPriority, int EuropeanPriority, int FastFoodPriority, int HealthFoodPriority,  int LatinAmericanPriority, int PizzaPriority, int SandwichPriority, int SeafoodPriority
	  	
	  	this.LikesAmerican = LikesAmerican;  
	  	this.LikesAsian = LikesAsian;
	  	this.LikesBakery = LikesBakery;
	  	this.LikesBar = LikesBar;
	  	this.LikesBreakfast = LikesBreakfast;
	  	this.LikesCafe = LikesCafe;  
	  	this.LikesCaribbean = LikesCaribbean;
	  	this.LikesChicken = LikesChicken;
	  	this.LikesEuropean = LikesEuropean;
	  	this.LikesFastFood = LikesFastFood; 
	  	this.LikesHealthFood = LikesHealthFood;  
	  	this.LikesLatinAmerican = LikesLatinAmerican;
	  	this.LikesPizza = LikesPizza;
	  	this.LikesSandwich = LikesSandwich;
	  	this.LikesSeafood = LikesSeafood; 
}

	}
