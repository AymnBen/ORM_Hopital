package uni.mundia.hopital.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.mundia.hopital.entities.Consultation;
import uni.mundia.hopital.entities.Medecin;
import uni.mundia.hopital.entities.Patient;
import uni.mundia.hopital.entities.RendezVous;
import uni.mundia.hopital.repository.ConsultationRepository;
import uni.mundia.hopital.repository.MedecinRepository;
import uni.mundia.hopital.repository.PatientRepository;
import uni.mundia.hopital.repository.RendezVousRepository;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    //@Autowired
    private PatientRepository patientRepository;
    //@Autowired
    private ConsultationRepository consultationRepository;
    //@Autowired
    private MedecinRepository medecinRepository;
    //Autowired
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, ConsultationRepository consultationRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
