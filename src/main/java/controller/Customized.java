package controller;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import java.io.File;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.primefaces.component.export.PDFOptions;

@Named(value = "customized")
@ViewScoped
public class Customized implements Serializable {

    private PDFOptions pdfo;

   @PostConstruct
   public void init() {
        customization();
    }

    public void customization() {
        pdfo = new PDFOptions();
        pdfo.setFacetBgColor("#DFDFDF");
        pdfo.setFacetFontColor("#000000");
        pdfo.setFacetFontSize("11");
        pdfo.setCellFontColor("#000000");
        pdfo.setCellFontSize("11");
    }

    public void preProcessPDF(Object document) throws Exception {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources"
                + File.separator + "images" + File.separator + "pdf.png";

        Image image = Image.getInstance(logo);
        image.setAlignment(Image.ALIGN_RIGHT);
        Phrase header = new Phrase();
        header.add("Este PDF se generó usando el atributo 'preProcessor' de la etiqueta <DataExport /> de Primefaces.");
        pdf.add(image);
        pdf.add(header);
    }

    public void postProcessExcel(Object document) throws Exception {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = ((HSSFWorkbook) document).getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }

    public PDFOptions getPdfo() {
        return pdfo;
    }

    public void setPdfo(PDFOptions pdfo) {
        this.pdfo = pdfo;
    }

}
