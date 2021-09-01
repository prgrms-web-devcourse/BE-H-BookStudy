package com.realSoftware.yongjin.model.importer;

import java.io.IOException;
import java.nio.file.Path;

public interface Importer {
    String importResource(String path);
}
