package com.db;

import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.text.TabableView;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cmpe226.dao.BooksDao;
import com.cmpe226.dao.NailPolishDao;
import com.cmpe226.dao.RefrigeratorDao;
import com.cmpe226.dao.TelevisionDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DatabaseConnection {

	DB db = null;

	public DatabaseConnection() throws UnknownHostException {
		MongoClient mongo;

		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("DB226");

	}

	public ArrayList<TelevisionDao> getTelevisionDetails()
			throws UnknownHostException, ParseException {
		ArrayList<TelevisionDao> televison = new ArrayList<TelevisionDao>();
//		MongoClient mongo = new MongoClient("localhost", 27017);
//		DB db = mongo.getDB("DB226");
		DBCollection coll = db.getCollection("product");
		DBObject query = new BasicDBObject("category", "Television");
		DBCursor cursor = coll.find(query);

		while (cursor.hasNext()) {

			TelevisionDao tDao = new TelevisionDao();
			JSONObject obj = (JSONObject) new JSONParser().parse(cursor.next()
					.toString());
			String product_id = obj.get("product_id").toString();
			String name = obj.get("name").toString();
			String description = obj.get("description").toString();
			String price = obj.get("price").toString();

			tDao.setProduct_id(product_id);
			tDao.setName(name);
			tDao.setPrice(price);
			tDao.setDescription(description);

			System.out.println(product_id + " " + name + " " + description
					+ " " + price);
			televison.add(tDao);
		}
		return televison;
	}

	// public ArrayList<TelevisionDao> getTelevisionDetails() {
	//
	//
	//
	// ArrayList<TelevisionDao> televison = new ArrayList<TelevisionDao>();
	// DBCollection coll = db.getCollection("product");
	// DBObject query = new BasicDBObject("category", "Television");
	// DBCursor cursor = coll.find(query);
	//
	// try {
	// while (cursor.hasNext()) {
	// TelevisionDao tDao = new TelevisionDao();
	// JSONObject obj = (JSONObject) new JSONParser().parse(cursor
	// .next().toString());
	// String product_id = obj.get("product_id").toString();
	// String name = obj.get("name").toString();
	// String description = obj.get("description").toString();
	// String price = obj.get("price").toString();
	//
	// System.out.println(product_id + " " + name + " " + description
	// + " " + price);
	//
	// tDao.setProduct_id(product_id);
	// tDao.setName(name);
	// tDao.setDescription(description);
	// tDao.setPrice(price);
	//
	// televison.add(tDao);
	// }
	// cursor.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return televison;
	//
	// }

	// public ArrayList<RefrigeratorDao> getRefrigeratorDetails() {
	// ArrayList<RefrigeratorDao> refrigerator = new
	// ArrayList<RefrigeratorDao>();
	// DBCollection coll = db.getCollection("product");
	// DBObject query = new BasicDBObject("category", "Refrigerator");
	// DBCursor cursor = coll.find(query);
	//
	// try {
	// while (cursor.hasNext()) {
	// RefrigeratorDao rDao = new RefrigeratorDao();
	// JSONObject obj = (JSONObject) new JSONParser().parse(cursor
	// .next().toString());
	// String product_id = obj.get("product_id").toString();
	// String name = obj.get("name").toString();
	// String description = obj.get("description").toString();
	// String price = obj.get("price").toString();
	//
	// System.out.println(product_id + " " + name + " " + description
	// + " " + price);
	//
	// rDao.setProduct_id(product_id);
	// rDao.setName(name);
	// rDao.setDescription(description);
	// rDao.setPrice(price);
	//
	// refrigerator.add(rDao);
	// }
	// cursor.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return refrigerator;
	//
	// }
	// public ArrayList<BooksDao> getBookDetails() {
	// ArrayList<BooksDao> books = new ArrayList<BooksDao>();
	// DBCollection coll = db.getCollection("product");
	// DBObject query = new BasicDBObject("category", "Books");
	// DBCursor cursor = coll.find(query);
	//
	// try {
	// while (cursor.hasNext()) {
	// BooksDao bDao = new BooksDao();
	// JSONObject obj = (JSONObject) new JSONParser().parse(cursor
	// .next().toString());
	// String product_id = obj.get("product_id").toString();
	// String name = obj.get("name").toString();
	// String description = obj.get("description").toString();
	// String price = obj.get("price").toString();
	//
	// System.out.println(product_id + " " + name + " " + description
	// + " " + price);
	//
	// bDao.setProduct_id(product_id);
	// bDao.setName(name);
	// bDao.setDescription(description);
	// bDao.setPrice(price);
	//
	// books.add(bDao);
	// }
	// cursor.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return books;
	//
	// }
	// public ArrayList<NailPolishDao> getNailPolishDetails() {
	// ArrayList<NailPolishDao> nail_polish = new ArrayList<NailPolishDao>();
	// DBCollection coll = db.getCollection("product");
	// DBObject query = new BasicDBObject("category", "Nail Polish");
	// DBCursor cursor = coll.find(query);
	//
	// try {
	// while (cursor.hasNext()) {
	// NailPolishDao nDao = new NailPolishDao();
	// JSONObject obj = (JSONObject) new JSONParser().parse(cursor
	// .next().toString());
	// String product_id = obj.get("product_id").toString();
	// String name = obj.get("name").toString();
	// String description = obj.get("description").toString();
	// String price = obj.get("price").toString();
	//
	// System.out.println(product_id + " " + name + " " + description
	// + " " + price);
	//
	// nDao.setProduct_id(product_id);
	// nDao.setName(name);
	// nDao.setDescription(description);
	// nDao.setPrice(price);
	//
	// nail_polish.add(nDao);
	// }
	// cursor.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return nail_polish;
	//
	// }
	//

//	public static void main(String[] args) throws UnknownHostException,
//			ParseException {
//
//		MongoClient mongo = new MongoClient("localhost", 27017);
//		DB db = mongo.getDB("DB226");
//		DBCollection coll = db.getCollection("product");
//		DBObject query = new BasicDBObject("category", "Television");
//		DBCursor cursor = coll.find(query);
//
//		while (cursor.hasNext()) {
//			TelevisionDao tDao = new TelevisionDao();
//			JSONObject obj = (JSONObject) new JSONParser().parse(cursor.next()
//					.toString());
//			String product_id = obj.get("product_id").toString();
//			String name = obj.get("name").toString();
//			String description = obj.get("description").toString();
//			String price = obj.get("price").toString();
//
//			System.out.println(product_id + " " + name + " " + description
//					+ " " + price);
//
//		}
//
//	}

}
