package com.example.polls;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.model.User;
import com.example.polls.repository.RoleRepository;
import com.example.polls.repository.UserRepository;

@SpringBootApplication
@EntityScan(basePackageClasses = { 
		PollsApplication.class,
		Jsr310JpaConverters.class 
})
public class PollsApplication implements CommandLineRunner{
	
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepository userRepo;

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PollsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		roleRepo.save(new Role(RoleName.ROLE_ADMIN));
//		roleRepo.save(new Role(RoleName.ROLE_USER));
//		User user = new User("Magnus","magnus","m@kvartsgatan13.se","pass");
//		Set<Role> roles = new HashSet<>();
//		Optional<Role> role = roleRepo.findByName(RoleName.ROLE_ADMIN);
//		roles.add(role.get());
//		user.setRoles(roles);
//		userRepo.save(user);
		
	}
}