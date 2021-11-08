package ru.dvsokolov.lib.numinwords.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderImpl implements FileReader{

    private final InputStream inputStream;
    private final String encoding;

    public FileReaderImpl(InputStream inputStream, String encoding){
        this.encoding = encoding;
        this.inputStream = inputStream;
    }

    @Override
    public String getFileContent() throws IOException {

        if (inputStream == null) {throw new IOException("Файл не существует");}
        try( BufferedReader br =
                     new BufferedReader( new InputStreamReader(inputStream, encoding )))
        {
            StringBuilder sb = new StringBuilder();
            String line;
            while(( line = br.readLine()) != null ) {
                sb.append( line );
                sb.append( '\n' );
            }
            return sb.toString();
        }
    }
}
