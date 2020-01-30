package com.gemframework.bas.common.utils;

import com.alibaba.fastjson.JSON;
import com.gemframework.bas.common.config.GemConfig;
import com.gemframework.bas.common.constant.GemConstant;
import com.gemframework.bas.common.enums.CodeType;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gemframework.bas.common.enums.CodeType.HTML;
import static com.gemframework.bas.common.enums.CodeType.JAVA;

@Slf4j
public class GemGenerate {

    @Resource
    private GemConfig gemConfig;

    /**
     * @Title:  lowercaseFirst
     * @MethodName:  lowercaseFirst
     * @Param: [str]
     * @Retrun: java.lang.String
     * @Description: 首字母小写
     * @Date: 2019/11/29 23:22
     */
    public static String lowercaseFirst(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);

    }

    /**
     * @Title:  uppercaseFirst
     * @MethodName:  uppercaseFirst
     * @Param: [str]
     * @Retrun: java.lang.String
     * @Description: 首字母大写
     * @Date: 2019/11/29 23:22
     */
    public static String uppercaseFirst(String str) {
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
    public static boolean writeTxtFile(CodeType type,String content,TempParas tempParas,File fileName)throws Exception{

        String packageName = tempParas.getPackageName();
        String lowerEntity = tempParas.getCapsEntityEn();
        String upperEntity = uppercaseFirst(lowerEntity);
        String entityCN = tempParas.getEntityCN();
        String lowerPkName = tempParas.getCapsPkName();
        String upperPkName = uppercaseFirst(lowerPkName);
        Integer pageW = tempParas.getPageWidth();
        Integer pageH = tempParas.getPageHeight();
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String author = tempParas.getAuthor();

        if(type == JAVA){
            content = content
                    .replace("${package}",packageName)
                    .replace("${Entity}",upperEntity)
                    .replace("${entity}",lowerEntity)
                    .replace("${PkName}",upperPkName)
                    .replace("${pkName}",lowerPkName)
                    .replace("${datetime}",datetime)
                    .replace("${author}",author);

        }else if(type == HTML){

            String addFeildHtml = "";
            String editFeildHtml = "";
            String listFeildHtml = "";
            List<TempParas.Filed> fileds = tempParas.getFileds();
            if(fileds!=null&&fileds.size()>0){
                for(int i=0;i<fileds.size();i++){
                    TempParas.Filed filed = fileds.get(i);
                    if(!filed.getAttrNameEn().equalsIgnoreCase("id")){
                        //添加页面：
                        addFeildHtml += "<tr>\n" +
                                "   <td>"+filed.getAttrNameCn()+"";
                        if(filed.getIsNull() == 0){
                            addFeildHtml += "\n<span class=\"span\">*</span>";
                        }
                        addFeildHtml += "   </td>\n";
                        if(filed.getAttrType().equalsIgnoreCase("text")
                                || filed.getAttrType().equalsIgnoreCase("number")
                                || filed.getAttrType().equalsIgnoreCase("checkbox")
                                || filed.getAttrType().equalsIgnoreCase("radio")
                                || filed.getAttrType().equalsIgnoreCase("email")
                        ){
                            addFeildHtml +="       <input type=\""+filed.getAttrType()+"\" " +
                                    "       id=\""+filed.getAttrNameEn()+"\" " +
                                    "       name=\""+filed.getAttrNameEn()+"\"" +
                                    //TODO: 设置布局
                                    "       class=\"block\" ";
                            if(filed.getIsNull() == 0){
                                addFeildHtml += " required ";
                            }
                            if(filed.getMinLength() > 0){
                                addFeildHtml += "minlength =\""+filed.getMinLength()+"\"";
                            }
                            if(filed.getMaxLength() > 0){
                                addFeildHtml += "minlength =\""+filed.getMaxLength()+"\"";
                            }
                            addFeildHtml += ">\n";
                        }else if(filed.getAttrType().equalsIgnoreCase("select")){
                            addFeildHtml +="<select " +
                                    "       id=\""+filed.getAttrNameEn()+"\" " +
                                    "       name=\""+filed.getAttrNameEn()+"\"" +
                                    //TODO: 设置布局
                                    "       class=\"block\" >";
                            String options = filed.getOptions();
                            String[] optionsArr = options.split(";");
                            if(optionsArr != null && optionsArr.length > 1){
                                for(int j = 0; j< optionsArr.length; j++){
                                    String[] option = optionsArr[j].split("=");
                                    if(option != null && option.length == 2){
                                        addFeildHtml += "<option value=\""+option[1]+"\">"+option[0]+"</option>";
                                    }
                                }
                            }
                            addFeildHtml +="</select>\n";
                        }
                        addFeildHtml += "   </td>\n" +
                                "</tr>";



                        //编辑页面
                        editFeildHtml += "<tr>\n" +
                                "   <td>"+filed.getAttrNameCn()+"";
                        if(filed.getIsNull() == 0){
                            editFeildHtml += "\n<span class=\"span\">*</span>";
                        }
                        editFeildHtml += "   </td>\n";
                        if(filed.getAttrType().equalsIgnoreCase("text")
                                || filed.getAttrType().equalsIgnoreCase("number")
                                || filed.getAttrType().equalsIgnoreCase("checkbox")
                                || filed.getAttrType().equalsIgnoreCase("radio")
                                || filed.getAttrType().equalsIgnoreCase("email")
                        ){
                            editFeildHtml +="       <input type=\""+filed.getAttrType()+"\" " +
                                    "       id=\""+filed.getAttrNameEn()+"\" " +
                                    "       name=\""+filed.getAttrNameEn()+"\"" +
                                    //TODO: 设置布局
                                    "       class=\"block\" ";
                            if(filed.getIsNull() == 0){
                                editFeildHtml += " required ";
                            }
                            if(filed.getMinLength() > 0){
                                editFeildHtml += "minlength =\""+filed.getMinLength()+"\"";
                            }
                            if(filed.getMaxLength() > 0){
                                editFeildHtml += "minlength =\""+filed.getMaxLength()+"\"";
                            }
                            editFeildHtml += "th:value=\"${editInfo."+filed.getAttrNameEn()+"}\">\n";
                            editFeildHtml += ">\n";
                        }else if(filed.getAttrType().equalsIgnoreCase("select")){
                            editFeildHtml +="<select " +
                                    "       id=\""+filed.getAttrNameEn()+"\" " +
                                    "       name=\""+filed.getAttrNameEn()+"\"" +
                                    //TODO: 设置布局
                                    "       class=\"block\" >";
                            String options = filed.getOptions();
                            String[] optionsArr = options.split(";");
                            if(optionsArr != null && optionsArr.length > 1){
                                for(int j = 0; j< optionsArr.length; j++){
                                    String[] option = optionsArr[j].split("=");
                                    if(option != null && option.length == 2){
                                        editFeildHtml += "<option th:selected=\"${editInfo."+filed.getAttrNameEn()+" eq "+option[1]+"}\" value=\""+option[1]+"\">"+option[0]+"</option>";
                                    }
                                }
                            }
                            editFeildHtml +="</select>\n";
                        }
                        editFeildHtml += "   </td>\n" +
                                "</tr>";
                    }


                    //列表页面：
                    if(filed.getIsTableVisit() == 1){
                        listFeildHtml += ",{field:'"+filed.getAttrNameEn()+"', title:'"+filed.getAttrNameCn()+"'" +
                                ",sort: "+((filed.getIsTableSort() == 1)?true:false)+" " +
                                ",edit: '"+((filed.getEditType()==null)?null:filed.getEditType())+"'}\n            ";
                    }
                }
            }
            content = content
                    .replace("${entityCN}",entityCN)
                    .replace("${pkName}",lowerPkName)
                    .replace("${pageW}",String.valueOf(pageW))
                    .replace("${pageH}",String.valueOf(pageH))
                    .replace("${addFeildHtml}",addFeildHtml)
                    .replace("${editFeildHtml}",editFeildHtml)
                    .replace("${listFeildHtml}",listFeildHtml);
        }

        boolean flag=false;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(content.getBytes(GemConstant.Character.UTF8));
            fileOutputStream.close();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    public void generateCode(TempParas tempParas){
        log.info("=========config==============="+gemConfig);
        try {
            String packageName = tempParas.getPackageName();
            String lowerEntity = tempParas.getCapsEntityEn();
            String upperEntity = uppercaseFirst(lowerEntity);
            String output = "D:\\";

            //spring boot中文件直接放在resources目录下
            String tempControllerTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/java/contorller/TempController.txt"));
            String tempServiceTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/java/service/TempService.txt"));
            String tempServiceImplTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/java/service/impl/TempServiceImpl.txt"));
            String tempRepositoryTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/java/repository/TempRepository.txt"));


            String javaCodePath = output+"\\code\\java\\" +packageName+ "\\";
            //文件目录
            String path1 = javaCodePath + "contorller\\";
            String path2 = javaCodePath + "service\\";
            String path3 = javaCodePath + "service\\impl\\";
            String path4 = javaCodePath + "repository\\";
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

            //生成文件
            File controller = new File(path1+upperEntity+"Controller.java");
            File service = new File(path2+upperEntity+"Service.java");
            File serviceImpl = new File(path3+upperEntity+"ServiceImpl.java");
            File repository = new File(path4+upperEntity+"Repository.java");

            writeTxtFile(JAVA,tempControllerTxt,tempParas,controller);
            writeTxtFile(JAVA,tempServiceTxt,tempParas,service);
            writeTxtFile(JAVA,tempServiceImplTxt,tempParas,serviceImpl);
            writeTxtFile(JAVA,tempRepositoryTxt,tempParas,repository);


            String listHtmlTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/html/list.txt"));
            String addHtmlTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/html/add.txt"));
            String editHtmlTxt = GemGenerate.readTxt(ResourceUtils.getFile("classpath:template/generate/html/edit.txt"));


            String htmlCodePath = output+"\\code\\html\\" +lowerEntity+ "\\";
            File folder5 = new File(htmlCodePath);
            //文件夹路径不存在
            if (!folder5.exists() && !folder5.isDirectory()) {
                log.info("文件夹路径不存在，创建路径:" + folder5);
                folder5.mkdirs();
            }

            //生成add
            File addHtml = new File(htmlCodePath+"add.html");
            writeTxtFile(HTML,addHtmlTxt,tempParas,addHtml);

            //生成edit
            File editHtml = new File(htmlCodePath+"edit.html");
            writeTxtFile(HTML,editHtmlTxt,tempParas,editHtml);

            //生成list
            File listHtml = new File(htmlCodePath+"list.html");
            writeTxtFile(HTML,listHtmlTxt,tempParas,listHtml);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("执行完毕！");
        }
    }

    @Data
    @Builder
    public static class TempParas{

        private String packageName;
        private String capsEntityEn;
        private String entityCN;
        private String capsPkName;
        private String author;

        private int pageWidth;
        private int pageHeight;

        private boolean isAdd;
        private boolean isEdit;
        private boolean isDel;
        private boolean isQuery;

        private List<Filed> fileds;

        @Data
        @Builder
        public static class Filed{
            private Long id;
            private Long moduleId;
            private String attrNameEn;
            private String attrNameCn;
            private String attrType;
            private String options;
            private Integer minLength;
            private Integer maxLength;
            private String filedName;
            private String editType;//列表支持编辑类型
            private Integer isNull;//是否允许为空
            private Integer isTableVisit;//列表显示
            private Integer isTableSort;//支持排序显示
            private Integer isQurey;//支持查询

            @Tolerate
            public Filed(){}
        }
        @Tolerate
        public TempParas(){}
    }

    public static void main(String[] args) {
//        TempParas.Filed filed = TempParas.Filed.builder()
//                .attrNameEn("id")
//                .attrNameCn("ID")
//                .attrType("bigint")
//                .filedLength(20)
//                .isNull(0)
//                .isTableVisit(0)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed2 = TempParas.Filed.builder()
//                .attrNameEn("moduleId")
//                .attrNameCn("所属模块")
//                .filedType("bigint")
//                .filedLength(20)
//                .isNull(0)
//                .isTableVisit(0)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed3 = TempParas.Filed.builder()
//                .attrNameEn("attrNameEn")
//                .attrNameCn("属性名[英]")
//                .filedType("varchar")
//                .filedLength(50)
//                .isNull(0)
//                .isTableVisit(1)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed4 = TempParas.Filed.builder()
//                .attrNameEn("attrNameCn")
//                .attrNameCn("属性名[中]")
//                .filedType("varchar")
//                .filedLength(80)
//                .isNull(1)
//                .isTableVisit(1)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed5 = TempParas.Filed.builder()
//                .attrNameEn("filedName")
//                .attrNameCn("字段名称")
//                .filedType("varchar")
//                .filedLength(60)
//                .isNull(0)
//                .isTableVisit(1)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed6 = TempParas.Filed.builder()
//                .attrNameEn("filedType")
//                .attrNameCn("字段类型")
//                .filedType("varchar")
//                .filedLength(10)
//                .isNull(0)
//                .isTableVisit(1)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed7 = TempParas.Filed.builder()
//                .attrNameEn("filedLength")
//                .attrNameCn("字段长度")
//                .filedType("int")
//                .filedLength(10)
//                .isNull(0)
//                .isTableVisit(1)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed8 = TempParas.Filed.builder()
//                .attrNameEn("editType")
//                .attrNameCn("表格编辑")
//                .filedType("varchar")
//                .filedLength(10)
//                .isNull(0)
//                .isTableVisit(1)
//                .isTableSort(0)
//                .build();
//
//        TempParas.Filed filed9 = TempParas.Filed.builder()
//                .attrNameEn("isNull")
//                .attrNameCn("是否为空")
//                .filedType("tinyint")
//                .filedLength(1)
//                .isNull(0)
//                .isTableVisit(0)
//                .isTableSort(0)
//                .build();
//        TempParas.Filed filed10 = TempParas.Filed.builder()
//                .attrNameEn("isTableVisit")
//                .attrNameCn("是否可见")
//                .filedType("tinyint")
//                .filedLength(1)
//                .isNull(0)
//                .isTableVisit(0)
//                .isTableSort(0)
//                .build();
//        TempParas.Filed filed11 = TempParas.Filed.builder()
//                .attrNameEn("isTableSort")
//                .attrNameCn("是否排序")
//                .filedType("tinyint")
//                .filedLength(1)
//                .isNull(0)
//                .isTableVisit(0)
//                .isTableSort(0)
//                .build();
//        TempParas.Filed filed12 = TempParas.Filed.builder()
//                .attrNameEn("isQurey")
//                .attrNameCn("是否查询")
//                .filedType("tinyint")
//                .filedLength(1)
//                .isNull(0)
//                .isTableVisit(0)
//                .isTableSort(0)
//                .build();
//
//
//        List<TempParas.Filed> list = new ArrayList<>();
//        list.add(filed);
//        list.add(filed2);
//        list.add(filed3);
//        list.add(filed4);
//        list.add(filed5);
//        list.add(filed6);
//        list.add(filed7);
//        list.add(filed8);
//        list.add(filed9);
//        list.add(filed10);
//        list.add(filed11);
//        list.add(filed12);
//        TempParas tempParas = TempParas.builder()
//                .packageName("com.gemframework.cms")
//                .capsEntityEn("ModuleAttr")
//                .entityCN("代码生成属性")
//                .capsPkName("FiledName")
//
//                .isAdd(true)
//                .isEdit(true)
//                .isDel(true)
//                .isQuery(true)
//
//                .pageWidth(550)
//                .pageHeight(550)
//
////                .fileds(list)
//                .author("zhangys")
//                .output("D:\\")
//                .build();
//        generateCode(tempParas);

//        String aa = "null;0";
//        String[] arr = aa.split(";");
//        log.info("================"+arr);
//        log.info("================"+arr.length);

        GemConfig config = new GemConfig();
        log.info("==="+config);
    }

}
