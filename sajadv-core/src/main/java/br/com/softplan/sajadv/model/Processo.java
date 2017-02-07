package br.com.softplan.sajadv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Processo implements Serializable {

  private static final long serialVersionUID = -2602606594652275090L;

  @Id
  @Column(unique = true)
  private String numeroProcessoUnificado;

  @Column
  @Temporal(TemporalType.DATE)
  private Date dataDistribuicao;

  @Column
  private Boolean segredoJustica;

  @Column
  private String pastaFisicaCliente;

  @Column
  private String descricao;

  @ManyToOne
  @JoinColumn(name = "numeroProcessopai")
  private Processo processoPai;

  @ManyToOne
  @JoinColumn(name = "idsituacao")
  private Situacao situacao;

  @ManyToMany
  @JoinTable(name = "Processo_Responsavel", joinColumns = {
    @JoinColumn(name = "numeroProcessoUnificado")}, inverseJoinColumns = {
    @JoinColumn(name = "cpf")})
  private List<Responsavel> responsaveis;

  public String getNumeroProcessoUnificado() {
    return numeroProcessoUnificado;
  }

  public void setNumeroProcessoUnificado(String numeroProcessoUnificado) {
    this.numeroProcessoUnificado = numeroProcessoUnificado;
  }

  public Date getDataDistribuicao() {
    return dataDistribuicao;
  }

  public void setDataDistribuicao(Date dataDistribuicao) {
    this.dataDistribuicao = dataDistribuicao;
  }

  public Boolean getSegredoJustica() {
    return segredoJustica;
  }

  public void setSegredoJustica(Boolean segredoJustica) {
    this.segredoJustica = segredoJustica;
  }

  public String getPastaFisicaCliente() {
    return pastaFisicaCliente;
  }

  public void setPastaFisicaCliente(String pastaFisicaCliente) {
    this.pastaFisicaCliente = pastaFisicaCliente;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Processo getProcessoPai() {
    return processoPai;
  }

  public void setProcessoPai(Processo processoPai) {
    this.processoPai = processoPai;
  }

  public Situacao getSituacao() {
    return situacao;
  }

  public void setSituacao(Situacao situacao) {
    this.situacao = situacao;
  }

  public List<Responsavel> getResponsaveis() {
    return responsaveis;
  }

  public void setResponsaveis(List<Responsavel> responsaveis) {
    this.responsaveis = responsaveis;
  }

}
