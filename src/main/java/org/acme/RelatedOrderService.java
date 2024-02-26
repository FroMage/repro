package org.acme;

import java.util.List;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelatedOrderService {

// @Inject
// @RestClient
// OrderManagement orderManagement;

 public Uni<List<RelatedOrder>> getAllRelatedOrders() {

        Uni<List<RelatedOrder>> ordersUni = RelatedOrder.<RelatedOrder> listAll();
        Multi<RelatedOrder> ordersMulti = ordersUni
                .onItem()
                .transformToMulti(list -> Multi.createFrom().iterable(list));

return ordersMulti
                .onItem()
                .transformToUniAndConcatenate(order -> Uni.createFrom().item(order)
/*
                                 orderManagement.orderStatus(order.trmOrder)
                                        .map(response -> { //map = onItem().transform()
                                            order.trmStatus = response.trmStatusCode();
                                            order.trmStatusDescription = response.trmStatusDescription();

                                            return order;
                                        })
                                        */
                                        ).collect().asList(); //returns Uni<List>
    }
}
