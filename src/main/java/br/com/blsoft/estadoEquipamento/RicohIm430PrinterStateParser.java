package br.com.blsoft.estadoEquipamento;

import java.io.IOException;
import java.net.ConnectException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RicohIm430PrinterStateParser implements PrinterStateParser {
    private final String URL_IM430 = "/web/guest/pt/websys/webArch/getStatus.cgi";
    private final String SEARCH_TEXT = "Estado OK";

    @Override
    public PrinterState getPrinterState(String url) throws IOException, ConnectException {
        PrinterState printerState = new PrinterState();
        Tonner tonner = new Tonner("Black", 0, true);
        Document doc = Jsoup.connect(url).get();
        Elements img = doc.getElementsByTag("img");
        for (Element el : img) {
            // If alt is empty or null, add one to counter
            if (el.attr("alt").equals(SEARCH_TEXT)) {
                tonner = new Tonner("Preto", 0, false);
                printerState.addTonner(tonner);
            }
        }
        return printerState;
    }

    @Override
    public String getUrl(Boolean httpSecurity, String printerIp) {
        String httpSecurityText = "http://";
        if (httpSecurity) {
            httpSecurityText = "https://";
        }
        return httpSecurityText + printerIp + URL_IM430;
    }

}
