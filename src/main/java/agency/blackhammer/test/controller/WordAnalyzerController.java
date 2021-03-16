package agency.blackhammer.test.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Andrey Fyodorov
 * Created on 16.03.2021
 */

@Controller("/wordanalyzer")
public class WordAnalyzerController {

  @GetMapping("/analyze?{word}")
  public ResponseEntity<JSONPObject> analyze(@PathVariable(name = "word") String word) {
    return null;
  }
}
