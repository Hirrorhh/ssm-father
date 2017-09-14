package cn.ssm.usermanager.view;

import cn.ssm.usermanager.pojo.User;
import cn.ssm.usermanager.utils.DownloadUtils;
import org.apache.poi.hssf.usermodel.*;
import org.joda.time.DateTime;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Map;




public class UserExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 从model对象中获取userList
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) model.get("userList");
		// 创建Excel的sheet
		HSSFSheet sheet = workbook.createSheet("会员列表");
		HSSFCellStyle cellHeaderStyle = workbook.createCellStyle();
		//设置背景色：
		cellHeaderStyle.setFillForegroundColor((short) 13);// 设置背景色
		cellHeaderStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置边框:
		cellHeaderStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		cellHeaderStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		cellHeaderStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		cellHeaderStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		//设置居中:
		cellHeaderStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		// 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 16);//设置字体大小
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		font.setColor(HSSFFont.COLOR_RED); //字体颜色
		font.setFontName("黑体"); //字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
		cellHeaderStyle.setFont(font);
        cellHeaderStyle.setWrapText(true);

        HSSFCellStyle cellBodyStyle = workbook.createCellStyle();
        //设置边框:
        cellBodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        cellBodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellBodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellBodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        //设置居中:
        cellBodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        // 设置字体
        HSSFFont font2 = workbook.createFont();
        font2.setFontHeightInPoints((short) 12);//设置字体大小
        font2.setFontName("黑体"); //字体
        cellBodyStyle.setFont(font2);
        cellBodyStyle.setWrapText(true);

		// 创建标题行
		HSSFRow header = sheet.createRow(0);
        HSSFCell cell0 = header.createCell(0);
        cell0.setCellValue("ID");
        cell0.setCellStyle(cellHeaderStyle);
        HSSFCell cell1 = header.createCell(1);
        cell1.setCellValue("用户名");
        cell1.setCellStyle(cellHeaderStyle);
        HSSFCell cell2 = header.createCell(2);
        cell2.setCellValue("姓名");
        cell2.setCellStyle(cellHeaderStyle);
        HSSFCell cell3 = header.createCell(3);
        cell3.setCellValue("年龄");
        cell3.setCellStyle(cellHeaderStyle);
        HSSFCell cell4 = header.createCell(4);
        cell4.setCellValue("性别");
        cell4.setCellStyle(cellHeaderStyle);
        HSSFCell cell5 = header.createCell(5);
        cell5.setCellValue("出生日期");
        cell5.setCellStyle(cellHeaderStyle);
        HSSFCell cell6 = header.createCell(6);
        cell6.setCellValue("创建时间");
        cell6.setCellStyle(cellHeaderStyle);
        HSSFCell cell7 = header.createCell(7);
        cell7.setCellValue("更新时间");
        cell7.setCellStyle(cellHeaderStyle);
		
		// 填充数据
		int rowNum = 1;
		for (User user : userList) {
			HSSFRow row = sheet.createRow(rowNum);
            HSSFCell cell_0 = row.createCell(0);
            cell_0.setCellStyle(cellBodyStyle);
            cell_0.setCellValue(user.getId());
            HSSFCell cell_1 = row.createCell(1);
            cell_1.setCellValue(user.getuserName()==null?"":user.getuserName());
            cell_1.setCellStyle(cellBodyStyle);
            HSSFCell cell_2 = row.createCell(2);
            cell_2.setCellStyle(cellBodyStyle);
            cell_2.setCellValue(user.getName());
            HSSFCell cell_3 = row.createCell(3);
            cell_3.setCellStyle(cellBodyStyle);
            cell_3.setCellValue(user.getAge());
            HSSFCell cell_4 = row.createCell(4);
            cell_4.setCellStyle(cellBodyStyle);
            cell_4.setCellValue(user.getSexName());
            HSSFCell cell_5 = row.createCell(5);
            cell_5.setCellStyle(cellBodyStyle);
            cell_5.setCellValue(new DateTime(user.getBirthday()).toString(Constants.DATE));
            HSSFCell cell_6 = row.createCell(6);
            cell_6.setCellStyle(cellBodyStyle);
            cell_6.setCellValue(new DateTime(user.getCreated()).toString(Constants.DATE_TIME));
            HSSFCell cell_7 = row.createCell(7);
            cell_7.setCellStyle(cellBodyStyle);
            cell_7.setCellValue(new DateTime(user.getUpdated()).toString(Constants.DATE_TIME));

			rowNum++;
		}
		sheet.autoSizeColumn(0); //调整第一列宽度
		sheet.autoSizeColumn(1); //调整第二列宽度
		sheet.autoSizeColumn(2); //调整第三列宽度
		sheet.autoSizeColumn(3); //调整第四列宽度
		sheet.autoSizeColumn(4); //调整第五列宽度
		sheet.autoSizeColumn(5); //调整第六列宽度
		sheet.autoSizeColumn(7); //调整第六列宽度
		// 设置相应头信息，以附件形式下载并且指定文件名
		String fileNameString = "会员列表"+new Date(System.currentTimeMillis()) +".xls";
        response.setHeader("Content-Disposition", "attachment;filename=" + DownloadUtils.getAttachmentFilename(fileNameString, request.getHeader("user-agent")));
	}

	

}
