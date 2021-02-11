package ru.rmanokhin.downloader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BootPreparationImpl implements BootPreparation {
    /**
     * метод для парсинга файла и получения ссылок для скачивания
     * */
    @Override
    public List<String> parsingFileForUrls(String pathFile) {
        List<String> urlsFromFile = null;
        try {
            urlsFromFile = Files.readAllLines(Paths.get(pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlsFromFile;
    }
    /**
     * метод для парсинга файла и получения имен файлов
     * */
    @Override
    public List<String> parsingFileForNames(List<String> urls) {
        List<String> namesForFiles = new ArrayList<>();

        for (String s : urls) {
            try {
                namesForFiles.add(Paths.get(new URI(s).getPath()).getFileName().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return namesForFiles;
    }

}
