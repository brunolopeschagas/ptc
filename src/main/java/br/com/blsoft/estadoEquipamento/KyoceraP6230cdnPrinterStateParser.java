package br.com.blsoft.estadoEquipamento;

import java.io.IOException;
import java.net.ConnectException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KyoceraP6230cdnPrinterStateParser implements PrinterStateParser {
    @Override
    public PrinterState getPrinterState(String url) throws IOException, ConnectException {
        PrinterState printerState = new PrinterState();
        Document doc = Jsoup.connect(url).get();
        Tonner tonnerBlack = new Tonner("Preto", 0, false);
        Tonner tonnerCiano = new Tonner("Ciano", 0, false);
        Elements elements = doc.getElementsByTag("body");
        for (Element element : elements) {
            if (element.ownText().equals("")) {
                tonnerBlack = new Tonner("Preto", 0, true);
                break;
            }
        }
        printerState.addTonner(tonnerBlack);
        return printerState;
    }

    @Override
    public String getUrl(Boolean httpSecurity, String printerIp, String language) {
        String httpSecurityText = "http://";
        if (httpSecurity) {
            httpSecurityText = "https://";
        }
        return httpSecurityText + printerIp; // To change body of generated
    }

}
