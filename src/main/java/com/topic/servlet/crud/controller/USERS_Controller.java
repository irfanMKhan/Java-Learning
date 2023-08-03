package com.topic.servlet.crud.controller;

import com.topic.servlet.crud.model.TBL_USERS;
import com.topic.servlet.crud.repository.USERS_REPO;
import com.topic.servlet.crud.service.USERS_SERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class USERS_Controller {
    private final USERS_SERVICE users_service;
    private final USERS_REPO users_repo;

    @GetMapping("/getUserNameFromParam")
    public ResponseEntity<?> getUserName(@RequestParam(name = "name", defaultValue = "SSamiul") String name_default, @RequestParam Optional<String> name_optional, @RequestParam String name_required ) {
        System.out.println(name_default+" " + name_optional.orElseGet(()->" not provided ") + name_required);
        Optional<String> test = users_service.getEmployeeName(name_default);
//        return ResponseEntity.ok(users_service.getEmployeeName(name_default));
        return Optional.ofNullable(users_service.getEmployeeName(name_default)).map(
                user -> ResponseEntity.ok().body(user)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getUserNameFromPath/{name}")
    public String getUsernameFromPath(@PathVariable String name){
        return "Id" + name;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody TBL_USERS user){
        Integer user_id = users_service.saveUser(user);
        return ResponseEntity.status(201).body("created id is " + user_id);
//        return ResponseEntity.ok().body("created id is " + user_id);
    }

    @GetMapping("/paging")
    public ResponseEntity<?> getAllUsers(){
        Page<TBL_USERS> results = users_repo.findAll(PageRequest.of(0, 10, Sort.by("username").descending().and(Sort.by("id").descending())));
        return ResponseEntity.ok(results);
    }

}
