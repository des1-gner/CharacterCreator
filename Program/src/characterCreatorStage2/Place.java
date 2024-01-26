package characterCreatorStage2;

// Instance Variables

public class Place extends Character {

    protected Integer placeId;

    private String Location;

    private String Size;

    private String Biome;

    static Integer nextID = 0;

    public Place() {
    }

    // Constructor and elimination of confusion of objects with same class
    // attributes and parameters names

    public Place(String Location, String Size, String Biome) {
        this.Location = Location;
        this.Size = Size;
        this.Biome = Biome;
        placeId = nextID++;
    }

    // Getters

    public Integer getplaceId() {
        return placeId;
    }

    public String getLocation() {
        return Location;
    }

    public String getSize() {
        return Size;
    }

    public String getBiome() {
        return Biome;
    }

    // Setters

    public Integer setplaceId() {
        return placeId;
    }

    public String setLocation() {
        return Location;
    }

    public String setSize() {
        return Size;
    }

    public String setBiome() {
        return Biome;
    }

    // toString Place Output

    public String toString() {
        return "\nCharacters are in " + Location + ", which is a " + Size + " sized " + Biome + ". PlaceId: " + placeId;
    }
}