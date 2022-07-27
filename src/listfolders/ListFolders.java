package listfolders;

import java.io.File;

public class ListFolders {
    private final String DIRECTORY_PATH = "C:\\Users\\Darius\\Desktop\\Training";
    public String getFileTypeFromFileName(String name){
        String[] split = name.split("\\.");
        if(split.length > 1){
            return "File";
        } else{
            return "Directory";
        }
    }
    public void listContentsOfFolder(){
        new File(DIRECTORY_PATH).list((dir, name) -> {
            System.out.println(name + " | " + getFileTypeFromFileName(name));
            return false;
        });
    }

    public static void main(String[] args) {
          ListFolders application = new ListFolders();
          application.listContentsOfFolder();
    }
}
