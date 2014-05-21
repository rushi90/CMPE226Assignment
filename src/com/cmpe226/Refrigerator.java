package com.cmpe226;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cmpe226.dao.RefrigeratorDao;
import com.cmpe226.dao.TelevisionDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Servlet implementation class Refrigerator
 */
public class Refrigerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Mongo mongo = null;
	public ArrayList<RefrigeratorDao> refrigerator = new ArrayList<RefrigeratorDao>();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			mongo = new Mongo("localhost");
			System.out.println("Connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	public Refrigerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in doGet Method");
		DB db = mongo.getDB("DB226");
		DBCollection coll = db.getCollection("product");
		System.out.println(coll.findOne());
		DBObject query = new BasicDBObject("category", "Refrigerator");
		DBCursor cursor = coll.find(query);
		System.out.println("Connection Done");
		System.out.println("--------------------");
		System.out.println(cursor.count());
		System.out.println("--------------------");
		
		while (cursor.hasNext()) {
			RefrigeratorDao rDao=new RefrigeratorDao();
			JSONObject obj;
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
				
				rDao.setProduct_id(product_id);
				rDao.setName(name);
				rDao.setDescription(description);
				rDao.setPrice(price);
			} catch (MongoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			refrigerator.add(rDao);

		}
	
		cursor.close();
		request.setAttribute("refrigeratorDAO", refrigerator);
		try {
			request.getRequestDispatcher("RefrigeratorList.jsp").forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		mongo.close();
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
