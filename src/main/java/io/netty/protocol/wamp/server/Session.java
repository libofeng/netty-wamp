package io.netty.protocol.wamp.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.protocol.wamp.messages.EventMessage;

import java.util.HashMap;
import java.util.Random;

public class Session {
	private static final int ID_LENGTH = 16;

	public final String sessionId;
	private final ChannelHandlerContext ctx;
	public final HashMap<String, String> prefixes = new HashMap<>();

	public Session(ChannelHandlerContext ctx) {
		this.sessionId = randomString(ID_LENGTH);
		this.ctx = ctx;
	}

	public ChannelFuture write(EventMessage msg) {
		return ctx.writeAndFlush(msg);
	}

	private final static String alphaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final static Random rnd = new Random();

	private static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(alphaNum.charAt(rnd.nextInt(alphaNum.length())));
		return sb.toString();
	}
}
