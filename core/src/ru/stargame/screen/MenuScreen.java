package ru.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.stargame.base.BaseScreen;
import ru.stargame.math.Rect;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture textureLogo;
    private Background background;
    private Logo logo;


    @Override
    public void show() {
        super.show();
        bg = new Texture("galaxy.jpg");
        textureLogo = new Texture("badlogic.jpg");
        background = new Background(new TextureRegion(bg));
        logo = new Logo(new TextureRegion(textureLogo));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }
    private void update(float delta) {
        logo.update(delta);
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }


    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        textureLogo.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        logo.touchDown(touch, pointer);
        return false;
    }



}
