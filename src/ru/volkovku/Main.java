package ru.volkovku;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            for (int l = 0; l <= 1; l++) {
                Prison prison = new Prison(i, l == 1);
                if (!prison.playGame()) {
                    System.out.println("Prisoners are loses!!!");
                    return;
                }
            }
        }
        System.out.println("Prisoners are win in all games!!!");
    }
}
