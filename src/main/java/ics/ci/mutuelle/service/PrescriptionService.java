package ics.ci.mutuelle.service;

import ics.ci.mutuelle.dto.prescription.examen.ExamenDTO;
import ics.ci.mutuelle.dto.prescription.examen.ExamenINPUT;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceDTO;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceINPUT;
import ics.ci.mutuelle.dto.prescription.orientation.OrientationDTO;
import ics.ci.mutuelle.dto.prescription.orientation.OrientationINPUT;
import ics.ci.mutuelle.entity.*;

import java.util.List;

public interface PrescriptionService {

    //Orientation
    OrientationDTO createOrientation (OrientationINPUT input);
    OrientationDTO createOrientation (Orientation orientation);
    List<OrientationDTO> listToOrientation(List<Orientation> orientations);
    List<OrientationDTO> listToOrientation();

    //Examen

    ExamenDTO createExamen (ExamenINPUT input);
    ExamenDTO createExamen (Examen examen);
    List<ExamenDTO> listToExamen(List<Examen> examens);
    List<ExamenDTO> listToExamen();
    List<Typeexamen> getTypeExamensByExamen(Examen examen);

    //Ordonnance

    OrdonnanceDTO createOrdonnance(OrdonnanceINPUT input);
    OrdonnanceDTO createOrdonnance(Ordonnance ordonnance);
    List<OrdonnanceDTO> listToOrdonnance(List<Ordonnance> ordonnances);
    List<OrdonnanceDTO> listToOrdonnance();
    List<Medicament> getMedicamentsByOrdonnance(Ordonnance ordonnance);
}
