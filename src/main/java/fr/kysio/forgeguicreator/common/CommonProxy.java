package fr.kysio.forgeguicreator.common;

import fr.kysio.forgeguicreator.utils.FilesManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class CommonProxy {

    public static File guiCreatorDirectory;

    public void preInit(File configFile)
    {
        guiCreatorDirectory = new File(configFile.getParentFile().getPath()+"/gui-creator/projects");
        FilesManager.initFiles(guiCreatorDirectory);
    }

    public void init()
    {
    }

}
