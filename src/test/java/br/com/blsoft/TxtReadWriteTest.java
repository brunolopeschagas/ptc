package br.com.blsoft;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.blsoft.util.TxtReadWrite;

public class TxtReadWriteTest {
    @Test
    public void deveLerUmaLinhaDoArquivo(){
        TxtReadWrite arquivo = new TxtReadWrite("impressoras.txt");
        List<String> linhasArquivo = arquivo.readFile();
        System.out.println(linhasArquivo);
        assertTrue(linhasArquivo.size() > 0);
    }
}
