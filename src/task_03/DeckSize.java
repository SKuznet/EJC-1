package task_03;

public enum DeckSize {
    ONE_DECK(1), TWO_DECKS(2), THREE_DECKS(3), FOUR_DECKS(4);

    public int value;

    DeckSize(int value) {
        this.value = value;
    }
}
