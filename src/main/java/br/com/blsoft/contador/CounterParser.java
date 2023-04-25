/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blsoft.contador;

import java.io.IOException;
import java.net.ConnectException;

/**
 *
 * @author bruno.chagas
 */
public interface CounterParser {
    public Contador getContadorTotal(String urlFormatada) throws IOException, ConnectException ;
    public String getUrl(Boolean httpSecurity,  String printerIp);
}
