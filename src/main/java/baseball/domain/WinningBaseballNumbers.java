package baseball.domain;

import baseball.constant.BaseballConstant;

import java.util.*;

import static baseball.constant.BaseballConstant.*;

public class WinningBaseballNumbers {

    private final List<Integer> numbers;

    public WinningBaseballNumbers(List<Integer> numbers) {
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicateNumbers(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(numbers.size() != BASEBALL_LIST_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 서로 다른 세개의 숫자가 아닙니다.");
        }
    }

    public BaseballResult calcResult(BaseballNumbers baseballNumbers) {
        List<Integer> tryNumbers = baseballNumbers.getNumbers();
        Map<String, Integer> result = new HashMap<>();

        calculateStrikes(result, tryNumbers);
        calculateBalls(result, tryNumbers);
        if (result.isEmpty()) {
            initializeEmptyResult(result);
        }
        return new BaseballResult(result);
    }

    private void calculateStrikes(Map<String, Integer> result, List<Integer> tryNumbers) {
        for (int i = 0; i < BASEBALL_LIST_MAX_NUMBER; i++) {
            if (numbers.get(i).equals(tryNumbers.get(i))) {
                updateResult(result, STRIKE);
            }
        }
    }

    private void calculateBalls(Map<String, Integer> result, List<Integer> tryNumbers) {
        for (int i = 0; i < BASEBALL_LIST_MAX_NUMBER; i++) {
            if (tryNumbers.contains(numbers.get(i)) && !numbers.get(i).equals(tryNumbers.get(i))) {
                updateResult(result, BALL);
            }
        }
    }

    private void updateResult(Map<String, Integer> result, String key) {
        result.put(key, result.getOrDefault(key, 0) + 1);
    }

    private void initializeEmptyResult(Map<String, Integer> result) {
        result.put(NOTHING, 1);
    }
}
