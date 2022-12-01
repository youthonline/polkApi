package polkAPI.scaletypes;

import polkAPI.scale.ScaleCodecReader;
import polkAPI.scale.ScaleReader;
import polkAPI.ss58.SS58Type;
import polkAPI.types.DotAmount;
import polkAPI.types.Units;

/**
 * Decode balance encoded as uint128
 */
public class BalanceReader implements ScaleReader<DotAmount> {

    private final Units units;

    /**
     * Create a default balance reader for the Polkadot network, i.e. DOT.
     */
    public BalanceReader() {
        this.units = DotAmount.Polkadots;
    }

    /**
     * <p>Create a balance reader for the provided network.</p>
     * <p>Transforms the read balance to the unit matching the network (DOT, KSM, WND).</p>
     *
     * @param network the SS58 network whose unit to consider when reading accounts
     */
    public BalanceReader(SS58Type.Network network) {
        this.units = DotAmount.getUnitsForNetwork(network);
    }

    @Override
    public DotAmount read(ScaleCodecReader rdr) {
        return new DotAmount(rdr.readUint128(), units);
    }
}