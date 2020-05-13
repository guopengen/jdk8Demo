package com.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/28 0:29
 */
public class CreateSimpleExcelToDisk {
    private static List<Member> getMember() throws Exception
    {
        List list = new ArrayList();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        Member user1 = new Member(1, "熊大", 24, df.parse("1993-08-28"), Arrays.asList(new Animal("dog",1),new Animal("dog1",1)));
        Member user2 = new Member(2, "熊二", 23, df.parse("1994-08-19"),Arrays.asList(new Animal("cat",2),new Animal("cat1",2)));
        Member user3 = new Member(3, "熊熊", 24, df.parse("1983-11-22"),Arrays.asList(new Animal("snak",2),new Animal("snak1",2)));
        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }

    public static void main(String[] args) throws Exception
    {
        //testB();
        testA();
    }

    public static void testB(){
        ArrayList<AchievementVo> achievementVoArrayList = new ArrayList<>();

        AchievementVo achievementVo1 = new AchievementVo();
        List<AchievementCaseVo> achievementInfoVoList1 = new  ArrayList<>();

        AchievementCaseVo achievementCaseVo1 = new AchievementCaseVo();
        List<AchievementReport> achievementReportList1 = new ArrayList<>();
        AchievementReport achievementReport1 = new AchievementReport();
        achievementReport1.setGroupName("A");
        achievementReport1.setTargetSettlementRate(new BigDecimal("1.1"));
        achievementReport1.setCurrentSettlementRate(new BigDecimal("1.2"));
        achievementReport1.setBatchReachRate(new BigDecimal("1.3"));
        achievementReport1.setTargetReachRate(new BigDecimal("1"));

        AchievementReport achievementReport1B = new AchievementReport();
        achievementReport1B.setGroupName("B");
        achievementReport1B.setTargetSettlementRate(new BigDecimal("1.11"));
        achievementReport1B.setCurrentSettlementRate(new BigDecimal("1.21"));
        achievementReport1B.setBatchReachRate(new BigDecimal("1.31"));
        achievementReport1B.setTargetReachRate(new BigDecimal("1"));

        AchievementReport achievementReport1C = new AchievementReport();
        achievementReport1C.setGroupName("C");
        achievementReport1C.setTargetSettlementRate(new BigDecimal("1.12"));
        achievementReport1C.setCurrentSettlementRate(new BigDecimal("1.22"));
        achievementReport1C.setBatchReachRate(new BigDecimal("1.32"));
        achievementReport1C.setTargetReachRate(new BigDecimal("1"));

        achievementReportList1.add(achievementReport1);
        achievementReportList1.add(achievementReport1B);
        achievementReportList1.add(achievementReport1C);
        achievementCaseVo1.setAchievementReportList(achievementReportList1);
        achievementCaseVo1.setCaseType("B0");
        achievementInfoVoList1.add(achievementCaseVo1);


        AchievementCaseVo achievementCaseVo2 = new AchievementCaseVo();
        List<AchievementReport> achievementReportList2 = new ArrayList<>();
        AchievementReport achievementReport2 = new AchievementReport();
        achievementReport2.setGroupName("A");
        achievementReport2.setTargetSettlementRate(new BigDecimal("2.1"));
        achievementReport2.setCurrentSettlementRate(new BigDecimal("2.2"));
        achievementReport2.setBatchReachRate(new BigDecimal("2.3"));
        achievementReport2.setTargetReachRate(new BigDecimal("2"));

        AchievementReport achievementReport2B = new AchievementReport();
        achievementReport2B.setGroupName("B");
        achievementReport2B.setTargetSettlementRate(new BigDecimal("2.11"));
        achievementReport2B.setCurrentSettlementRate(new BigDecimal("2.21"));
        achievementReport2B.setBatchReachRate(new BigDecimal("2.31"));
        achievementReport2B.setTargetReachRate(new BigDecimal("2"));

        AchievementReport achievementReport2C = new AchievementReport();
        achievementReport2C.setGroupName("C");
        achievementReport2C.setTargetSettlementRate(new BigDecimal("2.12"));
        achievementReport2C.setCurrentSettlementRate(new BigDecimal("2.22"));
        achievementReport2C.setBatchReachRate(new BigDecimal("2.32"));
        achievementReport2C.setTargetReachRate(new BigDecimal("2"));

        achievementReportList2.add(achievementReport2);
        achievementReportList2.add(achievementReport2B);
        achievementReportList2.add(achievementReport2C);
        achievementCaseVo2.setAchievementReportList(achievementReportList2);
        achievementCaseVo2.setCaseType("B1");
        achievementInfoVoList1.add(achievementCaseVo2);


        achievementVo1.setAchievementInfoVoList(achievementInfoVoList1);
        achievementVo1.setAppName("CBC");
        achievementVoArrayList.add(achievementVo1);



        AchievementVo achievementVo = achievementVoArrayList.get(0);
        List<AchievementCaseVo> achievementCaseVos = achievementVo.getAchievementInfoVoList();
        List<String> caseTypeList = achievementCaseVos.stream().map(AchievementCaseVo::getCaseType).collect(Collectors.toList());
        //要遍历的总列数(以4为单位)
        int unitNum = achievementCaseVos.size();

        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("成绩报表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow firstRow = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        HSSFCell title = firstRow.createCell(0);
        title.setCellValue("报表");
        title.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4*unitNum+1));


