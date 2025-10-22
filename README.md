# Hopital ORM (Object-Relational Mapping)

Application de gestion d'hôpital développée avec **Spring Boot**, **Spring Data JPA** et **MySQL**.  
Elle permet de gérer les **patients**, **médecins**, **rendez-vous** et **consultations**.

---

## 🚀 Fonctionnalités

- Gestion des **patients** (ajout, consultation, modification, suppression)
- Gestion des **médecins**
- Gestion des **rendez-vous**
- Gestion des **consultations**
- Relations entre les entités :
  - Un patient peut avoir plusieurs rendez-vous
  - Un médecin peut avoir plusieurs rendez-vous
  - Chaque rendez-vous peut avoir une consultation associée

---

## 🛠 Technologies utilisées

- **Java 25**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Hibernate ORM 6.6**
- **H2** (base de données en mémoire pour tests) / **MySQL** (production)
- **Lombok**
- **Tomcat Embedded**

---

## 🗂 Structure des entités

- **Patient**
  - id : Long
  - nom : String
  - dateNaissance : Date
  - malade : Boolean

- **Medecin**
  - id : Long
  - nom : String
  - email : String
  - specialite : String

- **Rendez_vous**
  - id : UUID
  - date : DateTime
  - statusRdv : Enum (PENDING, DONE, CANCELLED)
  - patient : Patient
  - medecin : Medecin

- **Consultation**
  - id : Long
  - dateConsultation : DateTime
  - rapport : String
  - rendez_vous : Rendez_vous

---
## ⚙️ Configurer l'unité de persistance dans application.properties 
- Pour H2
```properties 
spring.datasource.url=jdbc:h2:mem:hopital
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

- Pour MySQL
``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/hopital
spring.datasource.username=root
spring.datasource.password=motdepasse
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🔗 Endpoints REST (Exemples)

GET /patients : Liste des patients <br> 

POST /patients : Ajouter un patient<br>

GET /medecins : Liste des médecins<br>

POST /medecins : Ajouter un médecin<br>

POST /rendezvous : Créer un rendez-vous<br>

POST /consultations : Ajouter une consultation<br>

## ⚙️ Installation 

1. **Cloner le projet :**

```bash
git clone [<URL_DU_PROJET>](https://github.com/AymnBen/ORM_Hopital)
cd hopital
```


