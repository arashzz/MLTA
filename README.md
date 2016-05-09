ManuLife
This sample project is for Manulife assignment purpose only.

This spring project is compiled against java 1.8 so make sure you have your spring sts is set to compile this project with java 1.8

You can use the data.csv in the root directory as the initial data. Feel free to use your own csv file but make sure it follows the same format or if will be ignored. (I made duplicate data from the original data just to make it big in size in order to see the upload process, previously it was too small that you couldn't notice an upload process)

Make sure you have a mysql schema created with the same name as mentioned in the application.properties(in the root directory), also mentioned below:

spring.datasource.url = jdbc:mysql://localhost:3306/mltestdb (mysql connector driver is already added into the build path but it's not a bad idea to check if its checkbox is checked)
spring.datasource.username=root I assume that's anyone's mysql root username but you can change it to yours if it's different
spring.datasource.password=***** replace with your mysql root password
spring.jpa.hibernate.ddl-auto=create-drop is set to create-drop for the first init. Although there is no seed in this project but feel free to change it to update if you wanted to change any of the models.
