package org.example;

import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    abstract List<String> generateCharList(int language);

    private String word;
    Integer tryCount;
    GameStatus gameStatus = GameStatus.INIT;

    @Override
    public void start(Integer wordSize, Integer tryCount, Integer language) {
        word = generateWord(wordSize, language);
        this.tryCount = tryCount;
        gameStatus = GameStatus.START;
        Logging.writeToLogFile("Статус изменен на Start ", "log.txt");
    }

    private String generateWord(Integer wordSize, int language) {
        List<String> alphabet = generateCharList(language);
        Random rnd = new Random();
        String result = "";
        for (int i = 0; i < wordSize; i++) {
            int randomIndex = rnd.nextInt(alphabet.size());
            result += alphabet.get(randomIndex);
            alphabet.remove(randomIndex);
        }
        Logging.writeToLogFile("Сгененрировано слово ", "log.txt");
        return result;
    }

    @Override
    public Answer inputValue(String value) {
        if (!getGameStatus().equals(GameStatus.START)) {
            throw new RuntimeException("Игра не запущена");
        }
        int cowCounter = 0;
        int bullCounter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (value.charAt(i) == word.charAt(i)) {
                cowCounter++;
                bullCounter++;
            } else if (word.contains(String.valueOf(value.charAt(i)))) {
                cowCounter++;
            }
        }
        tryCount--;
        Logging.writeToLogFile("Проверено загаданное слово ", "log.txt");
        if (tryCount == 0){
            gameStatus = GameStatus.LOOSE;
            Logging.writeToLogFile("Статус изменен на LOOSE ", "log.txt");
        }
        if (bullCounter == word.length()){
            gameStatus = GameStatus.WIN;
            Logging.writeToLogFile("Статус изменен на WIN ", "log.txt");
        }

        return new Answer(cowCounter, bullCounter, tryCount);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus){
        this.gameStatus = gameStatus;
        Logging.writeToLogFile("Статус изменен на LOOSE ", "log.txt");
    }
}
