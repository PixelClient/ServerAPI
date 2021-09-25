package gg.pixel.nethandler.server;

import gg.pixel.nethandler.ByteBufWrapper;
import gg.pixel.nethandler.CBPacket;
import gg.pixel.nethandler.ICBNetHandler;
import gg.pixel.nethandler.client.ICBNetHandlerClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;

@AllArgsConstructor @NoArgsConstructor @Getter
public class CBPacketUpdateWorld extends CBPacket {

    private String world;

    @Override
    public void write(ByteBufWrapper out) throws IOException {
        out.writeString(this.world);
    }

    @Override
    public void read(ByteBufWrapper in) throws IOException {
        this.world = in.readString();
    }

    @Override
    public void process(ICBNetHandler handler) {
        ((ICBNetHandlerClient)handler).handleUpdateWorld(this);
    }

}
