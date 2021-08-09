//package searching;
//
//import javafx.util.Pair;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SearchSequence {
//
//    public boolean isValidSequence(List<Pair<String, String>> input, List<String> s1, List<String> s2) {
//        if (input == null || input.isEmpty()) {
//            return false;
//        }
//
//        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
//            return false;
//        }
//
//        if (s1.size() != s2.size()) {
//            return false;
//        }
//
//        Map<String, String> table = generateTable(input);
//
//        for (int i = 0; i < s1.size(); ++i) {
//            String s1Value = table.get(s1.get(i));
//            String s2Value = table.get(s2.get(i));
//
//            if (!table.containsKey(s1Value) || !table.containsKey(s2Value) ||
//                !s1.get(i).equals(s2Value) || !s2.get(i).equals(s1Value)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private Map<String, String> generateTable(List<Pair<String, String>> input) {
//        Map<String, String> tableResult = new HashMap<>();
//        for (Pair<String, String> pair : input) {
//            tableResult.putIfAbsent(pair.getKey(), pair.getValue());
//            tableResult.putIfAbsent(pair.getValue(), pair.getKey());
//        }
//
//        return tableResult;
//    }
//}
