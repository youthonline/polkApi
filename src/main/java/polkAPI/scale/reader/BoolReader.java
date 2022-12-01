package polkAPI.scale.reader;

import polkAPI.scale.ScaleReader;
import polkAPI.scale.ScaleCodecReader;

public class BoolReader implements ScaleReader<Boolean> {
    @Override
    public Boolean read(ScaleCodecReader rdr) {
        byte b = rdr.readByte();
        if (b == 0) {
            return false;
        }
        if (b == 1) {
            return true;
        }
        throw new IllegalStateException("Not a boolean value: " + b);
    }
}