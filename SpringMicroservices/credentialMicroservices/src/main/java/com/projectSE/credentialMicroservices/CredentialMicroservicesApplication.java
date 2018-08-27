package com.projectSE.credentialMicroservices;

import com.projectSE.credentialMicroservices.daos.CourseOfStudyDao;
import com.projectSE.credentialMicroservices.daos.UserTypeDao;
import com.projectSE.credentialMicroservices.entities.CourseOfStudy;
import com.projectSE.credentialMicroservices.entities.UserType;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CredentialMicroservicesApplication implements CommandLineRunner{

	@Autowired
	UserTypeDao userTypeDao;

	@Autowired
	CourseOfStudyDao courseOfStudyDao;

	public static void main(String[] args) {
		SpringApplication.run(CredentialMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userTypeDao.count()==0)
		{
			userTypeDao.save(new UserType("Studente"));
			userTypeDao.save(new UserType("Docente"));
			userTypeDao.save(new UserType("Segreteria"));
		}
	}

	@Bean
	public BasicTextEncryptor textEncryptor(){
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("mySecretEncryptionKeyForPPS");
		return textEncryptor;
	}
}
