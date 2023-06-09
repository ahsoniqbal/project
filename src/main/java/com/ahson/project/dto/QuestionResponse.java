package com.ahson.project.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class QuestionResponse {

	private Long id;
	private String question;
	private List<ChoiceResponse> choices = new ArrayList<>();
	private UserSummary createdBy;
	private Date createdAt;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long selectedChoice;
	private Long totalVotes;
	
	
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
	public List<ChoiceResponse> getChoices() {
		return choices;
	}
	public void setChoices(List<ChoiceResponse> choices) {
		this.choices = choices;
	}
	public UserSummary getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserSummary createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Long getSelectedChoice() {
		return selectedChoice;
	}
	public void setSelectedChoice(Long selectedChoice) {
		this.selectedChoice = selectedChoice;
	}
	public Long getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(Long totalVotes) {
		this.totalVotes = totalVotes;
	}
	
}
