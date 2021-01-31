package com.houssame.sec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.houssame.sec.auth.dao.AppRoleRepository;
import com.houssame.sec.auth.dao.AppUserRepo;
import com.houssame.sec.auth.dao.ProfesseurRepo;
import com.houssame.sec.auth.entities.AppRole;
import com.houssame.sec.auth.entities.AppUser;
import com.houssame.sec.auth.entities.Professeur;
import com.houssame.sec.auth.service.account.AccService;

@SpringBootApplication
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class ServiceAuthentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAuthentificationApplication.class, args);
	}
	@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	CommandLineRunner start(AppUserRepo userRepo,AppRoleRepository roleRepo, AccService accService,ProfesseurRepo professeurRepo) {
		return args -> {
			userRepo.save(new AppUser("SofiaA", "sofiaPassword", "Sofia", "AG", "sofia@gmail.com", "10/5/92"));
			userRepo.save(new AppUser("RedaQ", "redaPass", "Reda", "QABLE", "reda@gmail.com", "10/5/92"));
			userRepo.save(new AppUser("AbdoM", "abdoPass", "Abdreeahmane", "MOUDINE", "abdo@gmail.com", "10/5/92"));
			userRepo.save(new AppUser("OussamaC", "oussPassword", "Oussama", "CHIHABI", "oussama@gmail.com", "10/5/92"));
			
			roleRepo.save(new AppRole("ADMIN"));
			roleRepo.save(new AppRole("USER"));
			roleRepo.save(new AppRole("SECRETAIRE"));
			roleRepo.save(new AppRole("COMPTABLE"));
			roleRepo.save(new AppRole("DIRECTEUR_ADJ"));
			roleRepo.save(new AppRole("MODERATOR"));
			
			accService.addRoleToUser("SofiaA", "MODERATOR");
			accService.addRoleToUser("SofiaA", "ADMIN");
			accService.addRoleToUser("SofiaA", "USER");
			
			accService.addRoleToUser("RedaQ", "MODERATOR");
			accService.addRoleToUser("RedaQ", "USER");
			
			accService.addRoleToUser("AbdoM", "MODERATOR");
			accService.addRoleToUser("AbdoM", "USER");
			
			accService.addRoleToUser("OussamaC", "MODERATOR");
			accService.addRoleToUser("OussamaC", "ADMIN");
			accService.addRoleToUser("OussamaC", "USER");
			
			professeurRepo.save(new Professeur("HamzaY", "hamzaPass", "YOUSFI", "Hamza", "hamza@gmail.com", "08/13/96"));
			professeurRepo.save(new Professeur("HichamK", "hichamPass", "KOUHAIL", "Hicham", "hicham@gmail.com", "08/13/96"));
			professeurRepo.save(new Professeur("AyoubT", "ayoubPass", "TAOUFIK", "Ayoub", "ayoub@gmail.com", "08/13/96"));
			
			accService.addRoleToUser("HamzaY", "PROFESSEUR");
			accService.addRoleToUser("HamzaY", "USER");
			
			accService.addRoleToUser("HichamK", "PROFESSEUR");
			accService.addRoleToUser("HichamK", "USER");
			
			accService.addRoleToUser("AyoubT", "PROFESSEUR");
			accService.addRoleToUser("AyoubT", "USER");
		};
		
	}

}
