package com.jesteves.qr.ports;

public interface StoragePorts {

    String uploadFile(byte[] fileData, String fileName, String contentType);
}
