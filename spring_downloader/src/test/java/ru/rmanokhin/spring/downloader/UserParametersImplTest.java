package ru.rmanokhin.spring.downloader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserParametersImplTest {


    private static UserParameters userParameters;

    @Autowired
    public void setStart(UserParameters userParameters) {
        UserParametersImplTest.userParameters = userParameters;
    }

    @Test
    void testTakeThreadsWithText() throws IOException {
        String excepted = "a";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            userParameters.takeThreads();
        });

        assertNotNull(thrown);

        bufferedReader.close();
        inputStreamReader.close();
    }

    @Test
    void testTakeThreadsActual() throws IOException {
        String excepted = "5";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        int actual = userParameters.takeThreads();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(5, actual);

        bufferedReader.close();
        inputStreamReader.close();
    }

    @Test
    void testTakeThreadsWrongCount() throws IOException {
        String excepted = "0";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        int actual = userParameters.takeThreads();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(0, actual);

        bufferedReader.close();
        inputStreamReader.close();
    }

    @Test
    void testTakePathFileActual() throws IOException {
        String excepted = "src/main/resources/info/testFile.txt";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = userParameters.takePathFile();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(excepted, actual);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testTakePathFileWithEmptyFile() throws IOException {
        String excepted = "src/main/resources/info/test_empty_data.txt";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = userParameters.takePathFile();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertNull(actual);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testTakePathFileWithWrongExpansionFile() throws IOException {
        String excepted = "src/main/resources/info/test_empty_data";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = userParameters.takePathFile();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertNull(actual);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testDownloadSpeedWithText() throws IOException {
        String excepted = "a";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            userParameters.downloadSpeed();
        });

        assertNotNull(thrown);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testDownloadSpeedWithZeroSpeed() throws IOException {
        String excepted = "0";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        int actual = userParameters.downloadSpeed();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(0, actual);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testDownloadSpeedActual() throws IOException {
        String excepted = "500";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        int actual = userParameters.downloadSpeed();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(512000, actual);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testPathDownloadActual() throws IOException {
        String excepted = "c:\\path";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = userParameters.pathDownload();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertEquals(excepted, actual);

        bufferedReader.close();
        inputStreamReader.close();

    }

    @Test
    void testPathDownloadWithWrongPathToDownload() throws IOException {
        String excepted = "path";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(excepted.getBytes());
        System.setIn(byteArrayInputStream);

        String actual = userParameters.pathDownload();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        assertNull(actual);

        bufferedReader.close();
        inputStreamReader.close();

    }
}