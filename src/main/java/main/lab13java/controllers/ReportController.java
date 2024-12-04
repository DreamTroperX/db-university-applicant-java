package main.lab13java.controllers;

import main.lab13java.dao.ApplicationRepository;
import main.lab13java.dao.FacultyRepository;
import main.lab13java.dao.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/information")
    public String showInformation(){
        return "information";
    }

    @GetMapping("/zvity")
    public String showZvity(){
        return "zvity";
    }
    /*@GetMapping("/specializationApplicationsReport")
    public String specializationApplicationsReport(Model model) {
        List<Object[]> specializationApplications = specializationRepository.getSpecializationApplications();
        model.addAttribute("specializationApplications", specializationApplications);
        return "specializationApplicationsReport";
    }

    @GetMapping("/facultyStatisticsReport")
    public String facultyStatisticsReport(Model model) {
        List<Object[]> facultyStatistics = facultyRepository.getFacultyStatistics();
        model.addAttribute("facultyStatistics", facultyStatistics);
        return "facultyStatisticsReport";
    }*/
}
