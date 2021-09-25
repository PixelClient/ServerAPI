package gg.pixel.nethandler.server;

import gg.pixel.nethandler.ByteBufWrapper;
import gg.pixel.nethandler.CBPacket;
import gg.pixel.nethandler.ICBNetHandler;
import gg.pixel.nethandler.client.ICBNetHandlerClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor @Getter
public class CBPacketVoiceChannelUpdate extends CBPacket {

    public int status;
    private UUID channelUuid;
    private UUID uuid;
    private String name;

    @Override
    public void write(ByteBufWrapper out) throws IOException {
        out.writeVarInt(this.status);
        out.writeUUID(this.channelUuid);
        out.writeUUID(this.uuid);
        out.writeString(this.name);
    }

    @Override
    public void read(ByteBufWrapper in) throws IOException {
        this.status = in.readVarInt();
        this.channelUuid = in.readUUID();
        this.uuid = in.readUUID();
        this.name = in.readString();
    }

    @Override
    public void process(ICBNetHandler handler) {
        ((ICBNetHandlerClient)handler).handleVoiceChannelUpdate(this);
    }

}
