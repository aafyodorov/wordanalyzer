package agency.blackhammer.test.service;

import agency.blackhammer.test.data.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordAnalyzerServiceTest {

  @Test
  public void getMostFrequentLetterInWord_taskTestCase1() {
    Pair pair = WordAnalyzerService.getMostFrequentLetterInWord("test");
    assertEquals('t', pair.getKey());
    assertEquals(2, pair.getValue());
  }

  @Test
  public void getMostFrequentLetterInWord_taskTestCase2() {
    Pair pair = WordAnalyzerService.getMostFrequentLetterInWord("tester");
    assertEquals('e', pair.getKey());
    assertEquals(2, pair.getValue());
  }

  @Test
  public void getMostFrequentLetterInWord() {
    Pair pair = WordAnalyzerService.getMostFrequentLetterInWord("trester");
    assertEquals('r', pair.getKey());
    assertEquals(2, pair.getValue());
  }

  @Test
  public void getMostFrequentLetterInWord_zeroLengthWord_IllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> WordAnalyzerService.getMostFrequentLetterInWord(""));
  }
}
