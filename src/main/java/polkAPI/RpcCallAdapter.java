package polkAPI;

import java.util.concurrent.CompletableFuture;

public interface RpcCallAdapter extends AutoCloseable {

    <T> CompletableFuture<T> produceRpcFuture(RpcCall<T> call);
}