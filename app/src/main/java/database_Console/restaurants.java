package database_Console;

public class restaurants {
	//variables
	//title	                    
	//Zarza Latin Food & Grill
	String title = "";

	//rating	
	//4.6	  
	String rating = "";
	      
	//category	      
	//Latin American	
	String category = "";
	
	//subCategory
	//Latin
	String subCategory = "";
	      
	//address	                                                        
	//4648 Cleveland Heights Blvd, Lakeland, FL 33813, United States	
	String address = "";
	      
	//phoneNumber
	//+1 863-607-3702
	String phoneNumber = "";
	
	//googleLink
	//https://www.google.com/maps/place/Zarza+Latin+Food+%26+Grill/@28.0628012,-82.0173989,12z/data=!4m9!1m3!2m2!1sfood+in+Lakeland,+FL!6e5!3m4!1s0x88dd3eadf9864f45:0xd7a430c73499daa6!8m2!3d27.9809523!4d-81.9477053?hl=en
	String googleLink = "";

	
	//constructor
		public restaurants(String title, String rating, String category, String subCategory, String address, String phoneNumber, String googleLink){
		  this.title = title;
	      this.rating = rating;
	      this.category = category;
	      this.subCategory = subCategory;
	      this.address = address;
	      this.phoneNumber = phoneNumber;
	      this.googleLink = googleLink;
			}

	  public String getTitle()
	  {
	    return title;
	  }

	  public String getRating()
	  {
	    return rating;
	  }
	  public String getCategory()
	  {
	    return category;
	  }
	  public String getSubCategory()
	  {
	    return subCategory;
	  }
	  public String getAddress()
	  {
	    return address;
	  }
	  public String getPhoneNumber()
	  {
	    return phoneNumber;
	  }
	  public String getGoogleLink()
	  {
	    return googleLink;
	  }




	  //methods 
	  String printRes(){
	    String Res = "Name: "+ getTitle() + "\n " + "Rating: "+ getRating() + "\n " + "Restaurant Type: "+ subCategory + "\n " + "Address: "+ getAddress() + "\n " + "Phone Number: "+ getPhoneNumber() + "\n " + "Link: "+ getGoogleLink() + "\n\n\n";
	    return Res;
	  }

	}
