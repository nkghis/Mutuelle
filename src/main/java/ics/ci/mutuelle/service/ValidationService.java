package ics.ci.mutuelle.service;

import ics.ci.mutuelle.entity.ExamenType;
import ics.ci.mutuelle.enums.Statut;

public interface ValidationService {

   /* void createHistoriqueValidation(ExamenType examenType, Boolean statut);

    void createHistoriqueValidation(ExamenType examenType, Boolean statut, String observation);*/

    void createStatut(ExamenType examenType, Statut statut, String observation);
}
