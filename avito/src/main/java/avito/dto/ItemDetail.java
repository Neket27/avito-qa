package avito.dto;

import avito.etity.Statistics;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    public class ItemDetail {
        private String id;
        private String name;
        private long price;
        private long sellerId;
        private Statistics statistics;
        private String createdAt;
    }
