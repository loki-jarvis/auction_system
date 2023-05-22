package com.auctionsystem.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Question {
	
	private int id;
	private String question;
	private String answer;
	private int uid;
	private Timestamp q_post_time;
	private Timestamp a_post_time;
	
	
	
	
	public Question() {
	}




	public Question(int id, String question, String answer, int uid, Timestamp q_post_time, Timestamp a_post_time) {
	
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.uid = uid;
		this.q_post_time = q_post_time;
		this.a_post_time = a_post_time;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getQuestion() {
		return question;
	}




	public void setQuestion(String question) {
		this.question = question;
	}




	public String getAnswer() {
		return answer;
	}




	public void setAnswer(String answer) {
		this.answer = answer;
	}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public Timestamp getQ_post_time() {
		return q_post_time;
	}




	public void setQ_post_time(Timestamp q_post_time) {
		this.q_post_time = q_post_time;
	}




	public Timestamp getA_post_time() {
		return a_post_time;
	}




	public void setA_post_time(Timestamp a_post_time) {
		this.a_post_time = a_post_time;
	}




	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", uid=" + uid
				+ ", q_post_time=" + q_post_time + ", a_post_time=" + a_post_time + "]";
	}
	
	
	
	
	
	
}
