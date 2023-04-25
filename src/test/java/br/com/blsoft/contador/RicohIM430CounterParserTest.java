package br.com.blsoft.contador;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.ConnectException;

import org.junit.Test;

public class RicohIM430CounterParserTest {
    @Test
    public void deveRetornarOsContadoresDaImpressoraIp212(){
        RicohIM430CounterParser ricohIM430 = new RicohIM430CounterParser();
        String url = ricohIM430.getUrl(false,"10.14.186.212");
        try {
            float contadorExperado = 40392;//alterar esse valor para o contador real da impressora na data corrente
            Contador contadores = ricohIM430.getContadorTotal(url);
            assertEquals("Resultado ", contadorExperado, contadores.getContTotal(), 1);
        } catch (ConnectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