        for (int i = 0; i < achievementVoArrayList.size(); i++){
            AchievementVo dealAchievementVo = achievementVoArrayList.get(i);

            List<AchievementCaseVo> achievementInfoVoList = dealAchievementVo.getAchievementInfoVoList();

            int rowUnitNum = (i+1)*3;
            //对第一次循环做特殊处理，需要设置案件类型和表头
            if (i==0) {
                //第二行固定的字段
                HSSFRow secondRow0 = sheet.createRow(1);
                HSSFCell secondRow0cell1 = secondRow0.createCell(0);
                secondRow0cell1.setCellValue("公司");
                HSSFCell secondRow0cell2 = secondRow0.createCell(1);
                secondRow0cell2.setCellValue("组别");

                //第二行的变动列表
                for (int k=0;k<unitNum;k++){
                    int cellUnitNum = 4*k+2;
                    HSSFCell secondRow0cell3 = secondRow0.createCell(cellUnitNum);
                    secondRow0cell3.setCellValue(caseTypeList.get(k));
                    secondRow0cell3.setCellStyle(style);
                    sheet.addMergedRegion(new CellRangeAddress(1, 1, cellUnitNum, cellUnitNum+3));
                }

                //第三行固定的
                HSSFRow thirdRow = sheet.createRow((int) 2);
                HSSFCell thirdRowCell1 = thirdRow.createCell((short) 0);
                thirdRowCell1.setCellValue("");
                HSSFCell thirdRowCell2 = thirdRow.createCell((short) 1);
                thirdRowCell2.setCellValue("");
                //第三行的变动列表
                for (int k=0;k<unitNum;k++){
                    int cellUnitNum = 4*k+2;
                    HSSFCell thirdRowCell3 = thirdRow.createCell(cellUnitNum);
                    thirdRowCell3.setCellValue("化解率目标");
                    HSSFCell thirdRowCell4 = thirdRow.createCell(cellUnitNum+1);
                    thirdRowCell4.setCellValue("当前化解率");
                    HSSFCell thirdRowCell5 = thirdRow.createCell(cellUnitNum+2);
                    thirdRowCell5.setCellValue("批次达成率");
                    HSSFCell thirdRowCell6 = thirdRow.createCell(cellUnitNum+3);
                    thirdRowCell6.setCellValue("目标达成率");
                }
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
            }

            //第四行
            HSSFRow fourRow = sheet.createRow(rowUnitNum);
            HSSFCell fourRowCell1 = fourRow.createCell(0);
            fourRowCell1.setCellValue(dealAchievementVo.getAppName());
            HSSFCell fourRowCell2 = fourRow.createCell(1);
            fourRowCell2.setCellValue("A");

            for (int k=0;k<unitNum;k++){
                int cellUnitNum = 4*k+2;
                AchievementCaseVo achievementCaseVo = achievementInfoVoList.get(k);
                List<AchievementReport> achievementReportList = achievementCaseVo.getAchievementReportList().stream().filter(achievementReport -> achievementReport.getGroupName().equals("A")).collect(Collectors.toList());
                AchievementReport achievementReport = achievementReportList.get(0);
                HSSFCell fourRowCell3 = fourRow.createCell(cellUnitNum);
                fourRowCell3.setCellValue(achievementReport.getTargetSettlementRate().toString());
                HSSFCell fourRowCell4 = fourRow.createCell(cellUnitNum+1);
                fourRowCell4.setCellValue(achievementReport.getCurrentSettlementRate().toString());
                HSSFCell fourRowRowCell5 = fourRow.createCell(cellUnitNum+2);
                fourRowRowCell5.setCellValue(achievementReport.getBatchReachRate().toString());
                HSSFCell fourRowRowCell6 = fourRow.createCell(cellUnitNum+3);
                fourRowRowCell6.setCellValue(achievementReport.getTargetReachRate().toString());
                fourRowRowCell6.setCellStyle(style);
            }


            //第五行
            HSSFRow fiveRow = sheet.createRow(rowUnitNum+1);
            HSSFCell fiveRowCell1 = fiveRow.createCell((short) 0);
            fiveRowCell1.setCellValue("");
            HSSFCell fiveRowCell2 = fiveRow.createCell((short) 1);
            fiveRowCell2.setCellValue("B");

            for (int k=0;k<unitNum;k++){
                int cellUnitNum = 4*k+2;
                /*for (int m=0;m<achievementInfoVoList.size();m++){*/
                AchievementCaseVo achievementCaseVo = achievementInfoVoList.get(k);
                List<AchievementReport> achievementReportList = achievementCaseVo.getAchievementReportList().stream().filter(achievementReport -> achievementReport.getGroupName().equals("B")).collect(Collectors.toList());
                AchievementReport achievementReport = achievementReportList.get(0);
                HSSFCell fiveRowCell3 = fiveRow.createCell(cellUnitNum);
                fiveRowCell3.setCellValue(achievementReport.getTargetSettlementRate().toString());
                HSSFCell fiveRowCell4 = fiveRow.createCell(cellUnitNum+1);
                fiveRowCell4.setCellValue(achievementReport.getCurrentSettlementRate().toString());
                HSSFCell fiveRowRowCell5 = fiveRow.createCell(cellUnitNum+2);
                fiveRowRowCell5.setCellValue(achievementReport.getBatchReachRate().toString());
                HSSFCell fiveRowRowCell6 = fiveRow.createCell(cellUnitNum+3);
                fiveRowRowCell6.setCellValue("");
                /*}*/
            }


            //第六行
            HSSFRow sixRow = sheet.createRow(rowUnitNum+2);
            HSSFCell sixRowCell1 = sixRow.createCell((short) 0);
            sixRowCell1.setCellValue("");
            HSSFCell sixRowCell2 = sixRow.createCell((short) 1);
            sixRowCell2.setCellValue("C");
            for (int k=0;k<unitNum;k++){
                int cellUnitNum = 4*k+2;
                /*for (int m=0;m<achievementInfoVoList.size();m++){*/
                AchievementCaseVo achievementCaseVo = achievementInfoVoList.get(k);
                List<AchievementReport> achievementReportList = achievementCaseVo.getAchievementReportList().stream().filter(achievementReport -> achievementReport.getGroupName().equals("C")).collect(Collectors.toList());
                AchievementReport achievementReport = achievementReportList.get(0);
                HSSFCell sixRowCell3 = sixRow.createCell(cellUnitNum);
                sixRowCell3.setCellValue(achievementReport.getTargetSettlementRate().toString());
                HSSFCell sixRowCell4 = sixRow.createCell(cellUnitNum+1);
                sixRowCell4.setCellValue(achievementReport.getCurrentSettlementRate().toString());
                HSSFCell sixRowRowCell5 = sixRow.createCell(cellUnitNum+2);
                sixRowRowCell5.setCellValue(achievementReport.getBatchReachRate().toString());
                HSSFCell sixRowRowCell6 = sixRow.createCell(cellUnitNum+3);
                sixRowRowCell6.setCellValue("");
                /*}*/
            }

            for (int k=0;k<unitNum;k++){
                int linshi = 4*k+2;
                sheet.addMergedRegion(new CellRangeAddress(rowUnitNum, rowUnitNum+2, linshi+3, linshi+3));
            }

            sheet.addMergedRegion(new CellRangeAddress(rowUnitNum, rowUnitNum+2, 0, 0));
        }

