package product.service;

import java.util.List;

import product.model.ClassBean;
import product.model.ProductBean;

public interface ProductService {
	// 依name來刪除單筆記錄
		int deleteProduct(String name);
		
		// 依name來查詢單筆記錄
		ProductBean getProduct(String name);

		// 取出所有的類型
		
		List<ProductBean> getProducts();
		
		List<ClassBean> getClassList();
		
		// 新增一筆記錄
		int saveProduct(ProductBean bean);

		void setSelected(String selected);


}
