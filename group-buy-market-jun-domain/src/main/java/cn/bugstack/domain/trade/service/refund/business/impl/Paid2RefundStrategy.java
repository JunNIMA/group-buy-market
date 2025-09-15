package cn.bugstack.domain.trade.service.refund.business.impl;

import cn.bugstack.domain.trade.adapter.port.ITradePort;
import cn.bugstack.domain.trade.adapter.repository.ITradeRepository;
import cn.bugstack.domain.trade.model.aggregate.GroupBuyRefundAggregate;
import cn.bugstack.domain.trade.model.entity.NotifyTaskEntity;
import cn.bugstack.domain.trade.model.entity.TradeRefundOrderEntity;
import cn.bugstack.domain.trade.model.valobj.TeamRefundSuccess;
import cn.bugstack.domain.trade.service.ITradeTaskService;
import cn.bugstack.domain.trade.service.lock.factory.TradeLockRuleFilterFactory;
import cn.bugstack.domain.trade.service.refund.business.AbstractReundOrderStrategy;
import cn.bugstack.domain.trade.service.refund.business.IRefundOrderStrategy;
import cn.bugstack.types.exception.AppException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 发起退单（已支付、未成团），锁单量-1、完成量-1、组队订单状态更新、发送退单消息（MQ）
 *
 * @author xiaofuge bugstack.cn @小傅哥
 * 2025/7/8 07:43
 */
@Slf4j
@Service("paid2RefundStrategy")
public class Paid2RefundStrategy extends AbstractReundOrderStrategy {


    @Override
    public void refundOrder(TradeRefundOrderEntity tradeRefundOrderEntity) throws Exception{
        log.info("退单；已支付，未成团 userId:{} teamId:{} orderId:{}", tradeRefundOrderEntity.getUserId(), tradeRefundOrderEntity.getTeamId(), tradeRefundOrderEntity.getOrderId());

        // 1. 退单，已支付&未成团
        NotifyTaskEntity notifyTaskEntity = repository.paid2Refund(GroupBuyRefundAggregate.buildPaid2RefundAggregate(tradeRefundOrderEntity, -1, -1));

        // 2. 发送MQ消息 - 发送MQ， 恢复锁单库存量使用
        sendRefundNotifyMessage(notifyTaskEntity, "已支付，未成团");
    }

    @Override
    public void reverseStock(TeamRefundSuccess teamRefundSuccess) throws Exception {
        doReverseStock(teamRefundSuccess,"已支付，未成团，但有锁单记录，要恢复锁单库存");
    }


}
