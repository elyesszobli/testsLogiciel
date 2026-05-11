package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatistiqueTests {

    private StatistiqueImpl statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void prixMoyenAvecUneVoiture() throws ArithmeticException {
        Voiture mockVoiture = mock(Voiture.class);
        when(mockVoiture.getPrix()).thenReturn(15000);

        statistique.ajouter(mockVoiture);
        Echantillon e = statistique.prixMoyen();

        assertEquals(15000, e.getPrixMoyen());
        assertEquals(1, e.getNombreDeVoitures());
        verify(mockVoiture, times(1)).getPrix();
    }

    @Test
    void prixMoyenAvecPlusieursVoitures() throws ArithmeticException {
        Voiture mock1 = mock(Voiture.class);
        Voiture mock2 = mock(Voiture.class);
        Voiture mock3 = mock(Voiture.class);
        when(mock1.getPrix()).thenReturn(10000);
        when(mock2.getPrix()).thenReturn(20000);
        when(mock3.getPrix()).thenReturn(30000);

        statistique.ajouter(mock1);
        statistique.ajouter(mock2);
        statistique.ajouter(mock3);
        Echantillon e = statistique.prixMoyen();

        assertEquals(20000, e.getPrixMoyen());
        assertEquals(3, e.getNombreDeVoitures());
        verify(mock1, times(1)).getPrix();
        verify(mock2, times(1)).getPrix();
        verify(mock3, times(1)).getPrix();
    }

    @Test
    void prixMoyenSansVoitureLanceException() {
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }

    @Test
    void nombreDeVoituresCorrect() throws ArithmeticException {
        Voiture mock1 = mock(Voiture.class);
        Voiture mock2 = mock(Voiture.class);
        when(mock1.getPrix()).thenReturn(50000);
        when(mock2.getPrix()).thenReturn(60000);

        statistique.ajouter(mock1);
        statistique.ajouter(mock2);
        Echantillon e = statistique.prixMoyen();

        assertEquals(2, e.getNombreDeVoitures());
    }

    @Test
    void prixMoyenArrondiInferieur() throws ArithmeticException {
        Voiture mock1 = mock(Voiture.class);
        Voiture mock2 = mock(Voiture.class);
        when(mock1.getPrix()).thenReturn(10000);
        when(mock2.getPrix()).thenReturn(11000);

        statistique.ajouter(mock1);
        statistique.ajouter(mock2);
        Echantillon e = statistique.prixMoyen();

        assertEquals(10500, e.getPrixMoyen());
    }
}
