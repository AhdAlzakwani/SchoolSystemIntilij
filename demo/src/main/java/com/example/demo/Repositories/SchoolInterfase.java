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

    @Query(value = "SELECT s FROM School s WHERE s.id =:id")
    School getSchoollById(@Param("id") Integer id);

}
