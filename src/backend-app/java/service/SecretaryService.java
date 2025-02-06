package service;

import hhn.system.internship.repository.Secretary;
import hhn.system.internship.repository.person.SecretaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService {
    private final SecretaryRepository secretaryRepository;

    public SecretaryService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    public List<Secretary> getSecretariesByStudyProgram(Long studyProgramId) {
        return secretaryRepository.findByStudyProgramId(studyProgramId);
    }


    public Optional<Secretary> getSecretaryByStudyProgramAndId(Long studyProgramId, Long id) {
        return Optional.ofNullable(secretaryRepository.findByStudyProgramIdAndId(studyProgramId, id));
    }


    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }
}
