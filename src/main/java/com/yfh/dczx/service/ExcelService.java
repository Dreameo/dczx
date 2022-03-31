package com.yfh.dczx.service;

import com.yfh.dczx.exception.MyException;
import com.yfh.dczx.mapper.UserMapper;
import com.yfh.dczx.pojo.Student;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    private UserMapper userMapper;



    public Boolean excelToData(String fileName, MultipartFile file, Integer sheetNo, Integer startLine, Integer endLine) throws IOException {

        boolean notNull = false;


        List<Student> studentList = new ArrayList<Student>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确"); // 判断文件是不是excel
        }


        boolean isExcel2003 = true;  // 是否excel2013
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }


        InputStream is = file.getInputStream(); // 得到文件输入流

        Workbook wb = null; // 工作簿


        if (isExcel2003) {
            wb = new HSSFWorkbook(is); // excel2013版本
        } else {
            wb = new XSSFWorkbook(is);  // xlsx版本
        }


        Sheet sheet = wb.getSheetAt(sheetNo - 1); // 表格sheet1

        if(sheet!=null){
            notNull = true;
        }

        for (int r = startLine - 1; r < endLine; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }


            Integer examNo = getCellValue(row.getCell(0)) == "" ? 0 : Integer.parseInt(getCellValue(row.getCell(0)));

            String name = getCellValue(row.getCell(1)); // 姓名



            Double chinese = getCellValue(row.getCell(2)) == "" ? 0.0: Double.parseDouble(getCellValue(row.getCell(2)));

            Double math = getCellValue(row.getCell(3)) == "" ? 0.0 : Double.parseDouble(getCellValue(row.getCell(3)));

            Double english = getCellValue(row.getCell(4)) == "" ? 0.0 : Double.parseDouble(getCellValue(row.getCell(4)));
            Double politics = getCellValue(row.getCell(5)) == "" ? 0.0 : Double.parseDouble(getCellValue(row.getCell(5)));
            Double history = getCellValue(row.getCell(6)) == "" ? 0.0 : Double.parseDouble(getCellValue(row.getCell(6)));
            Double geography = getCellValue(row.getCell(7)) == "" ? 0.0 : Double.parseDouble(getCellValue(row.getCell(7)));
            Double biology = getCellValue(row.getCell(8)) == "" ? 0.0 : Double.parseDouble(getCellValue(row.getCell(8)));

            Student student = new Student(0, examNo, name, chinese, math, english, politics, history, geography, biology);
            student.getBiology();
            studentList.add(student);
        }
//        userMapper.insertByList(studentList);

        for (Student student : studentList) {
            String stuName = student.getStuName();
            int cnt = userMapper.selectByName(stuName);
            if (cnt == 0) {
                userMapper.insertStudent(student);
                System.out.println("添加一条信息");
            } else {
                userMapper.updateStudent(student);
                System.out.println("更新一条信息");
            }

        }

//        for (User userResord : userList) {
//            String name = userResord.getName();
//            int cnt = userMapper.selectByName(name);
//            if (cnt == 0) {
//                userMapper.addUser(userResord);
//                System.out.println(" 插入 "+userResord);
//            } else {
//                userMapper.updateUserByName(userResord);
//                System.out.println(" 更新 "+userResord);
//            }
//        }
        return notNull;
    }

    private static String getCellValue(Cell c) {
        String o = null;
        switch (c.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                o = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                o = String.valueOf(c.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                o = String.valueOf(c.getCellFormula());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(c)) {
                    double d = c.getNumericCellValue();
                    Date date = HSSFDateUtil.getJavaDate(d);
                    SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                    o = dformat.format(date);
                }
                else {
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setGroupingUsed(false);// true时的格式：1,234,567,890
                    o = nf.format(c.getNumericCellValue());//
                }
                break;
            case Cell.CELL_TYPE_STRING:
                o = c.getStringCellValue();
                break;
            default:
                o = null;
                break;
        }
        return o;
    }

}
