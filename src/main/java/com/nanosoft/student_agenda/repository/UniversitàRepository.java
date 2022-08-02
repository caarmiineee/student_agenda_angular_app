package com.nanosoft.student_agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanosoft.student_agenda.model.Università;

@Repository
public interface UniversitàRepository extends JpaRepository<Università, Integer>{

}
