package avito.constants;

import avito.etity.Statistics;

import java.math.BigInteger;

public class CreateConstants {
    public static BigInteger SELLER_ID = BigInteger.valueOf(111222);
    public static String NAME = "Имя";
    public static BigInteger PRiCE = BigInteger.valueOf(999);

    public static BigInteger LIKES = BigInteger.ONE;
    public static BigInteger VIEW_COUNT = BigInteger.ONE;
    public static BigInteger CONTACTS = BigInteger.ONE;
    public static Statistics STATISTICS = new Statistics(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE);
}
