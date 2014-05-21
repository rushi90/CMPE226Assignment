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

import com.cmpe226.dao.BooksDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Servlet implementation class Book
 */
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<BooksDao> book = new ArrayList<BooksDao>();
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
			System.out.println("connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public Book() {
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
		DBObject query = new BasicDBObject("category", "Books");
		DBCursor cursor = coll.find(query);
		System.out.println("Connection Done");
		System.out.println("--------------------");
		System.out.println(cursor.count());
		System.out.println("--------------------");

		while (cursor.hasNext()) {

			JSONObject obj;
			BooksDao bdao=new BooksDao();
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
				
				bdao.setProduct_id(product_id);
				bdao.setName(name);
				bdao.setPrice(price);
				bdao.setDescription(description);
				
			} catch (MongoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			book.add(bdao);
		}
		cursor.close();
		request.setAttribute("BookDAO", book);
		try {
			request.getRequestDispatcher("BookList.jsp").forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mongo.close();
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
