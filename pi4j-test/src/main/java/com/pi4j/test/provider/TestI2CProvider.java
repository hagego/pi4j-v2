package com.pi4j.test.provider;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: UNITTEST :: Unit/Integration Tests
 * FILENAME      :  TestI2CProvider.java
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

import com.pi4j.io.i2c.I2C;
import com.pi4j.io.i2c.I2CConfig;
import com.pi4j.io.i2c.I2CProvider;

import java.io.IOException;

public class TestI2CProvider extends TestProvider<I2C, I2CConfig> implements I2CProvider {

    public TestI2CProvider(){ super(); }

    public TestI2CProvider(String id){
        super(id);
    }

    public TestI2CProvider(String id, String name){
        super(id, name);
    }

    @Override
    public I2C instance(I2CConfig config) throws IOException {
        return new I2C() {
            @Override
            public int getAddress() {
                return 0;
            }

            @Override
            public void write(byte b) throws IOException {

            }

            @Override
            public void write(byte[] buffer, int offset, int size) throws IOException {

            }

            @Override
            public void write(byte[] buffer) throws IOException {

            }

            @Override
            public void write(int address, byte b) throws IOException {

            }

            @Override
            public void write(int address, byte[] buffer, int offset, int size) throws IOException {

            }

            @Override
            public void write(int address, byte[] buffer) throws IOException {

            }

            @Override
            public int read() throws IOException {
                return 0;
            }

            @Override
            public int read(byte[] buffer, int offset, int size) throws IOException {
                return 0;
            }

            @Override
            public int read(int address) throws IOException {
                return 0;
            }

            @Override
            public int read(int address, byte[] buffer, int offset, int size) throws IOException {
                return 0;
            }

            @Override
            public int read(byte[] writeBuffer, int writeOffset, int writeSize, byte[] readBuffer, int readOffset, int readSize) throws IOException {
                return 0;
            }
        };
    }
}
