package string;

public class URLifyTest {

    public static void main(String[] args) {
        URLify url = new URLify();
        String output = url.toUrl("Mr John Smith");
        System.out.println(output);


    }

}
