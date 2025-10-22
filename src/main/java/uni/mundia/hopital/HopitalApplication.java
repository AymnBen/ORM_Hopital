package uni.mundia.hopital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uni.mundia.hopital.entities.*;
import uni.mundia.hopital.repository.ConsultationRepository;
import uni.mundia.hopital.repository.MedecinRepository;
import uni.mundia.hopital.repository.PatientRepository;
import uni.mundia.hopital.repository.RendezVousRepository;
import uni.mundia.hopital.service.IHospitalService;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication  {

    public static void main(String[] args) {

        SpringApplication.run(HopitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            MedecinRepository medecinRepository,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository) {
        return args -> {
            Stream.of("Saad","Aymen","Oussama")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);

                    });
            Stream.of("Mehdi","Abdo","Yuyu")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.ma");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);

                    });
            Patient patient =patientRepository.findById(1L).orElse(null);
            Patient patient1 =patientRepository.findByNom("Aymen");

            Medecin medecin =medecinRepository.findByNom("Aymane");

            RendezVous rendezVous =new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRDV(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de Consultation ...");

            hospitalService.saveConsultation(consultation);
            //patientRepository.save(new Patient(null,"Aymen",new Date(),false,null));
        };
    }

}
