package com.pi4j.io.i2c;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  I2CRegisterDataReader.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.io.exception.IOReadException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * I2C Register Data Writer Interface for Pi4J Data Communications
 *
 * @author Robert Savage
 *
 * Based on previous contributions from:
 *        Daniel Sendula,
 *        <a href="http://raspelikan.blogspot.co.at">RasPelikan</a>
 */
public interface I2CRegisterDataReader {

    // ------------------------------------------------------------------------------------------------------------

    int readRegister(int register) throws IOException;
    int readRegister(int register, ByteBuffer buffer, int offset, int length) throws IOException;

    // ------------------------------------------------------------------------------------------------------------

    default int readRegister(int register, byte[] buffer, int offset, int length) throws IOException{
        ByteBuffer bb = ByteBuffer.wrap(buffer);
        return readRegister(register, bb, offset, length);
    }
    default int readRegister(int register, byte[] buffer, int length) throws IOException{
        return readRegister(register, buffer, 0, length);
    }
    default int readRegister(int register, byte[] buffer) throws IOException{
        return readRegister(register, buffer, 0, buffer.length);
    }
    default int readRegister(int register, ByteBuffer buffer, int length) throws IOException{
        return readRegister(register, buffer, 0, length);
    }
    default int readRegister(int register, ByteBuffer buffer) throws IOException{
        return readRegister(register, buffer, 0, buffer.capacity());
    }

    // ------------------------------------------------------------------------------------------------------------

    default String readRegisterString(int register, int length) throws IOException, IOReadException {
        return readRegisterString(register, length, StandardCharsets.US_ASCII);
    }

    default String readRegisterString(int register, int length, Charset charset) throws IOException, IOReadException {
        byte[] temp = new byte[length];
        int actual = readRegister(register, temp, 0, length);
        if(actual < 0) throw new IOReadException(actual);
        return new String(temp, 0, actual, charset);
    }

    default byte readRegisterByte(int register) throws IOException, IOReadException {
        int actual = readRegister(register);
        if(actual < 0) throw new IOReadException(actual);
        return (byte)actual;
    }

    default int readRegisterWord(int register) throws IOException, IOReadException {
        byte[] buffer=  new byte[2];
        int actual = readRegister(register, buffer);
        if(actual < 2) throw new IOReadException(actual);
        return ((buffer[0] & 0xff) << 8) | (buffer[1] & 0xff);
    }

    default ByteBuffer readRegisterBuffer(int register, int length) throws IOException, IOReadException {
        byte[] temp = new byte[length];
        int actual = readRegister(register, temp, 0, length);
        if(actual < 0) throw new IOReadException(actual);
        return ByteBuffer.wrap(temp, 0, actual);
    }

    default byte[] readRegisterArray(int register, int length) throws IOException, IOReadException {
        byte[] temp = new byte[length];
        int actual = readRegister(register, temp, 0, length);
        if(actual < 0) throw new IOReadException(actual);
        return Arrays.copyOf(temp, actual);
    }
}
