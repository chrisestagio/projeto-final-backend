package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

@Path("/Conversion")
public class ConversionResource {

    @POST
    @Path("/km-to-miles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String kmToMiles(String body) {
        double km = Double.parseDouble(body);
        double miles = km * 0.621371;
        return String.valueOf(miles);
    }

    @GET
    @Path("/knots-to-km/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Double> knotsToKm(@PathParam("value") double value) {
        double result = value * 1.852;
        return Map.of("value", result);
    }
}
