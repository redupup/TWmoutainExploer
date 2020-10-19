package product.service;

import java.util.List;

import product.model.ClassBean;
import product.model.ProductBean;

public interface IProductService {
	
		//查詢所有	
		public List<ProductBean> getProducts();
	
		// 依name來刪除單筆記錄
		int deleteProduct(String name);
		
		// 依name來查詢單筆記錄
//		ProductBean getProduct(String name);

		// 新增一筆記錄
		int saveProduct(ProductBean bean);

		// 修改一筆資料
		public int updateProduct(ProductBean bean);

		// 取出所有的類型
		
		public List<ClassBean> getClassList();
		
}
