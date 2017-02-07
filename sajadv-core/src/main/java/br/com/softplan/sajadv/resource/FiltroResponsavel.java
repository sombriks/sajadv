package br.com.softplan.sajadv.resource;

import javax.servlet.http.HttpServletRequest;

public class FiltroResponsavel {

  private String cpf;
  private String nome;
  private String numeroProcessoUnificado;
  private int limit;
  private int page;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNumeroProcessoUnificado() {
    return numeroProcessoUnificado;
  }

  public void setNumeroProcessoUnificado(String numeroProcessoUnificado) {
    this.numeroProcessoUnificado = numeroProcessoUnificado;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public static FiltroResponsavel fromRequest(HttpServletRequest req) {
    FiltroResponsavel fr = new FiltroResponsavel();
    fr.setCpf(req.getParameter("cpf"));
    fr.setNome(req.getParameter("nome"));
    fr.setNumeroProcessoUnificado(req.getParameter("numeroProcessoUnificado"));
    fr.setPage(Integer.parseInt(req.getParameter("page")));
    fr.setLimit(Integer.parseInt(req.getParameter("limit")));
    return fr;
  }
}
