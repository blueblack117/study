package thread.notifyAll;

public class CakeMaker extends Thread {
    private CakePlate cake;

    public CakeMaker(CakePlate cake) {
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
            cake.makeBread();
        }
    }
}
