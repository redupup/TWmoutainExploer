package product.dao;

import java.util.List;

import product.model.ProductBean;

public interface ProductDao {
	
	//列出Products
		List<ProductBean> getProducts();
	
	// 依name來刪除單筆記錄
		int deleteProduct(String name);

		// 依name來查詢單筆記錄
		ProductBean getProduct(String name);
		
		
		// 新增一筆記錄
		int saveProduct(ProductBean bean);

		
	    void setSelected(String selected);

}
