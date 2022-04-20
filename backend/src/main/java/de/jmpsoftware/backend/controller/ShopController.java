package de.jmpsoftware.backend.controller;

import de.jmpsoftware.backend.model.db.ShopItemDB;
import de.jmpsoftware.backend.model.frontendconnection.ShopItemData;
import de.jmpsoftware.backend.repo.ShopRepo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/shop")
public class ShopController {
    private static final Log LOG = LogFactory.getLog(FixtureController.class);

    final ShopRepo repositoryShop;

    public ShopController(ShopRepo repositoryShop) {
        this.repositoryShop = repositoryShop;
    }

    @GetMapping(path = "/testlist")
    public ResponseEntity<List<ShopItemData>> returnAllShopList() {
        List<ShopItemData> tmpList = new ArrayList<>();
        tmpList.add(ShopItemData.builder().name("Milch").count(3).place("Rewe").build());
        tmpList.add(ShopItemData.builder().name("Eier").count(6).place("Denns").build());
        tmpList.add(ShopItemData.builder().name("Kaese").count(1).place("Markt").build());
        tmpList.add(ShopItemData.builder().name("Bier").count(3).place("Kiosk").build());
        return ResponseEntity.ok( tmpList);
    }

    @GetMapping(path = "/test")
    public ResponseEntity<ShopItemData> returnTest() {

        ShopItemData item = ShopItemData.builder().name("Milch").count(3).place("Rewe").build();

        return ResponseEntity.ok( item );
    }

    @GetMapping(path = "/test2")
    public ResponseEntity<ShopItemData> returnTest2() {

        ShopItemData item = ShopItemData.builder().name("Milch").count(3).place("Rewe").build();

        return item;
    }

}
