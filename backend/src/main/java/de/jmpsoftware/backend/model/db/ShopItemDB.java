package de.jmpsoftware.backend.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopItemDB {
    @Id
    private String id;
    private String name;
    private int count;
    private String place;
}
