package gg.pixel.nethandler;

import gg.pixel.nethandler.shared.CBPacketAddWaypoint;
import gg.pixel.nethandler.shared.CBPacketRemoveWaypoint;

public interface ICBNetHandler {

    void handleAddWaypoint(CBPacketAddWaypoint var1);

    void handleRemoveWaypoint(CBPacketRemoveWaypoint var1);

}
