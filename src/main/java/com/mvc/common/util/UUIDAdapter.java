package com.mvc.common.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class UUIDAdapter {

    public static byte[] getByteArrayFromUUID(UUID uuid){
        ByteBuffer bufer = ByteBuffer.wrap(new byte[16])
                .order(ByteOrder.BIG_ENDIAN)
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());
        return bufer.array();
    }

    public static UUID getUUIDFromByteArray(byte[] bb){
        ByteBuffer bufer = ByteBuffer.wrap(bb);
        Long high = bufer.getLong();
        Long low = bufer.getLong();
        return new UUID(high,low);
    }
}
