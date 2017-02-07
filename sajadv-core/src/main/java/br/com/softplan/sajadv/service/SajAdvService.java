package br.com.softplan.sajadv.service;

import br.com.softplan.sajadv.model.Processo;
import br.com.softplan.sajadv.model.Situacao;
import br.com.softplan.sajadv.resource.Page;
import br.com.softplan.sajadv.model.Responsavel;
import br.com.softplan.sajadv.resource.FiltroProcesso;
import br.com.softplan.sajadv.resource.FiltroResponsavel;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Singleton
public class SajAdvService {

  @PersistenceContext(name = "sajadv-pu")
  private EntityManager em;

  public Page listSituacoes() {
    List<Situacao> ret = em.createQuery("select s from Situacao s", Situacao.class).getResultList();
    Page p = new Page();
    p.setOffset(0);
    p.setLimit(ret.size());
    p.setResultSituacao(ret);
    return p;
  }

  public Page listResponsaveis(FiltroResponsavel filtro) {
    String q = "select r from Responsavel r "
            + "where r.cpf like :cpf "
            + "and r.nome like :nome ";

    Page p = new Page();
    p.setOffset((filtro.getPage() - 1) * filtro.getLimit());

    TypedQuery<Responsavel> query = em.createQuery(q, Responsavel.class)
            .setParameter("cpf", "%" + filtro.getCpf() + "%")
            .setParameter("nome", "%" + filtro.getNome() + "%")
            //            .setParameter("numeroProcessoUnificado", "%" + filtro.getNumeroProcessoUnificado() + "%")
            .setMaxResults(filtro.getLimit())
            .setFirstResult(p.getOffset());

    List<Responsavel> ret = query.getResultList();
    p.setLimit(ret.size());
    p.setResultResponsavel(ret);

    return p;
  }

  public Page listProcessos(FiltroProcesso filtro) {
    String q = "select p from Processo p "
            + "left join p.responsaveis r "
            + "where p.numeroProcessoUnificado like :numeroProcessoUnificado "
            + "and r.nome like :nomeResponsavel "
            + "and p.pastaFisicaCliente like :pastaFisicaCliente "
            + "and p.segredoJustica = :segredoJustica ";

    if (filtro.getNumeroProcessoPai() != null){
      q += "and p.processoPai.numeroProcessoUnificado like :numeroProcessoPai ";
    }
    
    if (filtro.getIdSituacao() > 0) {
      q += "and p.situacao.idSituacao = :idSituacao ";
    }

    if (filtro.getInicioDataDistribuicao() != null) {
      q += "and p.dataDistribuicao >= :inicioDataDistribuicao ";
    }

    if (filtro.getFimDataDistribuicao() != null) {
      q += "and p.dataDistribuicao <= :fimDataDistribuicao ";
    }

    Page p = new Page();
    p.setOffset((filtro.getPage() - 1) * filtro.getLimit());

    TypedQuery<Processo> query = em.createQuery(q, Processo.class)
            .setParameter("nomeResponsavel", "%" + filtro.getNomeResponsavel() + "%")
            .setParameter("numeroProcessoUnificado", "%" + filtro.getNumeroProcessoUnificado() + "%")
            .setParameter("pastaFisicaCliente", "%" + filtro.getPastaFisicaCliente() + "%")
            .setParameter("segredoJustica", filtro.isSegredoJustica())
            .setMaxResults(filtro.getLimit())
            .setFirstResult(p.getOffset());

    if (filtro.getIdSituacao() > 0) {
      query.setParameter("idSituacao", filtro.getIdSituacao());
    }

    if (filtro.getNumeroProcessoPai() != null) {
      query.setParameter("numeroProcessoPai", "%" + filtro.getNumeroProcessoPai() + "%");
    }

    if (filtro.getInicioDataDistribuicao() != null) {
      query.setParameter("inicioDataDistribuicao", filtro.getInicioDataDistribuicao());
    }

    if (filtro.getFimDataDistribuicao() != null) {
      query.setParameter("fimDataDistribuicao", filtro.getFimDataDistribuicao());
    }

    List<Processo> ret = query.getResultList();
    p.setLimit(ret.size());
    p.setResultProcesso(ret);

    return p;
  }

  public Responsavel findResponsavel(String cpf) {
    return em.find(Responsavel.class, cpf);
  }

  public Processo findProcesso(String numeroProcessoUnificado) {
    return em.find(Processo.class, numeroProcessoUnificado);
  }

  public Page listProcessosResponsavel(String cpf) {
    String q = "select p from Processo p join p.responsaveis r where r.cpf = :cpf";
    return new Page(em.createQuery(q, Processo.class).setParameter("cpf", cpf).getResultList());
  }

  @Transactional
  public Responsavel saveResponsavel(Responsavel responsavel) {
    if (em.find(Responsavel.class, responsavel.getCpf()) != null) {
      em.merge(responsavel);
    } else {
      em.persist(responsavel);
    }
    return responsavel;
  }

  @Transactional
  public Processo saveProcesso(Processo processo) {
    if (em.find(Processo.class, processo.getNumeroProcessoUnificado()) != null) {
      em.merge(processo);
    } else {
      em.persist(processo);
    }
    return processo;
  }
}
