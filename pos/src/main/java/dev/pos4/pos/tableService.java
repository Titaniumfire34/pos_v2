package dev.pos4.pos;
import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tableService {

    @Autowired
    private tableRepository tRepository;

    public List<table> allTables() {  
        return tRepository.findAll();
    }

    public Optional<table> singleTable(ObjectId id) {  
        return tRepository.findById(id);
    }

    public Optional<table> singleTable(int i) {  
        return tRepository.findTableBytableNumber(i);
    }
}
