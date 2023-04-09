package com.ahson.project.dto;

public class PollDTO {
	
	private String id;
	private String body;
	private String votes;
	private QuestionDTO question;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getVotes() {
		return votes;
	}
	public void setVotes(String votes) {
		this.votes = votes;
	}
	public QuestionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "PollDTO [id=" + id + ", body=" + body + ", votes=" + votes + ", question=" + question + "]";
	}
	
}
