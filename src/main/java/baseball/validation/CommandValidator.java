package baseball.validation;

public class CommandValidator {

    public static void validate(String input){
        if(isNot1Or2(input)){
            throw new IllegalArgumentException("[ERROR] 1또는2를 입력 해 주세요.");
        }
    }

    public static boolean isNot1Or2(String input){
        if(input.matches("[12]")){
            return false;
        }
        return true;
    }
}