        // 第六步，将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream("E:/Members.xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testA(){
        ArrayList<AchievementVo> achievementVoArrayList = new ArrayList<>();

        AchievementVo achievementVo1 = new AchievementVo();
        List<AchievementCaseVo> achievementInfoVoList1 = new  ArrayList<>();

        AchievementCaseVo achievementCaseVo1 = new AchievementCaseVo();
        List<AchievementReport> achievementReportList1 = new ArrayList<>();
        AchievementReport achievementReport1 = new AchievementReport();
        achievementReport1.setGroupName("A");
        achievementReport1.setTargetSettlementRate(new BigDecimal("1.1"));
        achievementReport1.setCurrentSettlementRate(new BigDecimal("1.2"));
        achievementReport1.setBatchReachRate(new BigDecimal("1.3"));
        achievementReport1.setTargetReachRate(new BigDecimal("1"));

        /*AchievementReport achievementReport1B = new AchievementReport();
        achievementReport1B.setGroupName("B");
        achievementReport1B.setTargetSettlementRate(new BigDecimal("1.11"));
        achievementReport1B.setCurrentSettlementRate(new BigDecimal("1.21"));
        achievementReport1B.setBatchReachRate(new BigDecimal("1.31"));
        achievementReport1B.setTargetReachRate(new BigDecimal("1"));

        AchievementReport achievementReport1C = new AchievementReport();
        achievementReport1C.setGroupName("C");
        achievementReport1C.setTargetSettlementRate(new BigDecimal("1.12"));
        achievementReport1C.setCurrentSettlementRate(new BigDecimal("1.22"));
        achievementReport1C.setBatchReachRate(new BigDecimal("1.32"));
        achievementReport1C.setTargetReachRate(new BigDecimal("1"));*/

