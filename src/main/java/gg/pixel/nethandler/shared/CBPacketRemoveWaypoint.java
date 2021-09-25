package gg.pixel.nethandler.shared;

import gg.pixel.nethandler.ByteBufWrapper;
import gg.pixel.nethandler.CBPacket;
import gg.pixel.nethandler.ICBNetHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;

@AllArgsConstructor @NoArgsConstructor @Getter
public class CBPacketRemoveWaypoint extends CBPacket {

    private String name;
    private String world;

    @Override
    public void write(ByteBufWrapper b) throws IOException {
        b.writeString(this.name);
        b.writeString(this.world);
    }

    @Override
    public void read(ByteBufWrapper b) throws IOException {
        this.name = b.readString();
        this.world = b.readString();
    }

    @Override
    public void process(ICBNetHandler handler) {
        handler.handleRemoveWaypoint(this);
    }

}
