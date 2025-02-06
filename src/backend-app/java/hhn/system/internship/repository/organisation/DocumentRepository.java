package hhn.system.internship.repository.organisation;


import hhn.system.internship.repository.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
