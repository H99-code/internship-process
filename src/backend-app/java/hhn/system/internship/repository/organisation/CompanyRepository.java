package hhn.system.internship.repository.organisation;

import hhn.system.internship.repository.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {


    List<Company> findAll();

    Optional<Company> findById(Long id);
}
