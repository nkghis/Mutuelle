package ics.ci.mutuelle;


import ics.ci.mutuelle.dto.prestation.consultation.ConsultationDTO;
import ics.ci.mutuelle.dto.prestation.consultation.ConsultationINPUT;
import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.repository.ConsultationRepository;
import ics.ci.mutuelle.service.PrescriptionService;
import ics.ci.mutuelle.service.PrestationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@SpringBootApplication
public class MutuelleApplication {





	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MutuelleApplication.class, args);

		/*SpecialiteHopitalRepository specialiteHopitalRepository = ctx.getBean(SpecialiteHopitalRepository.class);
		HopitalRepository hopitalRepository = ctx.getBean(HopitalRepository.class);
		SpecialiteRepository specialiteRepository = ctx.getBean(SpecialiteRepository.class);
		Hopital hopital = hopitalRepository.findByPartenaireId(1L);
		Specialite specialite = specialiteRepository.findBySpecialiteId(3L);
		specialiteHopitalRepository.save(new SpecialiteHopital(specialite, hopital));
		List<Hopital> hopitals = hopitalRepository.findAll();
		String u ="";

		UserRepository userRepository = ctx.getBean(UserRepository.class);
		AppUser user = userRepository.findByUserName("admin");
		String s ="";*/

		/*AssureService assureService = ctx.getBean(AssureService.class);
		AdherantRepository adherantRepository = ctx.getBean(AdherantRepository.class);
		BeneficiaireRepository beneficiaireRepository = ctx.getBean(BeneficiaireRepository.class);

		List<BeneficiaireDTO> out = assureService.listToBeneficiaireDTO(beneficiaireRepository.findAll());*/

/*		AdherantMapper adherantMapper = ctx.getBean(AdherantMapper.class);
		BeneficiaireMapper beneficiaireMapper = ctx.getBean(BeneficiaireMapper.class);
		AdherantRepository adherantRepository = ctx.getBean(AdherantRepository.class);
		BeneficiaireRepository beneficiaireRepository = ctx.getBean(BeneficiaireRepository.class);
		Adherant adherant = adherantRepository.findByAssureId(1L);
		Beneficiaire beneficiaire = beneficiaireRepository.findByAssureId(4L);
		AdherantDTOut dto = adherantMapper.toDTOut(adherant);


		List<AdherantDTOut> ou = adherantMapper.listToDTOut(adherantRepository.findAll());
		BeneficiaireDTO bdto = beneficiaireMapper.toDTOut(beneficiaire);*/

		/*AssureService assureService = ctx.getBean(AssureService.class);
		List<AdherantDTOut> ou = assureService.listAdherantDTOut();
		List<BeneficiaireDTO> outs = assureService.listToBeneficiaireDTOut();
		String s = "";
		*/


