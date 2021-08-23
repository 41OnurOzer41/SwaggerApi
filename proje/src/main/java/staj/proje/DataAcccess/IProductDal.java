package staj.proje.DataAcccess;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import staj.proje.Entities.Product;


public interface IProductDal extends JpaRepository<Product, Integer>{
	@Query("select p from Product p")
	List<Product> getAll();
	
	//@Query("insert into Product (id,productName,unitPrice,unitsInStok,quantityPerUnit,category) values (id,productName,unitPrice,unitsInStok,quantityPerUnit,category)")
	//void add(Product product);
	
	//@Query("update Product set id=:id,productName=:productName,unitPrice=:unitPrice,quantityPerUnit=:quantityPerUnit,category=:category where id=:id")
	//void update(Product product);
	
	//@Query("delete from Product where id=:id")
	//void delete(Product id);
	
	@Query("select p from Product p where productName=:productName")
	List<Product>  getByProductName(String productName);

	//@Query("select p from Product p where productName=:productName and categoryId=:categoryId")
	List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	//@Query("select p from Product p where productName=:productName or categoryId=:categoryId")
	List<Product> getByProductNameOrCategory(String productName, int categoryId);

	//@Query("select c from Category c")
	List<Product> getByCategoryIn(List<Integer> categories);

	//@Query("select p from Product p where productName=:productName")
	List<Product> getByProductNameContains(String productName);

	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("select p from Product p where productName=:productName and categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

	

	
}
