package model;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

//Classe responsavel pela pratica de web scraping no site do IBGE para utilizar os valores atuais da inflacao
public class AcessarInflacaoIBGE {
    private Document getURL() throws IOException {
        return Jsoup.connect("https://www.ibge.gov.br/explica/inflacao.php").get();
    }

    private void getFooter() throws IOException {
        Elements elements = getURL().getElementsByClass("resultados-destaque clearfix sem-busca");
        getFooterPaginas(elements.eq(0));
    }

    private void getFooterPaginas(Elements elements) throws IOException {
        for(Element element : elements) {
            Elements filho = element.getElementsByTag("li");
            for(Element li : filho) {
                String descricao1 = li.getElementsByClass("variavel-titulo").text();
                String descricao2 = li.getElementsByClass("variavel-dado").text();
                String descricao3 = li.getElementsByClass("variavel-periodo").text();
                System.out.println(descricao1 + ": " + descricao2 + " no período de " + descricao3);
            }
        }
    }

    public void getValoresInflacao() throws IOException {
        getFooter();
    }
}