/*		//Ajout Police Adherant et Beneficiaire
		System.out.println("===============DEBUT TRANSACTION=======================");
		PoliceRepository policeRepository = ctx.getBean(PoliceRepository.class);
		Police policeBronze = policeRepository.save(new Police(UUID.randomUUID().toString(), "BRONZE"));
		Police policeArgent = policeRepository.save(new Police(UUID.randomUUID().toString(), "ARGENT"));
		Police policeOr = policeRepository.save(new Police(UUID.randomUUID().toString(), "OR"));
		Police policePlatinium = policeRepository.save(new Police(UUID.randomUUID().toString(), "PLATINIUM"));
		System.out.println("===============AJOUT POLICE=======================");
		policeRepository.findAll().forEach(u->System.out.println(u.getLibelle()));
		System.out.println("Police ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");


		System.out.println("===============DEBUT TRANSACTION ADHERANT=======================");
		AdherantRepository adherantRepository = ctx.getBean(AdherantRepository.class);
		Adherant adherant1 = new Adherant();
		adherant1.setMatricule(UUID.randomUUID().toString());
		adherant1.setNom("ZOUZOU");
		adherant1.setPrenom("Oka Fabrice");
		adherant1.setDatenaissance(LocalDate.of(1977, 10, 1));
		adherant1.setSexe(Sexe.MASCULIN);
		adherant1.setTelephone("+2250707070708");
		adherant1.setStatut(true);
		adherant1.setPolice(policeBronze);

		Adherant adherant2 = new Adherant();
		adherant2.setMatricule(UUID.randomUUID().toString());
		adherant2.setNom("YAO");
		adherant2.setPrenom("Kouakou Paul David");
		adherant2.setDatenaissance(LocalDate.of(1980, 8, 12));
		adherant2.setSexe(Sexe.MASCULIN);
		adherant2.setTelephone("+2250707070709");
		adherant2.setStatut(true);
		adherant2.setPolice(policeOr);

		Adherant adherant3 = new Adherant();
		adherant3.setMatricule(UUID.randomUUID().toString());
		adherant1.setNom("TRA");
		adherant3.setPrenom("Lou Marie Madeleine");
		adherant3.setDatenaissance(LocalDate.of(1981, 9, 16));
		adherant3.setSexe(Sexe.FEMININ);
		adherant3.setTelephone("+2250707070701");
		adherant3.setStatut(true);
		adherant3.setPolice(policePlatinium);


		adherantRepository.save(adherant1);
		adherantRepository.save(adherant2);
		adherantRepository.save(adherant3);

		System.out.println("===============AJOUT ADHERANT=======================");
		adherantRepository.findAll().forEach(u->System.out.println(u.getNom() + " " + u.getPrenom()));
		System.out.println("Adherants ajoutés avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============DEBUT TRANSACTION BENEFICIAIRE=======================");
		BeneficiaireRepository beneficiaireRepository = ctx.getBean(BeneficiaireRepository.class);
		Beneficiaire beneficiaire1 = new Beneficiaire();
		beneficiaire1.setMatricule(UUID.randomUUID().toString());
		beneficiaire1.setNom("ZOUZOU");
		beneficiaire1.setPrenom("Kra Gustave");
		beneficiaire1.setDatenaissance(LocalDate.of(1990, 10, 1));
		beneficiaire1.setSexe(Sexe.MASCULIN);
		beneficiaire1.setTelephone("+2250707070708");
		beneficiaire1.setStatut(true);
		beneficiaire1.setAdherant(adherant1);

		Beneficiaire beneficiaire2 = new Beneficiaire();
		beneficiaire2.setMatricule(UUID.randomUUID().toString());
		beneficiaire2.setNom("ZOUZOU");
		beneficiaire2.setPrenom("Ya Martin");
		beneficiaire2.setDatenaissance(LocalDate.of(1995, 2, 2));
		beneficiaire2.setSexe(Sexe.MASCULIN);
		beneficiaire2.setTelephone("+2250707070700");
		beneficiaire2.setStatut(true);
		beneficiaire2.setAdherant(adherant1);

		Beneficiaire beneficiaire3 = new Beneficiaire();
		beneficiaire3.setMatricule(UUID.randomUUID().toString());
		beneficiaire3.setNom("YAO");
		beneficiaire3.setPrenom("Akissi Olga");
		beneficiaire3.setDatenaissance(LocalDate.of(2001, 3, 13));
		beneficiaire3.setSexe(Sexe.FEMININ);
		beneficiaire3.setTelephone("+3350707070703");
		beneficiaire3.setStatut(true);
		beneficiaire3.setAdherant(adherant2);

		Beneficiaire beneficiaire4 = new Beneficiaire();
		beneficiaire4.setMatricule(UUID.randomUUID().toString());
		beneficiaire4.setNom("YAO");
		beneficiaire4.setPrenom("Aya Anne-Marie");
		beneficiaire4.setDatenaissance(LocalDate.of(2003, 4, 24));
		beneficiaire4.setSexe(Sexe.FEMININ);
		beneficiaire4.setTelephone("+4450707070704");
		beneficiaire4.setStatut(true);
		beneficiaire4.setAdherant(adherant2);

		Beneficiaire beneficiaire5 = new Beneficiaire();
		beneficiaire5.setMatricule(UUID.randomUUID().toString());
		beneficiaire5.setNom("YAO");
		beneficiaire5.setPrenom("Yao Jean");
		beneficiaire5.setDatenaissance(LocalDate.of(2006, 5, 14));
		beneficiaire5.setSexe(Sexe.MASCULIN);
		beneficiaire5.setTelephone("+4450707070704");
		beneficiaire5.setStatut(true);
		beneficiaire5.setAdherant(adherant2);

		Beneficiaire beneficiaire6 = new Beneficiaire();
		beneficiaire6.setMatricule(UUID.randomUUID().toString());
		beneficiaire6.setNom("ALLO");
		beneficiaire6.setPrenom("Edwige");
		beneficiaire6.setDatenaissance(LocalDate.of(2010, 4, 4));
		beneficiaire6.setSexe(Sexe.FEMININ);
		beneficiaire6.setTelephone("+4460707070704");
		beneficiaire6.setStatut(true);
		beneficiaire6.setAdherant(adherant3);
		beneficiaireRepository.save(beneficiaire1);
		beneficiaireRepository.save(beneficiaire2);
		beneficiaireRepository.save(beneficiaire3);
		beneficiaireRepository.save(beneficiaire4);
		beneficiaireRepository.save(beneficiaire5);
		beneficiaireRepository.save(beneficiaire6);

		System.out.println("===============AJOUT BENEFICIARE=======================");
		beneficiaireRepository.findAll().forEach(u->System.out.println(u.getNom() + " " + u.getPrenom()));
		System.out.println("Bénéficiaires ajoutés avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");*/




