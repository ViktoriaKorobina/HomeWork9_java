package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AbstractGame ag = new GameNumber();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите код языка:\n0 - цифры, 1 - русский, 2 - английский");
        int language = scanner.nextInt();
        ag.start(5,3, language);
        if(language == 0){
            System.out.println("Введи значение слова цифрами (5 знаков):");
        } else if(language == 1){
            System.out.println("Введи значение на русском языке (5 знаков):");
        } else if(language == 2) {
            System.out.println("Введи значение на английском языке (5 знаков):");
        }
        while (ag.getGameStatus().equals(GameStatus.START)){
            String word = scanner.next();
            Logging.writeToLogFile("Пользователь ввел слово " + word + " ", "log.txt");
            if(word.length() != 5){
                ag.setGameStatus(GameStatus.LOOSE);
                System.out.println("Вы ввели неверное слово");
                break;
            }
            Answer answer = ag.inputValue(word);
            System.out.println(answer);
        }

        if (ag.getGameStatus().equals(GameStatus.WIN)){
            System.out.println("Вы победили");
        } else if (ag.getGameStatus().equals(GameStatus.LOOSE)){
            System.out.println("Вы проиграли");
        }
        else {
            System.out.println("Неопознанный статус");
        }
        System.out.println("Желаете ли Вы просмотреть лог-файл?\n1 - да, 2 - нет");
        if(scanner.nextInt() == 1){
            try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Игра окончена");
        }
    }
}