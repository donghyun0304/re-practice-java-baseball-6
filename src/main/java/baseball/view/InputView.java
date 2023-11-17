package baseball.view;

import baseball.validation.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> inputNumbers(){
        return getInput(() -> {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine().trim();
            NumberValidator.validate(input);
            return Arrays.stream(input.split(""))
                    .map(number -> Integer.parseInt(number))
                    .collect(Collectors.toList());
        });
    }

    private <T> T getInput(Supplier<T> inputSupplier){
        while(true){
            try{
                return inputSupplier.get();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