/*
		//Ajout de specialité
		System.out.println("===============DEBUT TRANSACTION SPECIALITE=======================");

		SpecialiteRepository specialiteRepository = ctx.getBean(SpecialiteRepository.class);
		Specialite cardiologie =  specialiteRepository.save(new Specialite("CARDIOLOGIE", "Coeur, Système Circulatoire"));
		Specialite oncologie =  specialiteRepository.save(new Specialite("ONCOLOGIE", "Cancer"));
		Specialite gastro =  specialiteRepository.save(new Specialite("GASTRO-ENTEROLOGIE", "Foie, Intestin, Estomac, Pancréas"));
		Specialite neurologie =  specialiteRepository.save(new Specialite("NEUROLOGIE", "Nerf, Systemes Nerveux"));
		Specialite general =  specialiteRepository.save(new Specialite("GENERALE", "Medecine Générale"));
		Specialite ophtamologie =  specialiteRepository.save(new Specialite("OPHTAMOLOGIE", "Yeux"));
		Specialite maternite =  specialiteRepository.save(new Specialite("MATERNITE", "Accouchement"));
		Specialite gynecologie =  specialiteRepository.save(new Specialite("GYNECOLOGIE", "Sexe feminin"));
		Specialite urologie =  specialiteRepository.save(new Specialite("UROLOGIE", "Sexe masculin"));
		System.out.println("===============AJOUT SPECIALITES=======================");
		specialiteRepository.findAll().forEach(u->System.out.println(u.getLibelle()));
		System.out.println("Specialités ajoutés avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		//Ajout de Partenaire.
		//Ajout de Hopitaux

		System.out.println("===============DEBUT TRANSACTION HOPITAUX=======================");
		HopitalRepository hopitalRepository = ctx.getBean(HopitalRepository.class);

		Hopital  hopitalLesvallons = new Hopital();
		hopitalLesvallons.setReference(UUID.randomUUID().toString());
		hopitalLesvallons.setNom("LES VALLONS");
		hopitalLesvallons.setContact("+2250101010101");
		hopitalLesvallons.setEtat(true);
		hopitalRepository.save(hopitalLesvallons);

		Hopital hopitalLesRosiers = new Hopital();
		hopitalLesRosiers.setReference(UUID.randomUUID().toString());
		hopitalLesRosiers.setNom("LES ROSIERS");
		hopitalLesRosiers.setContact("+2250101010102");
		hopitalLesRosiers.setEtat(true);
		hopitalRepository.save(hopitalLesRosiers);

		System.out.println("===============AJOUT HOPITAUX=======================");
		hopitalRepository.findAll().forEach(u->System.out.println(u.getNom()));
		System.out.println("Hopitaux ajoutés avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============DEBUT SPECIALITE_HOPITAL=======================");

		//Ajout de specialite hopital

		SpecialiteHopitalRepository specialiteHopitalRepository = ctx.getBean(SpecialiteHopitalRepository.class);
		specialiteHopitalRepository.save(new SpecialiteHopital(cardiologie, hopitalLesvallons));
		specialiteHopitalRepository.save(new SpecialiteHopital(ophtamologie, hopitalLesvallons));
		specialiteHopitalRepository.save(new SpecialiteHopital(oncologie, hopitalLesvallons));
		specialiteHopitalRepository.save(new SpecialiteHopital(general, hopitalLesvallons));
		specialiteHopitalRepository.save(new SpecialiteHopital(gynecologie, hopitalLesRosiers));
		specialiteHopitalRepository.save(new SpecialiteHopital(general, hopitalLesRosiers));
		specialiteHopitalRepository.save(new SpecialiteHopital(maternite, hopitalLesRosiers));
		specialiteHopitalRepository.save(new SpecialiteHopital(gastro, hopitalLesRosiers));
		specialiteHopitalRepository.save(new SpecialiteHopital(neurologie, hopitalLesRosiers));
		specialiteHopitalRepository.save(new SpecialiteHopital(urologie, hopitalLesRosiers));

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===============SPECIALITE_HOPITAL=======================");

		//Ajout de pharmacie
		System.out.println("===============DEBUT TRANSACTION PHARMACIE=======================");
		PharmacieRepository pharmacieRepository = ctx.getBean(PharmacieRepository.class);

		Pharmacie pharmacieLesVallonsJardin = new Pharmacie();
		pharmacieLesVallonsJardin.setNom("LES VALLONS JARDIN");
		pharmacieLesVallonsJardin.setContact("+2250909090909");
		pharmacieLesVallonsJardin.setEtat(true);
		pharmacieLesVallonsJardin.setReferencePharmacien(UUID.randomUUID().toString());
		pharmacieLesVallonsJardin.setNomPharmacien("GOTTA");
		pharmacieLesVallonsJardin.setPrenomPharmacien("Jean");
		pharmacieLesVallonsJardin.setContactPharmacien("+2250606060606");

		Pharmacie pharmacieStLuc = new Pharmacie();
		pharmacieStLuc.setNom("SAINT LUC");
		pharmacieStLuc.setContact("+225090909090°");
		pharmacieStLuc.setEtat(true);
		pharmacieStLuc.setReferencePharmacien(UUID.randomUUID().toString());
		pharmacieStLuc.setNomPharmacien("BAMBA");
		pharmacieStLuc.setPrenomPharmacien("Lancina");
		pharmacieStLuc.setContactPharmacien("+2250606060607");

		pharmacieRepository.save(pharmacieLesVallonsJardin);
		pharmacieRepository.save(pharmacieStLuc);

		System.out.println("===============AJOUT PHARMACIE=======================");
		pharmacieRepository.findAll().forEach(u->System.out.println(u.getNom()));
		System.out.println("Pharmacies ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++"); */








		/*String p = "123";
		String password = EncrytedPasswordUtils.encrytePassword(p);

		System.out.println("===============DEBUT TRANSACTION=======================");
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		AppUser user1 = userRepository.save(new AppUser("admin",password,true));
		AppUser user2 = userRepository.save(new AppUser("user",password,true));
		AppUser userHopitalVallons = userRepository.save(new AppUser("hvallons",password,true));
		AppUser userHopitalRosier = userRepository.save(new AppUser("hrosiers",password,true));
		AppUser userPharmacieVallons = userRepository.save(new AppUser("pvallons",password,true));
		AppUser userPharmacieStLuc = userRepository.save(new AppUser("pstluc",password,true));
		System.out.println("===============AJOUT CLIENT=======================");
		userRepository.findAll().forEach(u->System.out.println(u.getUserName()));
		System.out.println("Utilisateurs ajoutés avec succes");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===============AJOUT ROLE=======================");
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		AppRole roleadmin = roleRepository.save(new AppRole("ROLE_ADMIN"));
		AppRole roleuser = roleRepository.save(new AppRole("ROLE_USER"));
		AppRole rolePharmacie = roleRepository.save(new AppRole("ROLE_PHARMACIE"));
		AppRole roleHopital = roleRepository.save(new AppRole("ROLE_HOPITAL"));
		roleRepository.findAll().forEach(u->System.out.println(u.getRoleName()));
		System.out.println("Roles ajoutés avec succes");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============AFFECTATION ROLE PAR USER=======================");
		UserRoleRepository userRoleRepository = ctx.getBean(UserRoleRepository.class);
		userRoleRepository.save(new UserRole(user1,roleadmin));
		userRoleRepository.save(new UserRole(user1,roleuser));
		userRoleRepository.save(new UserRole(user2,roleuser));
		userRoleRepository.save(new UserRole(userHopitalVallons,roleHopital));
		userRoleRepository.save(new UserRole(userHopitalRosier,roleHopital));
		userRoleRepository.save(new UserRole(userPharmacieVallons,rolePharmacie));
		userRoleRepository.save(new UserRole(userPharmacieStLuc,rolePharmacie));

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");*/


