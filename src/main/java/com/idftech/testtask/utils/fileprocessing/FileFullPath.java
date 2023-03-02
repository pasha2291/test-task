package com.idftech.testtask.utils.fileprocessing;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FileFullPath {
    private static ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    public static String getFileFullPath(String path) {
        return classLoader.getResource(path).getFile();
    }
}
