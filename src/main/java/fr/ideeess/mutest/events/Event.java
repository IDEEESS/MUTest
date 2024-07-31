package fr.ideeess.mutest.events;

public class Event {
    private String name;
    private int x;
    private int y;
    private int z;
    private float pitch;
    private float yaw;

    public Event(String name, int x, int y, int z, float pitch, float yaw) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }
}
