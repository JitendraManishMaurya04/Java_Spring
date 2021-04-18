package com.mySpringPorject.rest.webservices.restfulwebservices.filteringBeanAttributes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.FilterExceptFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringBeanController {
	
	
	@GetMapping("/filtering")
	public MappingJacksonValue retreiveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		Set<String> filterSet = new HashSet<>();
		filterSet.add("field1");
		filterSet.add("field3");
		
		SimpleBeanPropertyFilter filters = new SimpleBeanPropertyFilter
				.FilterExceptFilter(filterSet);
		FilterProvider filterRes = new SimpleFilterProvider().addFilter("someBeanFilter", filters);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filterRes);
		
		return mapping;
	}

	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retreiveSomeBeanList() {
		List<SomeBean> someBeanList =  Arrays.asList( new SomeBean("value1","value2","value3")
				,new SomeBean("Hey1","Hey2","Hey3"));
		
		
		Set<String> filterSet = new HashSet<>();
		filterSet.add("field1");
		filterSet.add("field2");
		
		SimpleBeanPropertyFilter filters = new SimpleBeanPropertyFilter
				.FilterExceptFilter(filterSet);
		FilterProvider filterRes = new SimpleFilterProvider().addFilter("someBeanFilter", filters);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
		mapping.setFilters(filterRes);
		
		return mapping;
	}

}
