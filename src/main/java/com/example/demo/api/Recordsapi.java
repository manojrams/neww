package com.example.demo.api;

import com.example.demo.model.Records;
import com.example.demo.recordservice.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/records")

public class Recordsapi {
    @Autowired
    private Service Service;

    @PostMapping
    public Records addRecord(@RequestBody Records records){
        return Service.addrecords(records);
    }

    @GetMapping
    public List<Records> getRecords(){
        return Service.getRecords();
    }
    @GetMapping(value = "/{customerId}")
    public Records getRecord(@PathVariable("customerId") int RollNo){
        return Service.getRecord(RollNo);

    }
    @PutMapping(value = "/{customerId}")
    public Records updateRecord(@PathVariable("customerId") int customerId,@RequestBody  Records Records){
        return Service.updateRecord(customerId,Records);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("RollNo") int RollNo){
        Service.deleteRecord(RollNo);
    }




}
