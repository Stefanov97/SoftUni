package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        int numberOfShotBullets = 0;
        int bulletsPerBarrel = this.getBulletsPerBarrel();
        int totalBullets = this.getTotalBullets();
        if(bulletsPerBarrel>0){
            numberOfShotBullets++;
        }
        if(totalBullets>0){
            this.setTotalBullets(totalBullets - 1);
        }else {
            this.setBulletsPerBarrel(bulletsPerBarrel - 1);
        }

        return numberOfShotBullets;
    }
}
