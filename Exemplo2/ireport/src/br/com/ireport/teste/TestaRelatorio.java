package br.com.ireport.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import br.com.ireport.modelo.Aluno;

public class TestaRelatorio {

	
	public static void main(String[] args) throws JRException, FileNotFoundException {
		
				
				// lista chave e valor
				Map<String, Object> params = new HashMap<String, Object>();
				// colecao de alunos
				Collection<Aluno> listaDeAluno = new ArrayList<Aluno>();
				
				// compila o arquivo para extensao jasper
				JasperCompileManager.compileReportToFile("relatorio.jrxml");
				
				// cria o aluno e adiciona a lista
				listaDeAluno.add(new Aluno(1, "Renato", Arrays.asList("Programação", "Redes")));
				listaDeAluno.add(new Aluno(2, "Bispo", Arrays.asList("Logica", "Sistemas Operacionais")));
				listaDeAluno.add(new Aluno(3, "Rudolf", Arrays.asList("Analise de Sistemas", "Orientação a Objetos")));
				
				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaDeAluno);
				
				JasperPrint jasperPrint = JasperFillManager.fillReport("relatorio.jasper", params, dataSource);
				JRExporter exporter = new JRPdfExporter();
				
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("relatorio.pdf"));
				exporter.exportReport();
			
			
				
				
			
				
		
		
		
	}
}
