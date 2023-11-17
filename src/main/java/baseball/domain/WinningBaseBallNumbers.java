package baseball.domain;

import baseball.constant.BaseballConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.BaseballConstant.*;

public class WinningBaseBallNumbers {

    private final List<Integer> numbers;

    public WinningBaseBallNumbers(List<Integer> numbers) {
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
