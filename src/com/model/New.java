package com.model;

import java.sql.Date;

public class New {
    private Integer ID;
    private String name;
    private Integer category_id;
    private String content;
    private String short_content;
    private String image;
    private String auth;
    private String name_cate;
    private Integer typeOfNew;
    private Date createAt;
    private Date exp;

	public New(Integer ID, String name, String short_content, String image, String auth, String name_cate) {
		this.ID = ID;
		this.name = name;
		this.short_content = short_content;
		this.image = image;
		this.auth = auth;
		this.name_cate = name_cate;
	}

	public New() {
	}

	public String getName_cate() {
		return name_cate;
	}


	public void setName_cate(String name_cate) {
		this.name_cate = name_cate;
	}


	public New(String name, Integer category_id, String content, String short_content, String image, String auth, String name_cate, Integer typeOfNew, Date createAt, Date exp) {
		this.name = name;
		this.category_id = category_id;
		this.content = content;
		this.short_content = short_content;
		this.image = image;
		this.auth = auth;
		this.name_cate = name_cate;
		this.typeOfNew = typeOfNew;
		this.createAt = createAt;
		this.exp = exp;
	}

	public New(Integer ID, String name, Integer category_id, String content, String short_content, String image, String auth, Integer typeOfNew, Date createAt, Date exp) {
		this.ID = ID;
		this.name = name;
		this.category_id = category_id;
		this.content = content;
		this.short_content = short_content;
		this.image = image;
		this.auth = auth;
		this.typeOfNew = typeOfNew;
		this.createAt = createAt;
		this.exp = exp;
	}

	public void setShort_content(String short_content) {
		this.short_content = short_content;
	}

	public Integer getTypeOfNew() {
		return typeOfNew;
	}

	public void setTypeOfNew(Integer typeOfNew) {
		this.typeOfNew = typeOfNew;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Integer getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getShort_content() {
		return short_content;
	}


	public void setSort_content(String short_content) {
		this.short_content = short_content;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getAuth() {
		return auth;
	}


	public void setAuth(String auth) {
		this.auth = auth;
	}


	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", category_id="
				+ category_id + ", content=" + content + ",short_content=" + short_content + ",auth=" + auth + ", image=" + image + "]";
	}
    
}
