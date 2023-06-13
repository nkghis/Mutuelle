package ics.ci.mutuelle.service;

import ics.ci.mutuelle.dto.examentype.ExamenTypeDTO;
import ics.ci.mutuelle.dto.prescription.examen.ExamenDTO;
import ics.ci.mutuelle.dto.prescription.examen.ExamenINPUT;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceDTO;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceINPUT;
import ics.ci.mutuelle.dto.prescription.orientation.OrientationDTO;
import ics.ci.mutuelle.dto.prescription.orientation.OrientationINPUT;
import ics.ci.mutuelle.entity.*;
import ics.ci.mutuelle.enums.Etat;
import ics.ci.mutuelle.enums.Statut;

import java.util.List;

public interface PrescriptionService {

    //Orientation
    OrientationDTO createOrientation (OrientationINPUT input);
    OrientationDTO createOrientation (Orientation orientation);
    List<OrientationDTO> listToOrientation(List<Orientation> orientations);
    List<OrientationDTO> listToOrientation();
    List<Orientation> listOrientationByAssure(Assure assure);

    //Examen

    ExamenDTO createExamen (ExamenINPUT input);
    ExamenDTO createExamen (Examen examen);
    List<ExamenDTO> listToExamen(List<Examen> examens);
    List<ExamenDTO> listToExamen();
    List<Examen>listExamenByAssure(Assure assure);
    List<Typeexamen> getTypeExamensByExamen(Examen examen);
    List<ExamenType> listExamenTypeByExamen(Examen examen);
    List<ExamenType> listExamenTypeByStatut(Statut statut);
    List<ExamenType> listExamenTypeByStatut(List<ExamenType> examenTypes, Statut statut);
    List<ExamenType> listExamenTypeByStatutAndEtat(Statut statut, Etat etat);
    List<ExamenType> listExamenTypeByStatutAndEtat(List<ExamenType> examenTypes, Statut statut, Etat etat);
    List<ExamenType> listExamenTypeByAssure(Assure assure);
    void changeStatutExamenType(ExamenType examenType, Statut statut);
    void changeStatusExamenTypes(List<ExamenType> examenTypes, Statut statut);

    //Ordonnance



    OrdonnanceDTO createOrdonnance(OrdonnanceINPUT input);
    OrdonnanceDTO createOrdonnance(Ordonnance ordonnance);

    List<Ordonnance> listOrdonnanceByAssure(Assure assure);

    List<OrdonnanceDTO> listToOrdonnance(List<Ordonnance> ordonnances);
    List<OrdonnanceDTO> listToOrdonnance();
    List<Medicament> getMedicamentsByOrdonnance(Ordonnance ordonnance);
}
