package string;

import java.util.Collection;
import java.util.List;

public interface Matcher {

  List<String> match(String clientLangDesired, Collection<String> supportedLanguages);
}
