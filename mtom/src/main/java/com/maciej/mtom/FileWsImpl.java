package com.maciej.mtom;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.*;

public class FileWsImpl implements FileWs {
    @Override
    public void upload(DataHandler attachment) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = attachment.getInputStream(); // incoming file
            outputStream = new FileOutputStream(new File("files/uploaded/test.jpg"));
            byte[] b = new byte[100000]; // data will be read into this buffer
            int bytesRead = 0;

            while ((bytesRead = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public DataHandler download() {
        return new DataHandler(new FileDataSource(new File("files/uploaded/test.jpg")));
    }
}
