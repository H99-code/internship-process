package hhn.system.internship.repository;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HisproService {

    private List<File> files;

    public HisproService() {
        this.files = new ArrayList<>();
        files.add(new File("C:\\Users\\Tom\\Desktop\\server\\src\\main\\resources\\hispro-student-data.xml"));
    }


    public Student getStudent() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {


        for (File file : files) {

            Student student = new Student();
            try (FileInputStream fileIS = new FileInputStream(file)) {
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Document xmlDocument = builder.parse(fileIS);
                XPath xPath = XPathFactory.newInstance().newXPath();


                String firstname = (String) xPath.compile("/resultSet/row/cell[@name='Vorname']").evaluate(xmlDocument, XPathConstants.STRING);
                String lastname = (String) xPath.compile("/resultSet/row/cell[@name='Nachname']").evaluate(xmlDocument, XPathConstants.STRING);
                String gender = (String) xPath.compile("/resultSet/row/cell[@name='Geschl']").evaluate(xmlDocument, XPathConstants.STRING);
                String studentNumber = (String) xPath.compile("/resultSet/row/cell[@name='Mtknr']").evaluate(xmlDocument, XPathConstants.STRING);
                String studySemester = (String) xPath.compile("//Element[@ref-id='240']/Studysemester").evaluate(xmlDocument, XPathConstants.STRING);
                String courseName = (String) xPath.compile("//Element[@ref-id='239']/Shorttext").evaluate(xmlDocument, XPathConstants.STRING);

                student.setStudyProgram(courseName);
                student.setFirstName(firstname);
                student.setStudentNumber(Integer.parseInt(studentNumber));
                student.setGender(gender);
                student.setLastName(lastname);
                student.setCurrentSemester(Integer.valueOf(String.valueOf(Integer.parseInt(studySemester))));


            }
            return student;

        }

        return null;
    }

    public List<StudyAchievement> getAchievements() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
        List<StudyAchievement> achievements = new ArrayList<>();


        for (File file : files) {
            try (FileInputStream fileIS = new FileInputStream(file)) {
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Document xmlDocument = builder.parse(fileIS);
                XPath xPath = XPathFactory.newInstance().newXPath();

                String coreStatus = (String) xPath.compile("//Element[@ref-id='219']/WorkstatusShorttextDefRel").evaluate(xmlDocument, XPathConstants.STRING);
                String currentCoreECTS = (String) xPath.compile("//Element[@ref-id='219']/Bonus").evaluate(xmlDocument, XPathConstants.STRING);
                String totalCoreStudyECTS = (String) xPath.compile("//Element[@ref-id='219']/BonusOfUnit").evaluate(xmlDocument, XPathConstants.STRING);

                StudyAchievement achievement = new StudyAchievement();
                achievement.setRequiredECTSBasic(Integer.parseInt(totalCoreStudyECTS));
                achievement.setBasicStatus(coreStatus);
                achievement.setCurrentECTSBasic(Integer.parseInt(currentCoreECTS));

                List<Exam> exams = getExamData(xmlDocument);
                achievement.setExams(exams);

                achievements.add(achievement);
            }
        }

        return achievements;
    }

    private List<Exam> getExamData(Document xmlDocument) throws XPathExpressionException {
        List<Exam> exams = new ArrayList<>();
        XPath xPath = XPathFactory.newInstance().newXPath();

        String xpathExpression = "//Children[@dataType='List']/Element[RecSemester[contains(., '2') or contains(., '1')] and WorkstatusShorttext[contains(.,'BE')]]";
        NodeList nodes = (NodeList) xPath.compile(xpathExpression).evaluate(xmlDocument, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            String examStatus = (String) xPath.compile("WorkstatusShorttext").evaluate(nodes.item(i), XPathConstants.STRING);
            String examName = (String) xPath.compile("Defaulttext").evaluate(nodes.item(i), XPathConstants.STRING);
            String examNumber = (String) xPath.compile("Elementnr").evaluate(nodes.item(i), XPathConstants.STRING);

            Exam exam = new Exam();
            exam.setExamStatus(examStatus);
            exam.setExamNumber(Integer.parseInt(examNumber));
            exam.setExamName(examName);


            boolean isDuplicate = exams.stream()
                    .anyMatch(existingExam -> existingExam.getExamNumber() == exam.getExamNumber());

            if (!isDuplicate) {
                exams.add(exam);
            }
        }
        return exams;
    }
}
