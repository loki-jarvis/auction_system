package cn.auctionsystem.dao;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.auctionsystem.model.Auctions;
import com.auctionsystem.model.Question;

import cn.auctionsystem.model.User;

public class QuestionsDao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public QuestionsDao(Connection con) {
		this.con = con;
	}
	
public List<Question> getAllQuestions() {
		
	List<Question> questions = new ArrayList<Question>();
		
		try {
			
			//"select * from user where email = "+ email +" and password = "+password;
			//we are not writing in the above way to avoid SQL injection
			
			query = "select * from Questions ";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			
			while(rs.next()) {
				Question row = new Question();

				row.setId(rs.getInt("id"));
				row.setUid(rs.getInt("user"));
				row.setQuestion(rs.getString("question"));
				row.setAnswer(rs.getString("answer"));
				row.setQ_post_time(rs.getObject("q_post_time", Timestamp.class));
				row.setA_post_time(rs.getObject("a_post_time", Timestamp.class));
				
				questions.add(row);
				
			}
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("Questions: "+ questions);
		return questions;
	}
	
public void addQuestion(int user_id, String question) {
	
	LocalDateTime closingTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedClosingTime = closingTime.format(formatter);
    Timestamp timestamp = Timestamp.valueOf(formattedClosingTime);
    
    System.out.println(timestamp);
	
	query = String.format("INSERT into Questions (user, status, question, q_post_time) values (%d, %b, '%s', '%tF')", user_id, false, question, timestamp);
	
	
	try {
		System.out.println(LocalDateTime.now());
		System.out.println(query);
		pst = this.con.prepareStatement(query);
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}



///// CODE TO GET UNANSWERED QUESTIONS!!!!!!


public List<Question> getUnansweredQuestions() {
	
	List<Question> questions = new ArrayList<Question>();
		
		try {
			
			//"select * from user where email = "+ email +" and password = "+password;
			//we are not writing in the above way to avoid SQL injection
			
			query = "select * from Questions WHERE status = 0 ";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			
			while(rs.next()) {
				Question row = new Question();

				row.setId(rs.getInt("id"));
				row.setUid(rs.getInt("user"));
				row.setQuestion(rs.getString("question"));
				row.setAnswer(rs.getString("answer"));
				row.setQ_post_time(rs.getObject("q_post_time", Timestamp.class));
				row.setA_post_time(rs.getObject("a_post_time", Timestamp.class));
				
				questions.add(row);
				
			}
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("Questions: "+ questions);
		return questions;
	}



public Question getSpecificQuestion(int id) {
	
	List<Question> questions = new ArrayList<Question>();
		
		try {
			
			
			query = "select * from Questions where id = ?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Question row = new Question();

				row.setId(rs.getInt("id"));
				row.setUid(rs.getInt("user"));
				row.setQuestion(rs.getString("question"));
				row.setAnswer(rs.getString("answer"));
				row.setQ_post_time(rs.getObject("q_post_time", Timestamp.class));
				row.setA_post_time(rs.getObject("a_post_time", Timestamp.class));
				questions.add(row);
			}
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return questions.get(0);
	}



public void saveAnswer(String answer, int id) {
	
		
		try {
			
			query = "UPDATE questions SET answer = ?, status = 1 WHERE id = ? ";
			pst = this.con.prepareStatement(query);
			pst.setString(1, answer );
			pst.setInt(2, id);
			pst.executeUpdate();
			
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}



}
