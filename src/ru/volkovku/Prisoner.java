package ru.volkovku;

public class Prisoner {
    private final int _prisonersCount;
    private int _visitsCount;
    private int _lampSwitches;

    public static Prisoner figurant() {
        return new Prisoner(0);
    }

    public static Prisoner chosen(int prisonersCount) {
        return new Prisoner(prisonersCount);
    }

    private Prisoner(int prisonersCount) {
        _prisonersCount = prisonersCount;
    }

    public boolean isChosen() {
        return _prisonersCount > 0;
    }

    public boolean isVisitRoom() {
        return _visitsCount > 0;
    }

    public boolean isAllPrisonersVisitRoom() {
        return (_prisonersCount == 1 && _visitsCount > 0)
            || (isChosen() && (_lampSwitches / 2 == _prisonersCount));
    }

    public void visit(Room room) {
        _visitsCount++;

        if (isChosen()) visitWithChosenStrategy(room);
        else visitWithFigurantStrategy(room);
    }

    private void visitWithChosenStrategy(Room room) {
        if (room.isLightOff()) return;

        room.switchLight();
        _lampSwitches++;
    }

    private void visitWithFigurantStrategy(Room room) {
        if (_visitsCount == 2) return;
        if (room.isLightOn()) return;

        room.switchLight();
        _lampSwitches++;
    }
}
