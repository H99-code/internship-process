package controller;

import hhn.system.internship.repository.Secretary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SecretaryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/secretaries")
public class SecretaryController {
    private final SecretaryService secretaryService;

    public SecretaryController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }


    @GetMapping
    public List<Secretary> getAllSecretaries() {
        return secretaryService.getAllSecretaries();
    }


    @GetMapping("/study-program/{studyProgramId}")
    public List<Secretary> getSecretariesByStudyProgram(@PathVariable Long studyProgramId) {
        return secretaryService.getSecretariesByStudyProgram(studyProgramId);
    }


    @GetMapping("/study-program/{studyProgramId}/{id}")
    public Optional<Secretary> getSecretaryByStudyProgramAndId(@PathVariable Long studyProgramId, @PathVariable Long id) {
        return secretaryService.getSecretaryByStudyProgramAndId(studyProgramId, id);
    }
}
