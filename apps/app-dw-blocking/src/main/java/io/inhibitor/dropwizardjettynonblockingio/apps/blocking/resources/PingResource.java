package io.inhibitor.dropwizardjettynonblockingio.apps.blocking.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/ping")
public class PingResource {

  @GET
  @Path("/nowait")
  public String pingNoWait() {
    return "pong";
  }

  @GET
  @Path("/wait")
  public String pingWait() throws InterruptedException {
    Thread.sleep(30_000);
    return "pong";
  }
}
