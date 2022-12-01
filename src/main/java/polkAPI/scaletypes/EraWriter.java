package polkAPI.scaletypes;

import polkAPI.scale.ScaleWriter;
import polkAPI.scale.ScaleCodecWriter;

import java.io.IOException;

public class EraWriter implements ScaleWriter<Integer> {
    @Override
    public void write(ScaleCodecWriter wrt, Integer value) throws IOException {
        if (value != 0) {
            wrt.writeUint16(value);
        } else {
            wrt.writeByte(0x00);
        }
    }
}