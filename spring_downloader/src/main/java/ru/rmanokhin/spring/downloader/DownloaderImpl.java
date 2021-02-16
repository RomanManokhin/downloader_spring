package ru.rmanokhin.spring.downloader;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;

/**
 * Класс который производит загрузку файла
 */

public class DownloaderImpl implements Downloader {

    /**
     * поле для ссылки для скачивание файла
     */

    private final String fileUrl;

    /**
     * поле для имени файла
     */
    private final String fileName;

    /**
     * поле для скорости загрузки
     */
    private final int downloadSpeed;


    public DownloaderImpl(String fileUrl, String fileName, int downloadSpeed) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.downloadSpeed = downloadSpeed;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");

        try {
            /**
             * переменная для потока из url
             * */
            InputStream inputStream = new URL(fileUrl).openStream();

            /**
             * передаём поток в байтовый массив
             */
            byte[] bytes = IOUtils.toByteArray(inputStream);

            FileOutputStream fileOutputStream = new FileOutputStream("c:/testMusic/" + fileName, true);

            /**
             * буфер для считывания из потока
             */
            byte[] buffer = new byte[downloadSpeed];

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            /**
             * переменная для счета прочитанных байт из потока за итерацию
             * */
            int numberOfBytesRead;
            while ((numberOfBytesRead = byteArrayInputStream.read(buffer, 0, downloadSpeed)) != -1) {

                byteArrayOutputStream.write(buffer, 0, numberOfBytesRead);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /**
             * переменная для буфера файла
             * */
            byte[] bufferFile = byteArrayOutputStream.toByteArray();

            fileOutputStream.write(bufferFile);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread() + " finished");
    }

    public static DownloaderBuilder builder(){
        return new DownloaderBuilder();
    }

    public static class DownloaderBuilder {
        private String fileUrl;
        private String fileName;
        private int downloadSpeed;

        public DownloaderBuilder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public DownloaderBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public DownloaderBuilder downloadSpeed(int downloadSpeed) {
            this.downloadSpeed = downloadSpeed;
            return this;
        }

        public DownloaderImpl build() {
            return new DownloaderImpl(fileUrl, fileName, downloadSpeed);
        }
    }
}




