package www.test.java;

import java.io.*;

/**
 * 文件copy
 * @auther plg
 * @date 2019/3/31 17:11
 */
public class FileCopyUtil {
    public static void fileCopy(String sourcePath,String destPath){
        checkEmpty(sourcePath,"path is null");
        checkEmpty(destPath,"path is null");
        File sorceFile = new File(sourcePath);
        File destFile = new File(destPath);
        checkAndCreat(destFile);
        try(InputStream in = new FileInputStream(sorceFile);
           OutputStream out = new FileOutputStream(destFile);){
           int len = -1;
           byte[] buff = new byte[1024*1024*50];
           while((len = in.read(buff)) != -1){
               out.write(buff,0,len);
           }
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    private static void checkEmpty(String str,String msg){
        if(str == null || str.length() == 0) {
            throw new IllegalArgumentException(msg);
        }
    }
    private static void checkAndCreat(File file){
        if(file == null || file.isDirectory()){
            throw new RuntimeException("dest is Illeagal");
        }
        File parentFile = file.getParentFile();
        if(parentFile == null){
            boolean ret = parentFile.mkdirs();
            if(!ret){
                throw new RuntimeException("file creat failed");
            }
        }
    }

    public static void main(String[] args) {
        String sourceParh = "D:\\ideaIU-2018.1.6.exe";
        String destPath = "E:\\JAVA代码\\ideaIU-2018.1.6.exe";
        fileCopy(sourceParh,destPath);
    }
}
