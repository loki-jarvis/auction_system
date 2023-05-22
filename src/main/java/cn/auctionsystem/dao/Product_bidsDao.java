package cn.auctionsystem.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import com.auctionsystem.model.*;

public class Product_bidsDao {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public Product_bidsDao(Connection con) {
		this.con = con;
	}

	public List<Product_bids> getAllBids() {

		List<Product_bids> bids = new ArrayList<Product_bids>();

		try {
			query = "select * from Category";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {

				Product_bids row = new Product_bids();
				row.setUid(rs.getInt("uid"));
				row.setPid(rs.getInt("pid"));
				row.setCurrent_price(rs.getFloat("current_price"));

				bids.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bids;

	}

	public Product_bids getLatestBid(int aid) {

		List<Product_bids> bids = new ArrayList<Product_bids>();

		try {
			query = "select * from Product_bids where aid = ?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, aid);
			rs = pst.executeQuery();

			while (rs.next()) {

				Product_bids row = new Product_bids();
				row.setUid(rs.getInt("uid"));
				row.setPid(rs.getInt("pid"));
				row.setAid(rs.getInt("aid"));
				row.setCurrent_price(rs.getFloat("current_price"));

				bids.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (bids.size() == 0) {
			List<Auctions> auctions = new ArrayList<Auctions>();
			try {
				query = "select * from auctions where id = ?";
				pst = this.con.prepareStatement(query);
				pst.setInt(1, aid);
				rs = pst.executeQuery();
				while (rs.next()) {

					Auctions row = new Auctions();
					row.setId(rs.getInt("id"));
					row.setPid(rs.getInt("pid"));
					row.setMinimumPrice(rs.getFloat("minimum_price"));
					row.setUid(rs.getInt("uid"));

					auctions.add(row);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Product_bids(auctions.get(0).getUid(), auctions.get(0).getPid(), auctions.get(0).getMinimumPrice(), auctions.get(0).getId());
		}
		return bids.get(bids.size()-1);

	}
	
	
	
	public void InsertBid(Product_bids bid) throws SQLException{
			
		query = "INSERT INTO Product_bids(uid, pid, aid, current_price) VALUES (?, ?, ?, ?)";

		try(PreparedStatement pst = this.con.prepareStatement(query)) {

			pst.setInt(1, bid.getUid());
			pst.setInt(2, bid.getPid());
			pst.setInt(3, bid.getAid());
			pst.setFloat(4, bid.getCurrent_price());
			
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return;

	}
	
	
	public void notifyUsers(Product_bids bid) throws SQLException{
		
		ArrayList<String> bidNames = new ArrayList<String>();
		
		query = "SELECT u.name FROM Product_bids pb INNER JOIN user u ON pb.uid = u.uid WHERE pb.aid = ? GROUP BY pb.uid";

		try(PreparedStatement pst = this.con.prepareStatement(query)) {

			pst.setInt(1, bid.getAid());
			rs = pst.executeQuery();
			
			
			while (rs.next()) {

				bidNames.add(rs.getString("name"));
			}
			
			System.out.println("Notifying the following users about the bid: ");
			for (String name : bidNames) {
			    System.out.println(name);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return;

	}
	
	
	
	// CODE TO GET PREVIOUS BIDS
	
	
	public List<Product_bids> getPreviousBids(int aid) {

		List<Product_bids> bids = new ArrayList<Product_bids>();

		try {
			query = "select * from product_bids where aid = ?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, aid);
			rs = pst.executeQuery();

			while (rs.next()) {

				Product_bids row = new Product_bids();
				row.setUid(rs.getInt("uid"));
				row.setPid(rs.getInt("pid"));
				row.setAid(rs.getInt("aid"));
				row.setCurrent_price(rs.getFloat("current_price"));

				bids.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bids;

	}
	
	
	

}
