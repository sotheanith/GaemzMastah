package launcher.model;

import javax.imageio.IIOException;
import java.io.IOException;

public class Program {
    private String title;
    private String path;
    private String iconPath;
    public Program(String title, String path, String iconPath){
        this.title=title;
        this.path=path;
        this.iconPath=iconPath;
    }
    public void start(){
        try{
            new ProcessBuilder(path).start();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
    public String getIconPath(){
        return iconPath;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString() {
        return " Title: "+title+ " Path: "+path+" Icon Path: "+iconPath;
    }
}