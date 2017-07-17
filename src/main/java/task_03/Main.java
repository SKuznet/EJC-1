package task_03;

public class Main {
    public static void main(String[] args) {
        Board b = new Board(10);
//
//        Ship s1 = new Ship(3, true);
//        Ship s2 = new Ship(2, false);
//
//        try {
//            b.placeShip(s1, 0, 1);
//            b.placeShip(s2, 5, 5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            State r1 = b.fire(0, 0);
//            System.out.println(r1);
//            State r2 = b.fire(0, 1);
//            System.out.println(r2);
//            State r3 = b.fire(0, 2);
//            System.out.println(r3);
//            State r4 = b.fire(0, 3);
//            System.out.println(r4);
//
//            State r5 = b.fire(5, 5);
//            System.out.println(r5);
//            State r6 = b.fire(6, 5);
//            System.out.println(r6);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        b.initialize();
    }
}
