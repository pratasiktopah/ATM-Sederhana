package com.juaracoding.atmproject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class ATMTest {
    private ATM atm;

    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000);

    }

    @Test
    public void testLihatSaldo() {
        assertEquals(atm.lihatSaldo(), 1000);
    }

    @Test
    public void testTarikTunai() {
        atm.tarikUang(500);
        assertEquals(atm.lihatSaldo(), 500);
    }

    @Test
    public void testTarikTunaiInvalid() {
        assertThrows(IllegalArgumentException.class, () -> atm.tarikUang(1500));
    }

    @Test
    public void testSimpanUang() {
        atm.setorUang(200);
        assertEquals(atm.lihatSaldo(), 1200);
    }

    @Test
    public void testTarikTunaiNegatif() {
        assertThrows(IllegalArgumentException.class, () -> atm.tarikUang(-100));
    }

    @Test
    public void testSimpanUangNegatif() {
        assertThrows(IllegalArgumentException.class, () -> atm.setorUang(-200));
    }

}
