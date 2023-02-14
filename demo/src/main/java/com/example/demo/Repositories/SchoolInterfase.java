package com.example.demo.Repositories;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolInterfase extends CrudRepository<Student, Integer> {

    @Query(value = "SELECT s FROM School s")
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id = :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);

    @Query(value = "SELECT s from School s " +
            "WHERE s.Name = :schoolName")
    School getBySchoolName(@Param("schoolName") String schoolName);

    @Query(value = "SELECT s from School s where s.isActive = true")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = false")
    List<School> getAllNotActiveSchools();

}
