package com.SpringBootProject.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {



    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
       SomeBean someBean = new SomeBean("Renuka","Renuka@123", 23);


        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "age");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;


    }

    /* While running this comment JsonFilter from SomeBean class file*/
    @GetMapping("/filtering-List")
    public List<SomeBean> filteringByList(){
        return Arrays.asList(new SomeBean("Renuka","renuka@123", 23),
                new SomeBean("Vanitha","vanitha@111",20),
                new SomeBean("Neethu","Neethu@890",17));
    }

    @GetMapping("/filtering-List2")

    public  MappingJacksonValue filterByList2(){
      List<SomeBean> list=  Arrays.asList(new SomeBean("Renuka","renuka@123", 23),
                new SomeBean("Vanitha","vanitha@111",20),
                new SomeBean("Neethu","Neethu@890",17));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
