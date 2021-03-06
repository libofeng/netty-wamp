package io.netty.protocol.wamp;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.netty.protocol.wamp.server.CallErrorException;
import io.netty.protocol.wamp.server.RpcHandler;

import java.util.List;

public class EchoHandler implements RpcHandler {
	@Override
	public TreeNode call(List<TreeNode> args, HandlerContext ctx) throws CallErrorException {
		ArrayNode arrayNode = ctx.mapper.createArrayNode();
		for (Object o : args) arrayNode.add((JsonNode) o);
		return arrayNode;
	}
}
