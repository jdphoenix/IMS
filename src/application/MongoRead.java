package application;
import java.io.BufferedWriter;
import java.io.FileWriter;

import org.bson.Document;

//import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//import static com.mongodb.client.model.Filters.*;
//import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;

public class MongoRead {
	/*

	public void allInCollection(MongoDatabase db, String collection) {
			FindIterable<Document> iterable =
					db.getCollection(collection).find();

			iterable.forEach(new Block<Document>() {
			    @Override
			    public void apply(final Document document) {
			        System.out.println(document);
			    }
			});
	}

	public void byFieldValue(MongoDatabase db, String collection, String field, String value) {
		FindIterable<Document> iterable = db.getCollection(collection).find(
		        new Document(field, value));

		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		    }
		});
	}

	public void sorted(MongoDatabase db, String collection, String field, String value) {
		FindIterable<Document> iterable = db.getCollection(collection).find()
		        .sort(new Document(field, 1));

		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		    }
		});
	}

	public void allDocuments(MongoDatabase db) {
		try {
		DBCollection coll = (DBCollection) db.getCollection("NBGardens");
		System.out.println("Collection NB selected successfully");
		DBCursor cursor = coll.find();
		int i = 1;
		while (cursor.hasNext()) {
			  System.out.println("Inserted Document: "+i);
	          System.out.println(cursor.next());
	          i++;
		}
		}catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }

	}
	*/
}
