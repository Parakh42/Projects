package com.parakh.parakh.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="request")
@Inheritance(strategy=InheritanceType.JOINED)
public class Request {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="requestId", unique=true, nullable=false)
	 private int requestId;
	    
	    
	 @Column(name="message", nullable=false)
	 private String message;
	    
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "personId")
     private Customer customer;
	    
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "postId")
     private PostCar postCar;
     
     @Column(name="postOwner", nullable=false)
	 private int postOwner;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PostCar getPostCar() {
		return postCar;
	}

	public void setPostCar(PostCar postCar) {
		this.postCar = postCar;
	}

	public int getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(int postOwner) {
		this.postOwner = postOwner;
	}
	
}
