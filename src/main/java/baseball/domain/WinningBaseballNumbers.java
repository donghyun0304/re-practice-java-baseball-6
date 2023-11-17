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

    public BaseballResult calcResult(BaseballNumbers baseballNumbers){
        List<Integer> tryNumbers = baseballNumbers.getNumbers();
        Map<String, Integer> result = new HashMap<>();
        for(int i=0; i< BASEBALL_LIST_MAX_NUMBER; i++){
            for(int j=0; j<BASEBALL_LIST_MAX_NUMBER; j++){

                if(numbers.get(i) == tryNumbers.get(i)){
                    result.put(STRIKE, result.getOrDefault(STRIKE, 0) + 1);
                    break;
                }
                if(numbers.contains(tryNumbers.get(j)) && numbers.get(i) != tryNumbers.get(i)){
                    result.put(BALL, result.getOrDefault(BALL, 0) + 1);
                    break;
                }
            }
        }
        if(result.isEmpty()){
            result.put(NOTHING, 1);
        }
        return new BaseballResult(result);
    }
}
