package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-05 18:16
 * transformation character type
 */
@Slf4j
public class CharacterType {
    public static void characterType() {
        StringBuilder stringBuilder=new StringBuilder("\n");
        char letter = 'A';
        char numChar = '4';
        stringBuilder.append("'A':").append(letter).append("\n");
        stringBuilder.append("'4':").append(numChar).append("\n");

        // char
        char ch = (char) 0XAB0041;
        stringBuilder.append("(char) 0XAB0041 transformation result:").append(ch).append("\n");
        char ch2 = (char) 65.25;
        stringBuilder.append("(char) 65.25 transformation result:").append(ch2).append("\n");
        int i = (int) 'A';
        stringBuilder.append("(int) 'A' transformation result:").append(i).append("\n");

        i = '2' + 'a';
        stringBuilder.append("'2' + 'a' computed result:").append(i).append("\n");
        i = 2 + 'a';
        stringBuilder.append("2 + 'a' computed result:").append(i).append("\n");
        log.info(stringBuilder.toString());
    }
}