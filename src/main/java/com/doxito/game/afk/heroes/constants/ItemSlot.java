package com.doxito.game.afk.heroes.constants;

public enum ItemSlot {
    HEAD,
    HANDS,
    BODY,
    PANTS,
    FEETS;

    public static ItemSlot findByName(String name) {
        for (ItemSlot itemSlot : ItemSlot.values()) {
            if (itemSlot.name().equalsIgnoreCase(name)) {
                return itemSlot;
            }
        }

        throw new IllegalArgumentException("Item with name " + name + " not found");
    }
}
