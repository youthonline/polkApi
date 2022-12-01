package polkAPI.scaletypes;

import polkAPI.scale.ScaleCodecWriter;
import polkAPI.scale.ScaleWriter;

import java.io.IOException;

public class BalanceTransferWriter implements ScaleWriter<BalanceTransfer> {
    private static final MultiAddressWriter DESTINATION_WRITER = new MultiAddressWriter();

    @Override
    public void write(ScaleCodecWriter wrt, BalanceTransfer value) throws IOException {
        wrt.writeByte(value.getModuleIndex());
        wrt.writeByte(value.getCallIndex());
        wrt.write(DESTINATION_WRITER, value.getDestination());
        wrt.write(ScaleCodecWriter.COMPACT_BIGINT, value.getBalance().getValue());
    }
}