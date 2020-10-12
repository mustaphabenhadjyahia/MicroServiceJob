package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	@Autowired
	private JobRepository jobrepository ;
	
	public Job modiferetat(int id) {
		if (jobrepository.findById(id).isPresent()) {
			Job existingjob = jobrepository.findById(id).get();
		if(	existingjob.isEtat()) {
			
			existingjob.setEtat(false);
		}else {
			existingjob.setEtat(true);
		}
			

			return jobrepository.save(existingjob);
		} else
			return null;
	}
public List<Job> getall(){
return jobrepository.findAll();
	
}
public Job getbyid(int id) {
	return jobrepository.findById(id).get();
}
		
	

}
