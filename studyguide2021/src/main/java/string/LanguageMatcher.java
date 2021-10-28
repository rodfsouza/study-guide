package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LanguageMatcher {

  List<String> hasAcceptableLanguage(String clientDesire, Set<String> supportedLanguages) {
    if (clientDesire == null || clientDesire.length() == 0
        || supportedLanguages == null || supportedLanguages.isEmpty()) {
      return new ArrayList<>();
    }

    List<String> results = new ArrayList<>();

    Map<String, String> tagToLanguage = new HashMap<>();
    for (String lang : supportedLanguages) {
      String[] splittedLang = lang.split("-");
      tagToLanguage.putIfAbsent(splittedLang[0], lang);
    }

    String[] splitted = clientDesire.split(",");

    for (String language : splitted) {
      String lang = language.trim();
      if (supportedLanguages.contains(lang)) {
        results.add(lang);
      } else if (tagToLanguage.containsKey(lang)) {
        results.add(tagToLanguage.get(lang));
      }
    }

    return results;
  }
}
