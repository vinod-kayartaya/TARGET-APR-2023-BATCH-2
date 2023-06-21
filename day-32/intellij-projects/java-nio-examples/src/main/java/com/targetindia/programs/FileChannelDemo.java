package com.targetindia.programs;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception{
        FileInputStream file = new FileInputStream("pom.xml");
        FileChannel channel = file.getChannel();

        ByteBuffer dst= ByteBuffer.allocate(1024);
        channel.read(dst);
        channel.close();

        byte[] ar = dst.array();
        System.out.println(new String(ar).trim());
    }
}
