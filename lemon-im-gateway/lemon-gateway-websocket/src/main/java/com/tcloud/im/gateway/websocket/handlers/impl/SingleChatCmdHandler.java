package com.tcloud.im.gateway.websocket.handlers.impl;

import com.tcloud.im.common.annotations.CmdHandler;
import com.tcloud.im.common.enums.Command;
import com.tcloud.im.common.utils.CtxHelper;
import com.tcloud.im.gateway.websocket.cache.SocketSessionCache;
import com.tcloud.im.gateway.websocket.domain.core.WsMessage;
import com.tcloud.im.gateway.websocket.handlers.IChatCmdHandler;
import com.tcloud.register.domain.ClientRouteServerInfo;
import com.tcloud.register.manager.client.ClientRegisterRelateManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author evans
 * @description
 * @date 2023/8/3
 */
@Component
@CmdHandler(cmd = Command.SINGLE_CHAT)
public class SingleChatCmdHandler implements IChatCmdHandler {


    @Autowired
    private ClientRegisterRelateManager registerRelateManager;

    @Override
    public void execute(WsMessage message, NioSocketChannel channel) {
        // TODO 伪代码
        Long toUser = message.getToUser();
        // 从本服务器找
        if (SocketSessionCache.exists(toUser)){
            // 如果本地存在会话,则执行单条消息发送
            ChannelHandlerContext toUserChannel = SocketSessionCache.get(toUser);
            CtxHelper.writeSuccess(toUserChannel, message);
            // 消息入库, 等待签收
        } else {
            ClientRouteServerInfo serverInfo = registerRelateManager.find(toUser);
            // TODO TCP 或 HTTP 将消息进行转发到目标服务器

        }
    }
}
