package cn.auctionsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auctionsystem.model.Auctions;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuctionsDao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public AuctionsDao(Connection con) {
		this.con = con;
	}
	
		public List<Auctions> getAllAuctions(){
		
		List<Auctions> products = new ArrayList<Auctions>();
		
		try {
			query = "select * from Auctions";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
//				System.out.println("here2");
				Auctions row = new Auctions();
				row.setId(rs.getInt("id"));
				row.setPid(rs.getInt("pid"));
				row.setCategory(rs.getInt("category"));
				row.setClosingTime(rs.getObject("closing_time", Timestamp.class));
				row.setUpperLimit(rs.getFloat("upper_limit"));
				row.setBidType(rs.getInt("bid_type"));
				row.setBidIncrement(rs.getFloat("bid_increment"));
				row.setUid(rs.getInt("uid"));
				
				
				products.add(row);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("here" + products);
		return products;
		
	}
		
		
		public List<Auctions> getSortedAuctions2(int sortBy){
			
			List<Auctions> products = new ArrayList<Auctions>();
			
			try {
				query = "select * from Auctions";
				pst = this.con.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
//					System.out.println("here2");
					Auctions row = new Auctions();
					row.setId(rs.getInt("id"));
					row.setPid(rs.getInt("pid"));
					row.setCategory(rs.getInt("category"));
					row.setClosingTime(rs.getObject("closing_time", Timestamp.class));
					row.setUpperLimit(rs.getFloat("upper_limit"));
					row.setBidType(rs.getInt("bid_type"));
					row.setBidIncrement(rs.getFloat("bid_increment"));
					row.setUid(rs.getInt("uid"));
					
					
					products.add(row);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
//			System.out.println("here" + products);
			return products;
			
		}
		
		
		// Below code is to get sorted auctions
		
		public List<Auctions> getSortedAuctions(int sortBy) throws SQLException {
			
//			System.out.println("SortBy is"+ sortBy);
		    
		    List<Auctions> auctions = new ArrayList<>();

		    try {
		    	
		    	if (sortBy == 1) {
		    		query = "SELECT * FROM Auctions ORDER BY minimum_price ASC";
		    	}
		    	else if (sortBy == 2) {
		    		query = "SELECT * FROM Auctions ORDER BY minimum_price DESC";
		    	}
		    	else {
		    		query = "select * from Auctions";
		    	}
		    	
		    	
				pst = this.con.prepareStatement(query);
				rs = pst.executeQuery();

		        while (rs.next()) {
		            int id = rs.getInt("id");
		            int pid = rs.getInt("pid");
		            int uid = rs.getInt("uid");
		            float minimumPrice = rs.getFloat("minimum_price");
		            Timestamp closingTime = rs.getTimestamp("closing_time");
		            int bidType = rs.getInt("bid_type");
		            float upperLimit = rs.getFloat("upper_limit");
		            float bidIncrement = rs.getFloat("bid_increment");
		            int category = rs.getInt("category");

		            Auctions auction = new Auctions(id, pid, uid, minimumPrice, closingTime, bidType, upperLimit, bidIncrement, category);
		            auctions.add(auction);
		        }
		    } catch(Exception e){
				e.printStackTrace();
			}

		    return auctions;
		}

		
		
		
		
	
		
		
		// Code to add auction into database
		
		public void addAuction(Auctions auction) throws SQLException {
	        query = "INSERT INTO Auctions (pid, uid, minimum_price, closing_time, bid_type, upper_limit, bid_increment, category) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement pst = this.con.prepareStatement(query)) {
	        	
	            pst.setInt(1, auction.getPid());
	            pst.setInt(2, auction.getUid());
	            pst.setFloat(3, auction.getMinimumPrice());
	            
	            
//	            LocalDateTime closingTime = auction.getClosingTime().toLocalDateTime();
//	            pst.setTimestamp(4, Timestamp.valueOf(closingTime) );
//	            
//	            pst.setTimestamp(4, Timestamp.valueOf(auction.getClosingTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

	            
	            LocalDateTime closingTime = auction.getClosingTime().toLocalDateTime();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	            String formattedClosingTime = closingTime.format(formatter);
	            Timestamp timestamp = Timestamp.valueOf(formattedClosingTime);
	            pst.setTimestamp(4, timestamp);

	            
	            pst.setInt(5, auction.getBidType());
	            pst.setFloat(6, auction.getUpperLimit());
	            pst.setFloat(7, auction.getBidIncrement());
	            pst.setInt(8, auction.getCategory());

	            pst.executeUpdate();
	        }
	        catch(Exception e){
				e.printStackTrace();
			}
			
			return;
	    }
		
		
		
		
		
		// Code to get specific auction based on auction ID
		
		
		public Auctions getSpecificAuction(int aid){
			
			List<Auctions> auctions = new ArrayList<Auctions>();
			
			try {
				query = "select * from Auctions where id = ?";
				pst = this.con.prepareStatement(query);
				pst.setInt(1, aid);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					Auctions row = new Auctions();
					row.setId(rs.getInt("id"));
					row.setPid(rs.getInt("pid"));
					row.setCategory(rs.getInt("category"));
					row.setClosingTime(rs.getObject("closing_time", Timestamp.class));
					row.setUpperLimit(rs.getFloat("upper_limit"));
					row.setBidType(rs.getInt("bid_type"));
					row.setBidIncrement(rs.getFloat("bid_increment"));
					row.setUid(rs.getInt("uid"));
					
					
					auctions.add(row);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("here" + auctions);
			return auctions.get(0);
			
		}
		
		
		
		// Get search results along with sort
		
public List<Auctions> getSpecificSortedAuctions(int sortBy, int searchVal) throws SQLException {
			
//			System.out.println("SortBy is"+ sortBy);
		    
		    List<Auctions> auctions = new ArrayList<>();

		    try {
		    	
		    	if (sortBy == 1) {
//		    		query = "SELECT * FROM Auctions ORDER BY minimum_price ASC";
		    		query = "SELECT a.* FROM Auctions a JOIN Product p ON a.pid = p.id WHERE p.category = ? ORDER BY a.minimum_price ASC";
		    	}
		    	else if (sortBy == 2) {
		    		query = "SELECT a.* FROM Auctions a JOIN Product p ON a.pid = p.id WHERE p.category = ? ORDER BY a.minimum_price DESC";
		    	}
		    	else {
		    		query = "SELECT a.* FROM Auctions a JOIN Product p ON a.pid = p.id WHERE p.category = ?";
		    	}
		    	
				pst = this.con.prepareStatement(query);
				pst.setInt(1, searchVal);
				rs = pst.executeQuery();

		        while (rs.next()) {
		            int id = rs.getInt("id");
		            int pid = rs.getInt("pid");
		            int uid = rs.getInt("uid");
		            float minimumPrice = rs.getFloat("minimum_price");
		            Timestamp closingTime = rs.getTimestamp("closing_time");
		            int bidType = rs.getInt("bid_type");
		            float upperLimit = rs.getFloat("upper_limit");
		            float bidIncrement = rs.getFloat("bid_increment");
		            int category = rs.getInt("category");

		            Auctions auction = new Auctions(id, pid, uid, minimumPrice, closingTime, bidType, upperLimit, bidIncrement, category);
		            auctions.add(auction);
		        }
		    } catch(Exception e){
				e.printStackTrace();
			}

		    return auctions;
		}
		





////// CODE TO GET SIMILAR AUCTIONS BASED ON CATEGORY
		
public List<Auctions> getSimilarAuctions(int cid){
	
	System.out.println(cid);
	
	List<Auctions> products = new ArrayList<Auctions>();
	
	
	try {
		query = "SELECT a.* FROM Auctions a INNER JOIN Product p ON a.pid = p.id WHERE p.category = ? and closing_time BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) AND NOW()";
				
		pst = this.con.prepareStatement(query);
		pst.setInt(1, cid);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			Auctions row = new Auctions();
			row.setId(rs.getInt("id"));
			row.setPid(rs.getInt("pid"));
			row.setCategory(rs.getInt("category"));
			row.setClosingTime(rs.getObject("closing_time", Timestamp.class));
			row.setUpperLimit(rs.getFloat("upper_limit"));
			row.setBidType(rs.getInt("bid_type"));
			row.setBidIncrement(rs.getFloat("bid_increment"));
			row.setUid(rs.getInt("uid"));
			
			
			products.add(row);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
//	System.out.println("here" + products);
	return products;
	
}

public List<Auctions> getUserAuctions(int uid){
	
	System.out.println(uid);
	
	List<Auctions> products = new ArrayList<Auctions>();
	
	
	try {
		query = "SELECT a.* FROM Auctions a WHERE a.id in (SELECT DISTINCT aid from Product_bids where uid = ?)";
				
		pst = this.con.prepareStatement(query);
		pst.setInt(1, uid);
		rs = pst.executeQuery();
		
		while(rs.next()) {
//			System.out.println("here2");
			Auctions row = new Auctions();
			row.setId(rs.getInt("id"));
			row.setPid(rs.getInt("pid"));
			row.setCategory(rs.getInt("category"));
			row.setClosingTime(rs.getObject("closing_time", Timestamp.class));
			row.setUpperLimit(rs.getFloat("upper_limit"));
			row.setBidType(rs.getInt("bid_type"));
			row.setBidIncrement(rs.getFloat("bid_increment"));
			row.setUid(rs.getInt("uid"));
			
			
			products.add(row);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
//	System.out.println("here" + products);
	return products;
	
}



//////CODE TO GET PREVIOUS AUCTIONS FROM SELLER

public List<Auctions> getSellerAuctions(int uid){

System.out.println(uid);

List<Auctions> auctions = new ArrayList<Auctions>();


try {
	query = "SELECT a.* FROM Auctions a WHERE a.uid = ?";
			
	pst = this.con.prepareStatement(query);
	pst.setInt(1, uid);
	rs = pst.executeQuery();
	
	while(rs.next()) {
//		System.out.println("here2");
		Auctions row = new Auctions();
		row.setId(rs.getInt("id"));
		row.setPid(rs.getInt("pid"));
		row.setCategory(rs.getInt("category"));
		row.setClosingTime(rs.getObject("closing_time", Timestamp.class));
		row.setUpperLimit(rs.getFloat("upper_limit"));
		row.setBidType(rs.getInt("bid_type"));
		row.setBidIncrement(rs.getFloat("bid_increment"));
		row.setUid(rs.getInt("uid"));
		
		
		auctions.add(row);
	}
	
}catch(Exception e){
	e.printStackTrace();
}
//System.out.println("here" + auctions);
return auctions;

}
		

}
