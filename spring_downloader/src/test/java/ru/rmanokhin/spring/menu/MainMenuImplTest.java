package ru.rmanokhin.spring.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainMenuImplTest {

    private static MainMenu mainMenu;

    @Autowired
    public void setStart(MainMenu mainMenu) {
        MainMenuImplTest.mainMenu = mainMenu;

    }

    @Test
    void testTakeThreads() throws IOException {
        String excepted = "5";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());

        System.setIn(byteArrayInputStream);

        int actual = mainMenu.menuCountThreads();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(5, actual);
        bufferedReader.close();
        inputStreamReader.close();
    }

    @Test
    void testTakePathFile() throws IOException {
        String excepted = "src/main/resources/info/testFile.txt";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = mainMenu.menuTakePathFile();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(excepted, actual);

        bufferedReader.close();
        inputStreamReader.close();
    }

    @Test
    void testDownloadSpeed() throws IOException {
        String excepted = "500";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        int actual = mainMenu.menuDownloadSpeed();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(512000, actual);

        bufferedReader.close();
        inputStreamReader.close();
    }

    @Test
    void testPathDownload() throws IOException {
        String excepted = "c:\\path";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = mainMenu.menuPathDownload();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(excepted, actual);

        bufferedReader.close();
        inputStreamReader.close();
    }
}