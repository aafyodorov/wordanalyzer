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
      throw new IllegalArgumentException("Word is too short.");
	}
    Map<Character, Integer> occurrences = new HashMap<>();
    Pair mostFrequentLetter = new Pair(null, 0);
	word.chars().forEach((c) -> {
      if (!occurrences.containsKey((char) c)) {
        int count = StringUtils.countOccurrencesOf(word, Character.toString(c));
        occurrences.put((char) c, count);
        if (count >= mostFrequentLetter.getValue()) {
          mostFrequentLetter.setKey((char) c);
          mostFrequentLetter.setValue(count);
		}
	  }
	});
    return mostFrequentLetter;
  }
}
