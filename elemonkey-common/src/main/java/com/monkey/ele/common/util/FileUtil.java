package com.monkey.ele.common.util;

import java.io.*;
import java.util.Properties;

public class FileUtil {

    private static String[] PIC_TYPE = {"jpg","jpeg","png","bmp"};

    public static String copyFileInput(InputStream input,String toPath,String fileName){
        String newFilePath = null;
        String newFileName = null;
        try{
            newFileName = makeFileName(fileName);
            newFilePath = toPath+"\\"+newFileName;
            OutputStream out = new FileOutputStream(newFilePath,true);
            int len = 0;
            byte[] buf = new byte[128];
            while ((len = input.read(buf))!=-1) {
                out.write(buf,0,len);
            }
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return newFileName;
    }


    public static String makeFileName(String filename) {
        return UUIDUtils.get8UUID()+filename;
    }


    public static boolean checkIFPic(String filename){
        boolean result = false;
        for (String type:PIC_TYPE){
            if(filename.contains(type)){
                result = true;
                break;
            }
        }
        return result;
    }

    public static File getUploadFolder() {
        File file = null;
        Properties properties = new Properties();
        try {
            properties.load(FileUtil.class.getResourceAsStream("/upload_config.properties"));
            file = new File(properties.getProperty("upload_folder_path"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file == null) {
            file = new File("/upload_files");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String readFile(File file) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = reader.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

}
