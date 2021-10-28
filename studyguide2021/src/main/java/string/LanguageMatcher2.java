package string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LanguageMatcher2 implements Matcher {

  private static final String DELIMITER = ",";

  private static final String LANG_DELIMITER = "-";

  @Override
  public List<String> match(String clientLangDesired, Collection<String> supportedLanguages) {
    if (clientLangDesired == null || clientLangDesired.length() == 0) {
      return supportedLanguages.stream().collect(Collectors.toList());
    }

    if (supportedLanguages == null || supportedLanguages.isEmpty()) {
      return new ArrayList<>();
    }

    Map<String, List<String>> tagToLanguage = createTagToLanguage(supportedLanguages);

    Set<String> serverSupportedLanguages = new HashSet<>(supportedLanguages);
    String[] desiredLanguages = clientLangDesired.split(DELIMITER);

    List<String> languagesSupportedByServer = new ArrayList<>();
    Set<String> resultCache = new HashSet<>();

    for (String lang : desiredLanguages) {
      String trimmedLang = lang.trim();

      if (serverSupportedLanguages.contains(trimmedLang) && !resultCache.contains(trimmedLang)) {
        languagesSupportedByServer.add(trimmedLang);
        resultCache.add(trimmedLang);

      } else if (tagToLanguage.containsKey(trimmedLang)) {

        List<String> languages = tagToLanguage.get(trimmedLang);
        for (String language : languages) {
          if (!resultCache.contains(language)) {
            languagesSupportedByServer.add(language);
          }
        }
      }
    }

    return languagesSupportedByServer;
  }

  private Map<String, List<String>> createTagToLanguage(Collection<String> supportedLanguages) {

    Map<String, List<String>> tagToLanguage = new HashMap<>();
    for (String supported : supportedLanguages) {

      String[] split = supported.split(LANG_DELIMITER);
      String tag = split[0].trim();

      List<String> languages;
      if (!tagToLanguage.containsKey(tag)) {
        languages = new ArrayList<>();
      } else {
        languages = tagToLanguage.get(tag);
      }
      languages.add(supported);

      tagToLanguage.put(tag, languages);
    }

    return tagToLanguage;
  }
}
