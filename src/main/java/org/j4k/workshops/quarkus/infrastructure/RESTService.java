package org.j4k.workshops.quarkus.infrastructure;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.j4k.workshops.quarkus.domain.OrderInCommand;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("/order")
@RegisterRestClient
public interface RESTService {

    @POST
    CompletionStage<Response> placeOrders(OrderInCommand createOrderCommand);
}
