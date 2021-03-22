package fi.kesko.factory.controller;

import fi.kesko.factory.model.CheapestCombination;
import fi.kesko.factory.model.CustomerRequest;
import fi.kesko.factory.service.FactoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FactoryController.class)
@WithMockUser
public class FactoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FactoryService service;

	@Test
	public void retrieveSampleGivenTest() throws Exception {
		String requestJson = "{\"count\":150,\"barPrice\":2.3,\"packPrice\":25,\"boxPrice\":230,\"packSize\":12,\"boxSize\":120}";

		CheapestCombination mockCheapestCombination = new CheapestCombination(1, 2, 6, 293.8f);
		Mockito.when(service.getCheapestPriceCombo(Mockito.any(CustomerRequest.class)))
				.thenReturn(mockCheapestCombination);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/price")
				.accept(MediaType.APPLICATION_JSON)
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"boxCount\":1,\"packCount\":2,\"barCount\":6,\"totalPrice\":293.8}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	@Test
	public void additionalTest() throws Exception {
		String requestJson = "{\"count\":895,\"barPrice\":2.5,\"packPrice\":80,\"boxPrice\":400,\"packSize\":40,\"boxSize\":200}";

		CheapestCombination mockCheapestCombination = new CheapestCombination(4, 2, 15, 1797.5f);
		Mockito.when(service.getCheapestPriceCombo(Mockito.any(CustomerRequest.class)))
				.thenReturn(mockCheapestCombination);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/price")
				.accept(MediaType.APPLICATION_JSON)
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"boxCount\":4,\"packCount\":2,\"barCount\":15,\"totalPrice\":1797.5}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
