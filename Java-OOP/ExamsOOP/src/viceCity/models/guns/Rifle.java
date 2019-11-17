package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        int numberOfShotBullets = 0;
        int bulletsPerBarrel = this.getBulletsPerBarrel();
        int totalBullets = this.getTotalBullets();
        if(bulletsPerBarrel>5){
            numberOfShotBullets+=5;
        }
        if(totalBullets>5){
            this.setTotalBullets(totalBullets - 5);
        }else {
            this.setBulletsPerBarrel(bulletsPerBarrel - 5);
        }

        return numberOfShotBullets;
    }
}
