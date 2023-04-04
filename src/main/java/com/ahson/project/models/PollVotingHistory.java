package com.ahson.project.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poll_voting_history")
public class PollVotingHistory {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Question question;
	@ManyToOne
	private Poll poll;
	@ManyToOne
	private User user;
	private Date created_at;
	
	
	public PollVotingHistory() {}
	public PollVotingHistory(Integer id, Question question, Poll poll, User user, Date created_at) {
		super();
		this.id = id;
		this.question = question;
		this.poll = poll;
		this.user = user;
		this.created_at = created_at;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Poll getPoll() {
		return poll;
	}
	public void setPoll(Poll poll) {
		this.poll = poll;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
