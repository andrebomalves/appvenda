package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
public class Util {

	
	public static List<String> RecuperarLinhasDoArquivo(String nomeDoArquivo) throws Exception  {
		
		FileReader file = new FileReader(nomeDoArquivo);		
		BufferedReader leitura = new BufferedReader(file);
		
		List<String> linhas = new LinkedList<String>();
		
		String linha = null;
		linha = leitura.readLine();
		
		while(linha != null) {
			linhas.add(linha);
			linha = leitura.readLine();
		}
		
		leitura.close();
		
		return linhas;
	}
}
