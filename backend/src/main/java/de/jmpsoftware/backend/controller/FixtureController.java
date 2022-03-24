package de.jmpsoftware.backend.controller;

import de.jmpsoftware.backend.model.db.FixtureDB;
import de.jmpsoftware.backend.repo.FixtureRepo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("api/fixture")
public class FixtureController {
    private static final Log LOG = LogFactory.getLog(FixtureController.class);
    final FixtureRepo repositoryFixture;

    public FixtureController(FixtureRepo repositoryFixture) {
        this.repositoryFixture = repositoryFixture;
    }

    @GetMapping(path = "/getlist")
    public ResponseEntity<List<String>> returnAllFixtureNameList() {
        List<String> tmpList = new ArrayList<>();
        tmpList.add("Eins");
        tmpList.add("Zwei");
        tmpList.add("Drei");
        return ResponseEntity.ok( tmpList);
    }

    @GetMapping(path = "/getfixtures")
    public ResponseEntity<List<FixtureDB>> returnAllFixtureList() {
        List<FixtureDB> tmpList = repositoryFixture.findAll();
        return ResponseEntity.ok( tmpList);
    }

    @GetMapping(path = "/createdummy")
    public void createDummyFixtureList() {
        repositoryFixture.save(FixtureDB.builder().idName("SkyP").minKelvin(3000).maxKelvin(10000).build());
        repositoryFixture.save( FixtureDB.builder().idName("Test1").minKelvin(1000).maxKelvin(5000).build());
        repositoryFixture.save( FixtureDB.builder().idName("Test2").minKelvin(5000).maxKelvin(8000).build());
    }



}

