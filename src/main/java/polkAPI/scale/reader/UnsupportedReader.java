package polkAPI.scale.reader;

import polkAPI.scale.ScaleCodecReader;
import polkAPI.scale.ScaleReader;

public class UnsupportedReader<T> implements ScaleReader<T> {

    private final String message;

    public UnsupportedReader() {
        this("Reading an unsupported value");
    }

    public UnsupportedReader(String message) {
        this.message = message;
    }

    @Override
    public T read(ScaleCodecReader rdr) {
        throw new IllegalStateException(message);
    }
}