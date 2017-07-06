package task_03;

import java.util.ArrayList;

public class Ship {
    private DeckSize deckSize;
    private ArrayList<Square> decks = new ArrayList<>();

    public Ship(DeckSize deckSize) {
        this.deckSize = deckSize;
    }

    public DeckSize getDeckSize() {
        return deckSize;
    }

    public void addDeck(Square deck) {
        this.decks.add(deck);
    }
}
