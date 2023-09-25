package com.manu.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.manu.entity.Student;

public interface StudentRepo extends ReactiveMongoRepository<Student, String>{

}
