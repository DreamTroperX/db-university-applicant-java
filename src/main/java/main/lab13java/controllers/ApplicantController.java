package main.lab13java.controllers;

import lombok.AllArgsConstructor;
import main.lab13java.dao.ApplicantRepository;
import main.lab13java.entities.Applicant;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ApplicantController {

    private ApplicantRepository applicantRepository;

    @GetMapping("/applicants")
    public String showApplicants(Model model){
        List<Applicant> applicants = applicantRepository.findAll();
        model.addAttribute("applicants", applicants);
        return "applicants";
    }

    @PostMapping("/add_applicant")
    public String addApplicant(@RequestParam String name, @RequestParam String lastname, @RequestParam String middlename, @RequestParam LocalDate birthdate, @RequestParam int telephonenumber, @RequestParam double middleZNO, @RequestParam double middle_school){
        Applicant applicant = new Applicant();
        applicant.setName(name);
        applicant.setLastname(lastname);
        applicant.setMiddlename(middlename);
        applicant.setBirthdate(birthdate);
        applicant.setTelephonenumber(telephonenumber);
        applicant.setMiddleZNO(middleZNO);
        applicant.setMiddleSchool(middle_school);
        applicantRepository.save(applicant);
        return "redirect:/applicants";
    }

    @GetMapping("/delete_applicant")
    public String deleteApplicant(@RequestParam int id){
        applicantRepository.deleteById(id);
        return "redirect:/applicants";
    }

    @GetMapping("/edit_applicant")
    public String editApplicant(@RequestParam int id, Model model){
        Optional<Applicant> optionalApplicant = applicantRepository.findById(id);
        if (optionalApplicant.isEmpty()){
            return "redirect:/applicants";
        }
        else {
            model.addAttribute("applicant", optionalApplicant.get());
            return "edit_applicant";
        }
    }

    @PostMapping("/update_applicant")
    public String editApplicant(@RequestParam int id, @RequestParam String aname, @RequestParam String alastname, @RequestParam String amiddlename, @RequestParam LocalDate abirthdate, @RequestParam int atelephonenumber, @RequestParam double amiddleZNO, @RequestParam double amiddle_school){
        Optional<Applicant> optionalApplicant = applicantRepository.findById(id);
        if (optionalApplicant.isPresent()){
            Applicant a = optionalApplicant.get();
            a.setName(aname);
            a.setLastname(alastname);
            a.setMiddlename(amiddlename);
            a.setBirthdate(abirthdate);
            a.setTelephonenumber(atelephonenumber);
            a.setMiddleZNO(amiddleZNO);
            a.setMiddleSchool(amiddle_school);
            applicantRepository.save(a);
        }
        return "redirect:/applicants";
    }
}
