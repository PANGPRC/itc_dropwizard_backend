package com.oracle.itcdropwizard.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/coins")
@Produces(MediaType.APPLICATION_JSON)
public class CoinResource {

    @POST
    @Path("/calculate")
    public Response calculateMinimumCoins(@QueryParam("targetAmount") double targetAmount,
                                          @QueryParam("denominations") List<Double> denominations) {
        if (targetAmount < 0 || targetAmount > 10000) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Target amount must be between 0 and 10,000.00").build();
        }

        List<Double> result = getMinimumCoins(targetAmount, denominations);
        return Response.ok(result).build();
    }

    private List<Double> getMinimumCoins(double targetAmount, List<Double> denominations) {
        Collections.sort(denominations, Collections.reverseOrder());
        List<Double> result = new ArrayList<>();
        for (double coin : denominations) {
            while (targetAmount >= coin) {
                targetAmount -= coin;
                result.add(coin);
            }
        }
        return result;
    }
}
