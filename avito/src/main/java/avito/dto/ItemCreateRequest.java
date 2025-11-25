package avito.dto;

import avito.etity.Statistics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ItemCreateRequest {
        private BigInteger sellerID;
        private String name;
        private BigInteger price;
        private Statistics statistics;
}
