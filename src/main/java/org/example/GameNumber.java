package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameNumber extends AbstractGame {
    @Override
    List<String> generateCharList(int language) {
        List<String> list;
        if(language == 0) {
            list = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4",
                    "5", "6", "7", "8", "9"));
        } else if(language == 1) {
            list = new ArrayList<>(Arrays.asList("а", "б", "в", "г", "д",
                    "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н",
                    "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ш",
                    "щ", "ъ", "ы", "ь", "э", "ю", "я"));
        } else {
            list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e",
                    "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                    "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        }
        Logging.writeToLogFile("Сгенерирован алфавит ", "log.txt");
        return list;
    }
}
