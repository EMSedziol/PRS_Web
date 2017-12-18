package prs.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import prs.domain.PurchaseRequestLineItemRepository;
import prs.domain.*;

@Controller
@RequestMapping(path="/PRLineItem")

public class PurchaseRequestLineItemController {

	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllLineItems() {
		// This returns a JSON or XML with the users
		return purchaseRequestLineItemRepository.findAll();
	}
	
	@PostMapping(path="/Add") // Map ONLY GET Requests
	public @ResponseBody PurchaseRequestLineItem addNewPurchaseRequestLineItem (@RequestBody PurchaseRequestLineItem purchaseRequestLineItem,
			HttpServletRequest req) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
		System.out.println("PurchaseRequestLineItem saved:  "+purchaseRequestLineItem);
		return purchaseRequestLineItem;
	}
	
	@PostMapping(path="/AddString") // Map ONLY GET Requests
	public @ResponseBody PurchaseRequestLineItem addNewPurchaseRequestLineItem (@RequestBody String purchaseRequestLineItem) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		PurchaseRequestLineItem prli = getInputJson(PurchaseRequestLineItem.class, purchaseRequestLineItem);
		purchaseRequestLineItemRepository.save(prli);
		System.out.println("PurchaseRequestLineItem saved:  "+prli);
		return prli;
	}
	
	@GetMapping(path="/Remove") // Map ONLY GET Requests
	public @ResponseBody PurchaseRequestLineItem deletePurchaseRequestLineItem (@RequestParam int id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		PurchaseRequestLineItem purchaseRequestLineItem = purchaseRequestLineItemRepository.findOne(id);
		purchaseRequestLineItemRepository.delete(purchaseRequestLineItem);
		return purchaseRequestLineItem;
	}
	
	
	public <PurchaseRequestLineItem> PurchaseRequestLineItem getInputJson(
		    //final String trackId,
		    final Class<PurchaseRequestLineItem> inputJsonClass,
		    final String inputJsonString)
		{
			PurchaseRequestLineItem returnValue;

		    try
		    {
		    	ObjectMapper om = new ObjectMapper();
		        returnValue = om.readValue(
		            inputJsonString,
		            inputJsonClass);
		    }
		    catch (IOException exception)
		    {
		        //final String logId = CoreUtil.getLogId(trackId);

		        System.out.println(
		            "{}exception while converting inputJson.  inputJsonClass.name: {}, inputJsonString: {}\n"+
		            //logId,
		            inputJsonClass.getName()+"\n"+
		            inputJsonString);

		        returnValue = null;
		    }

		    return returnValue;
		}
}
