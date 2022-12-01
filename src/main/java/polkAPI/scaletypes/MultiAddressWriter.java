package polkAPI.scaletypes;

import polkAPI.scale.ScaleCodecWriter;
import polkAPI.scale.ScaleWriter;
import polkAPI.scale.UnionValue;
import polkAPI.scale.writer.UnionWriter;

import java.io.IOException;
import java.util.Arrays;

public class MultiAddressWriter implements ScaleWriter<UnionValue<MultiAddress>> {
    private static final UnionWriter<MultiAddress> WRITER = new UnionWriter<>(
            Arrays.asList(
                    new AccountIDWriter()
            )
    );

    @Override
    public void write(ScaleCodecWriter wrt, UnionValue<MultiAddress> value) throws IOException {
        wrt.write(WRITER, value);
    }

    static class AccountIDWriter implements ScaleWriter<MultiAddress> {
        @Override
        public void write(ScaleCodecWriter wrt, MultiAddress value) throws IOException {
            MultiAddress.AccountID accountID = (MultiAddress.AccountID) value;
            wrt.writeUint256(accountID.getAddress().getPubkey());
        }
    }
}