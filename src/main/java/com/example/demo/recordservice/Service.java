package com.example.demo.recordservice;

import com.example.demo.dao.dao;
import com.example.demo.model.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class Service {
    @Autowired
    private com.example.demo.dao.dao dao;

    private List<Records> customerList = new CopyOnWriteArrayList();
     //method 1 adding record
    public Records addrecords(Records records){
      return  dao.save(records);

    }

    // method 2 to get list of records
    public List<Records> getRecords(){
        return dao.findAll();
    }

    //method 3 to get record by rollno
    public Records getRecord(int RollNo){
        Optional<Records> optionalCustomer = dao.findById(RollNo);
        if(!optionalCustomer.isPresent()){
           // throw new CustomerNotFoundException("customer record is not present,Please try to add the record......");
        }
        return optionalCustomer.get();
    }


    // method 4 to update the record by passing rollno
    public Records updateRecord(int RollNo,Records records){
        records.setRollNo(RollNo);
        return dao.save(records);
    }

    // method 5 to delete the record by passing rollno
    public void deleteRecord(int RollNo){
        dao.deleteById(RollNo);
    }



}
