package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VoitureTest {

    @Test
    void creerVoiture() {
        Voiture spy = spy(new Voiture("Toyota", 15000));

        assertEquals("Toyota", spy.getMarque());
        assertEquals(15000, spy.getPrix());

        verify(spy, times(1)).getMarque();
        verify(spy, times(1)).getPrix();
    }

    @Test
    void modifierMarque() {
        Voiture spy = spy(new Voiture("Toyota", 15000));
        spy.setMarque("Renault");

        assertEquals("Renault", spy.getMarque());

        verify(spy, times(1)).setMarque("Renault");
        verify(spy, times(1)).getMarque();
    }

    @Test
    void modifierPrix() {
        Voiture spy = spy(new Voiture("Toyota", 15000));
        spy.setPrix(20000);

        assertEquals(20000, spy.getPrix());

        verify(spy, times(1)).setPrix(20000);
        verify(spy, times(1)).getPrix();
    }

    @Test
    void modifierId() {
        Voiture spy = spy(new Voiture("Toyota", 15000));
        spy.setId(5);

        assertEquals(5, spy.getId());

        verify(spy, times(1)).setId(5);
        verify(spy, times(1)).getId();
    }

    @Test
    void verifierToString() {
        Voiture spy = spy(new Voiture("Toyota", 15000));
        spy.setId(1);

        assertEquals("Car{marque='Toyota', prix=15000, id=1}", spy.toString());

        verify(spy, atLeastOnce()).toString();
    }
}
