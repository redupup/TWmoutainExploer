package product.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		request.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);
		try {
			String name = "";
			String type = "";
			String priceStr = "";
			double price = 0;
			String imgUrl = "";
			String description = "";
			String secondClass = "";
			int stock = 0;
			// request.getParts()方法傳回一個由javax.servlet.http.Part物件所組成的Collection
			// javax.servlet.http.Part: 代表上傳到Server的資料，可以是正常的表單資料(form data)，
			// 也可以上傳的檔案。
			// Part介面可以:
			// 1. 傳回欄位的名稱(<input>的name屬性)、大小、ContentType
			// 2. 每個Part的Header
			// 3. 刪除Part
			// 4. 將Part寫入硬碟
			Collection<Part> parts = request.getParts();

			//GlobalService.exploreParts(parts, request);
			if (parts != null) { // 如果這是一個上傳資料的表單
				for (Part p : parts) {
					String fldName = p.getName();
//					System.out.println("fldName=" + fldName);
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {   // 表示 p 為一般欄位而非上傳的表單
						// 根據欄位名稱來讀取欄位的內容，然後存入適當的變數內
						if (fldName.equals("name")) {
							name = value;
							if (value == null || name.trim().length() == 0) {
								errorMsgs.put("errName", "必須輸入品名");
							} else {
								request.setAttribute("name", name);
							}
						} else if (fldName.equals("type")) {
							type = value;
							if (type == null || type.trim().length() == 0) {
								errorMsgs.put("errType", "必須輸入類型");
							} else {
								request.setAttribute("type", type);
							}
						} else if (fldName.equals("price")) {
							priceStr = value;
							priceStr = priceStr.trim();
							if (priceStr == null || priceStr.trim().length() == 0) {
								errorMsgs.put("errPrice", "必須輸入價格");
							} else {
								try {
									price = Double.parseDouble(priceStr);
								} catch (NumberFormatException e) {
									errorMsgs.put("errPrice", "價格必須是數值");
								}
							}
							request.setAttribute("price", priceStr);
						} else if (fldName.equals("imgUrl")) {
							imgUrl = value;
							;
							if (imgUrl == null || imgUrl.trim().length() == 0) {
								errorMsgs.put("errimgUrl", "必須輸入imgUrl");
							} else {
								request.setAttribute("imgUrl", imgUrl);
							}
						} else if (fldName.equals("description")) {
							description = value;
							;
							if (description == null || description.trim().length() == 0) {
								errorMsgs.put("errDescription", "必須輸入description");
							}
							request.setAttribute("description", description);
						} else if (fldName.equals("secondClass")) {
							secondClass = value;
							;
							if (secondClass == null || secondClass.trim().length() == 0) {
								errorMsgs.put("errsecondClass", "必須輸入類型");
							}
							request.setAttribute("secondClass", secondClass);

						}}
			
			
		}
	}
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
	}


