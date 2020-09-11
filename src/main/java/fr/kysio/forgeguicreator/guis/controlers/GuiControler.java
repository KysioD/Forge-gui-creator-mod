package fr.kysio.forgeguicreator.guis.controlers;

import fr.kysio.forgeguicreator.guis.GuiFile;

public abstract class GuiControler {

    public GuiFile guiFile;

    public int x;
    public int y;
    public int width;
    public int height;
    public GuiControlers type;

    public GuiControler(GuiFile guiFile, GuiControlers type, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public abstract void enable();

    public  abstract void disable();

}
