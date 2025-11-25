package avito.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

    @Data
    @NoArgsConstructor
    public class ErrorResponse {
        private Result result;
        private String status;

        @Data
        @NoArgsConstructor
        public static class Result {
            private String message;
            private Map<String, Object> messages;
        }
    }
