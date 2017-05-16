package Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
	Map<String, Customer> customerDatabase = new HashMap<>();
	
	public void save(Customer customer){
		String id = customer.getId();
		customerDatabase.put(id, customer);
	}
	
	public void deleteById(String id){
//		Customer customer = customerDatabase.get(id);
		customerDatabase.remove(id);
	}


	public Customer findById(String id){
		return this.customerDatabase.get(id);	
	}
	
	
	public List<Customer> findAll(){
//		List<Customer> allCustomers = new ArrayList<Customer>(this.database.values());
		return new ArrayList<Customer>(this.customerDatabase.values());
		
	}
	
	public void printAll() {
		List<Customer> allCustomers = this.findAll();
		for (Customer customer : allCustomers) {
			System.out.println(customer);
		}
	}
}

