package agency.blackhammer.test.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Andrey Fyodorov
 * Created on 17.03.2021
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"letter",
	"count"})
public class Pair {

  @JsonProperty("letter")
  private Character key;

  @JsonProperty("count")
  private Integer value;

  public Pair(Character key, Integer value) {
	this.key = key;
	this.value = value;
  }

  public Character getKey() {
	return key;
  }

  @JsonProperty("letter")
  public void setKey(Character key) {
	this.key = key;
  }

  public Integer getValue() {
	return value;
  }

  @JsonProperty("count")
  public void setValue(Integer value) {
	this.value = value;
  }
}
