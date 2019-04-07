package ru.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



import java.awt.LayoutManager;

public class StarWars extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	static Sprite backgroundSprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		background = new Texture(Gdx.files.internal("galaxy.jpg"));
		backgroundSprite = new Sprite(background); // установка текстуры в спрайт
// настройка размеров и позиции спрайта заднего фона
		//backgroundSprite.setSize(0, 0);
		backgroundSprite.setPosition(0,0f);

	}

	@Override
	public void render () {


		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		backgroundSprite.draw(batch);
		//batch.draw(background, 0, 0);
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		background.dispose();
	}
}
