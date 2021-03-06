package org.telegram.api.functions.channels;

import org.telegram.api.input.chat.TLAbsInputChannel;
import org.telegram.api.messages.TLAbsMessages;
import org.telegram.tl.StreamingUtils;
import org.telegram.tl.TLContext;
import org.telegram.tl.TLIntVector;
import org.telegram.tl.TLMethod;
import org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL request channel get messages
 */
public class TLRequestChannelsGetMessages extends TLMethod<TLAbsMessages> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x93d7b347;

    private TLAbsInputChannel channel;
    private TLIntVector id;

    /**
     * Instantiates a new TL request channel get messages
     */
    public TLRequestChannelsGetMessages() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsMessages deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if ((res instanceof TLAbsMessages)) {
            return (TLAbsMessages) res;
        }
        throw new IOException("Incorrect response type. Expected " + TLAbsMessages.class.getName() +", got: " + res.getClass().getName());
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLIntVector getId() {
        return id;
    }

    public void setId(TLIntVector id) {
        this.id = id;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLObject(this.channel, stream);
        StreamingUtils.writeTLVector(this.id, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.channel = (TLAbsInputChannel) StreamingUtils.readTLObject(stream, context);
        this.id = StreamingUtils.readTLIntVector(stream, context);
    }

    public String toString() {
        return "functions.channels.TLRequestChannelsGetMessages#93d7b347";
    }
}