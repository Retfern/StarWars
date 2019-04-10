package ru.stargame;

import com.badlogic.gdx.Game;

import ru.stargame.screen.MenuScreen;

public class StarWars extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}

}
