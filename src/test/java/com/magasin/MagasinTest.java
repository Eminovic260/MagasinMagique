package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {


    @Test
    void testProduit() {
        Item[] items = new Item[]{
            new Item("Pass VIP Concert", 14, 21),
            new Item("Pass VIP Concert", 10, 49),
            new Item("Pass VIP Concert", 5, 49),
            new Item("Comté", 10, 30),
            new Item("Comté", 0, 50),
            new Item("Objet", 5, 10),
            new Item("Objet", -1, 10),
            new Item("Objet", -1, 1),
            new Item("Kryptonite", 0, 80),
            new Item("Kryptonite", -1, 81),
            new Item("Objet légendaire", 0, 80)

        };

        Magasin app = new Magasin(items);

        for (int jour = 0; jour <= 15; jour++) {
            System.out.println("Jour " + jour);
            for (Item item : items) {
                System.out.printf("Nom: %-18s | SellIn: %3d | Qualité: %2d%n",
                    item.name, item.sellIn, item.quality);
            }
            System.out.println();
            app.updateQuality();
        }
    }

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

