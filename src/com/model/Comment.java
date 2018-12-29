package com.model;

import java.sql.Date;

public class Comment {
	private Integer ID;
    private String name;
    private Integer newId;
    private String userId;
    private Date createAt;
    private String content;
    private String title;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Comment(String name, Integer newId, String userId, Date createAt,
			String content) {
		super();
		this.name = name;
		this.newId = newId;
		this.userId = userId;
		this.createAt = createAt;
		this.content = content;
	}
	public Integer getNewId() {
		return newId;
	}
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Comment() {
		
	}
    
}
