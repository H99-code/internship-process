package service;

import hhn.system.internship.repository.Company;
import hhn.system.internship.repository.organisation.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


    public Optional<Optional<Company>> getCompanyById(Long id) {
        return Optional.ofNullable(companyRepository.findById(id));
    }


    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }


    public Company updateCompany(Long id, Company updatedCompany) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setCompanyName(updatedCompany.getCompanyName());
                    company.setCompanyAddress(updatedCompany.getCompanyAddress());
                    company.setContactPerson(updatedCompany.getContactPerson());
                    company.setContactEmail(updatedCompany.getContactEmail());
                    company.setContactPhoneNumber(updatedCompany.getContactPhoneNumber());
                    company.setCompanyDescription(updatedCompany.getCompanyDescription());
                    company.setOverallProcess(updatedCompany.getOverallProcess());
                    return companyRepository.save(company);
                })
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }


    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
