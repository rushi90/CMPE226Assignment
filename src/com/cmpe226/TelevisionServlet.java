package com.cmpe226;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
//import org.json.simple.JSONObject;


/**
 * Servlet implementation class TelevisionServlet
 */
public class TelevisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelevisionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In TelevisionServlet");
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("DB226");
		DBCollection coll = db.getCollection("product");
		DBObject query = new BasicDBObject("category", "Television");
		DBCursor cursor = coll.find(query);
		
		System.out.println("Connection Done");
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
			JSONObject obj;		
				try {
					obj = (JSONObject) new JSONParser().parse(cursor.next()
							.toString());
					String product_id = obj.get("product_id").toString();
					String name = obj.get("name").toString();
					String description = obj.get("description").toString();
					String price = obj.get("price").toString();
					System.out.println(product_id);
					System.out.println(name);
				} catch (ParseException e) {
//					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				
		}
		cursor.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
