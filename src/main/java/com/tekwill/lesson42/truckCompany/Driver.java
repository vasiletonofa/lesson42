package com.tekwill.lesson42.truckCompany;

public class Driver {

    long id;

    String firstName;
    String lastName;

    int experience;

    public Driver() {

    }

    public Driver(String firstName, String lastName, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }

    public Driver(long id, String firstName, String lastName, int experience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", experience=" + experience +
                '}';
    }
}
