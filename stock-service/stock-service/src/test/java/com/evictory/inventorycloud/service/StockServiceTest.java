package com.evictory.inventorycloud.service;
import java.util.Collection;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.evictory.inventorycloud.StockServiceApplicationTests;
import com.evictory.inventorycloud.modal.Stock;



@Transactional
public class StockServiceTest extends StockServiceApplicationTests{

	@Autowired
	private StockServiceImpl stockServiceImpl;
	
	@Before
	public void setUp() {
		//stockServiceImpl.getClass();
}
	@Test
	public void testFetchAll() {
		
		Collection<Stock> list=stockServiceImpl.fetchAll();
		Assert.assertNotNull("failure exxpected", list);
		Assert.assertEquals("failure expected size", 2, list.size());

	}
	
	 @Test
	    public void testCreate() {

	        Stock entity = new Stock();
	        entity.setReason("hfhfj");
	        entity.setUser(2);
	        entity.setId(9);
	        //entity.setDate();
	        

	      Stock createdEntity = stockServiceImpl.saveEntry(entity);

	        Assert.assertNotNull("failure - expected not null", createdEntity);
	        Assert.assertNotNull("failure - expected id attribute not null",
	                createdEntity.getId());
	        Assert.assertEquals("failure - expected text attribute match", "test",
	                createdEntity.getReason());

	        Collection<Stock> list = stockServiceImpl.fetchAll();

	        Assert.assertEquals("failure - expected size", 3, list.size());

	}
	 @Test
	    public void testUpdate() {

	        Integer id = 1;
	        Stock stock=new Stock();

	       Stock entity = stockServiceImpl.updateEntry(id, stock);

	        Assert.assertNotNull("failure - expected not null", entity);

	        String updatedText = entity.getReason() + " test";
	        entity.setReason(updatedText);
	        Stock updatedEntity = stockServiceImpl.updateEntry(id, stock);

	        Assert.assertNotNull("failure - expected not null", updatedEntity);
	        Assert.assertEquals("failure - expected id attribute match", id,
	                updatedEntity.getId());
	        Assert.assertEquals("failure - expected text attribute match",
	                updatedText, updatedEntity.getReason());

	}
	 
	 @Test
	    public void testDelete() {

	    Integer id = 1;

	    Stock entity = stockServiceImpl.fetchEntry(id);

	        Assert.assertNotNull("failure - expected not null", entity);

	        stockServiceImpl.deleteEntry(id);

	        Collection<Stock> list = stockServiceImpl.fetchAll();

	        Assert.assertEquals("failure - expected size", 1, list.size());

	        Stock deletedEntity = stockServiceImpl.fetchEntry(id);

	        Assert.assertNull("failure - expected null", deletedEntity);

	    }

	
	
}
