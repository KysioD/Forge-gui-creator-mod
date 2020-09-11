package fr.kysio.forgeguicreator.guis.controlers.guiRect;

import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;

import java.awt.*;

public class GuiRect extends GuiControler {

    public Color backgroundColor;

    public GuiRect(GuiFile guiFile, GuiControlers type, int x, int y, int width, int height, Color backgroundColor){
        super(guiFile, type, x, y, width, height);
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }
}
