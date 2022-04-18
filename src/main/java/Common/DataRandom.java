package Common;

import java.util.concurrent.ThreadLocalRandom;

public class DataRandom {
    public static int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1,1000000000);
    }
    public static String generateRandomEmail(String email){
        String[] part = email.split("@");
        String part1 = part[0];
        String part2 = part[1];
        System.out.println(part1 + generateNumber() + "@" +part2);
        return part1 + "a" + generateNumber() + "@" +part2;
    }
}
