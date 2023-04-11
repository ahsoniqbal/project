package com.ahson.project.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "choice")
public class Choice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 1, max = 50)
	private String body;
	
	private Integer votes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Question question;

	
	public Choice() {}
	public Choice(Long id, String body, Integer votes, Question question) {
		super();
		this.id = id;
		this.body = body;
		this.votes = votes;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Choice )) return false;
        return id != null && id.equals(((Choice) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    

}