/*		//Update Table User
		System.out.println("===============DEBUT TRANSACTION UPDATE TABLE USER WITH PARTENAIRE=======================");

		UserRepository userRepository = ctx.getBean(UserRepository.class);
		PartenaireRepository partenaireRepository = ctx.getBean(PartenaireRepository.class);

		AppUser hvallons = userRepository.findByUserName("hvallons");
		Partenaire partenaireHvallons = partenaireRepository.findByPartenaireId(1L);
		hvallons.setPartenaire(partenaireHvallons);
		userRepository.save(hvallons);


		AppUser hrosiers = userRepository.findByUserName("hrosiers");
		Partenaire partenaireHrosiers = partenaireRepository.findByPartenaireId(2L);
		hrosiers.setPartenaire(partenaireHrosiers);
		userRepository.save(hrosiers);

		AppUser pvallons = userRepository.findByUserName("pvallons");
		Partenaire partenairePvallons = partenaireRepository.findByPartenaireId(3L);
		pvallons.setPartenaire(partenairePvallons);
		userRepository.save(pvallons);

		AppUser pstluc = userRepository.findByUserName("pstluc");
		Partenaire partenaireStluc = partenaireRepository.findByPartenaireId(4L);
		pstluc.setPartenaire(partenaireStluc);
		userRepository.save(pstluc);

		System.out.println("Mise a jour de la table APPUSER effectuée avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");
		*/



