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
import com.firstdata.globalgatewaye4.TaxType;
import com.google.gson.Gson;

public class LineItemTest {
	private GlobalGatewayE4 e4;
	private Gson gson;
	private Request request;
	private LineItem lineItemResponse;
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
		Response response = gson.fromJson(lineItemResponseString, Response.class);
		this.lineItemResponse = response.level3().getLine_items().get(0);
	}
	
	@Test
	public void testRequestLineItemCommodityCode() {
		assertTrue(requestJson.contains("\"commodity_code\":\"abc\""));
	}
	
	@Test
	public void testRequestLineItemDescription() {
		assertTrue(requestJson.contains("\"description\":\"test item\""));
	}
	
	@Test
	public void testRequestLineItemDiscountAmount() {
		assertTrue(requestJson.contains("\"discount_amount\":0.00"));
	}
	
	@Test
	public void testRequestLineItemDiscountIndicator() {
		assertTrue(requestJson.contains("\"discount_indicator\":false"));
	}
	
	@Test
	public void testRequestLineItemGrossNetIndicator() {
		assertTrue(requestJson.contains("\"gross_net_indicator\":false"));
	}
	
	@Test
	public void testRequestLineItemLineItemTotal() {
		assertTrue(requestJson.contains("\"line_item_total\":1.00"));
	}
	
	@Test
	public void testRequestLineItemProductCode() {
		assertTrue(requestJson.contains("\"product_code\":\"ABC123\""));
	}
	
	@Test
	public void testRequestLineItemQuantity() {
		assertTrue(requestJson.contains("\"quantity\":\"1\""));
	}
	
	@Test
	public void testRequestLineItemTaxAmount() {
		assertTrue(requestJson.contains("\"tax_amount\":0.00"));
	}
	
	@Test
	public void testRequestLineItemTaxRate() {
		assertTrue(requestJson.contains("\"tax_rate\":0.00"));
	}
	
	@Test
	public void testRequestLineItemTaxType() {
		assertTrue(requestJson.contains("\"tax_type\":\"4\""));
	}
	
	@Test
	public void testRequestLineItemUnitCost() {
		assertTrue(requestJson.contains("\"unit_cost\":1.00"));
	}
	
	@Test
	public void testRequestLineItemUnitOfMeasure() {
		assertTrue(requestJson.contains("\"unit_of_measure\":\"EA\""));
	}
	
	private final String lineItemResponseString = "{" + 
		"\"level3\":{" + 
			"\"line_items\":" + 
				"[{\"product_code\":\"ABC123\"," + 
				"\"description\":\"test item\"," +
				"\"quantity\":\"1.0\"," +
				"\"unit_of_measure\":\"EA\"," +
				"\"tax_rate\":\"0.0\"," +
				"\"tax_amount\":\"0.0\"," +
				"\"unit_cost\":\"1.0\"," +
				"\"gross_net_indicator\":false," +
				"\"line_item_total\":\"1.0\"," +
				"\"discount_amount\":\"0.0\"," +
				"\"discount_indicator\":false," +
				"\"commodity_code\":\"abc\"," +
				"\"tax_type\":\"4\"}]}}";
	
	@Test
	public void testResponseLineItemProductCode() {
		assertEquals(lineItemResponse.getProduct_code(),"ABC123");
	}
	
	@Test
	public void testResponseLineItemDescription() {
		assertEquals(lineItemResponse.getDescription(),"test item");
	}
	
	@Test
	public void testResponseLineItemQuantity() {
		assertEquals(lineItemResponse.getQuantity(),"1.0");
	}
	
	@Test
	public void testResponseLineItemUnitOfMeasure() {
		assertEquals(lineItemResponse.getUnit_of_measure(),"EA");
	}
	
	@Test
	public void testResponseLineItemTaxRate() {
		assertEquals(lineItemResponse.getTax_rate(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLineItemTaxAmount() {
		assertEquals(lineItemResponse.getTax_amount(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLineItemUnitCost() {
		assertEquals(lineItemResponse.getUnit_cost(),new BigDecimal("1.0"));
	}
	
	@Test
	public void testResponseLineItemGrossNetIndicator() {
		assertEquals(lineItemResponse.getGross_net_indicator(),false);
	}
	
	@Test
	public void testResponseLineItemLineItemTotal() {
		assertEquals(lineItemResponse.getLine_item_total(),new BigDecimal("1.0"));
	}
	
	@Test
	public void testResponseLineItemDiscountAmount() {
		assertEquals(lineItemResponse.getDiscount_amount(),new BigDecimal("0.0"));
	}
	
	@Test
	public void testResponseLineItemDiscountIndicator() {
		assertEquals(lineItemResponse.getDiscount_indicator(),false);
	}
	
	@Test
	public void testResponseLineItemCommodityCode() {
		assertEquals(lineItemResponse.getCommodity_code(),"abc");
	}
	
	@Test
	public void testResponseLineItemTaxType() {
		assertEquals(lineItemResponse.getTax_type(),TaxType.LocalSalesTax);
	}
}
