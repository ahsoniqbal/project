package com.ahson.project.dto;

import java.util.ArrayList;
import java.util.List;
import com.ahson.project.models.Poll;

public class QuestionDTO {
	private String id;
	private String question;
	private String postedOn;
	private List<PollDTO> polls = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}
	public List<PollDTO> getPolls() {
		return polls;
	}
	public void setPolls(List<PollDTO> polls) {
		this.polls = polls;
	}
	@Override
	public String toString() {
		return "QuestionDTO [id=" + id + ", question=" + question + ", postedOn=" + postedOn + ", polls=" + polls + "]";
	}
}