/*		//Ajouter medecin

		System.out.println("===============DEBUT MEDECIN ET MEDECIN_SPECIALITE=======================");

		SpecialiteRepository specialiteRepository = ctx.getBean(SpecialiteRepository.class);
		SpecialiteMedecinRepository specialiteMedecinRepository = ctx.getBean(SpecialiteMedecinRepository.class);
		Specialite chirurgie =  specialiteRepository.save(new Specialite("CHIRURGIE", "Opération, Urgence"));
		MedecinRepository medecinRepository = ctx.getBean(MedecinRepository.class);
		Medecin medecin1 = new Medecin();
		medecin1.setReference(UUID.randomUUID().toString());
		medecin1.setNom("KOUAME");
		medecin1.setPrenom("Dimitri");
		medecin1.setDatenaissance(LocalDate.of(1967, 8, 30));
		medecin1.setSexe(Sexe.MASCULIN);
		medecinRepository.save(medecin1);
		Specialite gastro = specialiteRepository.findBySpecialiteId(3L);
		specialiteMedecinRepository.save(new SpecialiteMedecin(gastro, medecin1));


		Medecin medecin2 = new Medecin();
		medecin2.setReference(UUID.randomUUID().toString());
		medecin2.setNom("SORO");
		medecin2.setPrenom("Tielourgo Aminata");
		medecin2.setDatenaissance(LocalDate.of(1982, 4, 12));
		medecin2.setSexe(Sexe.FEMININ);
		medecinRepository.save(medecin2);
		Specialite neurologie = specialiteRepository.findBySpecialiteId(4L);
		specialiteMedecinRepository.save(new SpecialiteMedecin(neurologie, medecin2));

		Medecin medecin3 = new Medecin();
		medecin3.setReference(UUID.randomUUID().toString());
		medecin3.setNom("DAKOURI");
		medecin3.setPrenom("Zako Paul André");
		medecin3.setDatenaissance(LocalDate.of(1988, 11, 23));
		medecin3.setSexe(Sexe.MASCULIN);
		medecinRepository.save(medecin3);
		Specialite generale = specialiteRepository.findBySpecialiteId(5L);
		specialiteMedecinRepository.save(new SpecialiteMedecin(generale, medecin3));

		Medecin medecin4 = new Medecin();
		medecin4.setReference(UUID.randomUUID().toString());
		medecin4.setNom("PEPE");
		medecin4.setPrenom("Jean David");
		medecin4.setDatenaissance(LocalDate.of(1970, 12, 19));
		medecin4.setSexe(Sexe.MASCULIN);
		medecinRepository.save(medecin4);
		Specialite cardiologie = specialiteRepository.findBySpecialiteId(1L);
		specialiteMedecinRepository.save(new SpecialiteMedecin(cardiologie, medecin4));
		specialiteMedecinRepository.save(new SpecialiteMedecin(chirurgie, medecin4));


		Medecin medecin5 = new Medecin();
		medecin5.setReference(UUID.randomUUID().toString());
		medecin5.setNom("ABI");
		medecin5.setPrenom("Kiria");
		medecin5.setDatenaissance(LocalDate.of(1960, 1, 10));
		medecin5.setSexe(Sexe.FEMININ);
		medecinRepository.save(medecin5);
		Specialite gyneco = specialiteRepository.findBySpecialiteId(8L);
		specialiteMedecinRepository.save(new SpecialiteMedecin(gyneco, medecin5));
		specialiteMedecinRepository.save(new SpecialiteMedecin(chirurgie, medecin5));

		System.out.println("===============AJOUT MEDECIN ET SPECIALITE=======================");
		medecinRepository.findAll().forEach(u->System.out.println(u.toNomComplet()));
		System.out.println("Medecin et Affectation des specialites ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");*/


