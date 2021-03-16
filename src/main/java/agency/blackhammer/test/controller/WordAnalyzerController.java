package agency.blackhammer.test.controller;

import agency.blackhammer.test.data.Pair;
import agency.blackhammer.test.service.WordAnalyzerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Andrey Fyodorov
 * Created on 16.03.2021
 */

@Controller
@RequestMapping("/wordanalyzer")
public class WordAnalyzerController {

  @GetMapping("/analyze")
  public ResponseEntity<Pair> analyze(@RequestParam(name = "word") String word) {
      Pair mostFrequentLetter = WordAnalyzerService.getMostFrequentLetterInWord(word);

      return ResponseEntity
          .ok(mostFrequentLetter);
  }

  @ExceptionHandler({IllegalArgumentException.class, MissingServletRequestParameterException.class})
  public ResponseEntity<String> wordAnalyzerControllerExceptionHandler(Exception ex) throws JSONException {
    JSONObject body = new JSONObject();

    body.put("message",  ex.getMessage());
    return ResponseEntity
        .status(400)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(body.toString());
  }
}
