package cn.auctionsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.*;

import com.auctionsystem.model.Product;

public class ProductDao {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductDao(Connection con) {
		this.con = con;
	}

	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<Product>();

		try {
			query = "select * from Product";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setDescription(rs.getString("description"));
				row.setCategory(rs.getInt("category"));

				products.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;

	}

	// Below is code to get specific product based on product ID

	public Product getSpecificProduct(int pid) {

		List<Product> products = new ArrayList<Product>();

		try {
			query = "select * from Product where id = ?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, pid);
			rs = pst.executeQuery();

			while (rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setDescription(rs.getString("description"));
				row.setCategory(rs.getInt("category"));

				products.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products.get(0);

	}

}
