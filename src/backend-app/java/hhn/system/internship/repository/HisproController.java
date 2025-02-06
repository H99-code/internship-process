package hhn.system.internship.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hispro")
@CrossOrigin(origins = "http://localhost:3000")
public class HisproController {

    @Autowired
    private HisproService hisproService;


    @GetMapping("/data")
    public Student getStudents() throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {


        Student student = hisproService.getStudent();


        List<StudyAchievement> achievements = hisproService.getAchievements();
        student.setStudyAchievementList(achievements);


        return student;
    }
}
