package com.bilel.SpringBoot_TP01.dto;

import com.bilel.SpringBoot_TP01.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TeacherDTO {
    private Long teacherId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
//    private String password;
    private String role;
    private Date birthday;
    private List<Course> courses;
}
