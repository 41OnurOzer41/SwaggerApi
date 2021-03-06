package staj.proje.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import staj.proje.DataAcccess.IProductDal;
import staj.proje.Entities.Product;

@Service
public class ProductManager implements IProductService{
	
	private IProductDal productDal;

	@Autowired
	public ProductManager(IProductDal productDal) {
		super();
		this.productDal = productDal;
	}
	
	
	@Override
	@Transactional
	public List<Product> getAll() {
		
		return  productDal.findAll();
	}

	
	
	@Override
	@Transactional
	public void update(Product product) {
		productDal.save(product);
		
	}


	@Override
	@Transactional
	public void add(Product product) {
		productDal.save(product);//update yapıyor add yapmıyor jpa reporostory de delete,update,findall var creat veya add yok. 
		
	}
	
	
	
	@Override
	public void delete(Product id) {
		productDal.delete(id);//delete 500 hatası veriyor
		
	}


	@Override
	@Transactional
	public List<Product> getByProductName(String productName) {
		  return (List<Product>) this.productDal.getByProductName(productName) ;
	}

	@Override
	@Transactional
	public List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return (List<Product>) this.productDal.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}

	@Override
	@Transactional
	public List<Product> getByProductNameOrCategory(String productName, int categoryId) {
		return (List<Product>)this.productDal.getByProductNameOrCategory(productName, categoryId);
	}

	@Override
	@Transactional
	public List<Product> getByCategoryIn(List<Integer> categories) {
		return (List<Product>) this.productDal.getByCategoryIn(categories);
	}

	@Override
	@Transactional
	public List<Product> getByProductNameContains(String productName) {
		return (List<Product>)this.productDal.getByProductNameContains(productName);
	}

	@Override
	@Transactional
	public List<Product> getByProductNameStartsWith(String productName) {
		return (List<Product>) this.productDal.getByProductNameStartsWith(productName);
	}

	@Override
	@Transactional
	public List<Product> getByNameAndCategory(String productName, int categoryId) {
		return (List<Product>)this.productDal.getByNameAndCategory(productName, categoryId);
	}

}
