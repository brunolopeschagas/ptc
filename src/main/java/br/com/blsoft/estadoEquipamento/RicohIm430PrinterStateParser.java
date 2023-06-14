package br.com.blsoft.estadoEquipamento;

import java.io.IOException;
import java.net.ConnectException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RicohIm430PrinterStateParser implements PrinterStateParser {
    private final String URL_IM430_PREFIX = "/web/guest/";
    private final String URL_IM430 = "/websys/webArch/getStatus.cgi";
    private final String[] STATUS_TONER = { "Cartucho quase vazio", "Cartucho vazio" };

    @Override
    public PrinterState getPrinterState(String url) throws IOException, ConnectException {
        PrinterState printerState = new PrinterState();
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsMatchingOwnText("vazio");
        for (Element element : elements) {
            if (element.attr("alt").equals(STATUS_TONER[0])) {
                Tonner tonner = new Tonner("Preto", 0, false);
                printerState.addTonner(tonner);
                break;
            }else{
                Tonner tonner = new Tonner("Preto", 0, false);
                printerState.addTonner(tonner);
                break;
            }
        }
        return printerState;
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
