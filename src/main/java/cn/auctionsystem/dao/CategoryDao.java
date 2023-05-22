package cn.auctionsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.auctionsystem.model.Category;

public class CategoryDao {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public CategoryDao(Connection con) {
		this.con = con;
	}

	public List<Category> getAllCategories() {

		List<Category> categories = new ArrayList<Category>();

		try {
			query = "select * from Category";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {

				Category row = new Category();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setDescription(rs.getString("description"));

				categories.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;

	}

}
