package baseball.view;

import baseball.constant.BaseballConstant;
import baseball.domain.BaseballResult;

import java.util.Map;
import java.util.Set;

import static baseball.constant.BaseballConstant.*;

public class OutputView {

    public void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(BaseballResult baseballResult){
        Map<String, Integer> result = baseballResult.getResult();

        if(result.containsKey(BALL) && !result.containsKey(STRIKE)){
            System.out.println(result.get(BALL) + "볼");
        }
        if(result.containsKey(BALL) && result.containsKey(STRIKE)){
            System.out.println(result.get(BALL) + "볼 " + result.get(STRIKE) + "스트라이크");
        }
        if(!result.containsKey(BALL) && result.containsKey(STRIKE)){
            System.out.println(result.get(STRIKE) + "스트라이크");
        }
        if(!result.containsKey(BALL) && !result.containsKey(STRIKE)){
            System.out.println("낫싱");
        }
    }
}
