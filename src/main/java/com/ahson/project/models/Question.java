package com.ahson.project.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 150)
	private String question;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="posted_on")
	private Date postedOn;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asked_by_id")
	private User askedBy;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Choice> choices = new ArrayList<Choice>();

	public Question() {}
	public Question(@NotNull Long id, @NotNull @NotEmpty @Size(min = 10, max = 150) String question,
			@NotNull Date postedOn, @NotNull User askedBy, List<Choice> choices) {
		super();
		this.id = id;
		this.question = question;
		this.postedOn = postedOn;
		this.askedBy = askedBy;
		this.choices = choices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public User getAskedBy() {
		return askedBy;
	}

	public void setAskedBy(User askedBy) {
		this.askedBy = askedBy;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setPolls(List<Choice> choices) {
		this.choices = choices;
	}
	
	public void addPoll(Choice choice) {
		choices.add(choice);
		choice.setQuestion(this);
	}
	public void removePoll(Choice choice) {
		choices.remove(choice);
		choice.setQuestion(null);
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", postedOn=" + postedOn + ", askedBy=" + askedBy
				+ ", choices=" + choices + "]";
	}
}
