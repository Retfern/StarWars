package ru.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;
    private Texture img;
    private boolean touchTrue;


    @Override
    public void show() {
        super.show();
        touch = new Vector2();
        pos = new Vector2(10, 10);
        v = new Vector2();
        img = new Texture("badlogic.jpg");
        touchTrue=false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (touchTrue) {
            if (Math.abs(pos.x-touch.x)<1 && Math.abs(pos.y-touch.y)<1) {
                v.setZero();
                touchTrue=false;
                pos.set(touch.x, touch.y);
            }else {
                pos.add(v);
            }
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v=touch.cpy().sub(pos);
        v.nor();
        System.out.println("touchDown touch.x = " + touch.x + " touch.y = " + touch.y);
        System.out.println("touchDown v.x = " + v.x + " v.y = " + v.y);
        touchTrue=true;
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        if (keycode==19) {
            v.set(0, 3);
            pos.add(v);
        } else if (keycode==20) {
            v.set(0, -3);
            pos.add(v);
        }else if (keycode==21) {
            v.set(-3, 0);
            pos.add(v);
        }else if (keycode==22) {
            v.set(3, 0);
            pos.add(v);
        }
        return false;
    }

}
