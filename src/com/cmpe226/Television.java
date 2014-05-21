package com.cmpe226;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cmpe226.dao.TelevisionDao;
import com.db.DatabaseConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Servlet implementation class Television
 */
public class Television extends HttpServlet {
	// DatabaseConnection dbconn;
	public ArrayList<TelevisionDao> television = new ArrayList<TelevisionDao>();
	private static final long serialVersionUID = 1L;

	Mongo mongo = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		// TODO Auto-generated method stub
		try {
			mongo = new Mongo("localhost");
			System.out.println("Connected");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Television() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws UnknownHostException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			UnknownHostException {
		// TODO Auto-generated method stub
		// DatabaseConnection dbconn = new DatabaseConnection();

		System.out.println("in doGet Method");
		
		DB db = mongo.getDB("DB226");
		DBCollection coll = db.getCollection("product");
		System.out.println(coll.findOne());

		//
		DBObject query = new BasicDBObject("category", "Television");
		DBCursor cursor = coll.find(query);
		System.out.println("Connection Done");
		while (cursor.hasNext()) {
//			System.out.println(cursor.next());
			JSONObject obj;
			TelevisionDao tdao=new TelevisionDao();
			
			//
			try {
				obj = (JSONObject) new JSONParser().parse(cursor.next()
						.toString());
				String product_id = obj.get("product_id").toString();
				System.out.println(product_id);
				String name = obj.get("name").toString();
				System.out.println(name);
				String description = obj.get("description").toString();
				System.out.println(description);
				String price = obj.get("price").toString();
				System.out.println(price);
				
				
				tdao.setProduct_id(product_id);
				tdao.setName(name);
				tdao.setPrice(price);
				tdao.setDescription(description);
				
			} catch (MongoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			television.add(tdao);
		}
		cursor.close();
//		mongo.close();
//		Object televisionDetails=television;
		request.setAttribute("TelevisionDAO", television);
		try {
			request.getRequestDispatcher("TelevisionList.jsp").forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
