package dev.pos4.pos;

import java.util.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/floor")
public class tableController {

    @Autowired
    private tableService tService;

    @GetMapping
    public ResponseEntity<List<table>> getAllTables() {
        return new ResponseEntity<List<table>>(tService.allTables(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<table>> getSingleTable(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<table>>(tService.singleTable(id), HttpStatus.OK);
    }

    @GetMapping("/{tableNumber}")
    public ResponseEntity<Optional<table>> getSingleTable(@PathVariable int tableNumber) {
        return new ResponseEntity<Optional<table>>(tService.singleTable(tableNumber), HttpStatus.OK);
    }
    
}
