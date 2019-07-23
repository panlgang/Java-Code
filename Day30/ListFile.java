package Day30;
import java.io.*;
import java.nio.file.FileSystems;

/**
 * @auther plg
 * @date 2019/7/23 15:42
 */
public class ListFile {
    public static void print(File file){
        if(file.isFile() && file.exists()){
            System.out.println(file.getAbsolutePath());
            return;
        }
        if(file.isDirectory() && file.exists()){
            File[] files = file.listFiles();
            for(File file1 : files){
                print(file1);
            }
        }
    }
    public static void main(String[] args) {
        print(new File("E:/JAVA代码/javaProject/每日一题"));
    }
}
