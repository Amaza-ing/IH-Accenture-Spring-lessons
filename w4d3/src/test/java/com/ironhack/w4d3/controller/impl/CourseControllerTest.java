package com.ironhack.w4d3.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.w4d3.controller.dto.CourseHoursDTO;
import com.ironhack.w4d3.model.Address;
import com.ironhack.w4d3.model.Course;
import com.ironhack.w4d3.model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    //  ******************************************************  GET  ******************************************************

    @Test
    void getAllCourses_validRequest_allCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Math"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Chemistry"));
    }

    @Test
    void getCourseById_validId_correctCourse() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses/math"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("math"));
    }

    @Test
    void getCourseById_invalidId_NotFound() throws Exception {
        mockMvc.perform(get("/api/courses/patata").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void getCourseByHoursLessThan_100Hours_correctCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses/hours?hours=100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("English"));
    }

    @Test
    void getCourseByHoursLessThan_100HoursWithParam_correctCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses/hours").param("hours", "100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("English"));
    }

    @Test
    void getCourseByClassroomAndHours_validClassroom_correctCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses/classroom?classroom=B1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Programming"));
    }


    //  *****************************************************  POST  ******************************************************

    @Test
    void saveCourse_validCourse_courseSaved() throws Exception {
        Address address = new Address("calle falsa", "123");
        Teacher teacher = new Teacher("nuevo teacher", address);
        Course course = new Course("Testing", 100, "A1", "2 weeks", teacher);

        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(post("/api/courses").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Testing"));

        mockMvc.perform(delete("/api/courses/testing"))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void saveCourse_invalidCourse_unprocessableEntityResponse() throws Exception {
        Address address = new Address("calle falsa", "123");
        Teacher teacher = new Teacher("nuevo teacher", address);
        Course course = new Course("Math", 100, "A1", "2 weeks", teacher);

        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(post("/api/courses").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andReturn();
    }


    //  ******************************************************  PUT  ******************************************************

    @Test
    void updateCourse_validCourse_courseUpdated() throws Exception {
        Address address = new Address("calle falsa", "123");
        Teacher teacher = new Teacher("nuevo teacher", address);
        Course course = new Course("Math", 100, "AAA", "2 weeks", teacher);

        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(put("/api/courses/math").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("AAA"));
    }

    @Test
    void updateCourse_invalidCourse_notFoundResponse() throws Exception {
        Address address = new Address("calle falsa", "123");
        Teacher teacher = new Teacher("nuevo teacher", address);
        Course course = new Course("Patata", 100, "AAA", "2 weeks", teacher);

        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(put("/api/courses/invalid-course").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }


    //  *****************************************************  PATCH  *****************************************************

    @Test
    void updateCourseHours_validHours_courseUpdated() throws Exception {
        CourseHoursDTO courseHoursDTO = new CourseHoursDTO(333);
        String body = objectMapper.writeValueAsString(courseHoursDTO);

        mockMvc.perform(patch("/api/courses/hours/math").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("333"));
    }

    @Test
    void updateCourseHours_invalidHours_badRequestResponse() throws Exception {
        CourseHoursDTO courseHoursDTO = new CourseHoursDTO(5);
        String body = objectMapper.writeValueAsString(courseHoursDTO);

        mockMvc.perform(patch("/api/courses/hours/math").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }


    //  ****************************************************  DELETE  *****************************************************

    @Test
    void deleteCourse__courseDeleted() throws Exception {
        Address address = new Address("calle falsa", "123");
        Teacher teacher = new Teacher("nuevo teacher", address);
        Course course = new Course("Testing", 100, "A1", "2 weeks", teacher);

        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(post("/api/courses").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(delete("/api/courses/testing"))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Testing"));
    }
}