        achievementReportList1.add(achievementReport1);
        achievementCaseVo1.setAchievementReportList(achievementReportList1);
        achievementCaseVo1.setCaseType("B0");
        achievementInfoVoList1.add(achievementCaseVo1);


        AchievementCaseVo achievementCaseVo2 = new AchievementCaseVo();
        List<AchievementReport> achievementReportList2 = new ArrayList<>();
        AchievementReport achievementReport2 = new AchievementReport();
        achievementReport2.setGroupName("A");
        achievementReport2.setTargetSettlementRate(new BigDecimal("2.1"));
        achievementReport2.setCurrentSettlementRate(new BigDecimal("2.2"));
        achievementReport2.setBatchReachRate(new BigDecimal("2.3"));
        achievementReport2.setTargetReachRate(new BigDecimal("2"));

        /*AchievementReport achievementReport2B = new AchievementReport();
        achievementReport2B.setGroupName("B");
        achievementReport2B.setTargetSettlementRate(new BigDecimal("2.11"));
        achievementReport2B.setCurrentSettlementRate(new BigDecimal("2.21"));
        achievementReport2B.setBatchReachRate(new BigDecimal("2.31"));
        achievementReport2B.setTargetReachRate(new BigDecimal("2"));

        AchievementReport achievementReport2C = new AchievementReport();
        achievementReport2C.setGroupName("C");
        achievementReport2C.setTargetSettlementRate(new BigDecimal("2.12"));
        achievementReport2C.setCurrentSettlementRate(new BigDecimal("2.22"));
        achievementReport2C.setBatchReachRate(new BigDecimal("2.32"));
        achievementReport2C.setTargetReachRate(new BigDecimal("2"));*/

        achievementReportList2.add(achievementReport2);
        achievementCaseVo2.setAchievementReportList(achievementReportList2);
        achievementCaseVo2.setCaseType("B1");
        achievementInfoVoList1.add(achievementCaseVo2);


        achievementVo1.setAchievementInfoVoList(achievementInfoVoList1);
        achievementVo1.setAppName("CBC");
        achievementVoArrayList.add(achievementVo1);



