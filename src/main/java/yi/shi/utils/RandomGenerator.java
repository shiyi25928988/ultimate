package yi.shi.utils;

public class RandomGenerator {

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            sb.append((char) (Math.random() * 26 + 'a'));
        }
        return sb.toString();
    }

}
