package com.firstdata.globalgatewaye4.integrationtest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.globalgatewaye4.Environment;
import com.firstdata.globalgatewaye4.GlobalGatewayE4;
import com.firstdata.globalgatewaye4.LevelThree;
import com.firstdata.globalgatewaye4.LineItem;
import com.firstdata.globalgatewaye4.Request;
import com.firstdata.globalgatewaye4.Response;
import com.firstdata.globalgatewaye4.ShipToAddress;
import com.firstdata.globalgatewaye4.TaxType;
import com.google.gson.Gson;

public class LevelThreeTest {
	private GlobalGatewayE4 e4;
	private Gson gson;
	private Request request;
	private Response levelThreeResponse;
	private String requestJson;
	
	private Request populateRequestData(GlobalGatewayE4 e4) {
		Request request = e4.getRequest();
		LevelThree levelThree = new LevelThree();
		LineItem lineItem = new LineItem();
		ArrayList<LineItem> items = levelThree.line_items();
		items.add(lineItem
				.commodity_code("abc")
				.description("test item")
				.discount_amount(new BigDecimal("0.00"))
				.discount_indicator(false)
				.gross_net_indicator(false)
				.line_item_total(new BigDecimal("1.00"))
				.product_code("ABC123")
				.quantity("1")
				.tax_amount(new BigDecimal("0.00"))
				.tax_rate(new BigDecimal("0.00"))
				.tax_type(TaxType.LocalSalesTax)
				.unit_cost(new BigDecimal("1.00"))
				.unit_of_measure("EA"));
		
		levelThree
			.alt_tax_amount(new BigDecimal("0.00"))
			.alt_tax_id("90210")
			.discount_amount(new BigDecimal("0.00"))
			.duty_amount(new BigDecimal("0.00"))
			.freight_amount(new BigDecimal("0.00"))
			.ship_from_zip("38016")
			.tax_amount(new BigDecimal("0.00"))
			.tax_rate(new BigDecimal("0.00"));
		
		request.level3(levelThree);
		
		return request;
	}

	@Before
	public void createGateway() {
		this.e4 = new GlobalGatewayE4(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.gson = e4.getGson();
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
		this.levelThreeResponse = gson.fromJson(levelThreeResponseString, Response.class);
	}

	@Test
	public void testRequestLevelThreeAltTaxAmount() {
		assertTrue(requestJson.contains("\"alt_tax_amount\":0.00"));
	}
	
	@Test
	public void testRequestLevelThreeAltTaxId() {
		assertTrue(requestJson.contains("\"alt_tax_id\":\"90210\""));
	}
	
	@Test
	public void testRequestLevelThreeDiscountAmount() {
		assertTrue(requestJson.contains("\"discount_amount\":0.00"));
	}
	
	@Test
	public void testRequestLevelThreeDutyAmount() {
		assertTrue(requestJson.contains("\"duty_amount\":0.00"));
	}
	
	@Test
	public void testRequestLevelThreeFreightAmount() {
		assertTrue(requestJson.contains("\"freight_amount\":0.00"));
	}
	
	@Test
	public void testRequestLevelThreeShipFromZip() {
		assertTrue(requestJson.contains("\"ship_from_zip\":\"38016\""));
	}
	
	@Test
	public void testRequestLevelThreeTaxAmount() {
		assertTrue(requestJson.contains("\"tax_amount\":0.00"));
	}
	
	@Test
	public void testRequestLevelThreeTaxRate() {
		assertTrue(requestJson.contains("\"tax_rate\":0.00"));
	}

	private final String levelThreeResponseString = "{" + 
			"\"level3\":{" + 
				"\"discount_amount\":\"0.0\"," +
				"\"duty_amount\":\"0.0\"," + 
				"\"freight_amount\":\"0.0\"," + 
				"\"ship_from_zip\":\"38016\"," + 
				"\"tax_amount\":\"0.0\"," + 
				"\"tax_rate\":\"0.0\"," + 
				"\"alt_tax_id\":\"90210\"," + 
				"\"alt_tax_amount\":\"0.0\"," + 
				"\"ship_to_address\":" + 
					"{}," + 
				"\"line_items\":" + 
					"[{}]}}";
	
	@Test
	public void testResponseLevelThreeClass() {
		assertEquals(levelThreeResponse.level3().getClass(),LevelThree.class);
	}
	
	@Test
	public void testResponseLevelThreeShipToAddressClass() {
		assertEquals(levelThreeResponse.level3().getShip_to_address().getClass(),ShipToAddress.class);
	}
	
	@Test
	public void testResponseLevelThreeLineItemClass() {
		assertEquals(levelThreeResponse.level3().getLine_items().get(0).getClass(),LineItem.class);
	}
	
	@Test
	public void testResponseLevelThreeDiscountAmount() {
		assertEquals(levelThreeResponse.level3().getDiscount_amount(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLevelThreeDutyAmount() {
		assertEquals(levelThreeResponse.level3().getDuty_amount(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLevelThreeFreightAmount() {
		assertEquals(levelThreeResponse.level3().getFreight_amount(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLevelThreeShipFromZip() {
		assertEquals(levelThreeResponse.level3().getShip_from_zip(),"38016");
	}
	
	@Test
	public void testResponseLevelThreeTaxAmount() {
		assertEquals(levelThreeResponse.level3().getTax_amount(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLevelThreeTaxRate() {
		assertEquals(levelThreeResponse.level3().getTax_rate(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLevelThreeAltTaxId() {
		assertEquals(levelThreeResponse.level3().getAlt_tax_id(),"90210");
	}
	
	@Test
	public void testResponseLevelThreeAltTaxAmount() {
		assertEquals(levelThreeResponse.level3().getAlt_tax_amount(),new BigDecimal("0.0"));
	}
}
