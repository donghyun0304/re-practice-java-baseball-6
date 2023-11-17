package baseball.domain;

import java.util.Collections;
import java.util.Map;

public class BaseballResult {

    private Map<String, Integer> result;

    public BaseballResult(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
