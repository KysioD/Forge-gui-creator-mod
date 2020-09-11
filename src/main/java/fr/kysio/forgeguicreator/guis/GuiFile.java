package fr.kysio.forgeguicreator.guis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

import java.util.ArrayList;

public class GuiFile {

    private String name;
    private ArrayList<GuiControler> guiControlers;

    public GuiFile(String name, ArrayList<GuiControler> controlers){
        this.name = name;
        this.guiControlers = controlers;
    }

    public String getName() {
        return name;
    }

    public ArrayList<GuiControler> getGuiControlers() {
        return guiControlers;
    }

    public Gson createGsonInstance(){
        return new GsonBuilder()
                .registerTypeAdapter(GuiFile.class, new GuiFileTypeAdapter())
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

}
