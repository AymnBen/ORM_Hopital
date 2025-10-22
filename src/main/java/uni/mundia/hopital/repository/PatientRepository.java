package uni.mundia.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.mundia.hopital.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
