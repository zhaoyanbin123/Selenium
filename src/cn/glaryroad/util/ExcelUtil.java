package cn.glaryroad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;;

public class ExcelUtil {

	 //������Ҫʵ���ļ���չΪ.xlsx��Excel�ļ�����
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	//�趨Ҫ�������ļ�·����Excel�ļ��е�sheet����
	//�ڶ�дExcel��ʱ�򣬾���Ҫ�ȵ��ô˷������趨Ҫ������Excel�ļ�·����Ҫ������sheet����
	public static void setExcelFile(String Path,String SheetName)throws Exception{
		
		FileInputStream ExcelFile;
		try{
			//ʵ����Excel�ļ���FileInputStream����
			ExcelFile=new FileInputStream(Path);
			//ʵ����Excel�ļ���XSSFWorkbook����
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			/*
			 * ʵ����XSSFSheet����ָ��Excel�ļ��е�sheet���ƣ���������sheet���С��к͵�Ԫ��Ĳ���
			 * */
			ExcelWSheet =ExcelWBook.getSheet(SheetName);
		}catch(Exception e){
			throw e;
		}
		
		
		}
	//��ȡExcel�ļ�ָ����Ԫ����
	public static String getCellData(int RowNum,int ColNum)throws Exception{
		try{
			//ͨ����������ָ����Ԫ����кź��кţ���ȡָ����Ԫ�����
			Cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
			/*
			 * �����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue������ȡ��Ԫ�������
			 * �����Ԫ�������Ϊ�������ͣ���ʹ��getNumberCellValue()������ȡ��Ԫ������
			 * ע��getNumberCellValue��������ֵΪdouble���ͣ�ת���ַ������ͱ�����Cell.getNumberValue()
			 * ǰ��ӡ���������ǿ��double���͵�String���ͣ����ӡ������׳�double�����޷�ת����String���͵��쳣*/
			String CellData=Cell.getCellType()==XSSFCell.CELL_TYPE_STRING?Cell.getStringCellValue()+""
					:String.valueOf(Math.round(Cell.getNumericCellValue()));
			return CellData;
		}catch(Exception e){
			return "";
		}
	}
	
