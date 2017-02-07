package br.com.softplan.sajadv.resource;

import br.com.softplan.sajadv.model.Processo;
import br.com.softplan.sajadv.model.Responsavel;
import br.com.softplan.sajadv.service.SajAdvService;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Stateless
@Path("/resources")
public class SajAdvResource {

  private static final Logger LOG = Logger.getAnonymousLogger();

  @EJB
  private SajAdvService service;

  @GET
  public String getStatus() {
    LOG.info("ONLINE");
    return "ONLINE";
  }

  @GET
  @Path("/situacoes")
  @Produces("application/json")
  public Page listSituacoes() {
    Page p = service.listSituacoes();
    LOG.info("busca situacoes");
    return p;
  }

  @GET
  @Path("/responsaveis")
  @Produces("application/json")
  public Page listResponsaveis(@Context HttpServletRequest req) {
    FiltroResponsavel filtro = FiltroResponsavel.fromRequest(req);
    Page p = service.listResponsaveis(filtro);
    LOG.info("busca responsaveis");
    return p;
  }

  @GET
  @Path("/processos")
  @Produces("application/json")
  public Page listProcessos(@Context HttpServletRequest req) {
    FiltroProcesso filtro = FiltroProcesso.fromRequest(req);
    Page p = service.listProcessos(filtro);
    LOG.info("busca processos");
    return p;
  }

  @GET
  @Path("/responsavel/{cpf}")
  @Produces("application/json")
  public Responsavel findResponsavel(@PathParam("cpf") String cpf) {
    Responsavel r = service.findResponsavel(cpf);
    LOG.info("busca responsavel");
    return r;
  }

  @GET
  @Path("/processo/{numeroProcessoUnificado}")
  @Produces("application/json")
  public Processo findProcesso(@PathParam("numeroProcessoUnificado") String numeroProcessoUnificado) {
    Processo p = service.findProcesso(numeroProcessoUnificado);
    LOG.info("busca processo");
    return p;
  }

  @GET
  @Path("/processos/{cpf}")
  @Produces("application/json")
  public Page listProcessosResponsavel(@PathParam("cpf") String cpf) {
    Page p = service.listProcessosResponsavel(cpf);
    LOG.info("busca processos por responsável");
    return p;
  }

  @POST
  @Path("/responsavel")
  @Produces("application/json")
  public Responsavel saveResponsavel(Responsavel responsavel) {
    LOG.info("salvando responsável");
    return service.saveResponsavel(responsavel);
  }

  @POST
  @Path("/processo")
  @Produces("application/json")
  public Processo saveProcesso(Processo processo) {
    LOG.info("salvando responsável");
    return service.saveProcesso(processo);
  }
}
