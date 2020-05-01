package com.example.gate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gate.exception.ResourceNotFoundException;
import com.example.gate.model.Customer;
import com.example.gate.repository.CustRepo;


@RestController
@RequestMapping("/walletApp")
@CrossOrigin(origins = "*")
public class CustContoller {
	
	@Autowired
	private CustRepo custRepo;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return custRepo.findAll();
	}
	
	@GetMapping("/getCustomers/{aadharNo}")
	public ResponseEntity<Customer> getCustomerByAadharNo(@PathVariable(value="aadharNo") Long custAadharNo) throws ResourceNotFoundException{
		
		Customer cust = custRepo.findById(custAadharNo).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + custAadharNo));
		
		return ResponseEntity.ok().body(cust);
	}
	
	@PostMapping("/customers")
	public Customer createCust(@Valid @RequestBody Customer cust) {
		return custRepo.save(cust);
		
	}

	@PutMapping("/updateCustomers/{aadharNo}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="aadharNo") Long custAadharNo, @Valid @RequestBody Customer custDetails) throws ResourceNotFoundException {
		
		Customer cust = custRepo.findById(custAadharNo).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + custAadharNo));
		
		cust.setEmailId(custDetails.getEmailId());
		cust.setCustName(custDetails.getCustName());
		cust.setMobileNo(custDetails.getMobileNo());
		
		final Customer updatedCust = custRepo.save(cust);
		
		return ResponseEntity.ok(updatedCust);
		
	}
	
	
	@DeleteMapping("/deleteCustomers/{aadharNo}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="aadharNo") Long custAadharNo) throws ResourceNotFoundException{
		
		Customer cust = custRepo.findById(custAadharNo).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + custAadharNo));
		
		custRepo.delete(cust);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}
}
