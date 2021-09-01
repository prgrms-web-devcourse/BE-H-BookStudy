package com.realSoftware.yongjin.model.importer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

public class ImageImporter implements Importer {
    @Override
    public String importResource(String path) {
        BufferedImage image;
        File imageFile = new File(path);

        try {
            image = ImageIO.read(imageFile);
            JFrame frame = new JFrame();
            frame.setSize(300, 300);
            JLabel label = new JLabel(new ImageIcon(image));
            frame.add(label);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
