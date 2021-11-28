package com.endpoint;

import java.util.Objects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/system")
public class SystemProperty {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValor(@QueryParam("property") String property, @QueryParam("value") Boolean valor) {
		  if (Objects.isNull(property) || Objects.isNull(valor)) {
			    throw new WebApplicationException(
			      Response.status(Response.Status.BAD_REQUEST)
			        .entity("parameter is mandatory")
			        .build()
			    );
		  }
		return valor ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.NOT_FOUND).entity("Valor falso").build();
	}

}
