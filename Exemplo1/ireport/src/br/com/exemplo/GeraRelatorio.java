package br.com.exemplo;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class GeraRelatorio {
public static void main(String[] args) throws Exception {
	Collection<LinhaVO> linhas = new LinkedList<LinhaVO>();

	for (int i = 0; i < 1; i++) {
		for (int j = 0; j < 10; j++) {
			LinhaVO l = new LinhaVO();
			l.setId(i);
			l.setNome("Nome " + i);
			l.setValor((double) j);
			linhas.add(l);
		}
	}

	JasperPrint p = JasperFillManager.fillReport(GeraRelatorio.class.getResourceAsStream("relatorio.jasper"),new HashMap<String, Object>(), new JRBeanCollectionDataSource(linhas));

	JasperExportManager.exportReportToPdfStream(p,(OutputStream) new FileOutputStream("C:\\a.pdf"));

}
}
