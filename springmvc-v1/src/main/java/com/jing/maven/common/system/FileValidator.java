package com.jing.maven.common.system;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jing.maven.common.model.UploadedFile;

@Component
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class arg0){
		return false;
	}
	
	@Override
	public void validate(Object uploadedFile, Errors errors){
		
		UploadedFile file = (UploadedFile) uploadedFile;
		
		if(file.getFile().getSize() == 0){
			errors.rejectValue("file", "uploadForm.selectFile", "Please select a file!");
		}
	}
	
}
