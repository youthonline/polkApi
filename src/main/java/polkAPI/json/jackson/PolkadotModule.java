package polkAPI.json.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import polkAPI.json.StorageChangeSetJson;
import polkAPI.types.Address;
import polkAPI.types.ByteData;
import polkAPI.types.DotAmount;
import polkAPI.types.Hash256;

public class PolkadotModule extends SimpleModule {

    public PolkadotModule() {
        super();
        addDeserializer(Hash256.class, new Hash256Deserializer());
        addSerializer(Hash256.class, new Hash256Serializer());
        addDeserializer(ByteData.class, new HexBytesDeserializer());
        addSerializer(ByteData.class, new HexBytesSerializer());
        addDeserializer(Address.class, new AddressDeserializer());
        addSerializer(Address.class, new AddressSerializer());
        addDeserializer(DotAmount.class, new DotAmountDeserializer());
        addSerializer(DotAmount.class, new DotAmountSerializer());

        addDeserializer(StorageChangeSetJson.KeyValueOption.class,
                new StorageChangeSetDeserializer.KeyValueOptionDeserializer());
    }
}