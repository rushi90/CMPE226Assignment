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

import com.cmpe226.dao.TelevisionDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Servlet implementation class TelevisionDetailServlet
 */
public class TelevisionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArrayList<TelevisionDao> television_details = new ArrayList<TelevisionDao>();
	Mongo mongo = null;

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

	public TelevisionDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TelevisionDao tdao=new TelevisionDao();
		// TODO Auto-generated method stub
		System.out.println("in DoGet Method");
		
		System.out.println(request.getParameter("Details_Television"));
		String product_id=request.getParameter("Details_Television");
		DB db = mongo.getDB("DB226");
		DBCollection coll = db.getCollection("product");
//		System.out.println(coll.findOne());
		
		
		DBObject query = new BasicDBObject("product_id", product_id);
		DBCursor cursor = coll.find(query);
		System.out.println(cursor.count());
		System.out.println(cursor);
		
		JSONObject obj;
		while (cursor.hasNext()) {
			try {
				obj = (JSONObject) new JSONParser().parse(cursor.next()
						.toString());
				
//				String product_id = obj.get("product_id").toString();
//				System.out.println(product_id);
				String name = obj.get("name").toString();
				System.out.println(name);
				String description = obj.get("description").toString();
				System.out.println(description);
				String price = obj.get("price").toString();
				System.out.println(price);
				
				String image_url=obj.get("image").toString();
				System.out.println(image_url);
				
				String ratings=obj.get("ratings").toString();
				System.out.println(ratings);
				String width=obj.get("width").toString();
				System.out.println(width);
				String dimensions=obj.get("dimensions").toString();
				System.out.println(dimensions);
				String resolution=obj.get("resolution").toString();
				System.out.println(resolution);
				String refresh_rate=obj.get("refresh_rate").toString();
				System.out.println(refresh_rate);
				
				tdao.setName(name);
				tdao.setDescription(description);
				tdao.setDimensions(dimensions);
				tdao.setImage(image_url);
				tdao.setPrice(price);
				tdao.setProduct_id(product_id);
				tdao.setRatings(ratings);
				tdao.setRefresh_rate(refresh_rate);
				tdao.setResolution(resolution);
				tdao.setWidth(width);
				
				
				
				
			} catch (MongoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cursor.close();
		request.setAttribute("TelevisionDAO_Details", tdao);
		
		try {
			request.getRequestDispatcher("TelevisionDetails.jsp").forward(request,response);
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
