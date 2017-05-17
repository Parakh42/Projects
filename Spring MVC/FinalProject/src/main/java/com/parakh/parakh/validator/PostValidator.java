package com.parakh.parakh.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.parakh.parakh.dao.PostDAO;
import com.parakh.parakh.pojo.PostCar;

@Component
public class PostValidator implements Validator{
	
	@Autowired
	@Qualifier("postDao")
	PostDAO postDao;
	
	public boolean supports(Class aClass) {
		return aClass.equals(PostCar.class);
	}

	public void validate(Object obj, Errors errors) {
		PostCar p = (PostCar) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "info", "error.invalid.info", "Information Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "arrivalFrom", "error.invalid.arrivalFrom", "Arrival Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destinationTo", "error.invalid.destinationTo", "Destination Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fileName", "error.invalid.fileName", "Filename Required");
		
		String image=p.getPhoto().getOriginalFilename();
        
        if(image.equals("")){
            errors.rejectValue("photo", "error.invalid.photo", "Please upload a photo");
        }
        
        else if(!image.endsWith("jpg") && !image.endsWith("png") && !image.endsWith("jpeg")){
            errors.rejectValue("photo",  "error.invalid.photo", "Please upload only jpg,png or jpeg files");
        }
        
        String pattern = "(?=.*[^ ])[a-zA-Z0-9 ]+" ;
        if(!p.getInfo().matches(pattern)){
            errors.rejectValue("info", "error.invalid.info", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!p.getArrivalFrom().matches(pattern)){
	            errors.rejectValue("arrivalFrom", "error.invalid.arrivalFrom", "Only Alphanumeric Values Allowed");
	            return;
	        }
        else if(!p.getDestinationTo().matches(pattern)){
			            errors.rejectValue("destinationTo", "error.invalid.destinationTo", "Only Alphanumeric Values Allowed");
			            return;
			        }
					
        else if(!p.getFileName().matches(pattern)){
			            errors.rejectValue("fileName", "error.invalid.fileName", "Only Alphanumeric Valuers Allowed");
			            return;
				}

}
}
