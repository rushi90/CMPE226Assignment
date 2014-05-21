package com.cmpe226;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cmpe226.dao.BooksDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class BookServlet
 */
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Mongo mongo = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BooksDao bdao = new BooksDao();
		System.out.println("in DoGet Method");

		System.out.println(request.getParameter("Details_book"));
		String product_id = request.getParameter("Details_book");
		DB db = mongo.getDB("DB226");
		DBCollection coll = db.getCollection("product");
		// System.out.println(coll.findOne());

		DBObject query = new BasicDBObject("product_id", product_id);
		DBCursor cursor = coll.find(query);
		System.out.println(cursor.count());
		System.out.println(cursor);

		JSONObject obj;
		while (cursor.hasNext()) {
			try {
				try {
					obj = (JSONObject) new JSONParser().parse(cursor.next()
							.toString());
					String name = obj.get("name").toString();
					System.out.println(name);
					String description = obj.get("description").toString();
					System.out.println(description);
					String price = obj.get("price").toString();
					System.out.println(price);

					String image_url = obj.get("image").toString();
					System.out.println(image_url);

					String author = obj.get("author").toString();
					System.out.println(author);
					String publisher = obj.get("publisher").toString();
					System.out.println(publisher);

					bdao.setName(name);
					bdao.setDescription(description);
					bdao.setAuthor(author);
					bdao.setPublisher(publisher);
					bdao.setImage(image_url);
					bdao.setPrice(price);
				} catch (org.json.simple.parser.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// String product_id = obj.get("product_id").toString();
				// System.out.println(product_id);

			} catch (MongoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		cursor.close();
		request.setAttribute("BookDAO_Details", bdao);
		
		try {
			request.getRequestDispatcher("BookDetails.jsp").forward(request,response);
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
