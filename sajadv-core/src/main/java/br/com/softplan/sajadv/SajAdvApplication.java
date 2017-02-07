package br.com.softplan.sajadv;

import br.com.softplan.sajadv.resource.SajAdvResource;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @class SajAdvApplication
 * Classe necesária para realizarmos o "Bootstrap" do jax-rs.
 * 
 * Nosso serviço rest não contará com mais nada além dos resources jax-rs, daí 
 * montarmos o Application na raiz.
 */
@ApplicationPath("/")
public class SajAdvApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    resources.add(SajAdvResource.class);
    return resources;
  }
}
