package com.nirwantech.com.elk_stack_logging_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class ElkStackLoggingExampleApplication {



	private static final Logger logger= LoggerFactory.getLogger(ElkStackLoggingExampleApplication.class);

	@GetMapping("/getUser/{id}")
	public UserDetails getUserById(@PathVariable int id) {
		List<UserDetails> users=getUserDetails();
		UserDetails userDetails=users.stream().
				filter(u->u.getId()==id).findAny().orElse(null);
		if(userDetails!=null){
			logger.info("UserDetails found : {}",userDetails);
			return userDetails;
		}else{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("UserDetails Not Found with ID : {}",id);
			}
			return new UserDetails();
		}
	}


	private List<UserDetails> getUserDetails() {
		return Stream.of(new  UserDetails(1, "Jyo"),
						new UserDetails(2, "Shyam"),
						new UserDetails(3, "Ronit"),
						new UserDetails(4, "mark"))
				.collect(Collectors.toList());
	}



	public static void main(String[] args) {

		SpringApplication.run(ElkStackLoggingExampleApplication.class, args);
	}

}
