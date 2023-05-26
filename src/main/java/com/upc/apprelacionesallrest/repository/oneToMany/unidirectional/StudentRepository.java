package com.upc.apprelacionesallrest.repository.oneToMany.unidirectional;

import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT u.students FROM University u where u.id =:id")
    List<Student> findStudents(Long id);
}
