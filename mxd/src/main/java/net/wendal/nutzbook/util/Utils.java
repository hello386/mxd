package net.wendal.nutzbook.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
	/** 
     * 生成随机文件名：当前年月日时分秒+五位随机数 
     *  
     * @return 
     */  
    public static String getRandomFileName() {  
  
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");  
  
        Date date = new Date();  
  
        String str = simpleDateFormat.format(date);  
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
  
        return  str+rannum;// 当前时间  
    }  
    /**
     * 将sourcePath文件移动到 distPath 并重命名为fileName
     * 
     * @param sourcePath  c:\\xxx\xxx.zip
     * @param distPath       d:\\aaa\bbb
     * @param fileName     aaa.zip
     */
    public static  void moveTotherFolders(String sourcePath,String distPath,String fileName){
    	System.out.println("----------sourcePath-"+sourcePath);
    	System.out.println("----------distPath-"+distPath);
    	System.out.println("----------fileName-"+fileName);
        String startPath = sourcePath;
        String endPath = distPath + File.separator;
        try {
            File startFile = new File(startPath);
            File tmpFile = new File(endPath);//获取文件夹路径
            if(!tmpFile.exists()){//判断文件夹是否创建，没有创建则创建新文件夹
                tmpFile.mkdirs();
            }
            if (startFile.renameTo(new File(endPath + fileName))) {
                System.out.println("File is moved successful!");
            } else {
                System.out.println("File is failed to move!");
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
