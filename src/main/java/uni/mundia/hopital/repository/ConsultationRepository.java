package uni.mundia.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.mundia.hopital.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
