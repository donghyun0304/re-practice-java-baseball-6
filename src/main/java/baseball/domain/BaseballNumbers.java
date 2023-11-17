package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.BaseballConstant.BASEBALL_LIST_MAX_NUMBER;

public class BaseballNumbers {

    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicateNumbers(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(numbers.size() != BASEBALL_LIST_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 서로 다른 세개의 숫자가 아닙니다.");
        }
    }


}
