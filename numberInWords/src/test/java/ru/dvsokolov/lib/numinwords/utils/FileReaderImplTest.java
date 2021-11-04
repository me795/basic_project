package ru.dvsokolov.lib.numinwords.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

@DisplayName("Класс FileReaderImpl")
class FileReaderImplTest {

    private FileReader fileReader;

    @DisplayName("должен возвращать содержимое файла в случае его наличия")
    @Test
    void shouldReturnContentIfFileExists() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("test.json");
        fileReader = new FileReaderImpl(inputStream,"UTF-8");
        Assertions.assertThatNoException().isThrownBy(() -> fileReader.getFileContent());
    }

    @DisplayName("должен возвращать исключение, если файла с запрашиваемым именем не существует")
    @Test
    void shouldReturnExceptionIfFileDoesNotExist() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("non-existent.json");
        fileReader = new FileReaderImpl(inputStream,"UTF-8");
        Assertions.assertThatThrownBy(() -> fileReader.getFileContent())
                .isInstanceOf(IOException.class);
    }
}