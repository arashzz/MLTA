package com.example.entities;

import javax.persistence.*;

@Entity
public class Website {

	public Website() {
		
	}
	public Website(String url) {
		this.url = url;
	}
	@Id
	@Column(name="website_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
 
}
