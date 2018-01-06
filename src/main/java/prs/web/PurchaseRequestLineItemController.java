package prs.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import prs.domain.PurchaseRequestLineItemRepository;
import prs.domain.PurchaseRequest;
import prs.domain.PurchaseRequestLineItem;
import prs.util.PRSMaintenanceReturn;

@CrossOrigin
@Controller
@RequestMapping(path="/PRLI")

public class PurchaseRequestLineItemController extends BaseController {

	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllLineItems() {
		// This returns a JSON or XML with the users
		return purchaseRequestLineItemRepository.findAll();
	}
	
	@GetMapping(path="/Get") 
	public @ResponseBody List<PurchaseRequestLineItem> getPurchaseRequestLineItem (@RequestParam int id) {
		PurchaseRequestLineItem prli = purchaseRequestLineItemRepository.findOne(id);
		return getReturnArray(prli);

	}
 
	@PostMapping(path="/Add")
	public @ResponseBody PRSMaintenanceReturn addNewPurchaseRequestLineItem (@RequestBody PurchaseRequestLineItem purchaseRequestLineItem,
			HttpServletRequest req) {
		try {
			purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
			System.out.println("PurchaseRequestLineItem added:  "+purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
			System.out.println("error" + e);
		}
		System.out.println("PurchaseRequestLineItem saved:  "+purchaseRequestLineItem);
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}
	
	@GetMapping(path="/Delete") // Map ONLY GET Requests
	public @ResponseBody PurchaseRequestLineItem deletePurchaseRequestLineItem (@RequestParam int id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		PurchaseRequestLineItem purchaseRequestLineItem = purchaseRequestLineItemRepository.findOne(id);
		purchaseRequestLineItemRepository.delete(purchaseRequestLineItem);
		return purchaseRequestLineItem;
	}
	
	@GetMapping(path="/Remove") 
	public @ResponseBody PRSMaintenanceReturn deletePurchaseRequest (@RequestParam int id) {
		PurchaseRequestLineItem purchaseRequestLineItem = purchaseRequestLineItemRepository.findOne(id);
		try {
			purchaseRequestLineItemRepository.delete(purchaseRequestLineItem);
			System.out.println("PurchaseRequest saved:  "+purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}
	
}
