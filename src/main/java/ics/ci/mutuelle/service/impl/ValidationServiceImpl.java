package ics.ci.mutuelle.service.impl;

import ics.ci.mutuelle.entity.ExamenType;
import ics.ci.mutuelle.entity.HistoriqueValidation;
import ics.ci.mutuelle.enums.Etat;
import ics.ci.mutuelle.enums.Statut;
import ics.ci.mutuelle.repository.ExamenTypeRepository;
import ics.ci.mutuelle.repository.HistoriqueValidationRepository;
import ics.ci.mutuelle.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@Slf4j
public class ValidationServiceImpl implements ValidationService {
    private final HistoriqueValidationRepository historiqueValidationRepository;
    private final ExamenTypeRepository examenTypeRepository;

    public ValidationServiceImpl(HistoriqueValidationRepository historiqueValidationRepository, ExamenTypeRepository examenTypeRepository) {
        this.historiqueValidationRepository = historiqueValidationRepository;
        this.examenTypeRepository = examenTypeRepository;
    }

    @Override
    public void createStatut(ExamenType examenType, Statut statut, String observation) {

        HistoriqueValidation historiqueValidation = new HistoriqueValidation();
        historiqueValidation.setDate(LocalDateTime.now());
        historiqueValidation.setExamenType(examenType);
        historiqueValidation.setStatut(statut);
        historiqueValidation.setObservation(observation);
        historiqueValidationRepository.save(historiqueValidation);

        switch (statut){

            case EN_ATTENTE:
                break;

            case REFUSER:

                examenType.setStatut(Statut.REFUSER);
                examenTypeRepository.save(examenType);
                break;

            case VALIDER:
                examenType.setStatut(Statut.VALIDER);
                examenType.setEtat(Etat.EN_ATTENTE);
                examenTypeRepository.save(examenType);
                break;

            case ANNULER:
                examenType.setStatut(Statut.ANNULER);
                examenTypeRepository.save(examenType);
                break;
        }
    }

/*    @Override
    public void createHistoriqueValidation(ExamenType examenType, Boolean statut) {
        HistoriqueValidation historiqueValidation = new HistoriqueValidation();
        historiqueValidation.setDate(LocalDateTime.now());
        historiqueValidation.setExamenType(examenType);
        historiqueValidation.setEtat(statut);
        historiqueValidation.setObservation("");
        historiqueValidationRepository.save(historiqueValidation);
    }

    @Override
    public void createHistoriqueValidation(ExamenType examenType, Boolean statut, String observation) {
        HistoriqueValidation historiqueValidation = new HistoriqueValidation();
        historiqueValidation.setDate(LocalDateTime.now());
        historiqueValidation.setExamenType(examenType);
        historiqueValidation.setEtat(statut);
        historiqueValidation.setObservation(observation);
        historiqueValidationRepository.save(historiqueValidation);
    }*/
}
