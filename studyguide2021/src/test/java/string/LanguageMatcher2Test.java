package string;

/*
parse_accept_language(
  "en-US, fr-CA, fr-FR",  # the client's Accept-Language header, a string
  ["fr-FR", "en-US"]      # the server's supported languages, a set of strings
)
returns: ["en-US", "fr-FR"]

parse_accept_language("fr-CA, fr-FR", ["en-US", "fr-FR"])
returns: ["fr-FR"]

parse_accept_language("en-US", ["en-US", "fr-CA"])
returns: ["en-US"]

Part 2

Accept-Language headers will often also include a language tag that is not
region-specific - for example, a tag of "en" means "any variant of English". Extend
your function to support these language tags by letting them match all specific
variants of the language.

Examples:

parse_accept_language("en", ["en-US", "fr-CA", "fr-FR"])
returns: ["en-US"]

parse_accept_language("fr", ["en-US", "fr-CA", "fr-FR"])
returns: ["fr-CA", "fr-FR"]

parse_accept_language("fr-FR, fr", ["en-US", "fr-CA", "fr-FR"])
returns: ["fr-FR", "fr-CA"]
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LanguageMatcher2Test {

  @Test
  public void MatchFrenchFRSuccess() {
    String client = "fr-CA, fr-FR";
    List<String> supported = List.of("en-US", "fr-FR");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("fr-FR"), results);
  }

  @Test
  public void MatchEnglishFrenchSuccess() {
    String client = "en-US, fr-CA, fr-FR";
    List<String> supported = List.of("fr-FR", "en-US");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("en-US", "fr-FR"), results);
  }

  @Test
  public void MatchEnglishSuccess() {
    String client = "en-US";
    List<String> supported = List.of("en-US", "fr-CA");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("en-US"), results);
  }

  @Test
  public void MatchEnglishFrenchFRSuccess() {
    String client = "en-US,fr-CA      , fr-FR";
    List<String> supported = List.of("fr-FR", "en-US");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("en-US", "fr-FR"), results);
  }

  @Test
  public void MatchEnglishTagSuccess() {
    String client = "en";
    List<String> supported = List.of("fr-FR", "en-US", "fr-CA");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("en-US"), results);
  }

  @Test
  public void MatchFrenchTagSuccess() {
    String client = "fr";
    List<String> supported = List.of("en-US", "fr-CA", "fr-FR");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("fr-CA", "fr-FR"), results);
  }

  @Test
  public void MatchFrenchFRTagSuccess() {
    String client = "fr-FR, fr";
    List<String> supported = List.of("en-US", "fr-CA", "fr-FR");

    Matcher languageMatcher = new LanguageMatcher2();
    List<String> results = languageMatcher.match(client, supported);

    Assertions.assertIterableEquals(List.of("fr-FR", "fr-CA"), results);
  }
}