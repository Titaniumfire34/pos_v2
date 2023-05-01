package dev.pos4.pos;

import java.util.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tableRepository extends MongoRepository<table,ObjectId> {
    Optional<table> findTableBytableNumber(int tableNumber);

}
