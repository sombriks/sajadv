package br.com.softplan.sajadv.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Responsavel implements Serializable {

  private static final long serialVersionUID = -6894749657081133779L;

  @Id
  @Column(unique = true)
  private String cpf;

  @Column
  private String nome;
  
  @XmlTransient
  @ManyToMany(mappedBy="responsaveis")
  private List<Processo> processos;
  
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

  public List<Processo> getProcessos() {
    return processos;
  }

  public void setProcessos(List<Processo> processos) {
    this.processos = processos;
  } 
}
