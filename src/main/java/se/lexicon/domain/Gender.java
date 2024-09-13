package se.lexicon.domain;

public enum Gender {

    MALE,FEMALE;

    public String toString(){
        return this.name().toLowerCase();
    }
}
