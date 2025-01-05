package com.oracle.itcdropwizard.resources;

import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoinResourceTest {

    @Test
    public void testCalculateMinimumCoins() {
        CoinResource resource = new CoinResource();
        List<Double> denominations = Arrays.asList(0.01, 0.5, 1.0, 5.0, 10.0);
        Response response = resource.calculateMinimumCoins(7.03, denominations);
        List<Double> expected = Arrays.asList(5.0, 1.0, 1.0, 0.01, 0.01, 0.01);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expected, response.getEntity());
    }

    @Test
    public void testCalculateMinimumCoinsWithDifferentDenominations() {
        CoinResource resource = new CoinResource();
        List<Double> denominations = Arrays.asList(1.0, 2.0, 50.0);
        Response response = resource.calculateMinimumCoins(103.0, denominations);
        List<Double> expected = Arrays.asList(50.0, 50.0, 2.0, 1.0);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expected, response.getEntity());
    }
}
