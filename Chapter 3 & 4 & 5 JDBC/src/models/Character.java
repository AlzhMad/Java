package models;

public class Character {
    private Long id;
    private String name;
    private String surname;
    private String occupation;
    private Species species;

    public Character() {
    }

    public Character(Long id, String name, String surname, String occupation, Species species) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.occupation = occupation;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
