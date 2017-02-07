package br.com.softplan.sajadv;

import br.com.softplan.sajadv.model.Processo;
import br.com.softplan.sajadv.model.Responsavel;
import br.com.softplan.sajadv.model.Situacao;
import br.com.softplan.sajadv.resource.Page;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.Test;

/**
 * Pequeno teste unitários de serialização via JAXB
 *
 * Embora originalmente concebido para xml, suas facilidades e anotações são 
 * aproveitadas pelo jersey para gerar json, caso o serviço rest decida 
 * responder com este formato
 */
public class BaseTests {

  @Test
  public void shouldConvertEntity2Xml() throws JAXBException {
    Page p = new Page();
    p.setLimit(5);
    p.setOffset(0);
    p.setResultSituacao(new ArrayList<>());
    int i = 5;
    while (i-- > 0) {
      p.getResultSituacao().add(new Situacao());
    }
    JAXBContext ctx = JAXBContext.newInstance(Page.class, Situacao.class, Processo.class, Responsavel.class);
    Marshaller m = ctx.createMarshaller();
    m.setProperty("jaxb.formatted.output", true);
    m.marshal(p, System.out);
  }
}
