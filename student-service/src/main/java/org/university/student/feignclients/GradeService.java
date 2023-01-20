package org.university.student.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.university.student.dto.GradeDTO;

import java.util.List;

@FeignClient(name = "grades-service")
@RequestMapping("/grades")
public interface GradeService {
    @GetMapping("student/{studentId}")
    List<GradeDTO> getAllGradesByStudentId(@PathVariable("studentId") Long studentId);
}