package com.SnapDeals.Tests;

import org.testng.annotations.Test;

import com.SnapDeals.Base.BaseTest;
import com.SnapDeals.Pages.MenSelection;

public class MenSelectionTest extends BaseTest {
	
	@Test
    public void testHoverAndClickShoes() throws InterruptedException {
        MenSelection ms = new MenSelection(driver);
        Thread.sleep(3000);
        ms.hoverAndClickSunGlasses();
        ms.selectPriceRange(150, 1500);
        ms.applyFilters();
        ms.selectItem();
        System.out.println(driver.getCurrentUrl());
        ms.addToCart();
        
    }
	
}
