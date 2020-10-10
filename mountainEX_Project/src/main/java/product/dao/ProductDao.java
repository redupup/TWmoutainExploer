package product.dao;

import product.model.ProductBean;

public interface ProductDao {
	// 依bookID來刪除單筆記錄
		int deleteProduct(String name);

		// 依bookID來查詢單筆記錄
		ProductBean getProduct(String name);
		
		
		// 新增一筆記錄
		int saveProduct(ProductBean bean);

		
	    void setSelected(String selected);

}
