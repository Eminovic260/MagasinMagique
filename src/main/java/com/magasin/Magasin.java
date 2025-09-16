package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            boolean isComte = item.name.equals("Comté");
            boolean isPassVIP = item.name.equals("Pass VIP Concert");
            boolean isKryptonite = item.name.equals("Kryptonite");


            if (!isComte && !isPassVIP) {
                if (item.quality > 0) {
                    if (!isKryptonite) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (isPassVIP) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }



            if (!isKryptonite) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.sellIn < 0) {
                if (!isComte) {
                    if (!isPassVIP) {
                        if (item.quality > 0 && !isKryptonite) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
