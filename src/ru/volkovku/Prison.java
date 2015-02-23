package ru.volkovku;

import java.util.ArrayList;
import java.util.Random;

public class Prison {
    private final Random _rnd = new Random(System.nanoTime());
    private final ArrayList<Prisoner> _prisoners;
    private final Room _room;

    public Prison(int prisonersCount, boolean isLightOn) {
        _room = new Room(isLightOn);

        _prisoners = new ArrayList<>(prisonersCount);
        _prisoners.add(Prisoner.chosen(prisonersCount));
        for (int i = 1; i < prisonersCount; i++) {
            _prisoners.add(Prisoner.figurant());
        }
    }

    public boolean playGame() {
        while (true) {
            Prisoner prisoner = getRandomPrisoner();
            prisoner.visit(_room);
            if (prisoner.isAllPrisonersVisitRoom()) {
                return isAllPrisonersVisitRoom();
            }
        }
    }

    private Prisoner getRandomPrisoner() {
        int index = _rnd.nextInt(_prisoners.size());
        return _prisoners.get(index);
    }

    private boolean isAllPrisonersVisitRoom() {
        return _prisoners.stream().allMatch(Prisoner::isVisitRoom);
    }
}
