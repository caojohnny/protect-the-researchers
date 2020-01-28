package io.github.agenttroll.ptr.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SplitScene {
    private final Stage left;
    private final Stage right;

    public SplitScene() {
        float windowWidth = Gdx.graphics.getWidth();
        int windowHeight = Gdx.graphics.getHeight();

        float halfWidth = windowWidth / 2;
        this.left = new Stage(new FitViewport(halfWidth, windowHeight));
        this.right = new Stage(new FitViewport(halfWidth, windowHeight));
    }

    public void resize(int width, int height) {
        int halfWidth = width / 2;

        Viewport leftViewport = this.left.getViewport();
        leftViewport.update(halfWidth, height, true);

        Viewport rightViewport = this.right.getViewport();
        rightViewport.update(halfWidth, height, true);
        rightViewport.setScreenX(halfWidth);
    }

    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        this.left.getViewport().apply();
        this.left.act(deltaTime);
        this.left.draw();

        this.right.getViewport().apply();
        this.right.act(deltaTime);
        this.right.draw();
    }

    public void dispose() {
        this.left.dispose();
        this.right.dispose();
    }

    public Stage getLeft() {
        return this.left;
    }

    public Stage getRight() {
        return this.right;
    }
}