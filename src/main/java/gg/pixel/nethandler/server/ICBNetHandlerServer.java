package gg.pixel.nethandler.server;

import gg.pixel.nethandler.ICBNetHandler;
import gg.pixel.nethandler.client.CBPacketClientVoice;
import gg.pixel.nethandler.client.CBPacketVoiceChannelSwitch;
import gg.pixel.nethandler.client.CBPacketVoiceMute;

public interface ICBNetHandlerServer extends ICBNetHandler {

    void handleVoice(CBPacketClientVoice var1);

    void handleVoiceChannelSwitch(CBPacketVoiceChannelSwitch var1);

    void handleVoiceMute(CBPacketVoiceMute var1);

}
