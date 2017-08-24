package data_grid;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

@Path("rest")
public class REST {

	Configuration conf = new ConfigurationBuilder().addServer().host("localhost").port(11422).build();
	RemoteCacheManager manager = new RemoteCacheManager(conf);
	RemoteCache defaultCache = manager.getCache();
	
	@POST
	@Path("persist")
	public void persiste(@FormParam ("titulo") String titulo, @FormParam ("isbn") Integer isbn, @FormParam ("autor") String autor) {
		defaultCache.put(isbn, new Livro(titulo, isbn, autor));
	}
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public Livro retorna(@QueryParam ("isbn") Integer isbn) {
		Livro l = (Livro) defaultCache.get(isbn);
		return l;
	}
	
}
