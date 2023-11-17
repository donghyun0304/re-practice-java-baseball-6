package baseball.utils;

import baseball.constant.BaseballConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.BaseballConstant.*;

public class BaseballNumberGenerator {

    public static List<Integer> createNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() != BASEBALL_LIST_MAX_NUMBER){
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
