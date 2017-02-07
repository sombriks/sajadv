package br.com.softplan.sajadv.resource;

import br.com.softplan.sajadv.model.Processo;
import br.com.softplan.sajadv.model.Responsavel;
import br.com.softplan.sajadv.model.Situacao;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @class Page
 *
 * Este helper é prática comum para manter limpa a camada jax-rs da aplicação. Com ele não precisamos nos preocupar com
 * serialização de listas e ainda conseguimos adicionar metainformação sobre a consulta realizada (aqui no exemplo dados
 * sobre a paginação).
 *
 * Não pode ser considerado HATEOAS porque a metainformação gerada não cria nenhuma informação de hipermídia para a
 * entidade retornada (i.e. endereço onde a consulta fora realizada), mas isso só tem valor para estratégias de
 * descoberta de serviços, que não iremos apresentar neste projeto exemplo.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Page {

  private int offset;
  private int limit;
  private List<Situacao> resultSituacao;
  private List<Processo> resultProcesso;
  private List<Responsavel> resultResponsavel;

  public Page() {
  }

  public Page(List<Processo> resultProcessos) {
    this.resultProcesso = resultProcessos;
    this.limit = resultProcessos.size();
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public List<Situacao> getResultSituacao() {
    return resultSituacao;
  }

  public void setResultSituacao(List<Situacao> resultSituacao) {
    this.resultSituacao = resultSituacao;
  }

  public List<Processo> getResultProcesso() {
    return resultProcesso;
  }

  public void setResultProcesso(List<Processo> resultProcesso) {
    this.resultProcesso = resultProcesso;
  }

  public List<Responsavel> getResultResponsavel() {
    return resultResponsavel;
  }

  public void setResultResponsavel(List<Responsavel> resultResponsavel) {
    this.resultResponsavel = resultResponsavel;
  }
}
