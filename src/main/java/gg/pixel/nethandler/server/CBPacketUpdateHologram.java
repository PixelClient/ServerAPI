package gg.pixel.nethandler.server;

import gg.pixel.nethandler.ByteBufWrapper;
import gg.pixel.nethandler.CBPacket;
import gg.pixel.nethandler.ICBNetHandler;
import gg.pixel.nethandler.client.ICBNetHandlerClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor @Getter
public class CBPacketUpdateHologram extends CBPacket {

    private UUID uuid;
    private List<String> lines;

    @Override
    public void write(ByteBufWrapper out) throws IOException {
        out.writeUUID(this.uuid);
        out.writeVarInt(this.lines.size());
        this.lines.forEach(out::writeString);
    }

    @Override
    public void read(ByteBufWrapper in) throws IOException {
        this.uuid = in.readUUID();
        int linesSize = in.readVarInt();
        this.lines = new ArrayList<>();
        for (int i = 0; i < linesSize; ++i) {
            this.lines.add(in.readString());
        }
    }

    @Override
    public void process(ICBNetHandler handler) {
        ((ICBNetHandlerClient)handler).handleUpdateHologram(this);
    }

}
