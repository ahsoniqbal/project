package com.ahson.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "choice_voting_history")
public class PollVotingHistory {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
	@ManyToOne(fetch = FetchType.LAZY)
	private Choice poll;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
	
	public PollVotingHistory() {}
	public PollVotingHistory(Long id, Question question, Choice poll, User user, Date createdAt) {
		super();
		this.id = id;
		this.question = question;
		this.poll = poll;
		this.user = user;
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Choice getPoll() {
		return poll;
	}
	public void setPoll(Choice poll) {
		this.poll = poll;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "PollVotingHistory [id=" + id + ", question=" + question + ", poll=" + poll + ", user=" + user
				+ ", createdAt=" + createdAt + "]";
	}
	
}
