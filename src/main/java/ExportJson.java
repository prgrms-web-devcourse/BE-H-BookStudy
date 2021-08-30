import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;

public class ExportJson implements Export{

    private StatisticalSummary statisticalSummary;

    private static final String PATH = "src/main/resources/";

    ExportJson(StatisticalSummary statisticalSummary){
        this.statisticalSummary = statisticalSummary;
    };

    @Override
    public void export() {
        try{
            ObjectMapper mapper = new ObjectMapper();

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            writer.writeValue(Paths.get(PATH + "statistics.json").toFile(), statisticalSummary);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
