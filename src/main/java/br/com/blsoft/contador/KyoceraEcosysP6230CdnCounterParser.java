/*
 * TODO esta classe ainda não foi implementada
 */
package br.com.blsoft.contador;

import java.io.IOException;
import java.net.ConnectException;

/**
 *
 * @author bruno.chagas
 */
public class KyoceraEcosysP6230CdnCounterParser implements CounterParser {
    
    private final String URL_IM430_PREFIX = "/web/guest/";
    private final String URL_IM430 = "/websys/status/getUnificationCounter.cgi";

    @Override
    public Counter getTotalCounters(String pUrl) throws IOException, ConnectException {
        Counter contador = new Counter();
        return contador;
    }

    @Override
    public String getUrl(Boolean httpSecurity, String printerIp, String language) {
        String httpSecurityText = "http://";
        if (httpSecurity) {
            httpSecurityText = "https://";
        }
        return httpSecurityText + printerIp + URL_IM430_PREFIX + language + URL_IM430; // To change body of generated methods, choose Tools |
                                                         // Templates.
    }

}
