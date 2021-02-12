package ru.rmanokhin.downloader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Downloader implements Runnable {

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


    public Downloader(String fileUrl, String fileName, int downloadSpeed) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.downloadSpeed = downloadSpeed;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");

        try {
            /**
             * открывается поток для обработки
             * */
            InputStream is = new URL(fileUrl).openStream();

            /**
             * передаём поток в байтовый массив
             */
            byte[] bytes = IOUtils.toByteArray(is);

            FileOutputStream fos = new FileOutputStream("c:/testMusic/" + fileName, true);

            /**
             * буфер для считывания из потока
             */
            byte[] buffer = new byte[downloadSpeed];

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int size;
            while ((size = byteArrayInputStream.read(buffer, 0, downloadSpeed)) != -1) {
                byteArrayOutputStream.write(buffer, 0, size);

                long resultWaitTime = Math.round((double) (size / downloadSpeed));
                try {
                    if (size == downloadSpeed) {
                        Thread.sleep(1000);
                    } else {
                        Thread.sleep(1000 / resultWaitTime);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            byte[] file = byteArrayOutputStream.toByteArray();
            fos.write(file);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //чтение всего файла в массив байт
//            byte[] content1 = url.openStream().readAllBytes();
        //указываем количество читаемых байт

//        try {
//            FileUtils.copyURLToFile(new URL(fileUrl), new File("c:/testMusic/" + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread() + " finished");
    }


}

