package yi.shi.ai.qianwen;


public class AiBookInfoGenerator {

    private static final String template = "{\"bookName\":null,\"isbn\":null,\"digest\":null,\"author\":null,\"aboutAuthor\":null,\"price\":null,\"coverUrl\":null}";


    public static String escapeJson(String input) {
        if (input == null) {
            return null;
        }
        String _input = input.substring(input.indexOf("{"), input.lastIndexOf("}")+1);
        System.out.println(_input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _input.length(); i++) {
            char c = _input.charAt(i);
            if (c >= 32) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
