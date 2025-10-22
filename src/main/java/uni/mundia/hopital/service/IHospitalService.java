package uni.mundia.hopital.service;

import uni.mundia.hopital.entities.Consultation;
import uni.mundia.hopital.entities.Medecin;
import uni.mundia.hopital.entities.Patient;
import uni.mundia.hopital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
