package com.example.demo.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {

    @Test
    void creerVoiture() {
        Voiture v = new Voiture("Toyota", 15000);
        assertEquals("Toyota", v.getMarque());
        assertEquals(15000, v.getPrix());
    }

    @Test
    void modifierMarque() {
        Voiture v = new Voiture("Toyota", 15000);
        v.setMarque("Renault");
        assertEquals("Renault", v.getMarque());
    }

    @Test
    void modifierPrix() {
        Voiture v = new Voiture("Toyota", 15000);
        v.setPrix(20000);
        assertEquals(20000, v.getPrix());
    }

    @Test
    void modifierId() {
        Voiture v = new Voiture("Toyota", 15000);
        v.setId(5);
        assertEquals(5, v.getId());
    }

    @Test
    void verifierToString() {
        Voiture v = new Voiture("Toyota", 15000);
        v.setId(1);
        assertEquals("Car{marque='Toyota', prix=15000, id=1}", v.toString());
    }

}
