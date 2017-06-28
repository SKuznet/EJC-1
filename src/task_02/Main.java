package task_02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Game duckRace = new Game(500, 100);
        duckRace.play();
    }
}
