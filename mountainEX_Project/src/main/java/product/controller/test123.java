package product.controller;

import java.util.List;

import product.model.ProductBean;
import product.service.ProductService;
import product.service.ProductServiceImpl;

public class test123 {

	public static void main(String[] args) {
		ProductService service = new ProductServiceImpl();
//		request.setAttribute("baBean", service);
		List<ProductBean> coll = service.getProducts();
		System.out.println(coll);

	}

}
