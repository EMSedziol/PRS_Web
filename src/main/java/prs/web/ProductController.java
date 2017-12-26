package prs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.Product;
import prs.domain.ProductRepository;
import prs.domain.User;
import prs.util.PRSMaintenanceReturn;

@Controller
@RequestMapping(path="/Product")
public class ProductController extends BaseController  {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping(path="/Get") 
	public @ResponseBody List<Product> getProduct (@RequestParam int id) {
		Product p = productRepository.findOne(id);
		return BaseController.getReturnArray(p);
	}
	
	@PostMapping(path="/Add") // Map ONLY GET Requests
	public @ResponseBody PRSMaintenanceReturn addNewProduct (@RequestBody Product product) {
		try {
			productRepository.save(product);
			System.out.println("User has been saved " + product);
		} catch (Exception e) {
			product = null;
			System.out.println("User saved:  "+ product);
		}
		return PRSMaintenanceReturn.getMaintReturn(product);
	}
	
	/*@GetMapping(path="/Delete")
	public @ResponseBody String getDelete(@RequestParam int id) {
		
		String msg = "";
		try {
			productRepository.delete(id);
			msg = "  id " + id + " was deleted";
		}
		catch (EmptyResultDataAccessException exc) {
			msg = "  id " + id + " was NOT deleted";
		}
		return msg;
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody Product addNewProduct (@RequestBody Product product) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
		// 
		// http://localhost:8080/Product/Add  - used in Postman
		//
        productRepository.save(product);
        System.out.println("Product saved:  "+product);
        return product;
    }
*/
}
