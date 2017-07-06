package task_03;

public class Main {
    public static void main(String[] args) {
        for (DeckSize size:
             DeckSize.values()) {
            System.out.println(size.value == 1);
        }
    }
}
