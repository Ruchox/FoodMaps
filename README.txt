FoodMaps
FoodMaps is a half Java/half Kotlin app designed to recommend users Restaurants to eat at in the Lakeland, Florida area. The app is currently non-functional but the backend code can be accessed if desired and the frontend app pages can be viewed.



Build Instructions (Windows 10)

While the functionality of the app is incomplete the pages of the app can still be viewed in an android emulator and the database can be accessed using the code. Once the .zip file of the project has been downloaded, extract it and 
open it with Android Studio. There is one necessary .jar file to be linked to the project, it will be packed in the .zip, all that will need to be done is the location mapping.  

With the project open in Android Studio, click the File -> Settigns and the go to the Version Control tab. Here the mysql-connector-java-8.0.23.jar file will need to be deleted, then hit apply. Next Click the File -> Project Structure 
and the go to the dependencies tab. First the mysql-connector-java-8.0.23.jar file will need to be deletedb again, then click the plus sybol under the All Dependencies section and add the jar file back with the proper path then hit apply. 

Finally in the top right of the screen click the green hammer to ensure the project builds. Next a android virtual device will need, to check and see if there is a virutal device installed or to install go to the top right of the 
screen and click on the dropdown menu (to the left of the greeen play icon), first check to see if there is a virtual device listed. If a virtual device is listed skip the next section.

If there is no virtual android machine, a machine will need to be added. This can be done clicking on AVD Manager and then clicking the "+ Create Virtual Device..." button in the bottom left. For the purpose of this project, 
click Pixel 2 then next. Here you will need to select a system image, select R, if it needs downloaded, download it and the click next. Finally name it and select Finish.

Now that you have the project and a AVD hit the greeen play icon in the top left and allow the system to load the AVD. Once this done you be placed in the apps home screen, enjoy.



Third Party Library

The only third party library (jar) is the mysql-connector-java-8.0.23.jar as that jar gives the code the functionality of connecting to a mySQL database



Organization

The code is in 2 halves, the backend java code and the frontend kotlin code. Before accessing any part of the code, make sure project is in android view. To access the frontend code, follow the folder path app -> java -> com.example.foodmaps.data -> activity, once here all the activity 
files can be seen, each one of these represents a page of the app and can be viewed in the AVD. For the backend java code follow the folder path app -> java -> database_Console. Here there are three files, Connect (The Main), restaurants (custom object), and User (another custom object). To run the Java files, right-click on Connect.java in Android Studio and select Run 'Connect.main()' With Coverage

Finally there is a file called DatabaseExport that can create the database at any time, just copy the contents into a system that accepts mySQL queries



Contributions
This program was made by Nathaniel Brooks, Ruel Coy, Elijah Tilus, and Ricardo Zuniga
