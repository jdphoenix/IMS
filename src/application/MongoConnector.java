package application;
import java.util.Scanner;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;

public class MongoConnector {
	
	 private MongoClient mongoClient;
	 private Scanner input = new Scanner(System.in);
	 
	public boolean connectToServer(String ip, int port) {
		
	    try {
			
	       // connect to mongo server
	       mongoClient = new MongoClient(ip, port);
	  
	       System.out.println("Connection to database established...");
	       //boolean auth = db.authenticate(myUserName, myPassword);
	       // System.out.println("Authentication: "+auth);
	       
	    }catch(Exception e){
	       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       return false;
	    }	
	    return true;
	}
	
	public MongoDatabase useDatabase(String database) {
			try {
		   // connect to the database
			MongoDatabase db = mongoClient.getDatabase(database);
				return db;
			}catch(Exception e){
			       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			}
			return null;	
			
	}
	
	public MongoClient getMongoClient() {
		return this.mongoClient;
	}
}
