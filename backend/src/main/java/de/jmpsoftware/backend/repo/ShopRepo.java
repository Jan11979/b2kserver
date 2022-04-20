package de.jmpsoftware.backend.repo;

import de.jmpsoftware.backend.model.db.ShopItemDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends MongoRepository<ShopItemDB,String> {
    ShopItemDB findByName(String name);
}

