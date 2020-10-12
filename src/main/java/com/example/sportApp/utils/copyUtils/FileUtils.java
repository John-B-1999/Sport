package com.example.sportApp.utils.copyUtils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 */
public class FileUtils {

    /**
     * 读取文件成字节数组
     *
     * @param path:文件路径
     */
    public static byte[] fileToByte(String path) {
        try {
            FileInputStream in = new FileInputStream(new File(path));
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字节数组写入文件
     *
     * @param path 写入后文件的路径加名称
     */
    public static void byteToFile(String path, byte[] data) {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(path));
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Base64解码并生成图片文件
     *
     * @param imgStr  图片base64
     * @param imgFile 输出图片路径
     */
    public static void generateImage(String imgStr, String imgFile) throws Exception {
        byte[] bytes;
        OutputStream out = null;
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            // 解码并处理数据
            bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }

            // 生成图片文件
            out = new FileOutputStream(imgFile);
            out.write(bytes);
            out.flush();
        } catch (Exception e) {
            throw new IOException();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据路径得到base编码后图片
     *
     * @param imgFilePath 图片文件路径
     */
    public static String getImageStr(String imgFilePath) throws IOException {
        byte[] data;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            throw new IOException();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 获取本地图片转换为Base64编码字符串
     *
     * @param imgPath 图片文件路径
     */
    public static String getImagePathToBase64(String imgPath) {

        byte[] buffer = null;
        InputStream inputStream = null;

        // 读取图片为字节数组
        try {
            inputStream = new FileInputStream(imgPath);

            // 设置字节数组长度
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            buffer = new byte[count];

            // 读取数据
            inputStream.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 字节数组进行Base64编码
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 获取网络图片转换成Base64编码字符串
     *
     * @param imgUrl 图片Url
     */
    public static String getImgUrlToBase64(String imgUrl) {

        byte[] buffer = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        try {
            // 创建URL与链接
            URL url = new URL(imgUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);

            inputStream = conn.getInputStream();
            outputStream = new ByteArrayOutputStream();

            // 将图片内容读取内存中
            buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            buffer = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // 关闭outputStream流
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 字节数组进行Base64编码
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 获取网络/本地图片文件转换为Base64编码字符串
     *
     * @param imgStr 网络图片Url/本地图片路径
     */
    public static String getImageToBase64(String imgStr) {

        byte[] buffer = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        try {
            // 判断是否为网络链接图片文件
            if (imgStr.startsWith("http://") || imgStr.startsWith("https://")) {

                // 创建URL与链接
                URL url = new URL(imgStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);

                // 创建输入输出流
                inputStream = conn.getInputStream();
                outputStream = new ByteArrayOutputStream();

                // 将图片内容读取内存中
                buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                buffer = outputStream.toByteArray();

                // 若为本地文件
            } else {
                inputStream = new FileInputStream(imgStr);

                // 设置字节数组长度
                int count = 0;
                while (count == 0) {
                    count = inputStream.available();
                }
                buffer = new byte[count];

                // 读取数据
                inputStream.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // 关闭outputStream流
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 字节数组进行Base64编码
        return new BASE64Encoder().encode(buffer);
    }

    /*
     * 常用文件的文件头如下：
     * JPEG (jpg)，文件头：FFD8FF
     * ZIP Archive (zip)，文件头：504B03
     * Excel( xls) 文件头：504B03
     * Excel( xlsx) 文件头：D0CF11
     *
     * */

    /**
     * 通过流方式判断文件类型
     *
     * @param path 文件路径
     */
    public static String getFileTypeByStream(String path) {
        try {
            FileInputStream inputStream = new FileInputStream(path);

            byte[] b = new byte[3];
            inputStream.read(b, 0, b.length);

            StringBuilder stringBuilder = new StringBuilder();
            for (byte value : b) {
                int v = value & 0xFF;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(hv);
            }
            String type = stringBuilder.toString().toUpperCase();

            inputStream.close();
            return type;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 读取本地Excel文件(.xlsx与.xls)
     *
     * @param filePath 文件路径
     *                 需导入依赖
     *                 <dependency>
     *                 <groupId>org.apache.poi</groupId>
     *                 <artifactId>poi</artifactId>
     *                 <version>4.0.1</version>
     *                 </dependency>
     *
     *                 <dependency>
     *                 <groupId>org.apache.poi</groupId>
     *                 <artifactId>poi-ooxml</artifactId>
     *                 <version>4.0.1</version>
     *                 </dependency>
     */
    public static void readExcel(String filePath) {
        try {
            /*
             *简单判断后缀名，如需通过文件流判断文件类型，
             * 请调用getFileTypeByStream方法
             * Excel( xls) 文件头：504B03
             * Excel( xlsx) 文件头：D0CF11
             * */
            boolean xls = filePath.endsWith(".xls");
            boolean xlsx = filePath.endsWith(".xlsx");

            Workbook book;
            Sheet sheet = null;
            InputStream inputStream = new FileInputStream(new File(filePath));

            if (xls) {
                // 解析excel
                POIFSFileSystem pSystem = new POIFSFileSystem(inputStream);
                // 获取整个excel
                book = new HSSFWorkbook(pSystem);
                // 获取第一个表单sheet
                sheet = book.getSheetAt(0);
            }

            if (xlsx) {
                // 直接通过流获取整个excel
                book = new XSSFWorkbook(inputStream);
                // 获取第一个表单sheet
                sheet = book.getSheetAt(0);
            }

            if (sheet != null) {
                // 获取第一行
                int firstRow = sheet.getFirstRowNum();
                // 获取最后一行
                int lastRow = sheet.getLastRowNum();

                // 循环行数依次获取列数
                for (int i = firstRow; i < lastRow + 1; i++) {
                    // 获取第 i 行
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        // 获取此行的第一列
                        int firstCell = 0;
                        /*
                         *获取此行的存在数据的第一列
                         * int firstCell = row.getFirstCellNum();
                         * */

                        // 获取此行的存在数据的最后一列
                        int lastCell = row.getLastCellNum();

                        // 创建集合，保存每一行的每一列
                        List<String> list = new ArrayList<>();
                        for (int j = firstCell; j < lastCell; j++) {
                            // 获取第 j 列
                            Cell cell = row.getCell(j);
                            if (cell != null) {
                                list.add(cell.toString());
                            } else {
                                list.add("");
                            }
                        }
                        System.out.println(list);
                    }
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建Excel文件并写入数据
     *
     * @param title     表头
     * @param sheetName 表名
     * @param pathName  文件路径
     */
    public static void writeExcel(String[] title, String sheetName, String pathName) {

        // 创建excel工作簿
        HSSFWorkbook book = new HSSFWorkbook();
        // 创建工作表sheet并设置表名
        HSSFSheet sheet = book.createSheet(sheetName);
        // 设置默认行宽
        sheet.setDefaultColumnWidth(10);

        // 标题样式（加粗，垂直水平居中）
        HSSFCellStyle cellStyle = book.createCellStyle();
        // 设置水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        HSSFFont fontStyle = book.createFont();
        // 设置加粗
        fontStyle.setBold(true);
        // 设置标题字体大小
        fontStyle.setFontHeightInPoints((short) 10);

        cellStyle.setFont(fontStyle);

        // 创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;

        // 插入第一行数据的表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(cellStyle);
        }
        // 写入数据
        for (int i = 1; i <= 10; i++) {
            HSSFRow nrow = sheet.createRow(i);
            HSSFCell ncell = nrow.createCell(0);
            ncell.setCellValue("" + i);
            ncell = nrow.createCell(1);
            ncell.setCellValue("user" + i);
            ncell = nrow.createCell(2);
            ncell.setCellValue("24");
        }
        // 创建excel文件
        File file = new File(pathName);
        try {
            file.createNewFile();
            // 将excel写入
            OutputStream stream = new FileOutputStream(file);
            book.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建Excel文件并写入数据
     */
    public static byte[] export(String sheetTitle, String[] title, List<Object> list) {

        HSSFWorkbook wb = new HSSFWorkbook();//创建excel表
        HSSFSheet sheet = wb.createSheet(sheetTitle);
        sheet.setDefaultColumnWidth(20);//设置默认行宽

        // 表头样式（加粗，水平居中，垂直居中）
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        // 设置边框样式
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框

        HSSFFont fontStyle = wb.createFont();
//        fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        cellStyle.setFont(fontStyle);

        //标题样式（加粗，垂直居中）
        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        cellStyle2.setFont(fontStyle);

        //设置边框样式
        cellStyle2.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle2.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle2.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle2.setBorderRight(BorderStyle.THIN);//右边框

        //字段样式（垂直居中）
        HSSFCellStyle cellStyle3 = wb.createCellStyle();
        cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

        //设置边框样式
        cellStyle3.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle3.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle3.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle3.setBorderRight(BorderStyle.THIN);//右边框

        //创建表头
        HSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(20);//行高

        HSSFCell cell = row.createCell(0);
        cell.setCellValue(sheetTitle);
        cell.setCellStyle(cellStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (title.length - 1)));

        //创建标题
        HSSFRow rowTitle = sheet.createRow(1);
        rowTitle.setHeightInPoints(20);

        HSSFCell hc;
        for (int i = 0; i < title.length; i++) {
            hc = rowTitle.createCell(i);
            hc.setCellValue(title[i]);
            hc.setCellStyle(cellStyle2);
        }

        byte[] result = null;

        ByteArrayOutputStream out = null;

        try {
            //创建表格数据
            Field[] fields;
            int i = 2;

            for (Object obj : list) {
                fields = obj.getClass().getDeclaredFields();

                HSSFRow rowBody = sheet.createRow(i);
                rowBody.setHeightInPoints(20);

                int j = 0;
                for (Field f : fields) {

                    f.setAccessible(true);

                    Object va = f.get(obj);
                    if (null == va) {
                        va = "";
                    }

                    hc = rowBody.createCell(j);
                    hc.setCellValue(va.toString());
                    hc.setCellStyle(cellStyle3);

                    j++;
                }

                i++;
            }

            out = new ByteArrayOutputStream();
            wb.write(out);
            result = out.toByteArray();
        } catch (Exception ex) {
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
            } catch (IOException ex) {
            } finally {
                try {
                    wb.close();
                } catch (IOException ex) {
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        String s = getImageToBase64("http://n.sinaimg.cn/news/crawl/64/w550h314/20200928/ead2-izrvxmh6255042.jpg");
        System.out.println(s);
        generateImage(s,"C:\\Users\\ywm\\Desktop\\img.jpg");
    }
}
