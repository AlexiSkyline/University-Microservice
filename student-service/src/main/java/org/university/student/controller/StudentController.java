package org.university.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.student.dto.CourseDTO;
import org.university.student.dto.GradeDTO;
import org.university.student.dto.MajorDTO;
import org.university.student.dto.SubjectDTO;
import org.university.student.entity.Student;
import org.university.student.feignclients.GradeService;
import org.university.student.feignclients.StudyProgramService;
import org.university.student.service.IStudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;
    private final StudyProgramService studyProgramService;
    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(this.studentService.save(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> studentList = this.studentService.findAll();
        if (studentList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        Optional<Student> foundStudent = this.studentService.findById(id);
        return foundStudent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("registration")
    public ResponseEntity<Student> findStudentByRegistration(@RequestParam String registration) {
        Optional<Student> foundStudent = this.studentService.findByRegistration(registration);
        return foundStudent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("major/{majorId}")
    public ResponseEntity<Map<String, Object>> findAllStudentByMajorId(@PathVariable Long majorId) {
        MajorDTO foundMajor = this.studyProgramService.getMajorById(majorId);
        List<Student> studentList = this.studentService.findByMajorId(majorId);
        Map<String, Object> response = new HashMap<>();
        response.put("majorInfo", foundMajor);
        response.put("studentList", studentList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("course/{courseId}")
    public ResponseEntity<Map<String, Object>> findAllStudentByCourseId(@PathVariable Long courseId) {
        CourseDTO foundCourse = this.studyProgramService.getCourseById(courseId);
        List<Student> studentList = this.studentService.findByCourseId(courseId);

        Map<String, Object> response = new HashMap<>();
        response.put("curseInfo", foundCourse);
        response.put("studentList", studentList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}/subjects")
    public ResponseEntity<Map<String, Object>> findAllSubjectsByStudentId(@PathVariable Long id) {
        Optional<Student> student = this.studentService.findById(id);
        if (student.isEmpty() || student.get().getCourseId() == null) {
            return ResponseEntity.notFound().build();
        }
        List<SubjectDTO> subjectList = this.studyProgramService
                .getAllSubjectByCourseId(student.get().getCourseId());
        List<GradeDTO> gradeList = this.gradeService.getAllGradesByStudentId(id);
        for (SubjectDTO subjectDTO : subjectList) {
            for (GradeDTO gradeDTO : gradeList) {
                if (subjectDTO.getId().equals(gradeDTO.getSubjectId())) {
                    subjectDTO.setFinalGrade(gradeDTO.getFinalGrade());
                }
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("studentInfo", student.get());
        response.put("subjectList", subjectList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> foundStudent = this.studentService.findById(id);
        if (foundStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
        return ResponseEntity.ok(this.studentService.update(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Optional<Student> foundStudent = this.studentService.findById(id);
        if (foundStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.studentService.delete(id));
    }
}