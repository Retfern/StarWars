package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.utils.Regions;

public class EnemyShip extends Sprite {

    private BulletPool bulletPool;
    private TextureRegion shipRegion;
    private TextureRegion bulletRegion;
    private Rect worldBounds;
    private float reloadInterval = 0.2f;
    private float reloadTimer;
    private Vector2 v = new Vector2(0f, -0.2f);
    private Vector2 bulletV = new Vector2(0f, -0.5f);
    private TextureAtlas atlas = new TextureAtlas("textures/mainAtlas.tpack");

    public EnemyShip() {
        regions = new TextureRegion[1];
        shipRegion = atlas.findRegion("enemy2");
        this.regions= Regions.split(shipRegion, 1, 2, 2);
    }

    public void setEnemyShip(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.bulletRegion = atlas.findRegion("bulletEnemy");
        this.worldBounds = worldBounds;
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        this.pos.set(posX, worldBounds.getTop());
        setHeightProportion(0.15f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
    }

    public EnemyShip(TextureRegion region) {
        super(region);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }

    }

    public void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, 0.015f, worldBounds, 1);
    }

    private void stop() {
        v.setZero();
    }

}
