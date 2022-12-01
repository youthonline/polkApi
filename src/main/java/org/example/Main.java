package org.example;

import polkAPI.JavaHttpAdapter;
import polkAPI.PolkadotApi;
import polkAPI.json.BlockResponseJson;
import polkAPI.json.MethodsJson;
import polkAPI.json.SystemHealthJson;
import polkAPI.types.ByteData;
import polkAPI.types.Hash256;

import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        try {

//            Root Key: 78a91f6de0dff1f34bafecb6c9badcc456cb1869bc9ebb84288fdd9b49e54a73377fdc773f70a6f206288532351dedfc381da59c387fa6f3b973b236a2ccf0f4
//
//            Address: DY5bB6mfYJvADxhiPSwJvWrerzviKcCPpYuLaJFmy7GTCxx
//            Public Key: 2a86db8d604535d38146f5829d1d5439089fd8d46b4ccdbdc8092a835623c545
//            Secret Key: 980f114dbdccf2fa3e4bad835292edce6965f6e1b79d389bb0491810eb8a91708f5c4bcaae66f0274eedcf18658eabcc808da87e139f195856a341635372b520


//            System.out.println("Generate a new Root Key + derive a `demo` address from that key");
//            System.out.println("");
//            Schnorrkel.KeyPair rootKey = Schnorrkel.getInstance().generateKeyPair();
//            System.out.println("  Root Key: " + Hex.encodeHexString(rootKey.getSecretKey()));
//            System.out.println("");
//            Schnorrkel.KeyPair key = Schnorrkel.getInstance().deriveKeyPair(rootKey, Schnorrkel.ChainCode.from("demo".getBytes()));
//
//            Address address = new Address(SS58Type.Network.CANARY, key.getPublicKey());
//            System.out.println("   Address: " + address);
//            System.out.println("Public Key: " + Hex.encodeHexString(key.getPublicKey()));
//            System.out.println("Secret Key: " + Hex.encodeHexString(key.getSecretKey()));



//            System.out.println("Derive new Address from existing");
//            System.out.println("");
//            Address address = Address.from("HhjZogQpUMuQEu8ChSAQUWj9UCnqAmCkogitYjqzCqD7xrq");
//            System.out.println("  Address (curr): " + address);
//            Schnorrkel.PublicKey publicKey = new Schnorrkel.PublicKey(address.getPubkey());
//
//            Schnorrkel.PublicKey derived = Schnorrkel.getInstance().derivePublicKeySoft(publicKey, Schnorrkel.ChainCode.from("demo".getBytes()));
//            Address anotherAddress = new Address(SS58Type.Network.CANARY, derived.getPublicKey());
//            System.out.println("   Address (new): " + anotherAddress);
//            System.out.println("Public Key (new): " + Hex.encodeHexString(derived.getPublicKey()));



//            Schnorrkel.KeyPair aliceKey = Schnorrkel.getInstance().generateKeyPairFromSeed(
//                    Hex.decodeHex("e5be9a5092b81bca64be81d212e7f2f9eba183bb7a90954f7b76361f6edb5c0a".toCharArray())
//            );
//            byte[] message = Hex.decodeHex(
//                    "8a3476995d076964c8c8517c8a1a504da91dc2b16ab36fb04ca22734e572619be108ee699592ccb9b1344835352e42c9".toCharArray()
//            );
//            byte[] signature = Schnorrkel.getInstance().sign(message, aliceKey);
//            System.out.println("Signature: " + Hex.encodeHexString(signature));


//            Schnorrkel.KeyPair aliceKey = Schnorrkel.getInstance().generateKeyPairFromSeed(
//                    Hex.decodeHex("e5be9a5092b81bca64be81d212e7f2f9eba183bb7a90954f7b76361f6edb5c0a".toCharArray())
//            );
//            byte[] message = Hex.decodeHex(
//                    "8a3476995d076964c8c8517c8a1a504da91dc2b16ab36fb04ca22734e572619be108ee699592ccb9b1344835352e42c9".toCharArray()
//            );
//            byte[] signature = Hex.decodeHex("e2525d278d3d4b32ca3372b6d2c32c1405f641a5c2309a94da416c32359ac76e485c6baa69baa66def1c3a46c76fc38fb58d88ee0312bfb0bc135b851df0928f".toCharArray());
//
//            // We have both Private Key and Public Key for Alice here, but let's pretend we have only Public Key:
//            Schnorrkel.PublicKey signer = new Schnorrkel.PublicKey(aliceKey.getPublicKey());
//            // Verify the signature
//            boolean valid = Schnorrkel.getInstance().verify(signature, message, signer);
//            System.out.println("Valid: " + valid + " for pubkey " + Hex.encodeHexString(aliceKey.getPublicKey()));


//            Address alice = Address.from("5GrwvaEF5zXb26Fz9rcQpDWS57CtERHpNehXCPcNoHGKutQY");
//            byte[] message = Hex.decodeHex(
//                    "8a3476995d076964c8c8517c8a1a504da91dc2b16ab36fb04ca22734e572619be108ee699592ccb9b1344835352e42c9".toCharArray()
//            );
//            byte[] signature = Hex.decodeHex("e2525d278d3d4b32ca3372b6d2c32c1405f641a5c2309a94da416c32359ac76e485c6baa69baa66def1c3a46c76fc38fb58d88ee0312bfb0bc135b851df0928f".toCharArray());
//
//            // Public key actually is an Address. So lets say you have only address of the signer, like:
//            Schnorrkel.PublicKey signer = new Schnorrkel.PublicKey(alice.getPubkey());
//            // Verify the signature
//            boolean valid = Schnorrkel.getInstance().verify(signature, message, signer);
//            System.out.println("Valid: " + valid + " for address " + alice);

//            JavaHttpSubscriptionAdapter wsAdapter = JavaHttpSubscriptionAdapter.newBuilder().build();
//            PolkadotApi api = PolkadotApi.newBuilder()
//                    .subscriptionAdapter(wsAdapter)
//                    .build();
//
//            // IMPORTANT! connect to the node as the first step before making calls or subscriptions.
//            wsAdapter.connect().get(10, TimeUnit.SECONDS);
//
//            Future<Subscription<BlockJson.Header>> hashFuture = api.subscribe(SubscriptionAdapter.subscriptions().newHeads());
//
//            Subscription<BlockJson.Header> subscription = hashFuture.get(5, TimeUnit.SECONDS);
//            subscription.handler((Subscription.Event<BlockJson.Header> event) -> {
//                BlockJson.Header header = event.getResult();
//                List<String> line = List.of(
//                        Instant.now().truncatedTo(ChronoUnit.SECONDS).toString(),
//                        header.getNumber().toString(),
//                        header.getStateRoot().toString()
//                );
//                System.out.println(String.join("\t", line));
//            });


            PolkadotApi client = PolkadotApi.newBuilder()
                    .rpcCallAdapter(JavaHttpAdapter.newBuilder().build())
                    .build();
            Future<Hash256> hashFuture = client.execute(
                    PolkadotApi.commands().getFinalizedHead()
            );

            Hash256 hash = hashFuture.get();
            System.out.println("Current head: " + hash);

            Future<MethodsJson> methodsFuture = client.execute(
                    PolkadotApi.commands().methods()
            );
            MethodsJson methods = methodsFuture.get();
            System.out.println(methods.getMethods());

//            Future<Hash256> blockhashfurture = client.execute(
//                    PolkadotApi.commands().getBlockHash()
//            );
//            Hash256 blockhash = blockhashfurture.get();
//            System.out.println("blockhash: " + blockhash);

            Future<Hash256> blockhashfurture = client.execute(
                    PolkadotApi.commands().getBlockHash(500)
            );
            Hash256 blockhash = blockhashfurture.get();
            System.out.println("blockhash: " + blockhash);


            Future<SystemHealthJson> systemhealthfurture = client.execute(
                    PolkadotApi.commands().systemHealth()
            );
            SystemHealthJson systemhealth = systemhealthfurture.get();
            System.out.println("systemhealth: " + systemhealth.getSyncing());

            Future<ByteData> stateMetadatafurture = client.execute(
                    PolkadotApi.commands().stateMetadata()
            );
            ByteData stateMetadata = stateMetadatafurture.get();
            System.out.println("stateMetadata: " + stateMetadata.toString());

            Future<BlockResponseJson> blockFuture = client.execute(
                    PolkadotApi.commands().getBlock(blockhash)
            );

            BlockResponseJson block = blockFuture.get();
            System.out.println("Current height: " + block.getBlock().getHeader().getNumber());
            System.out.println("State hash: " + block.getBlock().getHeader().getStateRoot());


            client.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
