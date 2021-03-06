package staj.proje.Business;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import staj.proje.Entities.Product;


public interface IProductService {
	
	List<Product> getAll();
	
	void add(Product product);
	
	void update(Product product);
	
	void delete(Product id);
	
	List<Product> getByProductName(String productName);

	List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);
	
	List<Product> getByNameAndCategory(String productName, int categoryId);

	
}