	//��Excel�ļ���ִ�е�Ԫ����д������
	@SuppressWarnings("static-access")
	public static void setCellData(int RowNum,int ColNum,String Result)throws Exception{
		try {
			//��ȡExcel�ļ��� ���ж���
			Row=ExcelWSheet.getRow(RowNum);
			//�����Ԫ��Ϊ�գ��򷵻�null
			Cell=Row.getCell(ColNum,Row.RETURN_BLANK_AS_NULL);
			if (Cell==null) {
				//����Ԫ�����ʱnull��ʱ���򴴽���Ԫ��
				//�����Ԫ��Ϊ�գ��޷�ֱ���õ�Ԫ������setCellValue�����趨��Ԫ���ֵ
				//������Ԫ��ſ��Ե���setCellValue�����趨��Ԫ���ֵ
				Cell.setCellValue(Result);
				
				
			}
			else{
				//��Ԫ���������ݣ������ֱ�ӵ��õ�Ԫ������setCellValue�����趨��Ԫ���ֵ
				Cell.setCellValue(Result);
				
			}
			//ʵ����д��Excel�ļ��е��ļ�����������
			FileOutputStream fileOut=new FileOutputStream(
					Constant.TestDataExcelFilePath);
			//������д��Excel�ļ���
			ExcelWBook.write(fileOut);
			//����flush����ǿ��ˢ��д���ļ�
			fileOut.flush();
			//�ر��ļ����������
			fileOut.close();
		} catch (Exception e) {
			throw e;

		}
	}
	//��Excel�ļ���ȡ�������ݵľ�̬����
	@SuppressWarnings("resource")
	public static Object[][] getTestData(String excelFilePath,String sheetName) throws IOException{
		//���ݲ�������������ļ�·�����ļ����ƣ���ϳ�Excel�����ļ��ľ���·��
		//����һ��file����
		File file=new File(excelFilePath);
		//����FileInputStream �������ڶ�ȡExcel�ļ�
		FileInputStream inputStream=new FileInputStream(file);
		//����Workbook ����
		Workbook Workbook=null;
		//��ȡ�ļ�����������չ�����ж���.xlsx�ļ�����xls�ļ�
		String fileExtensionName=excelFilePath.substring(excelFilePath.indexOf(","));
		//�ж��ļ����������.xlsx����ʹ��XSSFWorkbook�������ʵ����
		//�ж��ļ����������.xls����ʹ��SSFWorkbook�������ʵ����
		if (fileExtensionName.equals(".xlsx")) {
			Workbook=new XSSFWorkbook(inputStream);
			
			
		}else if(fileExtensionName.equals(".xls")){
		Workbook=new HSSFWorkbook(inputStream);
		
		}
		//ͨ��sheetName����������sheet����
		Sheet sheet=Workbook.getSheet(sheetName);
		//��ȡExcel�����ļ�sheet�е����ݵ�������getLastRowNum������ȡ���ݵ�����к�
		//getFirstRowNum������ȡ���ݵĵ�һ���кţ����֮���������ݵ�����
		//ע�⣺Excel�ļ����кź��кŶ��Ǵ�0��ʼ
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		//������Ϊrecords��list�������洢Excel�����ļ���ȡ������
		List<Object[]> records=new ArrayList<Object[]>();
		//ʹ������forѭ������Excel�����ļ����������ݣ����˵�һ�У���һ�������������ƣ�
		//����i��1��ʼ�������Ǵ�0��ʼ
		for (int i = 1; i < rowCount+1; i++) {
			//ʹ��getRow������ȡ�ж���
			Row row=sheet.getRow(i);
			/*
			 ����һ�����飬�����洢Excel�����ļ�ÿ���еĲ������ݺ������������С��
			 getLastCellNum-2�����ж�̬������ʵ�ֲ������ݸ����������С����һ�£���ΪExcel
			 �����ļ��еĲ��������е����һ����Ԫ��Ϊ����ִ�н���������ڶ�����Ԫ��Ϊ�˲����������Ƿ�
			 ���е�״̬λ������������еĵ�Ԫ�����ݲ�����Ҫ������Է����У�����ʹ��getLastCell-2�ķ�ʽ
			 ȥ��ÿ���е����������Ԫ�����ݣ��������Ҫ�洢�Ĳβ������ݸ���������Ϊ������������ĳ�ʼ����С
			 
			 */
			String []fileds=new String[row.getLastCellNum()-2];
			/*
			 if�����ж��������Ƿ�Ҫ������Ե�ִ�У�Excel�ļ��ĵ����ڶ���Ϊ�����е�״̬λ
			 ���Ϊ��ʾ��������Ҫ����ű�ִ�У����Ϊn ��ʾ��ִ�У�����*/
			if (row.getCell(row.getLastCellNum()-2).getStringCellValue().equals("y")) {
				
				for(int j=0;j<row.getLastCellNum()-2;j++){
					//�ж�excel�ĵ�Ԫ���ֶ��Ƿ����ַ����ַ�����ʽ����getStringCellValue������ȡ
					//���ָ�ʽ����getNumerCellValue������ȡ
					fileds[j]=(String)(row.getCell(j).getCellType()==XSSFCell.CELL_TYPE_STRING ?
							row.getCell(j).getStringCellValue():""+row.getCell(j).getNumericCellValue());
					
				}
				//fields�����ݶ���洢��records��list��
				records.add(fileds);
				
			}
			
		}
		//���庯������ֵ����Object[][]
		//���洢�������ݵ�listת��Ϊһ��object��Object�Ķ�ά����
		Object[][] results=new Object[records.size()][];
		//���ö�ά����ÿ�е�ֵ��ÿ����һ��Object����
		for (int i = 0; i < records.size(); i++) {
			results[i]=records.get(i);
			
		}
		return results;
		
	}
	
	public static int getLastColumnNUm(){
		//���������ļ����һ�е��кţ������12�У���������11
		return ExcelWSheet.getRow(0).getLastCellNum()-1;
	}
	

}
