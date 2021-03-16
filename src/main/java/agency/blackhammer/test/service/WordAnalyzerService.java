package agency.blackhammer.test.service;

import agency.blackhammer.test.data.Pair;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrey Fyodorov
 * Created on 16.03.2021
 */

@Service
public class WordAnalyzerService {

  public static Pair getMostFrequentLetterInWord(@NotNull String word) {
    if (word.length() == 0) {
      throw new IllegalArgumentException("Parameter 'word' cannot be zero length");
	}
    Map<Character, Integer> occurrences = new HashMap<>();
    Pair mostFrequentLetter = new Pair(null, 0);
    char c;

	for (int i = word.length() - 1; i >= 0; --i) {
	  c = word.charAt(i);
      if (!occurrences.containsKey(c)) {
        int count = StringUtils.countOccurrencesOf(word, Character.toString(c));
        occurrences.put(c, count);
        if (count > mostFrequentLetter.getValue()) {
          mostFrequentLetter.setKey(c);
          mostFrequentLetter.setValue(count);
		}
	  }
	}
    return mostFrequentLetter;
  }
}
