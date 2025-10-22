package uni.mundia.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.mundia.hopital.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
