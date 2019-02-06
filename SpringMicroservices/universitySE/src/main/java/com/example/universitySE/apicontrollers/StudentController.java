package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.PersonLoginDTO;
import com.example.universitySE.dtos.RatingDTO;
import com.example.universitySE.dtos.SubjectDTO;
import com.example.universitySE.intservices.StudentServiceInterface;
import com.example.universitySE.shared.JSONResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.Array;

@RestController
@RequestMapping("user/student")
public class StudentController {

    @Autowired
    StudentServiceInterface serviceInterface;

    @PostMapping("/addrating")
    public ResponseEntity<JSONResponseBody> getAllReporting(@Valid @RequestBody RatingDTO ratingDTO) {
        try {
            serviceInterface.addRating(ratingDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), "OK!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping("/getlastuploadmaterial")
    public ResponseEntity<JSONResponseBody> getLastUploadMaterial(@RequestBody SubjectDTO subjectDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), serviceInterface.getLastUpload(subjectDTO.getSubjects())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }
}
