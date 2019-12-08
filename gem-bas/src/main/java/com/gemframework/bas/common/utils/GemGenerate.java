package com.gemframework.bas.common.utils;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class GemGenerate {

    /**
     * @Title:  lowerFirstCapse
     * @MethodName:  lowerFirstCapse
     * @Param: [str]
     * @Retrun: java.lang.String
     * @Description: 首字母小写
     * @Date: 2019/11/29 23:22
     */
    public static String lowerFirstCapse(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);

    }

    /**
     * @Title:  createFile
     * @MethodName:  createFile
     * @Param: [fileName]
     * @Retrun: boolean
     * @Description: 创建文件
     * @Date: 2019/11/29 23:23
     */
    public static boolean createFile(File fileName)throws Exception{
        try{
            if(!fileName.exists()){
                fileName.createNewFile();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }


    /**
     * @Title:  readTxt
     * @MethodName:  readTxt
     * @Param: [file]
     * @Retrun: java.lang.String
     * @Description: 读取txt
     * @Date: 2019/11/29 23:22
     */
    public static String readTxt(File file) throws IOException {
        String s = "";
        InputStreamReader in = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(in);
        StringBuffer content = new StringBuffer();
        while ((s = br.readLine()) != null) {
            content.append(s);
            content.append("\r\n");
        }
        return content.toString();
    }


    /**
     * @Title:  writeTxtFile
     * @MethodName:  writeTxtFile
     * @Param: [content, fileName]
     * @Retrun: boolean
     * @Description: 写入TXT，覆盖原内容
     * @Date: 2019/11/29 23:23
     */
    public static boolean writeTxtFile(String content,File fileName)throws Exception{
        RandomAccessFile mm=null;
        boolean flag=false;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(content.getBytes("utf-8"));
            fileOutputStream.close();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * @Title:  fileChaseFW
     * @MethodName:  fileChaseFW
     * @Param: [filePath, content]
     * @Retrun: void
     * @Description: 写入TXT，追加写入
     * @Date: 2019/11/29 23:24
     */
    public static void fileChaseFW(String filePath, String content) {
        try {
            //构造函数中的第二个参数true表示以追加形式写文件
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.out.println("文件写入失败！" + e);
        }
    }


    public static void generateCode(TempParas tempParas){
        try {
            //模版参数
            String packageName = tempParas.getPackageName();
            String capsEntity = tempParas.getCapsEntity();
            String lowEntity = lowerFirstCapse(capsEntity);
            String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String author = tempParas.getAuthor();
            String output = tempParas.getOutput();

            //spring boot中文件直接放在resources目录下
            String tempController = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/contorller/TempController.txt"));
            String tempService = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/service/TempService.txt"));
            String tempServiceImpl = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/service/impl/TempServiceImpl.txt"));
            String tempRepository = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/repository/TempRepository.txt"));


            //文件目录
            String path1 = output+"\\code\\contorller\\";
            String path2 = output+"\\code\\service\\";
            String path3 = output+"\\code\\service\\impl\\";
            String path4 = output+"\\code\\repository\\";
            File folder1 = new File(path1);
            File folder2 = new File(path2);
            File folder3 = new File(path3);
            File folder4 = new File(path4);
            //文件夹路径不存在
            if (!folder1.exists() && !folder1.isDirectory()) {
                log.info("文件夹路径不存在，创建路径:" + path1);
                folder1.mkdirs();
            }
            //文件夹路径不存在
            if (!folder2.exists() && !folder2.isDirectory()) {
                log.info("文件夹路径不存在，创建路径:" + path2);
                folder2.mkdirs();
            }
            //文件夹路径不存在
            if (!folder3.exists() && !folder3.isDirectory()) {
                log.info("文件夹路径不存在，创建路径:" + path3);
                folder3.mkdirs();
            }
            //文件夹路径不存在
            if (!folder4.exists() && !folder4.isDirectory()) {
                log.info("文件夹路径不存在，创建路径:" + path4);
                folder4.mkdirs();
            }

            File controller = new File(path1+capsEntity+"Controller.java");
            File service = new File(path2+capsEntity+"Service.java");
            File serviceImpl = new File(path3+capsEntity+"ServiceImpl.java");
            File repository = new File(path4+capsEntity+"Repository.java");

            writeTxtFile(tempController.replace("${package}",packageName)
                    .replace("${Entity}",capsEntity)
                    .replace("${entity}",lowEntity)
                    .replace("${datetime}",datetime)
                    .replace("${author}",author),controller);
            writeTxtFile(tempService.replace("${package}",packageName)
                    .replace("${Entity}",capsEntity)
                    .replace("${entity}",lowEntity)
                    .replace("${datetime}",datetime)
                    .replace("${author}",author),service);
            writeTxtFile(tempServiceImpl.replace("${package}",packageName)
                    .replace("${Entity}",capsEntity)
                    .replace("${entity}",lowEntity)
                    .replace("${datetime}",datetime)
                    .replace("${author}",author),serviceImpl);
            writeTxtFile(tempRepository.replace("${package}",packageName)
                    .replace("${Entity}",capsEntity)
                    .replace("${entity}",lowEntity)
                    .replace("${datetime}",datetime)
                    .replace("${author}",author),repository);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("执行完毕！");
        }
    }

    @Data
    @Builder
    private static class TempParas{

        private String packageName;
        private String capsEntity;
        private String author;
        private String output;

        @Tolerate
        public TempParas(){}
    }

    public static void main(String[] args) {
        TempParas tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("Dept")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
        tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("Menu")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
        tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("Org")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
        tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("Role")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
        tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("RoleMenus")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
        tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("RoleOrgs")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
        tempParas = TempParas.builder()
                .packageName("com.gemframework.cms")
                .capsEntity("UserRoles")
                .author("zhangys")
                .output("D:\\xxx1")
                .build();
        generateCode(tempParas);
    }

}
