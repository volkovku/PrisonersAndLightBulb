package ru.volkovku;

public class Room {
    private boolean _isLightOn;

    public Room(boolean isLightOn) {
        _isLightOn = isLightOn;
    }

    public boolean isLightOn() {
        return _isLightOn;
    }

    public boolean isLightOff() {
        return !isLightOn();
    }

    public void switchLight() {
        _isLightOn = !_isLightOn;
    }
}
