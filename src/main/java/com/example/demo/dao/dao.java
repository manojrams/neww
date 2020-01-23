package com.example.demo.dao;

import com.example.demo.model.Records;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface dao extends CrudRepository<Records,Integer> {

    @Override
    List<Records> findAll();
}
