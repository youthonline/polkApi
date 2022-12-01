package polkAPI.tx;

import polkAPI.types.ByteData;

import java.io.IOException;

public interface EncodeRequest {

    ByteData encodeRequest() throws IOException;

}