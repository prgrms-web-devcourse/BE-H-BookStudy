package answer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static answer.Attributes.*;

public class ImageImporter implements Importer{

    @Override
    public Document importFile(File file) throws IOException {
        //사진 이미지의 높낮이를 저장하는구나;;ㅎ;;;
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH.getAttribute(), file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH.getAttribute(), String.valueOf(image.getWidth()));
        attributes.put(HEIGHT.getAttribute(), String.valueOf(image.getHeight()));
        attributes.put(TYPE.getAttribute(), "IMAGE");

        return new Document(attributes);
    }
}
