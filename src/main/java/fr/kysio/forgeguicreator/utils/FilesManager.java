package fr.kysio.forgeguicreator.utils;

import com.google.gson.Gson;
import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

import java.io.*;
import java.util.ArrayList;

public class FilesManager {

    public static void initFiles(File folder){
        if(!folder.exists()){
            folder.mkdirs();
        }
    }

    public static void createGuiFile(File directory, String name){
        if(directory.isDirectory()){

            try {
                File file = new File(directory.getPath()+"/"+name+".gui");
                file.createNewFile();

                ArrayList<GuiControler> guiControlers = new ArrayList<>();

                GuiFile guiFile = new GuiFile(name, guiControlers);

                Gson gson = guiFile.createGsonInstance();

                String json = gson.toJson(guiFile);

                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                dos.writeUTF(json);

                dos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static ArrayList<Project> getProjects(File directory){
        ArrayList<Project> projects = new ArrayList<>();

        for(File file : directory.listFiles()){
            if(file.isDirectory()){
                String name = file.getName();
                Project project = getProject(name, directory);

                if(project != null){
                    projects.add(project);
                }
            }
        }

        return projects;
    }

    public static Project getProject(String name, File directory){
        Gson gson = new Gson();

        File file = new File(directory.getPath() + "/" + name + "/project.json");

        try {
            if(!directory.exists()){
                System.out.println("file not exist");
                return null;
            }

            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            String txt = dis.readUTF();
            System.out.println(txt);
            dis.close();

            Project project = gson.fromJson(txt, Project.class);

            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
