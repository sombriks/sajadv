package br.com.softplan.sajadv.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Situacao implements Serializable {

  @Id
  private long idSituacao;

  @Column
  private String nome;

  @Column
  private boolean finalizado;

  public long getIdSituacao() {
    return idSituacao;
  }

  public void setIdSituacao(long idSituacao) {
    this.idSituacao = idSituacao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public boolean isFinalizado() {
    return finalizado;
  }

  public void setFinalizado(boolean finalizado) {
    this.finalizado = finalizado;
  }

}
