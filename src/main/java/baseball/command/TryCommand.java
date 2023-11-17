package baseball.command;

import java.util.Arrays;

public enum TryCommand {
    NEW_GAME(1),
    END(2);

    private int tryNumber;

    TryCommand(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public static TryCommand findCommand(int tryNumber){
        return Arrays.stream(TryCommand.values())
                .filter(tryCommand -> tryCommand.getTryNumber() == tryNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 1 또는 2를 입력 해 주세요."));
    }
}
