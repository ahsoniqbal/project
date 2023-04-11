package com.ahson.project.dto;

public class ChoiceResponse {
	
	private Long id;
	private String body;
	private Long voteCount;
	private Integer votePercent;
	
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
	public Long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}
	public Integer getVotePercent() {
		return votePercent;
	}
	public void setVotePercent(Integer votePercent) {
		this.votePercent = votePercent;
	}
	
}
