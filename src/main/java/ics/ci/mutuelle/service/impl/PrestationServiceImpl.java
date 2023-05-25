package ics.ci.mutuelle.service.impl;

import ics.ci.mutuelle.dto.examentype.ExamenTypeDTO;
import ics.ci.mutuelle.dto.prestation.consultation.ConsultationDTO;
import ics.ci.mutuelle.dto.prestation.consultation.ConsultationINPUT;
import ics.ci.mutuelle.dto.prestation.examenanalyse.ExamenAnalyseDTO;
import ics.ci.mutuelle.dto.prestation.examenanalyse.ExamenAnalyseINPUT;
import ics.ci.mutuelle.entity.*;
import ics.ci.mutuelle.mapper.ConsultationMapper;
import ics.ci.mutuelle.mapper.ExamenAnalyseMapper;
import ics.ci.mutuelle.mapper.MapperExamenType;
import ics.ci.mutuelle.repository.*;
import ics.ci.mutuelle.service.PrestationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
@Slf4j
public class PrestationServiceImpl implements PrestationService {

    private final ConsultationRepository consultationRepository;
    private final ExamenAnalyseRepository examenAnalyseRepository;
    private final ConsultationMapper consultationMapper;
    private final ExamenAnalyseMapper examenAnalyseMapper;
    private final MapperExamenType mapperExamenType;
    private final AssureRepository assureRepository;
    private final HopitalRepository hopitalRepository;
    private final MedecinRepository medecinRepository;
    private final SpecialiteRepository specialiteRepository;
    private final ExamenRepository examenRepository;
    private final ExamenTypeRepository examenTypeRepository;




    public PrestationServiceImpl(ConsultationRepository consultationRepository, ExamenAnalyseRepository examenAnalyseRepository, ConsultationMapper consultationMapper, ExamenAnalyseMapper examenAnalyseMapper, MapperExamenType mapperExamenType, AssureRepository assureRepository, HopitalRepository hopitalRepository, MedecinRepository medecinRepository, SpecialiteRepository specialiteRepository, ExamenRepository examenRepository, ExamenTypeRepository examenTypeRepository) {
        this.consultationRepository = consultationRepository;
        this.examenAnalyseRepository = examenAnalyseRepository;
        this.consultationMapper = consultationMapper;
        this.examenAnalyseMapper = examenAnalyseMapper;
        this.mapperExamenType = mapperExamenType;
        this.assureRepository = assureRepository;
        this.hopitalRepository = hopitalRepository;
        this.medecinRepository = medecinRepository;
        this.specialiteRepository = specialiteRepository;
        this.examenRepository = examenRepository;
        this.examenTypeRepository = examenTypeRepository;
    }



    //Consultation
    @Override
    public ConsultationDTO createConsultation(ConsultationINPUT input) {

        Assure assure = assureRepository.getOne(input.getAssure());
        Hopital hopital = hopitalRepository.getOne(input.getHopital());
        Medecin medecin = medecinRepository.getOne(input.getMedecin());
        Specialite specialite = specialiteRepository.getOne(input.getSpecialite());
        Consultation consultation = new Consultation();
        consultation.setAssure(assure);
        consultation.setHopital(hopital);
        consultation.setMedecin(medecin);
        consultation.setSpecialite(specialite);
        consultation.setObservation(input.getObservation());
        consultation.setDiagnostic(input.getDiagnostic());
        consultation.setSymptome(input.getSymptome());
        consultation.setDatePrestation(input.getDatePrestation());
        consultation.setDate(LocalDateTime.now());

        return consultationMapper.toDTO(consultationRepository.save(consultation));
    }

    @Override
    public ConsultationDTO createConsultation(Consultation consultation) {
        return consultationMapper.toDTO(consultationRepository.save(consultation));
    }

    @Override
    public List<ConsultationDTO> listToConsultationDTO(List<Consultation> consultations) {
        return consultationMapper.listToDTO(consultations);
    }

    @Override
    public List<ConsultationDTO> listToConsultationDTO() {
        return consultationMapper.listToDTO(consultationRepository.findAll());
    }

    //ExamenAnalyse

    @Override
    public ExamenAnalyseDTO createExamenAnalyse(ExamenAnalyseINPUT input) {

        Assure assure = assureRepository.getOne(input.getAssure());
        Hopital hopital = hopitalRepository.getOne(input.getHopital());
        Medecin medecin = medecinRepository.getOne(input.getMedecin());
        Examen examen = examenRepository.getOne(input.getExamen());

        ExamenAnalyse examenAnalyse = new ExamenAnalyse();
        examenAnalyse.setAssure(assure);
        examenAnalyse.setHopital(hopital);
        examenAnalyse.setMedecin(medecin);
        examenAnalyse.setExamen(examen);
        examenAnalyse.setEtat(true);
        examenAnalyse.setObservation(input.getObservation());
        examenAnalyse.setDatePrestation(input.getDatePrestation());
        examenAnalyse.setDate(LocalDateTime.now());

        List<ExamenTypeDTO> dtos = mapperExamenType.listToDTO(examenTypeRepository.findByExamen(examen));

        return examenAnalyseMapper.toDTO(examenAnalyseRepository.save(examenAnalyse), dtos);
    }

    @Override
    public ExamenAnalyseDTO createExamenAnalyse(ExamenAnalyse examenAnalyse) {
        List<ExamenTypeDTO> dtos = mapperExamenType.listToDTO(examenTypeRepository.findByExamen(examenAnalyse.getExamen()));
        return examenAnalyseMapper.toDTO(examenAnalyseRepository.save(examenAnalyse), dtos);
    }

    @Override
    public List<ExamenAnalyseDTO> listToExamenAnalyseDTO(List<ExamenAnalyse> examenAnalyses) {
        return examenAnalyseMapper.listToDTO(examenAnalyses);
    }

    @Override
    public List<ExamenAnalyseDTO> listToExamenAnalyseDTO() {
        return examenAnalyseMapper.listToDTO(examenAnalyseRepository.findAll());
    }
}
