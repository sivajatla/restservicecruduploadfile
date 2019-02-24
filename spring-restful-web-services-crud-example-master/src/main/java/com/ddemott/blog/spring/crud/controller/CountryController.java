package com.ddemott.blog.spring.crud.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ddemott.blog.spring.crud.domain.Country;
import com.ddemott.blog.spring.crud.service.CountryService;

@RestController
//@MultipartConfig(maxFileSize=20971520)
public class CountryController {

	private CountryService countryService = new CountryService();

	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@RequestParam("id") int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}

	@RequestMapping(value = "/country", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@RequestParam("id") int id) {
		countryService.deleteCountry(id);
	}
	
	@RequestMapping(value="/uploadFile",method = RequestMethod.POST)
	public boolean uploadFile(@RequestBody MultipartFile uploadTechData){
		System.out.println("inside uploadfile");
		return true;
		
	}
	
	/*@RequestMapping(value="/fileName",method = RequestMethod.POST)
	public boolean uploadFileName(@RequestBody String file1){
		System.out.println("inside uploadfileName");
		return true;
		
	}*/
	
}
