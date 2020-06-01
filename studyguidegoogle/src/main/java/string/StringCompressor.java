package string;

public class StringCompressor {

    public String compress(final String s) {
        if (s == null || s.isEmpty()) {
            return new String();
        }

        int countConsecutives = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            countConsecutives++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(countConsecutives);
                countConsecutives = 0;
            }
        }
        return sb.toString().length() > s.length() ? s : sb.toString();
    }
}
