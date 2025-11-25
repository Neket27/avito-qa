package avito.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// для GET /statistic/{id}
// TODO сервер возвращает *массив* из 1 элемента, хотя должен объект - моделируем как List
    @Data
    @NoArgsConstructor
    public class StatisticResponse {
        private long contacts;
        private long likes;
        private long viewCount;
    }
