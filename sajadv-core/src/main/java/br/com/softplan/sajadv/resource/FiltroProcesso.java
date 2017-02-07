package br.com.softplan.sajadv.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class FiltroProcesso {

  private Date inicioDataDistribuicao;
  private Date fimDataDistribuicao;
  private String numeroProcessoUnificado;
  private String pastaFisicaCliente;
  private String numeroProcessoPai;
  private String nomeResponsavel;
  private Boolean segredoJustica;
  private long idSituacao;
  private int limit;
  private int page;

  public Date getInicioDataDistribuicao() {
    return inicioDataDistribuicao;
  }

  public void setInicioDataDistribuicao(Date inicioDataDistribuicao) {
    this.inicioDataDistribuicao = inicioDataDistribuicao;
  }

  public Date getFimDataDistribuicao() {
    return fimDataDistribuicao;
  }

  public void setFimDataDistribuicao(Date fimDataDistribuicao) {
    this.fimDataDistribuicao = fimDataDistribuicao;
  }

  public String getNumeroProcessoUnificado() {
    return numeroProcessoUnificado;
  }

  public void setNumeroProcessoUnificado(String numeroProcessoUnificado) {
    this.numeroProcessoUnificado = numeroProcessoUnificado;
  }

  public String getPastaFisicaCliente() {
    return pastaFisicaCliente;
  }

  public void setPastaFisicaCliente(String pastaFisicaCliente) {
    this.pastaFisicaCliente = pastaFisicaCliente;
  }

  public String getNumeroProcessoPai() {
    return numeroProcessoPai;
  }

  public void setNumeroProcessoPai(String numeroProcessoPai) {
    this.numeroProcessoPai = numeroProcessoPai;
  }

  public String getNomeResponsavel() {
    return nomeResponsavel;
  }

  public void setNomeResponsavel(String nomeResponsavel) {
    this.nomeResponsavel = nomeResponsavel;
  }

  public Boolean isSegredoJustica() {
    return segredoJustica;
  }

  public void setSegredoJustica(Boolean segredoJustica) {
    this.segredoJustica = segredoJustica;
  }

  public long getIdSituacao() {
    return idSituacao;
  }

  public void setIdSituacao(long idSituacao) {
    this.idSituacao = idSituacao;
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

  private static Date dFormat(String date) throws ParseException {
    if (date == null) {
      return null;
    }
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    return df.parse(date);
  }

  private static Boolean bFormat(String bool) {
    if (bool == null) {
      return null;
    }
    return Boolean.parseBoolean(bool);
  }

  private static long lFormat(String aLong) {
    if (aLong == null) {
      return 0;
    }
    return Long.parseLong(aLong);
  }

  public static FiltroProcesso fromRequest(HttpServletRequest req) {
    try {
      FiltroProcesso fp = new FiltroProcesso();
      fp.setNumeroProcessoUnificado(req.getParameter("numeroProcessoUnificado"));
      fp.setNumeroProcessoPai(req.getParameter("numeroProcessoPai"));
      fp.setFimDataDistribuicao(dFormat(req.getParameter(("fimdataDistribuicao"))));
      fp.setInicioDataDistribuicao(dFormat(req.getParameter("inicioDataDistribuicao")));
      fp.setIdSituacao(lFormat(req.getParameter("idSituacao")));
      fp.setSegredoJustica(bFormat(req.getParameter("segredoJustica")));
      fp.setPastaFisicaCliente(req.getParameter("pastaFisicaCliente"));
      fp.setNomeResponsavel(req.getParameter("nomeResponsavel"));
      fp.setPage(Integer.parseInt(req.getParameter("page")));
      fp.setLimit(Integer.parseInt(req.getParameter("limit")));
      return fp;
    } catch (NumberFormatException | ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
