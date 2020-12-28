package Cargos;

import Persons.Person;

import java.util.ArrayList;

public class Peoples extends Cargo {
    private ArrayList<Person> persons;

    public Peoples(){
        this.persons = new ArrayList<>();
    }

    public Peoples(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    protected int getNumberOfPeoples(){
        return getPersons().size();
    }

    @Override
    public double getNecessaryInformation() {
        return getNumberOfPeoples();
    }
}
