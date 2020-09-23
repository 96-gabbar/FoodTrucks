package com.sage.FoodTrucks.utilities;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sage.FoodTrucks.pojo.Response;

public class Utilities {

	public static Response xmlToObject(String xml) throws JAXBException {
		StringReader sr = new StringReader(xml);
		JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Response response = (Response) unmarshaller.unmarshal(sr);
		return response;
	}
}
