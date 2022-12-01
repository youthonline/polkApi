package polkAPI.scaletypes;

import polkAPI.scale.ScaleCodecReader;
import polkAPI.scale.ScaleReader;
import polkAPI.ss58.SS58Type;

public class AccountInfoReader implements ScaleReader<AccountInfo> {

    private final SS58Type.Network network;

    public AccountInfoReader(SS58Type.Network network) {
        this.network = network;
    }

    @Override
    public AccountInfo read(ScaleCodecReader rdr) {
        AccountInfo result = new AccountInfo();
        result.setNonce(rdr.readUint32());
        result.setConsumers(rdr.readUint32());
        result.setProviders(rdr.readUint32());
        result.setSufficients(rdr.readUint32());
        result.setData(rdr.read(new AccountDataReader(network)));
        return result;
    }
}