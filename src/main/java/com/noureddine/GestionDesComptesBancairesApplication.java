package com.noureddine;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.noureddine.dao.ClientRepository;
import com.noureddine.dao.CompteRepository;
import com.noureddine.dao.OperationRepository;
import com.noureddine.entities.Client;
import com.noureddine.entities.Compte;
import com.noureddine.entities.CompteCourant;
import com.noureddine.entities.CompteEpargne;
import com.noureddine.entities.Retrait;
import com.noureddine.entities.Versement;
import com.noureddine.metier.IBanqueMetier;

@SpringBootApplication
public class GestionDesComptesBancairesApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteReposiory;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(GestionDesComptesBancairesApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		Client c1=clientRepository.save(new Client("Noureddine","nouredine_taher@yahoo.com"));
		Client c2=clientRepository.save(new Client("Ali","ali@gmail.com"));
		
		Compte cp1 = compteReposiory.save(new CompteCourant("c1", new Date(),12004, c1, 5000));
		Compte cp2 = compteReposiory.save(new CompteEpargne("c2", new Date(),15005, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(),6000,cp1));
		operationRepository.save(new Versement(new Date(),800,cp1));
		operationRepository.save(new Retrait(new Date(),2300,cp1));
		operationRepository.save(new Versement(new Date(),5500,cp1));
		
		operationRepository.save(new Versement(new Date(),9000,cp2));
		operationRepository.save(new Versement(new Date(),7500,cp2));
		operationRepository.save(new Retrait(new Date(),2500,cp2));

		banqueMetier.verser(cp1.getCodeCompte(), 4500);
		banqueMetier.retirer(cp1.getCodeCompte(),1011);
		banqueMetier.virement(cp2.getCodeCompte(), cp1.getCodeCompte(), 5555);
	
		
		
		

	}

}
