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
		if(courseOfStudyDao.count()==0)
		{
			courseOfStudyDao.save(new CourseOfStudy("MEDICINA E CHIRURGIA", "Il Corso"));
			courseOfStudyDao.save(new CourseOfStudy("INGEGNERIA DELL'INFORMAZIONE", "Il Corso di Laurea in Ingegneria dell’Informazione forma professionisti che possano trovare occupazione nelle aziende manifatturiere e di servizi, con competenze nell’uso degli strumenti informatici e telematici dedicati ai sistemi organizzativi delle stesse. In particolare il laureato acquisirà conoscenze e competenze connesse agli aspetti tecnologici e scientifici alla base delle più innovative scoperte dell’era digitale, dalle nanotecnologie a Internet. Gli obiettivi formativi vengono raggiunti attraverso un’offerta didattica che alterna  contenuti teorici con esercitazioni di laboratorio."));
			courseOfStudyDao.save(new CourseOfStudy("GIURISPRUDENZA", "Il Corso di Laurea Magistrale in Giurisprudenza fornisce conoscenze approfondite dei principali saperi dell’area giuridica attraverso un equilibrato rapporto tra la formazione culturale di base, la formazione sui fondamenti e sugli aspetti più rilevanti delle discipline di diritto positivo e la formazione in discipline affini rilevanti per la comprensione del diritto. Obiettivo del percorso di studi è l’acquisizione da parte degli studenti di conoscenze avanzate relative alla formazione culturale del giurista.\n" + "La laurea in Giurisprudenza è obbligatoria per coloro che intendano svolgere le professioni di avvocato o notaio ovvero accedere ai ruoli della magistratura, dell’alta dirigenza pubblica o della carriera diplomatica."));
		}
	}

	@Bean
	public BasicTextEncryptor textEncryptor(){
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("mySecretEncryptionKeyForPPS");
		return textEncryptor;
	}
}
