package com.parakh.parakh;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.parakh.parakh.dao.PostDAO;
import com.parakh.parakh.dao.UserDAO;
import com.parakh.parakh.exception.PostException;
import com.parakh.parakh.exception.UserException;
import com.parakh.parakh.pojo.Customer;
import com.parakh.parakh.pojo.PostCar;
import com.parakh.parakh.pojo.Request;
import com.parakh.parakh.pojo.User;
import com.parakh.parakh.validator.PostValidator;

@Controller
@RequestMapping("/postCar/*")
public class PostController {
	
	@Autowired
    @Qualifier("postDao")
	PostDAO postDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("mailSender")
	private MailSender mailSender;
	
	@Autowired
	@Qualifier("postValidator")
	private PostValidator postValidator;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/postCar/add", method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request) throws Exception {			
		//return new ModelAndView("postcar-form", "postCar", new PostCar());
		ModelAndView mv = new ModelAndView();
		mv.addObject("postCar", new PostCar());
		mv.setViewName("postcar-form");
		return mv;
	}
	
	@RequestMapping(value = "/postCar/add", method = RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest request,@ModelAttribute("postCar") PostCar postCar, BindingResult result) throws Exception {

		postValidator.validate(postCar, result);

		if (result.hasErrors()) {
			return new ModelAndView("postcar-form", "postCar", postCar);
		}
//		try {			
//			//HttpSession session = request.getSession();
//			System.out.println("grgre frewrf "+ postCar.getPostedBy());
//			User u = userDao.get(postCar.getPostedBy());
//			postCar.setUser(u);
//			postCar = postDao.create(postCar);
//			
//			return new ModelAndView("post-success", "postCar", postCar);
//			
//		} catch (PostException e) {
//			System.out.println(e.getMessage());
//			return new ModelAndView("error", "errorMessage", "error while login");
//		}
//		
//		
//	}
		//System.out.println(request.getParameter("fileName")+"----------------------------------------------------");
		try {
			
			if (postCar.getFileName().trim() != "" || postCar.getFileName() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					path = servletContext.getRealPath("resources").replace("build\\", ""); // gives real path as Lab9/build/web/
																				  // so we need to replace build in the path
																						}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
				}
				directory = new File(path + "\\" + postCar.getFileName());
				boolean temp = directory.exists();
				if (!temp) {
					temp = directory.mkdir();
				}
				if (temp) {
//					// We need to transfer to a file
//					CommonsMultipartFile photoInMemory = postCar.getPhoto();
//
//					String fileName = photoInMemory.getOriginalFilename();
//					// could generate file names as well
//
//					File localFile = new File(directory.getPath(), fileName);
//
//					// move the file from memory to the file
//
//					photoInMemory.transferTo(localFile);
					File localFile;
                    CommonsMultipartFile photoInMemory = postCar.getPhoto();
                    String name = photoInMemory.getOriginalFilename();
                    localFile =new File("C:\\webtools\\images",name);
                    photoInMemory.transferTo(localFile);
					postCar.setFileName(localFile.getPath());
		//			System.out.println("File is stored at" + localFile.getPath());
	//				System.out.print("registerNewUser");
//					User u = userDao.register(user);
					User u = userDao.get(postCar.getPostedBy());
					postCar.setUser(u);
					postCar = postDao.create(postCar);
					

				} else {
					System.out.println("Failed to create directory!");
				}
			}

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (PostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

		return new ModelAndView("post-success", "postCar", postCar);
	}
	
	@RequestMapping(value = "/postCar/view", method = RequestMethod.GET)
	public ModelAndView viewUser(HttpServletRequest request) throws Exception {

		try {			
			
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			
			List<PostCar> postCar = postDao.specificList(u.getPersonId());
			return new ModelAndView("post-list", "postCar", postCar);
			
		} catch (PostException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
		
	}
	
	@RequestMapping(value = "/postCar/delete", method = RequestMethod.POST)
	public ModelAndView deleteCategory(HttpServletRequest request) throws Exception {

		try {			
         	HttpSession session = request.getSession();
//			System.out.println("grgre frewrf "+ postCar.getPostedBy());
//			User u = userDao.get(postCar.getPostedBy());
//			postCar.setUser(u);
//			System.out.println("fsdgdb" + postCar.getDestinationTo());
			int postId = Integer.parseInt(request.getParameter("delete"));
			System.out.println(postId+"======================================================================");
			//PostCar postCar = postDao.get(postId);
			User u = (User)session.getAttribute("user");
			List<PostCar> postCarList = postDao.specificList(u.getPersonId());
			for(PostCar postCar : postCarList)
			{
				postCar = postDao.get(postId);
				postDao.delete(postCar);
				
			}
						
		} catch (PostException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		return new ModelAndView("post-delete");
		
	}
	
	@RequestMapping(value = "/postCar/request", method = RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request) throws Exception {

		try {			
			
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			
			List<PostCar> postCar = postDao.list();
			return new ModelAndView("customer-list", "postCar", postCar);
						
		} catch (PostException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
		
	}
	
	@RequestMapping(value="/postCar/search", method = RequestMethod.GET)
	public ModelAndView searchCar(HttpServletRequest request) throws Exception {			
		//return new ModelAndView("postcar-form", "postCar", new PostCar());
		ModelAndView mv = new ModelAndView();
		mv.addObject("postCar", new PostCar());
		mv.setViewName("searchCar-list");
		return mv;
	}
	@RequestMapping(value = "/postCar/search", method = RequestMethod.POST)
	public ModelAndView searchCar(HttpServletRequest request,@ModelAttribute("postCar") PostCar postCar, BindingResult result) throws Exception {

//		postValidator.validate(postCar, result);
//
//		if (result.hasErrors()) {
//			return new ModelAndView("searchCar-list", "postCar", postCar);
//		}
		
		try {			
         	//HttpSession session = request.getSession();
			String arrival = request.getParameter("arrivalFrom");
			String destination = request.getParameter("destinationTo");
			System.out.println(arrival +"fsghj");
			System.out.println(destination +"fsghfefefefegej");
			List<PostCar> searchlist= postDao.search(arrival, destination);
			for(PostCar ps : searchlist){
			System.out.println(ps +"fsghjfefee");
			}
			
			return new ModelAndView("search-list", "searchlist", searchlist);
			
		} catch (PostException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "Sorry there is error in finding your search result");
		}
		
		
	}
	
	//message
	@RequestMapping(value="/postCar/requestMessage", method = RequestMethod.GET)
	public ModelAndView sendRequest(HttpServletRequest request) throws Exception {			
		//return new ModelAndView("postcar-form", "postCar", new PostCar());
		
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		int personId = customer.getPersonId();
		int postId = Integer.parseInt(request.getParameter("request"));
		PostCar postCar = postDao.get(postId);
		List<Request> messageAllList = postDao.messageAllList();
		ModelAndView mv = new ModelAndView();
		for(Request message : messageAllList)
		{
			if(message.getCustomer().getPersonId() == personId  &&  message.getPostCar().getPostId() == postId)
			{
				mv.setViewName("request-alreadySent");
				return mv;
			}
		}
		
		mv.addObject("postCar", postCar);
		mv.addObject("request", new Request());
		mv.setViewName("request-form");
		return mv;
	}
	
	@RequestMapping(value = "/postCar/requestMessage", method = RequestMethod.POST)
	public ModelAndView sendRequest(HttpServletRequest request, Request requestMessage, BindingResult result) throws Exception {

		try {		
         	String message = request.getParameter("message");
         	int postId = Integer.parseInt(request.getParameter("send"));
         	PostCar postCar = postDao.get(postId);
         	//postCar.getPostId();
         	Customer customer = (Customer)request.getSession().getAttribute("customer");
         	//System.out.println(customer.getFirstName() + "hi POsted car here");
         	//requestMessage.setMessage(message);
         	//System.out.println(message + "hi message");
         	//requestMessage.setPostCar(postCar);
         	//System.out.println(postCar + "hi POsted car here");
         	//requestMessage.setCustomer(customer);
         	//System.out.println(customer + "hi customer here");
        	postDao.storeMessage(message, postCar, customer);
//         	SimpleMailMessage email = new SimpleMailMessage();
//            email.setTo("parakh.mahajan@gmail.com");
//            email.setSubject("CarPost Application");
//            email.setText("Hi Thanks for applying to Confirm ");
//            mailSender.send(email);
			ModelAndView mv = new ModelAndView();
			mv.addObject("postCar", postCar);
			mv.addObject("message", requestMessage);
			mv.setViewName("request-success");
			return mv;
			
		} catch (PostException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
		
	}
	
	//getting list of request list
	@RequestMapping(value="/postCar/messageList", method = RequestMethod.GET)
	public ModelAndView requestList(HttpServletRequest request) throws Exception {			
		//return new ModelAndView("postcar-form", "postCar", new PostCar());
		User u = (User)request.getSession().getAttribute("user");
		int personId = u.getPersonId();
    	List<Request> messageList = postDao.messageList(personId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("messageList", messageList);
		mv.setViewName("message-list");
		return mv;
	}
	
	@RequestMapping(value = "/postCar/mail", method = RequestMethod.POST)
	public ModelAndView seacrhUser(HttpServletRequest request) throws UserException {
		
		String messageId = request.getParameter("messageId");
		String key = request.getParameter(messageId);
		String personId = request.getParameter("send");
		try {
			Customer c = userDao.getCustomer(personId);
			String customerEmail = c.getEmail();
			if(key.equalsIgnoreCase("confirmation"))
			{
				SimpleMailMessage email = new SimpleMailMessage();
	            email.setTo(customerEmail);
	            email.setSubject("CarPost Application");
	            email.setText("Hi, Thanks for applying. Your car post request is confirmed ");
	            mailSender.send(email);
	            return new ModelAndView("user-home");
			}
			else
			{
				SimpleMailMessage email = new SimpleMailMessage();
	            email.setTo(customerEmail);
	            email.setSubject("CarPost Application");
	            email.setText("Hi Thanks for applying. You car post request is rejected ");
	            mailSender.send(email);
	            return new ModelAndView("user-home");
			}
			
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "errorMessage", "error while sending mail");
		}
		//User u =get method from dao(persid)
		//var sendemail = u.getEmail.id;
		
        
	}
	

}
