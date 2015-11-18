package com.mygdx.pause;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class TriForceG_pause extends Game {
	Stage stage;
	ImageButton imgButton;
	ImageButton.ImageButtonStyle imgButtonStyle;
	TextureAtlas atlasTest;
	Skin skin;


	@Override
	public void create () {
		atlasTest = new TextureAtlas("Pause2.pack");
		skin = new Skin(atlasTest);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		imgButtonStyle = new ImageButton.ImageButtonStyle();
		imgButtonStyle.up = skin.getDrawable("Pause2on");
		// imgbuttonstyle.over exists, it changes based on when you hover over the button
		imgButtonStyle.down = skin.getDrawable("Pause2off");

		imgButton = new ImageButton(imgButtonStyle);
		imgButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("test");
			}
		});

		stage.addActor(imgButton);
		//stage.addActor(img);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
}