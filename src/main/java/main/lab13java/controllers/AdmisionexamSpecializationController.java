package main.lab13java.controllers;


import lombok.AllArgsConstructor;
import main.lab13java.dao.AdmisionExamSpecializationRepository;
import main.lab13java.entities.AdmisionExam;
import main.lab13java.entities.AdmisionExamSpecialization;
import main.lab13java.entities.Specialization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AdmisionexamSpecializationController {

    private AdmisionExamSpecializationRepository admisionExamSpecializationRepository;

    @GetMapping("/admision_exams_specialization")
    public String showAdmisionExamsSpecialization (Model model, @RequestParam int id){
        List<AdmisionExamSpecialization> admisionExamSpecializations = admisionExamSpecializationRepository.findByIdSpecialization_IdOrderByIdAsc(id);
        model.addAttribute("admisionExamSpecializations", admisionExamSpecializations);
        return "admision_exams_specialization";
    }

    @GetMapping("/admision_exams_specializations")
    public String showAdmisionExamsSpecializations (Model model){
        List<AdmisionExamSpecialization> admisionExamSpecialization = admisionExamSpecializationRepository.findAll();
        model.addAttribute("admisionExamSpecialization", admisionExamSpecialization);
        return "admision_exams_specializations";
    }

    @PostMapping("/add_admision_exam_specialization")
    public String addAdmisionExamSpecialization(@RequestParam AdmisionExam idAdmisionExam, @RequestParam Specialization idSpecialization){
        AdmisionExamSpecialization admisionExamSpecialization = new AdmisionExamSpecialization();
        admisionExamSpecialization.setIdAdmisionExam(idAdmisionExam);
        admisionExamSpecialization.setIdSpecialization(idSpecialization);
        admisionExamSpecializationRepository.save(admisionExamSpecialization);
        return "redirect:/admision_exams_specializations";
    }

    @GetMapping("/delete_admission_exam_specialization")
    public String deleteAdmisionExamSpecialization(@RequestParam int id){
        admisionExamSpecializationRepository.deleteById(id);
        return "redirect:/admision_exams_specializations";
    }

    @GetMapping("/edit_admision_exam_specialization")
    public String editAdmisionExamSpecialization(@RequestParam int id, Model model){
        Optional<AdmisionExamSpecialization> optionalAdmisionExamSpecialization = admisionExamSpecializationRepository.findById(id);
        if (optionalAdmisionExamSpecialization.isEmpty()){
            return "redirect:/admision_exams_specializations";
        }
        else {
            model.addAttribute("admisionExamSpecialization", optionalAdmisionExamSpecialization.get());
            return "edit_admision_exam_specialization";
        }
    }

    @PostMapping("/update_admision_exam_specialization")
    public String editAdmisionExam(@RequestParam int id,@RequestParam AdmisionExam aidAdmisionExam, @RequestParam Specialization aidSpecialization){
        Optional<AdmisionExamSpecialization> optionalAdmisionExamSpecialization = admisionExamSpecializationRepository.findById(id);
        if (optionalAdmisionExamSpecialization.isPresent()){
            AdmisionExamSpecialization a = optionalAdmisionExamSpecialization.get();
            a.setIdSpecialization(aidSpecialization);
            a.setIdAdmisionExam(aidAdmisionExam);
            admisionExamSpecializationRepository.save(a);
        }
        return "redirect:/admision_exams_specializations";
    }


}
