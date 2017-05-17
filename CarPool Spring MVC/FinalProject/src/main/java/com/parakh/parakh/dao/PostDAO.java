package com.parakh.parakh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.parakh.parakh.exception.PostException;
import com.parakh.parakh.pojo.Customer;
import com.parakh.parakh.pojo.PostCar;
import com.parakh.parakh.pojo.Request;

public class PostDAO extends DAO {

	 public PostCar create(PostCar postCar)
	            throws PostException {
	        try {
	            begin();            
	            getSession().save(postCar);     
	            commit();
	            return postCar;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not post car", e);
	            throw new PostException("Exception while posting car: " + e.getMessage());
	        }
	    }

	    public void delete(PostCar postCar)
	            throws PostException {
	        try {
	            begin();
	            getSession().delete(postCar);
	            commit();
	            //return postCar;
	        } catch (HibernateException e) {
	            rollback();
	            throw new PostException("Could not delete post", e);
	        }
	    }
	    
	    public List<PostCar> list() throws PostException{
	    	
	    	try {
	            begin();
	            Query q = getSession().createQuery("from PostCar");
	            List<PostCar> postCar = q.list();
	            commit();
	            return postCar;
	        } catch (HibernateException e) {
	            rollback();
	            throw new PostException("Could not give list", e);
	        }
	    	
	    }
	    
        public List<PostCar> specificList(int personId) throws PostException{
	    	
	    	try {
	            begin();
	            Query q = getSession().createQuery("from PostCar where user.personId = :personId");
	            q.setInteger("personId", personId);
	            List<PostCar> postCar = q.list();
	            commit();
	            return postCar;
	        } catch (HibernateException e) {
	            rollback();
	            throw new PostException("Could not give list", e);
	        }
	    	
	    }
	
        public PostCar get(int postId) throws PostException {
    		try {
    			begin();
    			Query q = getSession().createQuery("from PostCar where postId= :postId");
    			q.setInteger("postId", postId);		
    			PostCar postCar = (PostCar) q.uniqueResult();
    			commit();
    			return postCar;
    		} catch (HibernateException e) {
    			rollback();
    			throw new PostException("Could not get posted car" + postId, e);
    		}
    	}
        
       public List<PostCar> search(String arrival, String destination) throws PostException{
	    	
	    	try {
	            
	            List<PostCar> searchList = list();
	            for(PostCar ps : searchList){
	            System.out.println(ps+"gredgwtqwq");
	            }
	            List<PostCar> addList = new ArrayList<PostCar>();
	            for(PostCar p: searchList){
	            	System.out.println("here 1 ");
	            	if(p.getArrivalFrom().contains(arrival) && p.getDestinationTo().contains(destination)){
	            		System.out.println("here 2 ");
	            		addList.add(p);
	            	}
	            
	            }
	            
	            for(PostCar hh : addList){
	            	System.out.println(hh.getArrivalFrom()+"arr");
	            	System.out.println(hh.getDestinationTo()+"dd");
	            }
	            
	            
	            
	            return addList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new PostException("Could hjhjh not give list", e);
	        }
	    	
	    }
       
       public void storeMessage(String message, PostCar postCar, Customer customer){
    	   		begin();
    	   		Request request = new Request();
    	   		request.setCustomer(customer);
    	   		request.setMessage(message);
    	   		request.setPostCar(postCar);
    	   		request.setPostOwner(postCar.getUser().getPersonId());
    	   		getSession().save(request);
    	   		commit();
       }
	
       public List<Request> messageList(int personId) throws PostException{
	    	
	    	try {
	            begin();
	            Query q = getSession().createQuery("from Request where postOwner = :personId");
	            q.setInteger("personId", personId);
	            List<Request> request = q.list();
	            commit();
	            return request;
	        } catch (HibernateException e) {
	            rollback();
	            throw new PostException("Could not give list", e);
	        }
	    	
	    }
       
       public List<Request> messageAllList() throws PostException{
	    	
	    	try {
	            begin();
	            Query q = getSession().createQuery("from Request");
	            List<Request> messageAllList = q.list();
	            commit();
	            return messageAllList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new PostException("Could not give list", e);
	        }
	    	
	    }

}
	

