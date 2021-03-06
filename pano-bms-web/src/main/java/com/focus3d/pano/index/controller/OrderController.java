package com.focus3d.pano.index.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.focus3d.pano.admin.service.OrderService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.OrderAdmin;
import com.focus3d.pano.model.pano_project;
import com.focustech.common.utils.DownloadUtils;
import com.focustech.common.utils.JsonUtils;
import com.focustech.common.utils.StringUtils;

/**
 * 
 * 订单管理
 * 
 * @author 熊峰
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;
	private int colum_width = 5120;
	private short colum_height = 256;
	private static final LinkedHashMap<String,String> Colum_Name = new LinkedHashMap<String,String>() {{  
			put("ORDER_NUM","订单编号");
			put("ORDER_TIME","订单日期");
			put("SUM_MONEY","订单金额");
			put("ActuallyMoney","实付金额");
			put("PAY_MONEY","已支付金额");
			put("total_trans_type","全款支付方式");
			put("first_trans_type","预付款支付方式");
			put("final_trans_type","尾款支付方式");
			put("DISCOUNT","优惠折扣");
			put("DISCOUNT_MONEY","优惠券");
			put("STATUS","订单状态");
			put("USER_SN","用户ID");
			put("LOGTC_ID","物流单号");
			put("LOGTC_SEND","物流状态");
			put("RECEIVER_NAME","姓名");
			put("RECEIVER_CERTNO","身份证号码");
			
			put("RECEIVER_ADDRESS","收货地址");
			put("RECEIVER_PHONE","联系电话");
			put("REMARK","后台备注");
			put("detail","套餐明细");
	}};   
	
	private static final LinkedHashMap<String,String> Product_Colum = new LinkedHashMap<String,String>() {{  
		put("productName","产品名称");
		put("productID","产品编号");
		put("productNum","件数");
	}};
	

	/**
	 * 进入订单管理
	 */
	@RequestMapping("/toOrder")
	public String toOrder(String page,HttpServletResponse response,ModelMap map) {
		// 总记录数
		int count = 0;
		int currentPage = 0;
		Page pages = null;
		List<OrderAdmin> OrderAdmin = null;
		int upPage = 0;
		int nextPage = 0;

		// 判断当前页
		if (page == null || page.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage == 1) {
			upPage = 1;
			nextPage = 2;
		}

		// 获取查询总记录数
		count = orderService.selOrderCount(new HashMap<String,Object>());

		// 通过Page这个类可以获取分页的起始下标和条数
		pages = new Page(count, currentPage);

		// 拼接分页语句
		OrderAdmin = orderService.selOrder(pages);
		
		for(OrderAdmin order:OrderAdmin){
			HashMap<String,Object> info = orderService.QueryOrderPay(order.getORDER_SN());
			if(!(info.get("num").toString().equals("0"))){
				String final_status = info.get("final_status").toString();
				String first_status = info.get("first_status").toString();
				if(first_status.equals("1")){
					order.setSTATUS(1);
				}else{
					if(final_status.equals("1"))
						order.setSTATUS(3);
					else
						order.setSTATUS(2);
				}
			}
		}
		
		map.put("orderList", OrderAdmin);
		map.put("pages", pages);
		int totalPages = pages.getTotalPages();

		if (currentPage == totalPages) {
			upPage = currentPage - 1;
			nextPage = totalPages;
		} else if (currentPage > 1) {
			upPage = currentPage - 1;
			nextPage = currentPage + 1;
		}
		int index = (currentPage - 1) * pages.getPagesize();
		map.put("total", pages.getTotalPages());
		map.put("current_index", currentPage);

		List<pano_project> houseList = orderService.selHouse();
		map.put("houseList", houseList);
		
		return "/order/order";
	}

	/**
	 * 订单管理-查看
	 */
	@RequestMapping("/toorder-details")
	public String toorder_details(ModelMap map,String ORDER_SN) {
		Long order_sn = Long.parseLong(ORDER_SN);
		HashMap<String,Object> order = GetDetail(order_sn);
		map.put("orderList", order);
		return "/order/order-details";
	}
	
	private HashMap<String,Object> GetDetail(Long order_sn){
		HashMap<String,Object> order = orderService.selOrderbySN(order_sn);
		
		
		List<HashMap<String,Object>> products = orderService.QueryOrderPackageDetail(order_sn);
	    HashMap<String,HashMap<String,Object>> detail = new HashMap<String,HashMap<String,Object>>();
	    
		for(HashMap<String,Object> child:products){
			String key = child.get("packageSn").toString();
			HashMap<String,Object> _package;
			List<HashMap<String,Object>> product_list;
			
			if(detail.containsKey(key)){
				_package = detail.get(key);
				product_list = (List<HashMap<String,Object>>)_package.get("child");
				HashMap<String, Object> product = new HashMap<String,Object>();
				product.put("productName", child.get("productName").toString());
				product.put("productID", child.get("productID").toString());
				product.put("productNum", child.get("productNum").toString());
				product_list.add(product);
			}else{
				String name = child.get("projectName").toString() + "-" +child.get("baseStyle").toString() + "-" + child.get("houseName").toString() + "-" + child.get("packageName").toString();
				_package = new HashMap<String,Object>();
				_package.put("name",name);
				product_list = new LinkedList<HashMap<String,Object>>();
		        
				HashMap<String, Object> product = new HashMap<String,Object>();
				product.put("productName", child.get("productName").toString());
				product.put("productID", child.get("productID").toString());
				product.put("productNum", child.get("productNum").toString());
				
				product_list.add(product);
				_package.put("child", product_list);
				detail.put(key, _package);
			}
		}
		order.put("detail", detail);
		
		HashMap<String,Object> pay_detail = orderService.QueryOrderPay(order_sn);
		String num = pay_detail.get("num").toString();
		if(num.equals("0")){
			if(order.get("TRANS_TYPE")!=null){
				order.put("total_trans_type", order.get("TRANS_TYPE").toString());
			}
		}else{
			order.put("ActuallyMoney", pay_detail.get("ActuallyMoney").toString());
			order.put("PAY_MONEY", pay_detail.get("PAY_MONEY").toString());
			if(pay_detail.get("first_trans_type")!=null){
				order.put("first_trans_type", pay_detail.get("first_trans_type").toString());
			}
			
			if(pay_detail.get("final_trans_type")!=null){
				order.put("final_trans_type", pay_detail.get("final_trans_type").toString());
			}
			String status = pay_detail.get("final_status").toString();
			if(status.equals("1")){
				order.put("STATUS",3);
			}else{
				order.put("STATUS",2);
			}
		}
		return order;
	}
	
	/**
	 * 订单管理-搜索
	 */
	@RequestMapping("/selOrder")
	public String selOrder(String PROJECT_SN, String NICK_NAME,String ORDER_TIME,String page,String ORDER_NUM,String PHONE_NUM,ModelMap result) {
	   HashMap<String,Object> map = new HashMap<String,Object>();
		if (!ORDER_TIME.equals("日期")) {
			map.put("ORDER_TIME",ORDER_TIME);
		}
		if (!PROJECT_SN.equals("楼盘名称")) {
			map.put("PROJECT_SN",PROJECT_SN);
		}
		map.put("NICK_NAME",NICK_NAME);
		map.put("ORDER_NUM", ORDER_NUM);
		map.put("PHONE_NUM",PHONE_NUM);
		
		int count = 0;
		int currentPage = 0;
		Page pages = null;
		int upPage = 0;
		int nextPage = 0;

		// 判断当前页
		if (page == null || page.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage == 1) {
			upPage = 1;
			nextPage = 2;
		}

		// 获取查询总记录数
		
		try {
			count = orderService.selOrderCount(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 通过Page这个类可以获取分页的起始下标和条数
		pages = new Page(count, currentPage);
		map.put("startIndex", pages.getStartIndex());
		map.put("pagesize", pages.getPagesize());
		List<OrderAdmin> orderList = orderService.selOrderbyAll(map);
		
		for(OrderAdmin order:orderList){
			HashMap<String,Object> info = orderService.QueryOrderPay(order.getORDER_SN());
			if(!(info.get("num").toString().equals("0"))){
				String status = info.get("final_status").toString();
				if(status.equals("1")){
					order.setSTATUS(3);
				}else{
					order.setSTATUS(2);
				}
			}
		}
		
		result.put("orderList", orderList);
		result.put("total", pages.getTotalPages());
		result.put("current_index", currentPage);
		
		result.put("ORDER_TIME",ORDER_TIME);
		result.put("PROJECT_SN",PROJECT_SN);
		result.put("NICK_NAME",NICK_NAME);
		result.put("ORDER_NUM", ORDER_NUM);
		result.put("PHONE_NUM",PHONE_NUM);

		List<pano_project> houseList = orderService.selHouse();
		result.put("houseList", houseList);

		return "/order/order";
	}
	
	@RequestMapping("/QueryOrderUpdate")
	public void QueryOrderUpdate(String ORDER_SN, HttpServletResponse response) {
		try{
			Long order_sn = Long.parseLong(ORDER_SN);
			HashMap<String,Object> order = orderService.selOrderbySN(order_sn);
			ajaxOutput(response, JsonUtils.objectToJson(order));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/UpdateLogtc")
	public void UpdateLogtc(String LOGTC_SN,String LOGTC_ID,String LOGTC_SEND,String RECEIVER_ADDRESS,String RECEIVER_PHONE,String REMARK,HttpServletResponse response) {
		try{
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("LOGTC_SN", LOGTC_SN);
			map.put("LOGTC_ID", LOGTC_ID);
			map.put("LOGTC_SEND", LOGTC_SEND);
			map.put("RECEIVER_ADDRESS", RECEIVER_ADDRESS);
			map.put("RECEIVER_PHONE", RECEIVER_PHONE);
			map.put("REMARK", REMARK);
			
			orderService.UpdateLogtc(map);
			
			JSONObject result = new JSONObject();
			result.put("info", "succedd");
			ajaxOutput(response, result.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/export")
	public void export(String ORDER_SN, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(StringUtils.isNotEmpty(ORDER_SN)){
			Long order_sn = Long.parseLong(ORDER_SN);
			
			HashMap<String,Object> order = GetDetail(order_sn);
			byte[] resultSetToExcel = new byte[0];
			String xlsFileName = "订单详情_" + order.get("ORDER_NUM").toString() + ".xls";
			resultSetToExcel = resultSetToExcel(xlsFileName, order);
			DownloadUtils.setDownloadHeader(xlsFileName, request, response);
			response.getOutputStream().write(resultSetToExcel);
		}
	}
	
	/**
	 *
	 * *
	 * @param filePath
	 * @param sheetName
	 * @param list
	 * @throws Exception
	 */
	private byte[] resultSetToExcel(String sheetName, HashMap<String,Object> map) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		sheet.setColumnWidth(0,colum_width);
		sheet.setColumnWidth(1,colum_width);
		sheet.setColumnWidth(2,colum_width);
		workbook.setSheetName(0, sheetName);
		
		HSSFRow row;
		HSSFCell cell = null;
		HSSFCellStyle cellStyle = null;
		/*HSSFFont font = workbook.createFont();
		font.setColor(HSSFFont.COLOR_NORMAL);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); */
		int index = -1;
		for (Map.Entry<String, String> entry : Colum_Name.entrySet()) {
			// 写入各条记录，每条记录对应Excel中的一行
			
			String key = entry.getKey();
			//1
			row = sheet.createRow((short) ++index);
			row.setHeight(colum_height);
			cell = row.createCell((short) 0);
			cellStyle = cell.getCellStyle();
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(entry.getValue());
			
			if(!key.equals("detail")){
				//2
				cell = row.createCell((short) 1);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				Object value = map.get(key);
				if(value!=null){
					String _value = value.toString();
					if(key.equals("STATUS")){
						if(_value.equals("1")){
							_value = "待付款";
						}else if(_value.equals("2")){
							_value = "已付款";
						}else if(_value.equals("3")){
							_value = "待付尾款";
						}
					}else if(key.equals("LOGTC_SEND")){
						if(_value.equals("0")){
							_value = "未发货";
						}else if(_value.equals("1")){
							_value = "已发货";
						}
					}else if(key.equals("total_trans_type")||key.equals("first_trans_type")||key.equals("final_trans_type")){
						if(_value.equals("1")){
							_value = "微信支付";
						}else if(_value.equals("2")){
							_value = "连连认证支付";
						}else if(_value.equals("2")){
							_value = "信用卡支付";
						}
					}
					cell.setCellValue(_value);
				}
			}else{
				HashMap<String,Object> detail_map = (HashMap<String,Object>)map.get(key);
				for(Map.Entry<String, Object> detail : detail_map.entrySet()){
					HashMap<String,Object> _package = (HashMap<String,Object>)detail.getValue();
					String name = _package.get("name").toString();
					List<HashMap<String,Object>> product_list = (List<HashMap<String,Object>>)_package.get("child");
					
					row = sheet.createRow((short) ++index);
					row.setHeight(colum_height);
					sheet.addMergedRegion(new CellRangeAddress(index, index, 0, 3));
					cell = row.createCell((short) 0);
					cellStyle = cell.getCellStyle();
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(name);
					
					row = sheet.createRow((short) ++index);
					row.setHeight(colum_height);
					cell = row.createCell((short) 0);
					cellStyle = cell.getCellStyle();
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue("产品名称");
					
					cell = row.createCell((short) 1);
					cellStyle = cell.getCellStyle();
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue("产品编号");
					
					cell = row.createCell((short) 2);
					cellStyle = cell.getCellStyle();
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue("件数");
					
					for(HashMap<String,Object> product : product_list){
						row = sheet.createRow((short) ++ index);
						row.setHeight(colum_height);
						int _index = -1;
						for(Map.Entry<String, String> product_entry : Product_Colum.entrySet()){
							String product_key = product_entry.getKey();
							
							cell = row.createCell((short) ++_index);
							cellStyle = cell.getCellStyle();
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
							cell.setCellValue(product.get(product_key).toString());
						}
					}
				}
			}
		}
		ByteArrayOutputStream fOut = new ByteArrayOutputStream();
		workbook.write(fOut);
		fOut.flush();
		fOut.close();
		return fOut.toByteArray();
	}
}
