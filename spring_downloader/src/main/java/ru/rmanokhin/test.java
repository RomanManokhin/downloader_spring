package ru.rmanokhin;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {

        URL url = new URL("https://ruv.hotmo.org/get/music/20200207/Artik_Asti_-_Vse_mimo_68289046.mp3");
        InputStream is = url.openStream();
        byte[] bytes = IOUtils.toByteArray(is);
//        BufferedReader bfr = new BufferedReader(new InputStreamReader(url.openStream()), 512000);
//
//        byte [] bufferr = new byte[512000];
//        bfr.read(bufferr, 0, 512000);


        //получаем количество байт в файле
        int fileSize = url.openConnection().getContentLength();
        url.openConnection().getContent();

        //чтение всего файла в массив байт
//            byte[] content1 = url.openStream().readAllBytes();
        //указываем количество читаемых байт
//        int content = 512000; // 500кб
        int content = 512000; // 500кб

        // сохраняем имя файла
        String name = Paths.get(url.getPath()).getFileName().toString();
        //указываем куда будем записывать и разрешаем до записывание
        FileOutputStream fos = new FileOutputStream("c:/testMusic/" + name, true);

        byte[] buffer = new byte[content];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        System.out.println(byteArrayInputStream.read(url.openStream().readAllBytes(), 0, fileSize));
//        System.out.println(byteArrayInputStream.read(url.openStream().readAllBytes(), 0, content));
//        int bufferContent = 0;
//        int size;
//        int off = 0;
//        int end = 512000;

//        byteArrayInputStream.skip(512000);
//        size = byteArrayInputStream.read(buffer, 0 , 512000);

        for (int i = 0; i < 5; i++) {

//            size =
                    byteArrayInputStream.read(buffer, 0 , 512000);

            byteArrayOutputStream.write(buffer);
//            long x =
                    byteArrayInputStream.skip(512000);



            Thread.sleep(1000);
            System.out.println("sleep");

        }
//        for (int i = 0; i < buffer.length; i++) {
//            System.out.println(buffer[i]);
//        }
        byte[] file = byteArrayOutputStream.toByteArray();
        fos.write(file);
        fos.close();
//        while ((size = byteArrayInputStream.read(buffer, 0 , fileSize)) != -1) {
//
//                byteArrayOutputStream.write(buffer, off, end);
//                off = end + 1;
//                end += end + 1;
//
//
//        bufferContent = content + 1;
//            System.out.println(bufferContent);
//        content = content + 512000 + 1;
//            System.out.println(content);
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cache);
//            byte[] file = byteArrayInputStream.readAllBytes();
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            byteArrayOutputStream.write(file);
//            b = byteArrayOutputStream.toByteArray();
//
//            System.out.println("Цикл");
//        }


//        String text = "Hello Java";


//        byte[] file = byteArrayOutputStream.toByteArray();
//
////        buffer = byteArrayOutputStream.toByteArray();
//
//
//        //производим запись
//        fos.write(file);
//        fos.close();





    }
}
