package task_06;

public class OnlineShop {
    private static int sausageStock = 100;

    public static void main(String[] args) {
        buyMultipleSuasages(5);
    }

    /**
     * Creates specified number of threads to make deals
     *
     * @param numberOfDeals - number of threads to initiate
     */
    private static void buyMultipleSuasages(int numberOfDeals) {
        for (int i = 0; i < numberOfDeals; i++) {
            new Thread(() -> buySausages(25)).start();
        }
    }

    /**
     * Removes specified number of sausages from stock
     *
     * @param numberOfSausagesToBuy - sausages to buy
     */
    private synchronized static void buySausages(int numberOfSausagesToBuy) {
        if (numberOfSausagesToBuy <= sausageStock) {
            sausageStock -= numberOfSausagesToBuy;
            System.err.println("Sausages left: " + sausageStock);
        } else {
            System.err.println("There is no sausages left");
            System.err.println("Remember, gluttony is a sin");
        }
    }
}
