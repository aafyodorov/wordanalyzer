package agency.blackhammer.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WordAnalyzerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void analyze_checkJSONFields() throws Exception {
	mockMvc.perform(get("/wordanalyzer/analyze?word=test"))
		.andExpect(status().isOk())
		.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
		.andExpect(content().string(containsString("\"count\"")))
		.andExpect(content().string(containsString("\"letter\"")));
  }

  @Test
  public void analyze_withoutWordParameter_missingServletRequestParameterException() throws Exception {
    mockMvc.perform(get("/wordanalyzer/analyze"))
		.andExpect(status().is(400))
		.andExpect(content().string(containsString("message")));
  }

  @Test
  public void analyze_withoutWordParameter_IllegalArgumentException() throws Exception {
	mockMvc.perform(get("/wordanalyzer/analyze?message="))
		.andExpect(status().is(400))
		.andExpect(content().string(containsString("message")));
  }
}