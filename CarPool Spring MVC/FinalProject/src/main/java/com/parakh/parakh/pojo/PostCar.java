package com.parakh.parakh.pojo;

import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="postCar")
public class PostCar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="postId", unique=true, nullable=false)
	private Integer postId;
	
	@Column(name="info")
	private String info;
	
	@Column(name="arrivalFrom")
	private String arrivalFrom;
	
	@Column(name="destinationTo")
	private String destinationTo;
	
	@ManyToOne
	private User user;
	
	@Transient
	int postedBy;
	
	@OneToMany(mappedBy = "postCar")
	private Set<Request> request = new HashSet<Request>();
	
	@Column(name = "filename")
	private String fileName;
	
	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	
	public PostCar(){
		
	}
	
	public PostCar(String info, String arrivalFrom, String destinationTo, User user){
		this.info = info;
		this.arrivalFrom = arrivalFrom;
		this.destinationTo = destinationTo;
		this.user = user;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getArrivalFrom() {
		return arrivalFrom;
	}

	public void setArrivalFrom(String arrivalFrom) {
		this.arrivalFrom = arrivalFrom;
	}

	public String getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}
	

	public int getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(int postedBy) {
		this.postedBy = postedBy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Request> getRequest() {
		return request;
	}

	public void setRequest(Set<Request> request) {
		this.request = request;
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
