import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;

public class ExportJson implements Export{

    private static final String PATH = "src/main/resources/";

    ExportJson(){};

    @Override
    public void export(SummaryStatistics summaryStatistics) {
        try{
            ObjectMapper mapper = new ObjectMapper();

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            writer.writeValue(Paths.get(PATH + "statistics.json").toFile(), summaryStatistics);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
