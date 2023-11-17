package baseball.validation;

import baseball.constant.BaseballConstant;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.BaseballConstant.*;

public class NumberValidator {

    public void validate(String input){
        if(isNotThreeNumbers(input) || isNotNonDuplicateNumbers(input)){
            throw new IllegalArgumentException("[ERROR] 서로다른 세자리의 숫자를 입력 해 주세요.");
        }
    }

    private boolean isNotThreeNumbers(String input){
        if(!input.matches("[1-9]{3}")){
            return true;
        }
        return false;
    }

    private boolean isNotNonDuplicateNumbers(String input){
        Set<String> nonDuplicateNumbers = Arrays.stream(input.split(""))
                .collect(Collectors.toSet());
        if(nonDuplicateNumbers.size() != BASEBALL_LIST_MAX_NUMBER){
            return true;
        }
        return false;
    }
}
