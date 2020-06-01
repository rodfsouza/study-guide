package string;

public class URLify {

    public String toUrl(final String s) {
        if (s == null || s.isEmpty()) {
            return new String();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
