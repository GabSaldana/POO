import java.io.File; 
import java.util.Date; 
import jxl.*; 
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import javax.swing.*;//JTable, JFileChooser

public class Tabla extends JFrame{
	
	private JFileChooser examinar;
	private File archivoexcel = null;
	int opcion;
	Workbook leerExcel;
	private DefaultTableModel model;

	public tabla(String archivoexcel) {

	examinar = new JFileChooser();
	examinar.setFileFilter(new FileFilter("Archivos excel","xls", "xlsx"));
	opcion= examinar.showOpenDialog(this);

	if(opcion==JFileChooser.APROVE_OPTION){

		archivoexcel = examinar.getSelectedFile().getAbsoluteFile();//obtenemos la rutadel archivo y la guardamos
		try{
		Workbook workbook = Workbook.getWorkbook(new File(archivoexcel));
		Sheet hoja = leerExcel.getSheet();
		Object data[] = new Object[columnas];
		for(int i=0 ; i<hoja.getRowCount() ; i++){

			for(int j=0 ; j<hoja.getColumnCount() ; j++){

				data[j]=hoja.getCell(j,i).getContents();//con getCell obtenemose el contenido de la fila y columna actual	y se guarda en data la fila completa
			}
			model.addRow(data);
		}

		}
		catch(IOException e ){System.out.println("Error al cargar la tabla");}
		catch(BiffException e){System.out.println("Error al almacenar la tabla ");}
	}

  }

}