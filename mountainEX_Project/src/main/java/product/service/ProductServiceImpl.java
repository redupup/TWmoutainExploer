package product.service;

import java.util.List;

import product.dao.impl.ProductDao_Jdbc;
import product.model.ClassBean;
import product.model.ProductBean;


public class ProductServiceImpl implements ProductService {
    
    ProductDao_Jdbc dao;
    
	public ProductServiceImpl() {
		this.dao = new ProductDao_Jdbc();
	}

	@Override
	public List<ProductBean> getProducts() {
		// TODO Auto-generated method stub
		return dao.getProducts();
	}

	@Override
	public List<ClassBean> getClassList() {
		// TODO Auto-generated method stub
		return dao.getClassList();
	}

	@Override
	public int deleteProduct(String name) {
		return dao.deleteProduct(name);
	}

	@Override
	public ProductBean getProduct(String name) {
		return dao.getProduct(name);
	}

	@Override
	public int saveProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.saveProduct(bean);
	}

	@Override
	public void setSelected(String selected) {
		dao.setSelected(selected);
	}

}