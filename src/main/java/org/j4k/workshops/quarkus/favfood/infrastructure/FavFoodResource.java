package org.j4k.workshops.quarkus.favfood.infrastructure;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.j4k.workshops.quarkus.domain.OrderInCommand;
import org.j4k.workshops.quarkus.favfood.domain.FavFoodOrder;
import org.j4k.workshops.quarkus.favfood.domain.FavFoodOrderHandler;
import org.j4k.workshops.quarkus.infrastructure.RESTService;

@Path("/FavFood")
public class FavFoodResource {

    Logger logger = LoggerFactory.getLogger(FavFoodResource.class);

    @Inject @RestClient
    RESTService restService;

    @Inject
    FavFoodOrderHandler FavFoodOrderHandler;

    @POST
    public Response placeOrder(final FavFoodOrder favFoodOrder){
        logger.debug("received {}", favFoodOrder);
        OrderInCommand orderInCommand = FavFoodOrderHandler.createFromFavFoodOrder(favFoodOrder);
        logger.debug("sent {}", favFoodOrder);
        restService.placeOrders(orderInCommand);
        return Response.accepted().entity(favFoodOrder).build();
    }
}
