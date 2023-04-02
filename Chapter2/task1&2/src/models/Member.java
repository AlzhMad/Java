package models;

public class Member {
    private Long id;
    private String name;
    private String surname;
    private String species;
    private String occupation;

    public Member() {
    }

    public Member(Long id, String name, String surname, String species, String occupation) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.species = species;
        this.occupation = occupation;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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
}
