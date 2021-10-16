package Track;

public class Track {
    private String name;
    private String location;
    private int difficulty; // int between 1 & 10
    private int corners;    // int
    private int drsZones;   // int

    public Track(String name, String l, int difficulty, int corners, int drsZones) {
        this.name = name;
        this.location = l;
        this.difficulty = difficulty;
        this.corners = corners;
        this.drsZones = drsZones;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public int getDrsZones() {
        return drsZones;
    }

    public void setDrsZones(int drsZones) {
        this.drsZones = drsZones;
    }
}
