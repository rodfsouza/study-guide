package integer;

public class ReverseInteger {

    public int reverse(int x) {
        long rev_num = 0;
        int sign = 1;

        if (x < 0) {
            sign = -1;
            x = x * (-1);
        }
        long base = 10;

        while (x > 0) {

            rev_num = rev_num * 10;

            //Multiply overflows
            if ((int)rev_num != rev_num) {
                return 0;
            }

            int remainder = x % 10;
            int r = remainder + (int)rev_num;
            //Addition overflow
            if (((remainder ^ r) & (rev_num ^ r)) < 0) {
                return 0;
            }
            rev_num = rev_num + x % 10;
            x = x / 10;
        }
        return (int)rev_num * sign;
    }
}
