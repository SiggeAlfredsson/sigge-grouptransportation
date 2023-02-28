package com.siggebig.GroupTransport;

import com.siggebig.GroupTransport.model.Group;

import com.siggebig.GroupTransport.model.User.User;
import com.siggebig.GroupTransport.service.GroupService;
import com.siggebig.GroupTransport.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GroupTransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupTransportApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(GroupService groupService, UserService userService) {
		return args -> {

			System.out.println("-------initalized database-------");


			Group group = new Group();
			group.setName("Group1");

			Group group2 = new Group();
			group2.setName("Group2");

			groupService.save(group);
			groupService.save(group2);

			User user = new User();
			user.setUsername("user1");
			userService.save(user);

			User user2 = new User();
			user2.setUsername("user2");
			userService.save(user2);

		};
	}

}