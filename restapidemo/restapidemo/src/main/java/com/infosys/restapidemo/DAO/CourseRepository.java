package com.infosys.restapidemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.restapidemo.Models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
