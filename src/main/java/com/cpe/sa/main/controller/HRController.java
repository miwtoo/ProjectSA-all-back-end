package com.cpe.sa.main.controller;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Map;
import javax.validation.Valid;
import java.util.Date;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Departments")
class DepartmentController {
    private  departmentrepos repository;
    public DepartmentController(departmentrepos repository){
        this.repository=repository;
    }
    @GetMapping()
    public Collection<Department> department() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Positions")
class JobPositionController {

    @Autowired private jobpositionrepos repository;
    @Autowired private departmentrepos departmentRepository;
    @Autowired private Personrepos personRepository;



    @GetMapping()
    public Collection<Job_position> Job_position() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()
    public Job_position  position(Job_position newJob,@RequestBody Map<String,Object> body){

        Optional<Department> depart = departmentRepository.findById(Long.valueOf(body.get("deploy").toString()));
        Optional<personnel> person = personRepository.findById(Long.valueOf(body.get("person").toString()));

        newJob.setDeploy(depart.get());
        newJob.setPerson(person.get());
        newJob.setDate(new Date());
        return repository.save(newJob);
    }

}

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Records")

class JobRecordController {

    @Autowired  private  jobrecordrepos repository;
    @Autowired private Personrepos personRepository;


    public JobRecordController(jobrecordrepos repository){
        this.repository=repository;
    }

    @GetMapping()
    public Collection<job_record> job_record() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()
    public  job_record  Record(job_record newrecord ,@RequestBody  Map<String,Object> body){


        Optional<personnel> person = personRepository.findById(Long.valueOf(body.get("person").toString()));

        newrecord.setPerson(person.get());
        newrecord.setTime(new Date());
        return repository.save(newrecord);

    }


}

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/persons")

 class personController {
    @Autowired private Personrepos repository;

    public  personController(Personrepos repository){

        this.repository = repository;
    }

    @GetMapping()

    public Collection<personnel> personnel() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()

    public personnel AddPerson(@RequestBody personnel body){

        return repository.save(body);
    }


    @DeleteMapping("delete/{id}")
    public  boolean deletePerson(@PathVariable  Long id) {
        try {

            repository.deleteById(id);



            return true;
        }catch (Exception e) {
            return false;
        }
    }

       @PutMapping("update")
    public  personnel updatePerson(@RequestBody personnel body) {

        if( repository.findById(body.getPersonid()).get() != null )
        return repository.save(body);

        else return null;
    }



}



