import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportHtml implements Export{
    private StatisticalSummary statisticalSummary;
    private static final String PATH = "src/main/resources/";

    ExportHtml(StatisticalSummary statisticalSummary){
        this.statisticalSummary = statisticalSummary;
    }

    String getStringSummary(){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <ul>");

        sb.append("<li>min: </li>").append(statisticalSummary.getMin()).append("\n");
        sb.append("<li>max: </li>").append(statisticalSummary.getMax()).append("\n");
        sb.append("<li>sum: </li> ").append(statisticalSummary.getSum()).append("\n");
        sb.append("<li>avg: </li> ").append(statisticalSummary.getAverage()).append("\n");
        sb.append("  </ul>\n" +
                "</body>\n" +
                "</html>");

        return sb.toString();
    }
    @Override
    public void export() {
        File file = new File(PATH + "index.txt");
        String str =  getStringSummary();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.append(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
