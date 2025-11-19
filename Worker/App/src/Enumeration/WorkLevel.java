package Enumeration;

public enum WorkLevel {

    JUNIOR(1),
    MID_LEVEL(2),
    SENIOR(2);

    private final int level;

    WorkLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}

