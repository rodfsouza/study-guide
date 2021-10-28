package string;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguageMatcherTest {

  @Test
  public void SupportsEnglishAndFrenchFROnly() {
    String langs = "en-US, fr-CA, fr-FR";
    Set<String> supportedLanguages = Set.of("fr-FR","en-US");
    LanguageMatcher lanMatcher = new LanguageMatcher();
    List<String> matches = lanMatcher.hasAcceptableLanguage(langs, supportedLanguages);
    Assertions.assertEquals(2, matches.size());
  }

  @Test
  public void SupportsFrenchFROnly() {
    String langs = "fr-CA, fr-FR";
    Set<String> supportedLanguages = Set.of("fr-FR","en-US");
    LanguageMatcher lanMatcher = new LanguageMatcher();
    List<String> matches = lanMatcher.hasAcceptableLanguage(langs, supportedLanguages);
    Assertions.assertEquals(1, matches.size());
  }

  @Test
  public void SupportsSingleTag() {
    String langs = "en";
    Set<String> supportedLanguages = Set.of("fr-FR","en-US");
    LanguageMatcher lanMatcher = new LanguageMatcher();
    List<String> matches = lanMatcher.hasAcceptableLanguage(langs, supportedLanguages);
    Assertions.assertEquals(1, matches.size());
  }

  @Test
  public void SupportsTagAndLanguage() {
    String langs = "en-US, fr";
    Set<String> supportedLanguages = Set.of("fr-FR", "fr-CA", "en-US");
    LanguageMatcher lanMatcher = new LanguageMatcher();
    List<String> matches = lanMatcher.hasAcceptableLanguage(langs, supportedLanguages);
    Assertions.assertEquals(2, matches.size());
  }
}