        AchievementVo achievementVo = achievementVoArrayList.get(0);
        List<AchievementCaseVo> achievementCaseVos = achievementVo.getAchievementInfoVoList();
        List<String> caseTypeList = achievementCaseVos.stream().map(AchievementCaseVo::getCaseType).collect(Collectors.toList());
        //要遍历的总列数(以4为单位)
        int unitNum = achievementCaseVos.size();

        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("成绩报表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow firstRow = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        HSSFCell title = firstRow.createCell(0);
        title.setCellValue("报表");
        title.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4*unitNum+1));


        for (int i = 0; i < achievementVoArrayList.size(); i++){
            AchievementVo dealAchievementVo = achievementVoArrayList.get(i);

            List<AchievementCaseVo> achievementInfoVoList = dealAchievementVo.getAchievementInfoVoList();

            int rowUnitNum = i+3;
            //对第一次循环做特殊处理，需要设置案件类型和表头
            if (i==0) {
                //第二行固定的字段
                HSSFRow secondRow0 = sheet.createRow(1);
                HSSFCell secondRow0cell1 = secondRow0.createCell(0);
                secondRow0cell1.setCellValue("公司");
                HSSFCell secondRow0cell2 = secondRow0.createCell(1);
                secondRow0cell2.setCellValue("组别");

                //第二行的变动列表
                for (int k=0;k<unitNum;k++){
                    int cellUnitNum = 4*k+2;
                    HSSFCell secondRow0cell3 = secondRow0.createCell(cellUnitNum);
                    secondRow0cell3.setCellValue(caseTypeList.get(k));
                    secondRow0cell3.setCellStyle(style);
                    sheet.addMergedRegion(new CellRangeAddress(1, 1, cellUnitNum, cellUnitNum+3));
                }

                //第三行固定的
                HSSFRow thirdRow = sheet.createRow((int) 2);
                HSSFCell thirdRowCell1 = thirdRow.createCell((short) 0);
                thirdRowCell1.setCellValue("");
                HSSFCell thirdRowCell2 = thirdRow.createCell((short) 1);
                thirdRowCell2.setCellValue("");
                //第三行的变动列表
                for (int k=0;k<unitNum;k++){
                    int cellUnitNum = 4*k+2;
                    HSSFCell thirdRowCell3 = thirdRow.createCell(cellUnitNum);
                    thirdRowCell3.setCellValue("化解率目标");
                    HSSFCell thirdRowCell4 = thirdRow.createCell(cellUnitNum+1);
                    thirdRowCell4.setCellValue("当前化解率");
                    HSSFCell thirdRowCell5 = thirdRow.createCell(cellUnitNum+2);
                    thirdRowCell5.setCellValue("批次达成率");
                    HSSFCell thirdRowCell6 = thirdRow.createCell(cellUnitNum+3);
                    thirdRowCell6.setCellValue("目标达成率");
                }
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
            }

            //第四行
            HSSFRow fourRow = sheet.createRow(rowUnitNum);
            HSSFCell fourRowCell1 = fourRow.createCell(0);
            fourRowCell1.setCellValue(dealAchievementVo.getAppName());
            HSSFCell fourRowCell2 = fourRow.createCell(1);
            fourRowCell2.setCellValue("");

            for (int k=0;k<unitNum;k++){
                int cellUnitNum = 4*k+2;
                AchievementCaseVo achievementCaseVo = achievementInfoVoList.get(k);
                List<AchievementReport> achievementReportList = achievementCaseVo.getAchievementReportList();
                AchievementReport achievementReport = achievementReportList.get(0);
                HSSFCell fourRowCell3 = fourRow.createCell(cellUnitNum);
                fourRowCell3.setCellValue(achievementReport.getTargetSettlementRate()== null ? "0.00":achievementReport.getTargetSettlementRate().toString());                HSSFCell fourRowCell4 = fourRow.createCell(cellUnitNum+1);
                fourRowCell4.setCellValue(achievementReport.getCurrentSettlementRate().toString());
                HSSFCell fourRowRowCell5 = fourRow.createCell(cellUnitNum+2);
                fourRowRowCell5.setCellValue(achievementReport.getBatchReachRate().toString());
                HSSFCell fourRowRowCell6 = fourRow.createCell(cellUnitNum+3);
                fourRowRowCell6.setCellValue(achievementReport.getTargetReachRate().toString());
                fourRowRowCell6.setCellStyle(style);
            }

        }

        // 第六步，将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream("E:/Members.xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
