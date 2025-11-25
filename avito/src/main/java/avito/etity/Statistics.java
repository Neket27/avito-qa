package avito.etity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
        private BigInteger likes;
        private BigInteger viewCount;
        private BigInteger contacts;
    }
