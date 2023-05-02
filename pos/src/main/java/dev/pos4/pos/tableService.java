package dev.pos4.pos;
import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class tableService {

    @Autowired
    private tableRepository tRepository;

    /*
    private MongoTemplate mongoTemplate;*/

    public List<table> allTables() {  
        return tRepository.findAll();
    }

    public Optional<table> singleTable(ObjectId id) {  
        return tRepository.findById(id);
    }

    public Optional<table> singleTable(int i) {  
        return tRepository.findTableBytableNumber(i);
    }

    public table createTable(int tableNumber, int numberOfSeats) {
        table table = new table(tableNumber,numberOfSeats);
        tRepository.insert(table);
        /*mongoTemplate.update(table.class)
            .matching(Criteria.where("tableNumber").is(tableNumber))
            .apply(new Update().push("tableIds").value(table));*/
        return table;
    }
}
