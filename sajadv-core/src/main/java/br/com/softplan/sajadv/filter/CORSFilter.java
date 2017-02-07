package br.com.softplan.sajadv.filter;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @class CORSFilter
 *
 * Serviços REST normalmente não serão consumidos no mesmo servidor em que estão publicados, todavia os navegadores
 * modernos estão submetidos ao SOP (Same Origin Policy) que dita regras para chamadas http realizadas via script sejam
 * honradas ou não. De modo a 'legalizar' estas chamadas, o cliente deve primeiro realizar um 'preflight' (normalmente
 * uma requisição com o verbo OPTIONS) para saber o o que o servidor aceita ou não. O mínimo que o cabeçalho da resposta
 * deve conter são as origens permitidas de acesso. Só então a requisição pode de fato tomar lugar.
 */
@WebFilter(value = "/*")
public class CORSFilter implements Filter {

  private static final Logger LOG = Logger.getAnonymousLogger();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    LOG.info("preparando filtro para permitir consumo remoto do serviço");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Headers", "Content-Type");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }

}
