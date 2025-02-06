package controller;

import hhn.system.internship.repository.Company;
import org.springframework.web.bind.annotation.*;
import service.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Optional<Company>> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }


    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }


    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }


    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}