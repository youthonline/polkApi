package polkAPI.scale.reader;

import polkAPI.scale.ScaleReader;
import polkAPI.scale.ScaleCodecReader;

public class UByteReader implements ScaleReader<Integer> {
    @Override
    public Integer read(ScaleCodecReader rdr) {
        byte x = rdr.readByte();
        if (x < 0) {
            return 256 + (int)x;
        }
        return (int)x;
    }
}