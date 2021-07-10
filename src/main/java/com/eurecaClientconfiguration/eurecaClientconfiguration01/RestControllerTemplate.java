package com.eurecaClientconfiguration.eurecaClientconfiguration01;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestControllerTemplate {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getAllTicket/{id}")
	public ResponseEntity<List<Ticket>> getListOfBook(@PathVariable("id") String author) {

		HttpHeaders header = new HttpHeaders();

		ParameterizedTypeReference<List<Ticket>> typeRef = new ParameterizedTypeReference<List<Ticket>>() {
		};
		System.out.println("test one");
		
		 ResponseEntity<List<Ticket>> responseEntity = restTemplate
		 .exchange("http://ticketbookmanagement/ticketbookmanagement/user/allticket", HttpMethod.GET, null,
		  typeRef); 
		 
		 List<Ticket> li = responseEntity.getBody();
		 
		 List<Ticket> finallist=li.stream().filter(x->x.getTicketfare()>300).collect(Collectors.toList());
		return new ResponseEntity<List<Ticket>>(finallist, HttpStatus.OK);

	}

}
