package product.controller;

import java.util.Collection;

import product.model.ProductBean;
import product.service.ProductService;
import product.service.ProductServiceImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService service = new ProductServiceImpl();
		Collection<ProductBean> coll = service.getProducts();
		
		System.out.println(coll);

	}

}
