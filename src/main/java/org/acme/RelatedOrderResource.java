package org.acme;

import java.util.List;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/relatedorders")
public class RelatedOrderResource {

    @Inject
    RelatedOrderService relatedOrderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @WithSession
    public Uni<List<RelatedOrder>> getAll() {

        return (Uni<List<RelatedOrder>>) relatedOrderService.getAllRelatedOrders();
    }
}
