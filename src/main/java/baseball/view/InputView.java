package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> inputNumbers(){
        return getInput(() -> {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine().trim();
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
