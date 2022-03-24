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
public class FixtureDB {
    @Id
    private String idName;
    private int minKelvin;
    private int maxKelvin;
}
