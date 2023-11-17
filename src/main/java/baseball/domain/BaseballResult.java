package baseball.domain;

import baseball.constant.BaseballConstant;

import java.util.Collections;
import java.util.Map;

public class BaseballResult {

    private static final int STRIKE_NUMBER_FOR_END = 3;
    private Map<String, Integer> result;

    public BaseballResult(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public boolean isPossibleEnd(){
        if(getStrike() == STRIKE_NUMBER_FOR_END){
            return true;
        }
        return false;
    }

    private int getStrike(){
        return result.getOrDefault(BaseballConstant.STRIKE, 0);
    }
}
