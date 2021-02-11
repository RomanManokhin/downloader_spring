package ru.rmanokhin.downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Downloader implements Runnable {

    /**
     * поле для ссылки для скачивание файла
     */
    private String fileUrl;

    /**
     * поле для имени файла
     */
    private String fileName;


    public Downloader(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    public Downloader() {

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");

        try {
            FileUtils.copyURLToFile(new URL(fileUrl), new File("c:/testMusic/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " finished");
    }



}

