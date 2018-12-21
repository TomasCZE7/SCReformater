package cz.hacker;

import java.util.Comparator;

public class SortComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.getMaterialName().compareTo(item2.getMaterialName());
    }

}
