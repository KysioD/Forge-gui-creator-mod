package fr.kysio.forgeguicreator.guis.controlers.guiRect;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlerTypeAdapter;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;

import java.awt.*;
import java.io.IOException;

public class GuiRectTypeAdapter extends TypeAdapter<GuiControler> {
    public GuiControlers guiControlers;

    public GuiControler customRread(JsonReader reader, GuiControlers controlers) throws IOException {
        this.guiControlers = controlers;
        return read(reader);
    }

    @Override
    public void write(JsonWriter writer, GuiControler guiControler) throws IOException {
        GuiRect rect = (GuiRect)guiControler;

        new GuiControlerTypeAdapter().write(writer, guiControler);
        //writer.beginObject();
        writer.name("backgroundColor_r").value(rect.backgroundColor.getRed());
        writer.name("backgroundColor_g").value(rect.backgroundColor.getGreen());
        writer.name("backgroundColor_b").value(rect.backgroundColor.getBlue());
        //writer.name("width").value(rect.width);
        //writer.name("height").value(rect.height);
        //writer.endObject();
    }

    @Override
    public GuiControler read(JsonReader reader) throws IOException {
        //reader.beginObject();
        int backgroundColorR = 0;
        int backgroundColorG = 0 ;
        int backgroundColorB = 0;
        GuiControler controler = new GuiControlerTypeAdapter().customRread(reader, guiControlers);

        while (reader.hasNext()){
            String nextName = reader.nextName();
            System.out.println("NEW NAME : "+nextName);
            switch (nextName){
                case "backgroundColor_r":
                    backgroundColorR = reader.nextInt();
                    System.out.println("READ BACKGROUND COLOR R ");
                    break;
                case "backgroundColor_g":
                    backgroundColorG = reader.nextInt();
                    System.out.println("READ BACKGROUND COLOR G ");
                    break;
                case "backgroundColor_b":
                    backgroundColorB = reader.nextInt();
                    System.out.println("READ BACKGROUND COLOR B ");
                    break;
                /*case "width":
                    width = reader.nextInt();
                    break;
                case "height":
                    height = reader.nextInt();
                    break;*/
                default:
                    reader.skipValue();
                    break;
            }
        }
        //reader.endObject();

        System.out.println("READED COLOR : "+backgroundColorR+" "+backgroundColorG+" "+backgroundColorB);

        return new GuiRect(null, controler.type, controler.x, controler.y, controler.width, controler.height, new Color(backgroundColorR, backgroundColorG, backgroundColorB, 1));
    }
}
