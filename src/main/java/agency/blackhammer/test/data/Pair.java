package agency.blackhammer.test.data;

/**
 * @author Andrey Fyodorov
 * Created on 17.03.2021
 */

public class Pair {

  private Character key;
  private Integer value;

  public Pair(Character key, Integer value) {
	this.key = key;
	this.value = value;
  }

  public Character getKey() {
	return key;
  }

  public void setKey(Character key) {
	this.key = key;
  }

  public Integer getValue() {
	return value;
  }

  public void setValue(Integer value) {
	this.value = value;
  }
}
