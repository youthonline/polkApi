package polkAPI.scale.writer;

import polkAPI.scale.ScaleWriter;
import polkAPI.scale.ScaleCodecWriter;

import java.io.IOException;

public class UByteWriter implements ScaleWriter<Integer> {

    @Override
    public void write(ScaleCodecWriter wrt, Integer value) throws IOException {
        if (value < 0 || value > 0xff) {
            throw new IllegalArgumentException("Only values in range 0..255 are supported: " + value);
        }
        wrt.directWrite(value);
    }
}