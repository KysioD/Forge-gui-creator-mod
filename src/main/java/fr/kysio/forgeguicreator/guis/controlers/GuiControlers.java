package fr.kysio.forgeguicreator.guis.controlers;

public enum GuiControlers {
    GUI_RECT(GuiControler.class, GuiControlerTypeAdapter.class);

    private Class<GuiControler> guiRectClass;
    private Class<GuiControlerTypeAdapter> guiRectTypeAdapterClass;

    GuiControlers(Class<GuiControler> guiRectClass, Class<GuiControlerTypeAdapter> guiRectTypeAdapterClass) {
        this.guiRectClass = guiRectClass;
        this.guiRectTypeAdapterClass = guiRectTypeAdapterClass;
    }

    public Class<GuiControler> getGuiRectClass() {
        return guiRectClass;
    }

    public Class<GuiControlerTypeAdapter> getGuiRectTypeAdapterClass() {
        return guiRectTypeAdapterClass;
    }
}
