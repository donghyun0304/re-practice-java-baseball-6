package baseball.view;

import baseball.command.TryCommand;
import baseball.validation.CommandValidator;
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

    public TryCommand inputTryCommand(){
        return getInput(() -> {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine().trim();
            CommandValidator.validate(input);
            return TryCommand.findCommand(Integer.parseInt(input));
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
