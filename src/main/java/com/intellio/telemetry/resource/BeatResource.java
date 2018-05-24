package com.intellio.telemetry.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/beats")
public interface BeatResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();
}
