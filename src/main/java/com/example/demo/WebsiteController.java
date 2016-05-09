package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Visit;
import com.example.repositories.IVisitRepository;
import com.example.utils.Utils;
import com.example.utils.ValueComparator;

@RestController
public class WebsiteController {

	@Autowired
	private IVisitRepository visitRepository;
	
	@RequestMapping(
			value="/top",
			method = RequestMethod.GET)
	public @ResponseBody Map getTopWebsites(String from, String to, int limit, HttpServletResponse response) {
		List<Visit> visits = new ArrayList<>();
		Map<String, Long> groupedBy = null;
		LinkedHashMap<String, Long> result = new LinkedHashMap<String, Long>();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date fromDate = format.parse(from);
			Date toDate = format.parse(to);
			visits = visitRepository.findByVisitDateBetween(fromDate, toDate);
			groupedBy = visits
					.stream().collect(
							Collectors.groupingBy(
									v -> (String)v.getWebsite().getUrl(), 
									Collectors.summingLong(v -> v.getCount())));
			int counter = 0;
			Comparator<String> comparator = new ValueComparator(groupedBy);
			Map<String, Long> treemap = new TreeMap<String, Long>(comparator);
			treemap.putAll(groupedBy);
			for (Map.Entry<String, Long> entry : treemap.entrySet())
			{
				if(counter++ == limit) {
					break;
				}
				result.put(entry.getKey(), entry.getValue());
			}
		}
		catch(Exception e) {
			try {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return result;
	}
}
