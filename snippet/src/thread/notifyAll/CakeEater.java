package thread.notifyAll;

public class CakeEater extends Thread {
    private CakePlate cake;

    public CakeEater(CakePlate cake) {
        setCakePlate(cake);
    }

    public CakePlate getCakePlate() {
        return cake;
    }

    public void setCakePlate(CakePlate cake) {
        this.cake = cake;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            cake.eatBread();
        }
    }
}
