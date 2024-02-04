package org.example;

public interface Game {
    //Интерфейс взаимодействий Game (должны быть описаны сигнатуры методов start, inputValue,getGameStatus)
    void start(Integer wordSize, Integer tryCount, Integer language);
    Answer inputValue(String value);
    GameStatus getGameStatus();
}
