package string;

public class ReverseWords2 {

    public String reverse(String cmds[]) {

        if (cmds == null || cmds.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        for (int i = cmds.length - 1; i >= 1; --i) {
            String cmd = cmds[i];
            for (int j = cmd.length() - 1; j >= 0; --j) {
                sb.append(cmd.charAt(j));
            }
            reversed.append(sb).append(" ");
            sb = new StringBuilder();
        }
        return reversed.toString();
    }
}
