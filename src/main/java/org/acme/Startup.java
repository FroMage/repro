package org.acme;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.logging.Log;
import io.quarkus.vertx.VertxContextSupport;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Startup {
	@io.quarkus.runtime.Startup
	public void onstart() throws Throwable {
		Log.info("Creating instance");
		VertxContextSupport.subscribeAndAwait(() -> 
			Panache.withTransaction(() -> new RelatedOrder().persist())
		);
	}
}
