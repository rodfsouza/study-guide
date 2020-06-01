package searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodsou on 7/14/17.
 */
public class SearchingProblems {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Rodrigo");
        words.add("Vanessa");
        words.add("Benjamin");
        words.add("Benjamin");
        words.add("Benjamin");
        words.add("Vanessa");
        words.add("Rafael");
        words.add("Rafael");


        BucketSearch search = new BucketSearch(words);
        List<String> wordsByPosition = search.getWords2(1);

        for (String s : wordsByPosition) {
            System.out.println(s);
        }
    }
}