/*		//Ajouter Consultation.
		System.out.println("===============DEBUT CONSULTATION=======================");

		PrestationService prestationService = ctx.getBean(PrestationService.class);
		ConsultationINPUT consultationINPUT1 = new ConsultationINPUT();
		consultationINPUT1.setAssure(4L);
		consultationINPUT1.setHopital(1L);
		consultationINPUT1.setMedecin(3L);
		consultationINPUT1.setSpecialite(5L);
		consultationINPUT1.setSymptome("Fièvre, Diarrhee, Vomissement");
		consultationINPUT1.setDiagnostic("Debut de Palu");
		consultationINPUT1.setDatePrestation(LocalDate.of(2023, 1, 1));

		ConsultationINPUT consultationINPUT2 = new ConsultationINPUT();
		consultationINPUT2.setAssure(6L);
		consultationINPUT2.setHopital(2L);
		consultationINPUT2.setMedecin(1L);
		consultationINPUT2.setSpecialite(3L);
		consultationINPUT2.setSymptome("Crampes d'estomac, Douleurs abdominales, RGO, Douleurs à la poitrine");
		consultationINPUT2.setDiagnostic("Potentiel Colon irritable, debut de colopathie fonctionnelle");
		consultationINPUT2.setDatePrestation(LocalDate.of(2023, 2, 1));

		ConsultationINPUT consultationINPUT3 = new ConsultationINPUT();
		consultationINPUT3.setAssure(7L);
		consultationINPUT3.setHopital(1L);
		consultationINPUT3.setMedecin(2L);
		consultationINPUT3.setSpecialite(4L);
		consultationINPUT3.setSymptome("Douleurs au bas du dos, tension dans les jambes, fourmillement aux pieds");
		consultationINPUT3.setDiagnostic("Potentiel debut de lombalgie");
		consultationINPUT3.setDatePrestation(LocalDate.of(2023, 2, 1));

		ConsultationDTO consultationDTO1 =  prestationService.createConsultation(consultationINPUT1);
		ConsultationDTO consultationDTO2 =  prestationService.createConsultation(consultationINPUT2);
		ConsultationDTO consultationDTO3 =  prestationService.createConsultation(consultationINPUT3);
		List<ConsultationDTO> dtos = prestationService.listToConsultationDTO();
		System.out.println("===============AJOUT CONSULTATION=======================");
		System.out.println("consultations ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");*/

		ConsultationRepository consultationRepository = ctx.getBean(ConsultationRepository.class);
		PrescriptionService prescriptionService = ctx.getBean(PrescriptionService.class);

		//Ajouter Prescription.
		System.out.println("===============DEBUT PRESCRIPTION=======================");

		//Ajout Examen
		System.out.println("    @@@__DEBUT EXAMEN__@@@");



		System.out.println("    @@@__FIN EXAMEN__@@@");

		//Ajout Ordonnance

		System.out.println("    @@@__DEBUT ORDONNANCE__@@@");

		System.out.println("    @@@__FIN ORDONNANCE__@@@");


		//Ajout Orientation
		System.out.println("    @@@__DEBUT ORIENTATION__@@@");

		System.out.println("    @@@__FIN ORIENTATION__@@@");



		System.out.println("===============AJOUT PRESCRIPTION=======================");

		System.out.println("Prescriptions ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");

		//private String port;
		//String port = env.getProperty("server.port");
		String server ="Server start on http://localhost:8088";
		//String server ="Server start on http://localhost:"+this.port;

		//Logger get configuration on file "logback"
		log.info(server);
		System.out.println(server);

		/*//Ajouter Consultation.
		System.out.println("===============DEBUT CONSULTATION=======================");


		System.out.println("===============AJOUT CONSULTATION=======================");

		System.out.println("consultations ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");*/









	}


}
