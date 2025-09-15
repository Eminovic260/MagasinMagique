package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void testItem() {
        Item[] items = new Item[]{new Item("Objet", 10, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("Objet", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }


    @Test
    void testComté() {
        Item[] items = new Item[]{new Item("Comté", 10, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("Comté", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void testPassVIP() {
        Item[] items = new Item[]{new Item("Pass VIP Concert", 1, 49)};
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testKrypto() {
        Item[] items = new Item[]{new Item("Kryptonite", 0, 80)};
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("Kryptonite", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

}

