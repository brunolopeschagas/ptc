/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blsoft.contador;

import java.io.IOException;
import java.net.ConnectException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author bruno.chagas
 */
public class RicohIM430CounterParser implements CounterParser {

    private final String URL_IM430_PREFIX = "/web/guest/";
    private final String URL_IM430 = "/websys/status/getUnificationCounter.cgi";

    @Override
    public Counter getTotalCounters(String pUrl) throws IOException, ConnectException {
        Counter contador = new Counter();
        Document doc = Jsoup.connect(pUrl).get();
        Elements trs = doc.select("tr");
        if (trs.size() > 0) {
            Elements tds = trs.get(0).select("td");
            int countPretoEBrancos = 0;
            for (int i = 0; i < tds.size(); i++) {
                if (countPretoEBrancos > 1) {
                    break;
                }
                if (tds.get(i).text().equals("Total")) {
                    contador.setContTotal(Long.parseLong(tds.get(i + 2).text()));
                }
                if (tds.get(i).text().equals("Preto e branco")) {
                    if (countPretoEBrancos == 0) {
                        contador.setContCopiadora(Long.parseLong(tds.get(i + 2).text()));
                    } else if (countPretoEBrancos == 1) {
                        contador.setContImpressora(Long.parseLong(tds.get(i + 2).text()));
                    }
                    countPretoEBrancos++;
                }
            }
        }
        return contador;
    }

    public void getHistoricoTrabalhos(String purl) throws IOException {
        Document doc = Jsoup.connect(purl).get();
        System.out.println(doc);
    }

    @Override
    public String getUrl(Boolean httpSecurity, String printerIp, String language) {
        String httpSecurityText = "http://";
        if (httpSecurity) {
            httpSecurityText = "https://";
        }
        return httpSecurityText + printerIp + URL_IM430_PREFIX + language + URL_IM430; // To change body of generated
                                                                                       // methods, choose Tools |
        // Templates.
    }

}
